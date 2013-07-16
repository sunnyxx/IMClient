package cn.edu.bjtu.chat.m.pojo;

import java.sql.Timestamp;

public class Comment {
	private int cid;//评论id，自增，删除评论时使用
	private String name;//被评论人
	private String comname;//发表评论的人
	private Timestamp  time;//评论时间
	private String comment;//评论内容
	
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
