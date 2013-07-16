package cn.edu.bjtu.chat.v;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.net.Socket;
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
import javax.swing.JTextField;

import cn.edu.bjtu.chat.m.pojo.UserInfo;
import cn.edu.bjtu.chat.util.Network;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import com.sun.xml.internal.ws.Closeable;

public class RegisterFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private JFrame jm = null;//�ڹ�������new����Ȼ��ʾ������
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
	private JTextArea textArea_info = null;
	private JScrollPane scrollPane = null;
	public RegisterFrame() {
		super();
		initialize();
	}
	
	public void display(String value){
		JOptionPane.showMessageDialog(this, value);
	}
	
	public void close(){
		this.setVisible(false);
	}
	
	private void initialize() {
		//jm = new JFrame("ע��");
		//jm.getContentPane().setLayout(null);
		this.setSize(300, 460);
		this.setContentPane(this.jContentPane);//panel��Ҫ����this���jframe��
		//this.setUndecorated(true);
		//this.getContentPane().add(jContentPane);
		jContentPane.setBounds(0, 0, 308, 432);
		jContentPane.setVisible(true);
		jContentPane.setLayout(null);
		
		JLabel label_nameJLabel = new JLabel("�û���:");
		label_nameJLabel.setBounds(20, 26, 46, 15);
		jContentPane.add(label_nameJLabel);
		textField_name = new JTextField();
		textField_name.setBounds(66, 22, 177, 21);
		textField_name.setColumns(10);
		jContentPane.add(textField_name);
		
		JLabel label_passw = new JLabel("����:");
		label_passw.setBounds(20, 56, 56, 24);
		jContentPane.add(label_passw);
		passwordField = new JPasswordField();
		passwordField.setBounds(66, 58, 177, 21);
		jContentPane.add(passwordField);
	
		System.out.println("yonghu");
		
		JLabel label_passack = new JLabel("ȷ������:");
		label_passack.setBounds(10, 90, 56, 24);
		jContentPane.add(label_passack);
		passwordField_ack = new JPasswordField();
		passwordField_ack.setBounds(66, 92, 177, 21);
		jContentPane.add(passwordField_ack);
		
		JLabel label_petname = new JLabel("�ǳ�:");
		label_petname.setBounds(20, 128, 46, 15);
		jContentPane.add(label_petname);
		textField_petname = new JTextField();
		textField_petname.setBounds(66, 124, 177, 21);
		textField_petname.setColumns(10);
		jContentPane.add(textField_petname);
		
		JLabel label_mail = new JLabel("����:");
		label_mail.setBounds(20, 159, 46, 15);
		jContentPane.add(label_mail);
		textField_mail = new JTextField();
		textField_mail.setBounds(66, 156, 177, 21);
		jContentPane.add(textField_mail);
		textField_mail.setColumns(10);
		
		JLabel label_sex = new JLabel("�Ա�:");
		label_sex.setBounds(20, 191, 46, 15);
		jContentPane.add(label_sex);
		
		this.sexGroup = new ButtonGroup();
		radioButton_m = new JRadioButton("��");
		radioButton_m.setBounds(66, 187, 66, 23);
		this.sexGroup.add(radioButton_m);
		this.jContentPane.add(radioButton_m);
		radioButton_f = new JRadioButton("Ů");
		radioButton_f.setBounds(146, 187, 97, 23);
		this.sexGroup.add(radioButton_f);
		this.jContentPane.add(radioButton_f);
		
		JLabel label_age = new JLabel("����:");
		label_age.setBounds(20, 219, 46, 15);
		jContentPane.add(label_age);
		textField_age = new JTextField();
		textField_age.setBounds(66, 216, 177, 21);
		jContentPane.add(textField_age);
		
		JLabel label_info = new JLabel("����ǩ��:");
		label_info.setBounds(10, 256, 66, 15);
		jContentPane.add(label_info);
		
		JButton button = new JButton("ע��");
		button.setBounds(26, 387, 70, 24);
		
		textArea_info = new JTextArea();
		textArea_info.setBounds(66, 252, 280, 177);
		jContentPane.add(textArea_info);
		scrollPane = new JScrollPane(textArea_info);
		jContentPane.add(scrollPane);
		
		button.addActionListener(new java.awt.event.ActionListener() {
		//@SuppressWarnings("deprecation")
			
		public void actionPerformed(java.awt.event.ActionEvent e) {
			try {

				// 102|�û���\0����\0�ǳ�\0����\0�Ա�\0����
				JTextField fields[] = {
						textField_name,
						textField_petname,
						textField_mail
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
					display("�п�ֵ�����������룡");
				}
				else if (isPasswordOK) {
					display("�����������벻һ��");
				}
				else {
					String sex = null;
					//ע�����
					if (radioButton_f.isSelected() == true) {
						sex = "Ů";
					}
					else {
						sex = "��";
					}
					
//					SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd HH:MM:SS");
//					String vTimestamp = df.format(new Date());
//					Timestamp creaTimestamp = Timestamp.valueOf(vTimestamp);
					
					//ע�� 102/�û���/����/�ǳ�/���� /�Ա�/����/����ǩ��
					UserInfo userInfo = UserInfo.getInstance();
					userInfo.setName(textField_name.getText());
					userInfo.setPassw(passwordField.getPassword().toString());
					userInfo.setPetname(textField_petname.getText());
					userInfo.setMail(textField_mail.getText());
					userInfo.setSex(sex);
					userInfo.setAge(Integer.parseInt(textField_age.getText()));
					userInfo.setInfo(textField_info.getText());
							
					boolean registerSuccess = userInfo.requestRegister();	
					if (registerSuccess)
					{
						display("ע��ɹ���");
						//System.out.println("success");
						//��ʾ���û�������
						//u.setName(textField_name.getName());
//						u.setPetname(textField_petname.getText().trim());
//						u.setInfo(textField_info.getText().trim());
//						thisFrame.setVisible(false);
						close();
						new UserFrame();
					}
					else{
						display("�û������������");
					}
				}	
			} catch (Exception e1) {
				display("��������ʧ��");
				System.out.println(e1.getMessage());
			} 
		}
	});

		jContentPane.add(button);
		
		JButton button_1 = new JButton("����");
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
		
		this.setTitle("ע��");
		this.setVisible(true);
	}
}
