package cn.edu.bjtu.chat.m.pojo;

import java.sql.Timestamp;

public class Filetrans {
	private int fid;
	private String sendname;
	private String getname;
	private String fname;
	private String ip;
	public int state;
	private String recpath;
	private Timestamp  timestart;
	private Timestamp  timeend;
	private String ftype;
	private int fsize;
	private Timestamp  lastmodify;
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
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
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getRecpath() {
		return recpath;
	}
	public void setRecpath(String recpath) {
		this.recpath = recpath;
	}
	public Timestamp getTimestart() {
		return timestart;
	}
	public void setTimestart(Timestamp timestart) {
		this.timestart = timestart;
	}
	public Timestamp getTimeend() {
		return timeend;
	}
	public void setTimeend(Timestamp timeend) {
		this.timeend = timeend;
	}
	public String getFtype() {
		return ftype;
	}
	public void setFtype(String ftype) {
		this.ftype = ftype;
	}
	public int getFsize() {
		return fsize;
	}
	public void setFsize(int fsize) {
		this.fsize = fsize;
	}
	public Timestamp getLastmodify() {
		return lastmodify;
	}
	public void setLastmodify(Timestamp lastmodify) {
		this.lastmodify = lastmodify;
	}
	
}
