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
				//登陆  101/用户名/密码
				if (head.equals("101")) {
					String v1 = response.substring(index + 1);
					
					u.setName(u.getName() + '\n' + v1);
					u.setPassw(u.getPassw() + '\n' + v1.substring(index + 1));	
				}
				//注册
				if (head.equals("102")) {
					String v1 = response.substring(index + 1);
					
				}
				if(head.equals("113")){
					String v1 = response.substring(index + 1);
//					//查询好友及分组信息  根据用户的昵称
//					//查询好友及分组信息 113|姓名\0昵称\0邮箱\0性别\0年龄\0个性签名\0状态\0头像
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
//							p.println("查询好友分组时用户名不存在！");
//						}
//					} catch (NameException e) {
//						
//					} catch (Exception e) {
//						System.out.println("传输分组信息时，内部错误，写日志");
//					}
//				}

				
//				if(head.equals("113")){
//					//查询好友及分组信息  根据用户的昵称
//					//查询好友及分组信息 113|姓名\0昵称\0邮箱\0性别\0年龄\0个性签名\0状态\0头像
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
//							p.println("查询好友分组时用户名不存在！");
//						}
//					} catch (NameException e) {
//						
//					} catch (Exception e) {
//						System.out.println("传输分组信息时，内部错误，写日志");
//					}
//				}

			//	new UserFrame(u);
//				//短信协议
//				if(head.equals("109")){
//					String v = response.substring(index+1);
//					q.tget.setText(q.tget.getText()+"\n" +v);
//				}
//				//注册102
				}
			} catch (IOException e) {
				break;
			}
		}
	}
}
