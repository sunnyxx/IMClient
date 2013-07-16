package cn.edu.bjtu.chat.c;

import java.util.ArrayList;

import cn.edu.bjtu.chat.m.pojo.Message;
import cn.edu.bjtu.chat.m.pojo.UserInfo;
import cn.edu.bjtu.chat.util.Network;
import cn.edu.bjtu.chat.v.P2PChat;

//�̶߳�Ӧ���첽����ס���߳�����̣߳����߳̿��Գ��ܿ�ס�������߳�
//�������Ҫ�첽���߿��Կ�ס���߳� �Ϳ��Բ��÷��̣߳����Կ�ס���߳̾Ͳ����첽
public class ReceiveThread extends Thread {
	//ÿ��new P2PchatʱҪ���µ�frame��ӵ�messageFrames
	private ArrayList<P2PChat> messageFrames = null;
	
	//ÿ���û�ֻ��һ��socket������ÿ���û�ֻ��һ��receiveThread�������ǵ���
	private static ReceiveThread instance = null;
	public static synchronized ReceiveThread getInstance() {
		if (instance == null) {
			instance = new ReceiveThread();
		}
		return instance;
	}
	
	@Override
	public void run() {
		while (true) {
			//��socketһֱ������������Ϣ�ַ���
			String response = Network.getInstance().receiveString();
			//������ɾ������Ϣ
			//����Ϣ�ַ���������Message����
			Message msg = Message.generateMessage(response);
			
			//֪ͨ���̵߳�Frame������Ϣ��ʾ
			for (P2PChat p2pFrame : this.messageFrames) {
				
				if (msg.getGetname().equals(p2pFrame.receiveName)) {
					p2pFrame.updateNewMessage(msg);
				}
				
			}
		}
	}
	
	
	public void addP2PChatFrame(P2PChat frame) {
		if (this.messageFrames == null) {
			this.messageFrames = new ArrayList<P2PChat>();	
		}
		this.messageFrames.add(frame);
	}
	
	
}
