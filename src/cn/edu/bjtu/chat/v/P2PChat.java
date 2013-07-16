package cn.edu.bjtu.chat.v;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import cn.edu.bjtu.chat.m.pojo.Message;
import cn.edu.bjtu.chat.m.pojo.UserInfo;

public class P2PChat  extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserInfo u = null;
	Socket s = null;
	JLabel petnameL = new JLabel("昵称");
	JTextField petnameField = new JTextField();
	public JTextArea tgetArea = new JTextArea();//9,21
	JTextArea tsendArea = new JTextArea();
	JLabel sendboxL = new JLabel("收件箱");
	JButton sentButton = new JButton("发送");
	private JTextField finfoField;
	
	public String receiveName = null;
	
	public P2PChat(UserInfo u , Socket s){
		this.u  = u;
		this.s  = s;
		petnameField.setText(u.getName());
		
		getContentPane().setLayout(null);
		sentButton.setBounds(282, 328, 70, 23);
		getContentPane().add(sentButton);
		sentButton.addActionListener(new actionl());
		
		JButton closeButton = new JButton("关闭");
		closeButton.setBounds(197, 328, 70, 23);
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
		
		JLabel fpic = new JLabel("好友头像");
		fpic.setBounds(355, 33, 149, 191);
		getContentPane().add(fpic);
		
		JLabel mpic = new JLabel("我的头像");
		mpic.setBounds(355, 225, 149, 136);
		getContentPane().add(mpic);
		
		JButton fontButton = new JButton("字体");
		fontButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FontFrame();
			}
		});
		
		fontButton.setBounds(0, 223, 70, 23);
		getContentPane().add(fontButton);
		
		JLabel property = new JLabel("  ");
		property.setBounds(0, 225, 352, 19);
		getContentPane().add(property);
		this.setSize(520,400);
		this.setDefaultCloseOperation(3);
		this.setTitle("QQ 正在聊天："+u.getName());
		//this.setResizable(false);
		this.setVisible(true);
	}
	
	public void display(String value){
		JOptionPane.showMessageDialog(this, value);
	}
	
	public class actionl implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
		}
	}
	
	public void updateNewMessage(Message msg) {
		//更新新的message
	}
}
