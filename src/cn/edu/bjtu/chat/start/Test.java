package cn.edu.bjtu.chat.start;

import cn.edu.bjtu.chat.m.pojo.UserInfo;
import cn.edu.bjtu.chat.v.LoginFrame;
import cn.edu.bjtu.chat.v.UserFrame;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UserInfo u = new UserInfo();
	//	Socket socket = null;
	//	socket = new Socket(4001);
	//	P2PChat pp = new P2PChat(u, socket);
		//new AdminFrame();
//		AdminMainFrame m = new AdminMainFrame();
		//new UserFrame(u);
		//new UserInfoModifyFrame();
		//new UserInfoQueryFrame();
		new LoginFrame();
		
		
		
	//	new GetThread(u, pp);
	}

}
