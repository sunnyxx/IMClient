package cn.edu.bjtu.chat.v;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import cn.edu.bjtu.chat.m.pojo.UserInfo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminAddUser extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private JFrame jm = null;//在构造体内new，不然显示不出来
	private JPanel jContentPane = new JPanel();
	private JTextField textField_name = null;
	private JPasswordField passwordField = null;
	private JPasswordField passwordField_ack = null;
	private JTextField textField_petname = null;
	private JTextField textField_mail = null;
	private JRadioButton radioButton_m = null;
	private JRadioButton radioButton_f = null;
	private JTextField textField_age = null;
	private JTextField textField_info = null;	
	private ButtonGroup sexGroup = null;
	private Socket socket = null;
	private JTextField textField_power;
	public AdminAddUser() {
		super();
		initialize();
	}
	
	public void display(String value){
		JOptionPane.showMessageDialog(this, value);
	}
	
	private void initialize() {
		//jm = new JFrame("注册");
		//jm.getContentPane().setLayout(null);
		this.setSize(300, 460);
		this.setContentPane(this.jContentPane);//panel需要加载this这个jframe上
		//this.setUndecorated(true);
		//this.getContentPane().add(jContentPane);

		try {
			//socket = new Socket("localhost",4007);
			socket = new Socket("192.168.1.101",4008);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		jContentPane.setBounds(0, 0, 308, 432);
		
		jContentPane.setVisible(true);
		jContentPane.setLayout(null);
		
		JLabel label_nameJLabel = new JLabel("用户名:");
		label_nameJLabel.setBounds(20, 26, 46, 15);
		jContentPane.add(label_nameJLabel);
		textField_name = new JTextField();
		textField_name.setBounds(66, 22, 177, 21);
		textField_name.setColumns(10);
		jContentPane.add(textField_name);
		
		JLabel label_passw = new JLabel("密码:");
		label_passw.setBounds(20, 56, 56, 24);
		jContentPane.add(label_passw);
		passwordField = new JPasswordField();
		passwordField.setBounds(66, 58, 177, 21);
		jContentPane.add(passwordField);
	
		System.out.println("yonghu");
		
		JLabel label_passack = new JLabel("确认密码:");
		label_passack.setBounds(10, 90, 56, 24);
		jContentPane.add(label_passack);
		passwordField_ack = new JPasswordField();
		passwordField_ack.setBounds(66, 92, 177, 21);
		jContentPane.add(passwordField_ack);
		
		JLabel label_petname = new JLabel("昵称:");
		label_petname.setBounds(20, 128, 46, 15);
		jContentPane.add(label_petname);
		textField_petname = new JTextField();
		textField_petname.setBounds(66, 124, 177, 21);
		textField_petname.setColumns(10);
		jContentPane.add(textField_petname);
		
		JLabel label_mail = new JLabel("邮箱:");
		label_mail.setBounds(20, 159, 46, 15);
		jContentPane.add(label_mail);
		textField_mail = new JTextField();
		textField_mail.setBounds(66, 156, 177, 21);
		jContentPane.add(textField_mail);
		textField_mail.setColumns(10);
		
		JLabel label_sex = new JLabel("性别:");
		label_sex.setBounds(20, 191, 46, 15);
		jContentPane.add(label_sex);
		
		this.sexGroup = new ButtonGroup();
		radioButton_m = new JRadioButton("男");
		radioButton_m.setBounds(66, 187, 66, 23);
		this.sexGroup.add(radioButton_m);
		this.jContentPane.add(radioButton_m);
		radioButton_f = new JRadioButton("女");
		radioButton_f.setBounds(146, 187, 97, 23);
		this.sexGroup.add(radioButton_f);
		this.jContentPane.add(radioButton_f);
		
		JLabel label_age = new JLabel("年龄:");
		label_age.setBounds(20, 219, 46, 15);
		jContentPane.add(label_age);
		textField_age = new JTextField();
		textField_age.setBounds(66, 216, 177, 21);
		jContentPane.add(textField_age);
		
		JLabel label_info = new JLabel("个人签名:");
		label_info.setBounds(10, 256, 66, 15);
		jContentPane.add(label_info);
		
		JTextArea textArea_info = new JTextArea();
		jContentPane.add(textArea_info);
		JScrollPane scrollPane = new JScrollPane(textArea_info);
		scrollPane.setBounds(66, 251, 177, 71);
		jContentPane.add(scrollPane);
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.setBounds(26, 387, 70, 24);
		button.addActionListener(new java.awt.event.ActionListener() {
		//@SuppressWarnings("deprecation")
		
		public void actionPerformed(java.awt.event.ActionEvent e) {
			try {

				// 102|用户名\0密码\0昵称\0邮箱\0性别\0年龄
				
				JTextField fields[] = {
						textField_name,
						textField_petname,
						textField_mail
				};
				boolean isAllWriten = true;
				//System.out.println("22222222222");
				for (JTextField field : fields) {
					if (field.getText().trim().equals("")) {
						isAllWriten = false;
					}
				}
				
				//System.out.println("111111111");
				boolean isPasswordOK = true;
				isPasswordOK = passwordField.getPassword().toString() == passwordField_ack.getPassword().toString();
				
				if (!isAllWriten) {
					display("有空值，请重新输入！");
				}
				else if (isPasswordOK) {
					display("两次输入密码不一致");
				}
				else {
					String sex = null;
					//注册操作
					if (radioButton_f.isSelected() == true) {
						sex = "女";
					}
					else {
						sex = "男";
					}
					
//					SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd HH:MM:SS");
//					String vTimestamp = df.format(new Date());
//					Timestamp creaTimestamp = Timestamp.valueOf(vTimestamp);
					
					//注册 102/用户名/密码/昵称/性别/年龄/个人签名
					String request = "102|"+textField_name.getText().trim()+"||"+
							passwordField.getText() + "||" +
							textField_petname.getText().trim() +"||" +
							textField_mail.getText().trim() + "||" +
							sex + "||" + //性别有问题
							textField_age.getText().trim() + "||" +
							textField_info.getText().trim() + "||"
							;
					
							PrintStream p = new PrintStream(socket.getOutputStream());
							p.println(request);
							p.flush();
							//System.out.println("flush");
							//接收服务器端的回值
							InputStreamReader i =new InputStreamReader(socket.getInputStream());
							BufferedReader b = new BufferedReader(i);
							String response = b.readLine();
							
							int index = response.indexOf("|");
							String head = response.substring(0,index);
							//System.out.println("lianjie");
							if(head.equals("true"))
							{
								display("注册成功！");
								//System.out.println("success");
								//显示在用户主界面
								UserInfo u = new UserInfo();
								u.setName(textField_name.getName());
//								u.setPetname(textField_petname.getText().trim());
//								u.setInfo(textField_info.getText().trim());
//								thisFrame.setVisible(false);
								//new UserFrame(u);
							}
							else{
								display("用户名或密码错误");
							}
				}	
			} catch (Exception e1) {
				display("网络连接失败");
				System.out.println(e1.getMessage());
			}finally {
				try {
					socket.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	});

		jContentPane.add(button);
		
		JButton button_1 = new JButton("重填");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_name.setText(null);
				passwordField.setText(null);
				passwordField_ack.setText(null);
				textField_petname.setText(null);
				textField_mail.setText(null);
				radioButton_f.setSelected(false);
				radioButton_m.setSelected(false);
				textField_age.setText(null);
				textField_info.setText(null);
			}
		});
		button_1.setBounds(185, 388, 70, 23);
		jContentPane.add(button_1);
		
		JLabel label_power = new JLabel("\u6743\u9650:");
		label_power.setBounds(20, 335, 46, 15);
		jContentPane.add(label_power);
		
		textField_power = new JTextField();
		textField_power.setBounds(66, 332, 177, 21);
		jContentPane.add(textField_power);
		
		this.setTitle("\u6DFB\u52A0\u7528\u6237");
		this.setVisible(true);
		
		try {
			socket.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
