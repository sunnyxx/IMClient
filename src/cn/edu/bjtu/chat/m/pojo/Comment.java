package cn.edu.bjtu.chat.m.pojo;

import java.sql.Timestamp;

public class Comment {
	private int cid;//����id��������ɾ������ʱʹ��
	private String name;//��������
	private String comname;//�������۵���
	private Timestamp  time;//����ʱ��
	private String comment;//��������
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComname() {
		return comname;
	}
	public void setComname(String comname) {
		this.comname = comname;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
