package cn.edu.bjtu.chat.c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import cn.edu.bjtu.chat.v.P2PChat;

public class GetThread extends Thread {
	Socket s = null;

	P2PChat q = null;

	public GetThread(Socket s, P2PChat q) {
		this.s = s;
		this.q = q;
	}
	
	public void run(){
		while(true){
			try {
				InputStreamReader i = new InputStreamReader(s.getInputStream());
				BufferedReader b = new BufferedReader(i);
				String response = b.readLine();
				int index = response.indexOf('|');
				String head = response.substring(0,index);
				//¶ÌÐÅÐ­Òé
				if(head.equals("102")){
					String v = response.substring(index+1);
					q.tgetArea.setText(q.tgetArea.getText()+"\n" +v);
				}
				//×¢²á102
				
			} catch (IOException e) {
				break;
			}
		}
	}
}
