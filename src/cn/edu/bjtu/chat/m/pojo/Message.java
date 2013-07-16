package cn.edu.bjtu.chat.m.pojo;

import java.sql.Timestamp;

import cn.edu.bjtu.chat.util.Network;

public class Message {
	private int mid;
	private String sendname;
	private String getname;
	private String messages;
	private Timestamp  time;
	
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getSendname() {
		return sendname;
	}
	public void setSendname(String sendname) {
		this.sendname = sendname;
	}
	public String getGetname() {
		return getname;
	}
	public void setGetname(String getname) {
		this.getname = getname;
	}
	public String getMessages() {
		return messages;
	}
	public void setMessages(String messages) {
		this.messages = messages;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	
	public void requestSend(){
		//协议
		String request = "xieyi";
		Network.getInstance().sendString(request);
	}
	
	public static Message generateMessage(String response) {
		//方法为了生成对象，所以static，类方法，直接点出来，只有final 不可变
		Message msg = new Message();
		
		//根据协议解析并设置msg的值
		//TODO
		//重置message，返回message对象
		
		return msg;
		
	}
	
	
	
}
