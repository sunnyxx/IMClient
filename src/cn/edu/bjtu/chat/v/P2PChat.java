package cn.edu.bjtu.chat.v;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import cn.edu.bjtu.chat.m.pojo.Friends;
import cn.edu.bjtu.chat.m.pojo.UserInfo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class P2PChat  extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserInfo u = null;
	private UserInfo uf = null;
	private Socket s = null;
	private JLabel petnameL = new JLabel("昵称");
	private JTextField petnameField = new JTextField();
	public JTextArea tgetArea = new JTextArea();//9,21
	private JTextArea tsendArea = new JTextArea();
	private JLabel sendboxL = new JLabel("收件箱");
	private JButton sentButton = new JButton("发送");
	private JTextField finfoField;
	public P2PChat(UserInfo u ,UserInfo uf, Socket s){
		this.u  = u;
		this.uf = uf;
		this.s  = s;
		petnameField.setText(u.getName());
		
		getContentPane().setLayout(null);
		sentButton.setBounds(282, 328, 70, 22);
		getContentPane().add(sentButton);
		sentButton.addActionListener(new action_send());
		
		JButton closeButton = new JButton("关闭");
		closeButton.setBounds(197, 328, 70, 22);
		getContentPane().add(closeButton);
		petnameL.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		petnameL.setBounds(10, 6, 42, 18);
		getContentPane().add(petnameL);
		petnameField.setBounds(47, 5, 102, 21);
		getContentPane().add(petnameField);
		
		JLabel finfo = new JLabel("个人签名");
		finfo.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		finfo.setBounds(159, 8, 70, 15);
		getContentPane().add(finfo);
		
		finfoField = new JTextField();
		finfoField.setText(u.getInfo());
		finfoField.setBounds(218, 5, 286, 21);
		getContentPane().add(finfoField);
		finfoField.setColumns(10);
		sendboxL.setForeground(Color.BLACK);
		sendboxL.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		sendboxL.setBounds(10, 37, 63, 15);
		getContentPane().add(sendboxL);
		
		JScrollPane sendscrollPane = new JScrollPane();
		sendscrollPane.setBounds(0, 34, 352, 190);
		getContentPane().add(sendscrollPane);
		tgetArea.setBounds(0, 33, 352, 191);
		getContentPane().add(tgetArea);
		
		JScrollPane getscrollPane = new JScrollPane();
		getscrollPane.setBounds(0, 245, 352, 106);
		getContentPane().add(getscrollPane);
		tsendArea.setBounds(0, 245, 352, 106);
		getContentPane().add(tsendArea);
		
		getContentPane().add(getfpic());
		JLabel mpic = new JLabel("我的头像");
		mpic.setBounds(355, 225, 149, 136);
		getContentPane().add(mpic);
		
		JButton button_sendFile = new JButton("\u53D1\u9001\u6587\u4EF6");
		button_sendFile.setBounds(0, 223, 93, 23);
		getContentPane().add(button_sendFile);
		
		JButton button_2 = new JButton("字体");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//new FontFrame();
			}
		});
		button_2.setBounds(91, 223, 93, 23);
		getContentPane().add(button_2);
		
		JButton button_back = new JButton("\u80CC\u666F\u56FE");
		button_back.setBounds(182, 223, 93, 23);
		getContentPane().add(button_back);
		
		JLabel label_property = new JLabel(" ");
		label_property.setBounds(0, 225, 352, 20);
		getContentPane().add(label_property);
		this.setSize(520,400);
		this.setDefaultCloseOperation(3);
		this.setTitle("QQ 正在聊天："+u.getName());
		//this.setResizable(false);
		this.setVisible(true);
	}
	
	public JLabel getfpic(){
		JLabel fpic = new JLabel("好友头像");
		fpic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Friends friends = new Friends();
				friends.setName(u.getName());
				friends.setFriendname(uf.getName());
				new FriendInfoFrame(friends);
			}
		});
		fpic.setBounds(355, 33, 149, 191);
		return fpic;
	}
	public void display(String value){
		JOptionPane.showMessageDialog(this, value);
	}
	
	//发送消息
	public class action_send implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}

//		public void actionPerformed(ActionEvent arg0) {
//			String request = "101|"+tu.getText().trim()+"||"+tp.getText();
//			PrintStream p = new PrintStream(s.getOutputStream());
//			p.println(request);
//			p.flush();
//			
//			//接收服务器端的回值
//			//System.out.println("接收服务器端的回值");
//			InputStreamReader i =new InputStreamReader(s.getInputStream());
//			BufferedReader b = new BufferedReader(i);
//			String response = b.readLine();
//			
//			int index = response.indexOf("|");
//			String head = response.substring(0,index);
//			UserInfo u = new UserInfo();
//			if(head.equals("true")){
//				String ss = response.substring(index+1);
//				String v[] = ss.split("\\|\\|");
// 				
////				u.setName(tu.getText());
////				u.setPassw(tp.getText());
////				u.setId(Integer.parseInt(v[0]));
////				u.setPetname(v[1]);
////				u.setMail(v[2]);
////				u.setSex(v[3]);
////				u.setAge(Integer.parseInt(v[4]));
////				u.setInfo(v[5]);
////				u.setPower(v[6]);
////				//u.setState(v[7]);
////				//u.setPic(v[7]);
////				if(u.getPower().equals(1))
//				
//		}
//			
//	}
	}
}
