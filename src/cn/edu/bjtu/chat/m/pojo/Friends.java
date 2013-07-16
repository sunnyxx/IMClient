package cn.edu.bjtu.chat.m.pojo;

import java.sql.Timestamp;

public class Friends {
	private String name;
	private String friendname;
	private Timestamp  bftime;
	private int value;
	private String group;
	private String remark;
	private int number;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFriendname() {
		return friendname;
	}
	public void setFriendname(String friendname) {
		this.friendname = friendname;
	}
	public Timestamp getBftime() {
		return bftime;
	}
	public void setBftime(Timestamp bftime) {
		this.bftime = bftime;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
}
