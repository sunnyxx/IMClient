package cn.edu.bjtu.chat.m.pojo;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.sql.Timestamp;

import cn.edu.bjtu.chat.util.Network;


public class UserInfo {
	private int id;
	private String name;
	private String passw;
	private String petname;
	private String mail;
	private String sex;
	private int age;
	private String info;
	private String power;
	public  int state;
	private InputStream  pic;
	private Timestamp createtime;

	//单例
	private static UserInfo instance = null;
	public static synchronized UserInfo getInstance() {
		if (instance == null) {
			instance = new UserInfo();
		}
		return instance;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name.trim();
	}
	public String getPassw() {
		return passw;
	}
	public void setPassw(String passw) {
		this.passw = passw.trim();
	}
	public String getPetname() {
		return petname;
	}
	public void setPetname(String petname) {
		this.petname = petname.trim();
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail.trim();
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex.trim();
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info.trim();
	}
//	public void setPic(String mail) {
//		this.mail = mail.trim();
//	}
	
	public void setPower(String power) {
		this.power = power.trim();
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public InputStream getPic() {
		return pic;
	}
	public void setPic(InputStream pic) {
		this.pic = pic;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	
	public String getPower() {
		return power;
	}
	public boolean isAdmin() {
		return this.power.equals("1");
	}
	//
	//network
	public boolean requestLogin(){
		
		//* 同步代码，不用分线程，发送之后立刻回复数据 *//
		
		//登陆请求
		String request = "101|"+this.getName()+"||"+this.getPassw();
		Network.getInstance().sendString(request);
		//登陆返回 - 更新数据
		String response = Network.getInstance().receiveString();
		int index = response.indexOf("|");
		String head = response.substring(0,index);
		UserInfo u = UserInfo.getInstance();
		
		boolean loginSuccess = true;
		if(head.equals("true")){
			String ss = response.substring(index+1);
			String v[] = ss.split("\\|\\|");

			u.setId(Integer.parseInt(v[0]));
			u.setPetname(v[1]);
			u.setMail(v[2]);
			u.setSex(v[3]);
			u.setAge(Integer.parseInt(v[4]));
			u.setInfo(v[5]);
			u.setPower(v[6]);
		}
		else {
			loginSuccess = false;
		}
		return loginSuccess;
	}
	
	
	public boolean requestRegister(){
		//注册 102/用户名/密码/昵称/邮箱 /性别/年龄/个人签名
		String request = "102|"+this.getName()+"||"+
		        this.getPassw() + "||" +
				this.getPetname() +"||" +
				this.getMail() + "||" +
				this.getSex() + "||" + //性别有问题
				String.valueOf(this.getAge()) + "||" +
				this.getInfo() + "||";
		Network.getInstance().sendString(request);
		//登陆返回 - 更新数据
		String response = Network.getInstance().receiveString();
		int index = response.indexOf("|");
		String head = response.substring(0,index);
		UserInfo u = UserInfo.getInstance();
		
		boolean registerSuccess = true;
//		if(head.equals("true")){
//		}
//		else {
//			registerSuccess = false;
//		}
		if (!head.equals("true")) {
			registerSuccess = false;
		}
		return registerSuccess;
	}
}

