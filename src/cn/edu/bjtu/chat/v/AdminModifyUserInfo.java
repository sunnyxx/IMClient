package cn.edu.bjtu.chat.v;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

import cn.edu.bjtu.chat.m.pojo.UserInfo;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class AdminModifyUserInfo extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = new JPanel();
	private JPasswordField passwordField= null;
	private JTextField textField_mail= null;
	private JTextField textField_petname= null;
	private JPasswordField passwordField_1= null;
	private JPasswordField passwordField_ack= null;
	private JTextField textField_age= null;
	private JRadioButton radioButton_m = null;
	private JRadioButton radioButton_f = null;
	private ButtonGroup sexGroup = null;
	private JLabel lblXi = null;
	private Socket socket = null;
	private JTextArea textArea = null;
	private JScrollPane scrollPane = null;
	private JButton button = null;
	private JButton button_1 = null;
	private JButton button_2 = null;
	private UserInfo u = null;
	private JTextField textField;
	
	public AdminModifyUserInfo(UserInfo u) {
		super();
		this.u = u;
		initialize();
	}
	
	public void display(String value){
		JOptionPane.showMessageDialog(this, value);
	}
	
	private void initialize() {
		this.setSize(300, 460);
		this.setContentPane(getJContentPane());
		jContentPane.setLayout(null);
		
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
		
		JButton btnNewButton = new JButton("头像");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(10, 10, 87, 73);
		jContentPane.add(btnNewButton);
		
		JLabel label = new JLabel("\u6635\u79F0");
		label.setBounds(187, 10, 97, 24);
		jContentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("个人签名");
		lblNewLabel.setBounds(107, 44, 177, 24);
		jContentPane.add(lblNewLabel);
		
		JComboBox<String> stateComboBox = new JComboBox<String>();
		stateComboBox.setBounds(107, 12, 70, 21);
		stateComboBox.addItem("--请选择--");
		stateComboBox.addItem("在线");
		stateComboBox.addItem("隐身");
		stateComboBox.addItem("忙碌");
		stateComboBox.addItem("离开");
		stateComboBox.addItem("请勿打扰");
		stateComboBox.addItem("Q我吧");
		stateComboBox.addItem("离线");
		jContentPane.add(stateComboBox);
		
		JLabel label_1 = new JLabel("原密码：");
		label_1.setBounds(10, 117, 56, 24);
		jContentPane.add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(66, 119, 177, 21);
		jContentPane.add(passwordField);
		
		JLabel label_3 = new JLabel("\u90AE\u7BB1\uFF1A");
		label_3.setBounds(20, 256, 46, 15);
		jContentPane.add(label_3);
		
		textField_mail = new JTextField();
		textField_mail.setBounds(66, 253, 177, 21);
		jContentPane.add(textField_mail);
		textField_mail.setColumns(10);
		
		JLabel label_4 = new JLabel("\u6027\u522B\uFF1A");
		label_4.setBounds(20, 284, 46, 15);
		jContentPane.add(label_4);
		
		JLabel label_5 = new JLabel("昵称：");
		label_5.setBounds(20, 92, 46, 15);
		jContentPane.add(label_5);
		
		textField_petname = new JTextField();
		textField_petname.setColumns(10);
		textField_petname.setBounds(66, 88, 177, 21);
		jContentPane.add(textField_petname);
		
		JLabel label_6 = new JLabel("个人签名：");
		label_6.setBounds(10, 196, 66, 15);
		jContentPane.add(label_6);
		
		JLabel label_7 = new JLabel("\u5E74\u9F84:");
		label_7.setBounds(20, 312, 46, 15);
		jContentPane.add(label_7);
		
		this.sexGroup = new ButtonGroup();
		radioButton_m = new JRadioButton("男");
		radioButton_m.setBounds(66, 280, 66, 23);
		this.sexGroup.add(radioButton_m);
		this.jContentPane.add(radioButton_m);
		radioButton_f = new JRadioButton("女");
		radioButton_f.setBounds(146, 280, 97, 23);
		this.sexGroup.add(radioButton_f);
		this.jContentPane.add(radioButton_f);
		
		lblXi = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
		lblXi.setBounds(10, 151, 56, 24);
		jContentPane.add(lblXi);
		
		passwordField_ack = new JPasswordField();
		passwordField_ack.setBounds(66, 153, 177, 21);
		jContentPane.add(passwordField_ack);
		
		textField_age = new JTextField();
		textField_age.setColumns(10);
		textField_age.setBounds(66, 309, 177, 21);
		jContentPane.add(textField_age);
		
		textArea = new JTextArea();
		textArea.setBounds(66, 184, 177, 59);
		jContentPane.add(textArea);
		
		scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(66, 184, 177, 59);
		//scrollPane.setBounds(86, 196, 2, 2);
		jContentPane.add(scrollPane);
		
		button = new JButton("提交");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 104|昵称\0密码\0个人签名\0邮箱\0性别\0年龄
				try {
					JTextField fields[] = {
							textField_petname,
							textField_mail,
							textField_age
					};
					boolean isAllWriten = true;
					for (JTextField field : fields) {
						if (field.getText().trim().equals("")) {
							isAllWriten = false;
						}
					}
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
						// 104|昵称\0密码\0个人签名\0邮箱\0性别\0年龄
						String request = "106|"+ textField_petname.getText().trim() +"||" +
								passwordField.getText() + "||" +
								textArea.getText().trim() + "||" +
								textField_mail.getText().trim() + "||" +
								sex + "||" + //性别有问题
								textField_age.getText().trim() + "||";
						
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
									display("修改成功！");
									//System.out.println("success");
									//显示在用户主界面
//								UserInfo u = new UserInfo();
//								u.setPetname(textField_petname.getText().trim());
//								u.setInfo(textField_info.getText().trim());
									//thisFrame.setVisible(false);
									//new UserFrame(s,u);
								}
								else{
									display("用户名或密码错误");
								}
					}
				} catch (IOException e1) {
					display("网络连接失败");
					e1.printStackTrace();
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


		button.setBounds(0, 387, 76, 24);
		jContentPane.add(button);
		
		button_1 = new JButton("重填");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 104|昵称\0密码\0个人签名\0邮箱\0性别\0年龄
				textField_petname.setText(null);
				passwordField.setText(null);
				passwordField_ack.setText(null);
				textArea.setText(null);
				textField_mail.setText(null);
				radioButton_f.setSelected(false);
				radioButton_m.setSelected(false);
				textField_age.setText(null);
			}
		});
		button_1.setBounds(94, 388, 76, 23);
		jContentPane.add(button_1);
		
		JLabel label_2 = new JLabel("\u6743\u9650:");
		label_2.setBounds(20, 345, 46, 15);
		jContentPane.add(label_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(66, 342, 177, 21);
		jContentPane.add(textField);
		
		JButton btnNewButton_1 = new JButton("\u5220\u9664\u7528\u6237");
		btnNewButton_1.setBounds(197, 387, 87, 24);
		jContentPane.add(btnNewButton_1);
		this.setTitle("\u4FEE\u6539\u7528\u6237\u4FE1\u606F");
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
