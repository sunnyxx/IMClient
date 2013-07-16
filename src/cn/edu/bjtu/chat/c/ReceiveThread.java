package cn.edu.bjtu.chat.c;

import java.util.ArrayList;

import cn.edu.bjtu.chat.m.pojo.Message;
import cn.edu.bjtu.chat.m.pojo.UserInfo;
import cn.edu.bjtu.chat.util.Network;
import cn.edu.bjtu.chat.v.P2PChat;

//线程对应着异步，卡住主线程则分线程；主线程可以承受卡住，则不用线程
//如果不需要异步或者可以卡住主线程 就可以不用分线程，可以卡住主线程就不用异步
public class ReceiveThread extends Thread {
	//每次new P2Pchat时要将新的frame添加到messageFrames
	private ArrayList<P2PChat> messageFrames = null;
	
	//每个用户只有一个socket，所以每个用户只有一个receiveThread，所以是单例
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
			//从socket一直读发过来的消息字符串
			String response = Network.getInstance().receiveString();
			//服务器删除该消息
			//将消息字符串解析成Message对象
			Message msg = Message.generateMessage(response);
			
			//通知主线程的Frame更新消息显示
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
