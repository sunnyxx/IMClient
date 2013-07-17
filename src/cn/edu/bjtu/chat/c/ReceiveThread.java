package cn.edu.bjtu.chat.c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import cn.edu.bjtu.chat.m.pojo.UserInfo;
import cn.edu.bjtu.chat.v.P2PChat;
import cn.edu.bjtu.chat.v.UserFrame;

public class ReceiveThread extends Thread {
	Socket s = null;
	//UserFrame userf = null;
	UserInfo u = null;
	//P2PChat q = null;

	public ReceiveThread(Socket s, UserInfo u) {
		this.s = s;
		this.u = u;
	}
	
	public void run(){
		while(true){
			try {
				InputStreamReader i = new InputStreamReader(s.getInputStream());
				BufferedReader b = new BufferedReader(i);
				String response = b.readLine();
				int index = response.indexOf('|');
				String head = response.substring(0,index);
				//��½  101/�û���/����
				if (head.equals("101")) {
					String v1 = response.substring(index + 1);
					
					u.setName(u.getName() + '\n' + v1);
					u.setPassw(u.getPassw() + '\n' + v1.substring(index + 1));	
				}
				//ע��
				if (head.equals("102")) {
					String v1 = response.substring(index + 1);
					
				}
				if(head.equals("113")){
					String v1 = response.substring(index + 1);
//					//��ѯ���Ѽ�������Ϣ  �����û����ǳ�
//					//��ѯ���Ѽ�������Ϣ 113|����\0�ǳ�\0����\0�Ա�\0����\0����ǩ��\0״̬\0ͷ��
//					String v = request.substring(index+1);
//					String s[] = v.split("\0");
//					//UserInfo u = new UserInfo();
//					Friends f = new Friends();
//					try {
//						Socket so = null;
//						PrintStream p = new PrintStream(so.getOutputStream());
//						boolean us = FriendsService.queryFriends(f);
//						if (us) {
//							p.println("113|"+f.getName()+":"+f.getFriendname()+":"+f.getBftime()
//									+":"+f.getValue()+":"+f.getGroup()+":"+f.getRemark());
////							System.out.println(f.getName()+":"+f.getFriendname()+":"+f.getBftime()
////									+":"+f.getValue()+":"+f.getGroup()+":"+f.getRemark());
//							
//						}else {
//							p.println("��ѯ���ѷ���ʱ�û��������ڣ�");
//						}
//					} catch (NameException e) {
//						
//					} catch (Exception e) {
//						System.out.println("���������Ϣʱ���ڲ�����д��־");
//					}
//				}

				
//				if(head.equals("113")){
//					//��ѯ���Ѽ�������Ϣ  �����û����ǳ�
//					//��ѯ���Ѽ�������Ϣ 113|����\0�ǳ�\0����\0�Ա�\0����\0����ǩ��\0״̬\0ͷ��
//					String v = request.substring(index+1);
//					String s[] = v.split("\0");
//					//UserInfo u = new UserInfo();
//					Friends f = new Friends();
//					try {
//						Socket so = null;
//						PrintStream p = new PrintStream(so.getOutputStream());
//						boolean us = FriendsService.queryFriends(f);
//						if (us) {
//							p.println("113|"+f.getName()+":"+f.getFriendname()+":"+f.getBftime()
//									+":"+f.getValue()+":"+f.getGroup()+":"+f.getRemark());
////							System.out.println(f.getName()+":"+f.getFriendname()+":"+f.getBftime()
////									+":"+f.getValue()+":"+f.getGroup()+":"+f.getRemark());
//							
//						}else {
//							p.println("��ѯ���ѷ���ʱ�û��������ڣ�");
//						}
//					} catch (NameException e) {
//						
//					} catch (Exception e) {
//						System.out.println("���������Ϣʱ���ڲ�����д��־");
//					}
//				}

			//	new UserFrame(u);
//				//����Э��
//				if(head.equals("109")){
//					String v = response.substring(index+1);
//					q.tget.setText(q.tget.getText()+"\n" +v);
//				}
//				//ע��102
				}
			} catch (IOException e) {
				break;
			}
		}
	}
}
