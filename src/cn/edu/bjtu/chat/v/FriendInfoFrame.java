package cn.edu.bjtu.chat.v;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cn.edu.bjtu.chat.m.pojo.Friends;
import cn.edu.bjtu.chat.m.pojo.UserInfo;

import java.awt.Font;
import java.net.Socket;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FriendInfoFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = new JPanel();
	private Socket s = null;
	private UserInfo u = null;
	private UserInfo ufriend = null;
	private Friends friend = null;
	
	public FriendInfoFrame(Socket s, Friends friend) {
		super();
		this.s = s;
		this.friend = friend;
		this.u.setName(friend.getName());
		this.u.setName(friend.getFriendname());
		initialize();
	}
	
	private void initialize() {
		this.setSize(300, 500);
		this.setContentPane(getJContentPane());
		jContentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("头像");
		btnNewButton.setBounds(10, 10, 87, 73);
		jContentPane.add(btnNewButton);
		
		JLabel label = new JLabel("\u5907\u6CE8:");
		label.setBounds(161, 10, 39, 24);
		jContentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("\u9B45\u529B\u503C:");
		lblNewLabel.setBounds(28, 93, 46, 24);
		jContentPane.add(lblNewLabel);
		
		JComboBox<String> stateComboBox = new JComboBox<String>();
		stateComboBox.setBounds(97, 12, 54, 21);
		stateComboBox.addItem("--请选择--");
		stateComboBox.addItem("在线");
		stateComboBox.addItem("隐身");
		stateComboBox.addItem("忙碌");
		stateComboBox.addItem("离开");
		stateComboBox.addItem("请勿打扰");
		stateComboBox.addItem("Q我吧");
		stateComboBox.addItem("离线");
		jContentPane.add(stateComboBox);
		
		JLabel lblId = new JLabel("  ID:");
		lblId.setBounds(97, 43, 30, 24);
		jContentPane.add(lblId);
		
		JLabel label_2 = new JLabel("真实姓名:");
		label_2.setBounds(18, 127, 54, 15);
		jContentPane.add(label_2);
		
		JLabel label_3 = new JLabel("性别:");
		label_3.setBounds(30, 248, 46, 15);
		jContentPane.add(label_3);
		
		JLabel label_4 = new JLabel("邮箱:");
		label_4.setBounds(30, 276, 46, 15);
		jContentPane.add(label_4);
		
		JLabel label_1 = new JLabel("个人签名:");
		label_1.setBounds(18, 180, 54, 24);
		jContentPane.add(label_1);
		
		JLabel label_5 = new JLabel("昵称:");
		label_5.setBounds(28, 155, 46, 15);
		jContentPane.add(label_5);
		
		JLabel lable_mail = new JLabel(ufriend.getMail());
		lable_mail.setBounds(76, 273, 177, 21);
		jContentPane.add(lable_mail);
		
		JLabel label_6 = new JLabel(String.valueOf(ufriend.getId()));
		label_6.setBounds(137, 44, 141, 21);
		jContentPane.add(label_6);
		
		JLabel label_7 = new JLabel(ufriend.getName());
		label_7.setBounds(76, 124, 177, 21);
		jContentPane.add(label_7);
		
		JLabel label_8 = new JLabel(ufriend.getPetname());
		label_8.setBounds(74, 152, 177, 21);
		jContentPane.add(label_8);
		
		JLabel label_9 = new JLabel(ufriend.getInfo());
		label_9.setBounds(74, 182, 177, 53);
		jContentPane.add(label_9);
		
		JLabel label_10 = new JLabel(ufriend.getSex());
		label_10.setBounds(76, 245, 177, 21);
		jContentPane.add(label_10);
		
		JLabel label_11 = new JLabel("年龄:");
		label_11.setBounds(30, 304, 46, 15);
		jContentPane.add(label_11);
		
		JLabel label_12 = new JLabel(String.valueOf(ufriend.getAge()));
		label_12.setBounds(76, 301, 188, 21);
		jContentPane.add(label_12);
		
		JLabel label_13 = new JLabel("权限:");
		label_13.setBounds(30, 332, 46, 15);
		jContentPane.add(label_13);
		
		JLabel label_14 = new JLabel(String.valueOf(ufriend.getPower()));
		label_14.setBounds(76, 329, 177, 21);
		jContentPane.add(label_14);
		
		JLabel label_15 = new JLabel("\u52A0\u4E3A\u597D\u6709\u65F6\u95F4:");
		label_15.setBounds(10, 360, 87, 15);
		jContentPane.add(label_15);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd HH:MM:SS");
		String vTimestamp = df.format(new Date());
		Timestamp creaTimestamp = Timestamp.valueOf(vTimestamp);
		long timeLong = creaTimestamp.getTime() - friend.getBftime().getTime();
		long day=timeLong/(24*60*60*1000);
	    long hour=(timeLong/(60*60*1000)-day*24);
	    long min=((timeLong/(60*1000))-day*24*60-hour*60);
	    long sec=(timeLong/1000-day*24*60*60-hour*60*60-min*60);
		JLabel label_16 = new JLabel(""+day+"天"+hour+"小时"+min+"分"+s+"秒");
		label_16.setBounds(101, 357, 152, 21);
		jContentPane.add(label_16);
		
		JLabel label_19 = new JLabel(String.valueOf(friend.getValue()));
		label_19.setBounds(76, 95, 124, 21);
		jContentPane.add(label_19);
		
		JButton button = new JButton("\u67E5\u770B");
		button.setFont(new Font("微软雅黑", Font.PLAIN, 10));
		button.setBounds(210, 94, 54, 24);
		jContentPane.add(button);
		
		JLabel label_20 = new JLabel(friend.getRemark());
		label_20.setBounds(206, 12, 78, 21);
		jContentPane.add(label_20);
		this.setTitle("\u597D\u53CB\u8BE6\u7EC6\u4FE1\u606F");
		this.setVisible(true);
	}
	private JPanel getJContentPane() {
		getContentPane().setLayout(null);
		
//		JButton button = new JButton("\u5934\u50CF");
//		button.setBounds(0, 0, 107, 80);
//		getContentPane().add(button);
		return jContentPane;
	}
}
