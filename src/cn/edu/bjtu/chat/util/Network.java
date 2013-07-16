package cn.edu.bjtu.chat.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.VoidType;


public class Network {
	private static Network instance = null;
	private Socket socket = null;
	private Network (){

	}
	private Socket getSocket (){
		if (this.socket == null) {
			try {
				socket = new Socket("localhost",4002);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return this.socket;
	}
	
	//* public *//
//	public static void main(String[] args) {
//	Network.getInstance();//static method
//    (new Network()).method(); //instance method
//	
//	
//}
	
	//单例
	public static synchronized Network getInstance() {
		if (instance == null) {
			instance = new Network();
		}
		return instance;
	}
	
	//通过socket发送数据
	public void sendString(String stringData){
		PrintStream p = null;
		try {
			p = new PrintStream(this.getSocket().getOutputStream());
			p.println(stringData);
			p.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String receiveString() {
		InputStreamReader i = null;
		String response = "SERVER ERROR";
		try {
			i = new InputStreamReader(this.getSocket().getInputStream());
			BufferedReader b = new BufferedReader(i);
			response = b.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
}

