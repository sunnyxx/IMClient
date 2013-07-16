package cn.edu.bjtu.chat.m.pojo;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MessageList {
	private ArrayList<Message> messages = null;
	
	private String receiveName = null;
	

	public MessageList(String receiveName) {
		this.receiveName = receiveName;
	}
	
	//* File *//
	
	private char[] getFileData() {
		
		String data = null;
		for (Message msg : this.messages) {
			data = data + msg.getGetname() + msg.getMid();
		}
		
		return "".toCharArray();
	}
	public static MessageList generateMessageListFromFile(String fileName) {
		return new MessageList(fileName);
	}
	
	public void saveToFile() {
		
		FileWriter fw;
		try {
			fw = new FileWriter(this.receiveName);
			fw.write(this.getFileData());
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
}
