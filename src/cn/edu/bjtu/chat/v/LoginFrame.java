package cn.edu.bjtu.chat.v;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//import com.neusoft.test.c.GetThread;
//import com.neusoft.test.pojo.Userinfo;
//import com.neusoft.test.v.MainFrame;
//import com.neusoft.test.v.QQ;


import cn.edu.bjtu.chat.c.ReceiveThread;
import cn.edu.bjtu.chat.m.pojo.UserInfo;

import javax.swing.JPasswordField;

public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel lu = null;

	private JTextField tu = null;

	private JLabel lp = null;

	private JButton b1 = null;

	private JButton b2 = null;
	private JLabel label;
	private JLabel lblNewLabel;
	private JPasswordField tp;
	private String ip = "";
	private int port = 4001;
	private LoginFrame loginFrame = this;

	/**
	 * This is the default constructor
	 */
	public LoginFrame() {
		super();
		setLocation(new Point(300, 200));
		initialize();
	}

	private void init() {
		Properties p = new Properties();
		try {
			p.load(this.getClass().getResourceAsStream("init.properties"));
			ip = p.getProperty("ip");
			port = Integer.parseInt(p.getProperty("port"));
		} catch (IOException e) {
			System.out.println("配置文件没找到") ;
		}
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		init();
		this.setSize(360, 298);
		//this.setLocation(250,280);
		//this.setResizable(false);
		this.setTitle("登录");
		this.setDefaultCloseOperation(3);
		this.setContentPane(getJContentPane());
		//this.setUndecorated(true);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\\u5B66\u4E60\\\u5B9E\u8BAD\\2013-\u5B9E\u8BAD2\\QQ\\images\\QQ\u622A\u56FE20130714232000.jpg"));
		//this.setOpaque(false);
		this.setVisible(true);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			lp = new JLabel();
			lp.setForeground(Color.WHITE);
			lp.setFont(new Font("微软雅黑", Font.PLAIN, 14));
			lp.setBounds(new Rectangle(31, 150, 58, 24));
			lp.setText("密     码");
			lu = new JLabel();
			lu.setForeground(Color.WHITE);
			lu.setFont(new Font("微软雅黑", Font.PLAIN, 14));
			lu.setBounds(new Rectangle(31, 95, 50, 20));
			lu.setText("用 户 名");
			jContentPane = new JPanel();
			jContentPane.setBackground(new Color(200, 230, 250));
			jContentPane.setLayout(null);
			jContentPane.add(lu, null);
			jContentPane.add(getTu(), null);
			
			tp = new JPasswordField();
			tp.setBounds(97, 147, 217, 27);
			jContentPane.add(tp);
			jContentPane.add(lp, null);
			jContentPane.add(getB1(), null);
			jContentPane.add(getB2(), null);
			jContentPane.add(getLabel());
			jContentPane.add(getLblNewLabel());
			jContentPane.setOpaque(false);
		}
		return jContentPane;
	}

	/**
	 * This method initializes tu	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTu() {
		if (tu == null) {
			tu = new JTextField();
			tu.setBounds(new Rectangle(97, 95, 217, 27));
		}
		return tu;
	}

	public void display(String value){
		JOptionPane.showMessageDialog(this, value);
	}
	/**
	 * This method initializes b1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public void close(){
		this.setVisible(false);
	}
	private JButton getB1() {
		if (b1 == null) {
			b1 = new JButton();
			b1.setBounds(new Rectangle(43, 198, 168, 35));
			b1.setText("登录");
			b1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						if (tu.getText().trim().equals("") || tp.getPassword().toString().trim().equals("")) {
							display("有空值，请重新输入");
						}
						else {
							
							//System.out.println("登陆");
							Socket socket = new Socket(ip,port);
							//Socket s = new Socket("localhost",4002);
							//System.out.println("建立socket");
							String request = "101|"+tu.getText().trim()+"||"+tp.getText();
							PrintStream p = new PrintStream(socket.getOutputStream());
							p.println(request);
							p.flush();
							
							//接收服务器端的回值
							//System.out.println("接收服务器端的回值");
							InputStreamReader i =new InputStreamReader(socket.getInputStream());
							BufferedReader b = new BufferedReader(i);
							String response = b.readLine();
							
							int index = response.indexOf("|");
							String head = response.substring(0,index);
							UserInfo u = new UserInfo();
							if(head.equals("true")){
								String ss = response.substring(index+1);
								String v[] = ss.split("\\|\\|");
								
								u.setName(tu.getText());
								u.setPassw(tp.getText());
								u.setId(Integer.parseInt(v[0]));
								u.setPetname(v[1]);
								u.setMail(v[2]);
								u.setSex(v[3]);
								u.setAge(Integer.parseInt(v[4]));
								u.setInfo(v[5]);
								u.setPower(v[6]);
								//u.setState(v[7]);
								//u.setPic(v[7]);
								if(u.getPower().equals(1)){
									close();
									AdminFrame m = new AdminFrame(socket,u);
									m.setVisible(true);//socket??????????????????????????
									System.out.println("adminFrame");
									
								}
								else{
									close();
									UserFrame userFrame = new UserFrame(socket,u);
									userFrame.setVisible(true);;
									//JLabel petnameL = new JLabel();
									//petnameL.setText(v[1]);
									
									//P2PChat q = new P2PChat(u,s);
									//线程只用来接受信息
//									Thread t = new LoginThread(s,u);
//									t.start();	
								}
								loginFrame.dispose();//关闭frame
							}else{
								display("用户名或密码错误");
							}
						}
			
					} catch (Exception e1) {
						display("网络连接失败");
						System.out.println(e1.getMessage());
					} 
				}
			});
		}
		return b1;
	}

	/**
	 * This method initializes b2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getB2() {
		if (b2 == null) {
			b2 = new JButton();
			b2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e){
					RegisterFrame frame = new RegisterFrame();
					frame.setVisible(true);
					//System.out.println("login succee");
					}
				});
			
			b2.setBounds(new Rectangle(221, 198, 93, 35));
			b2.setText("注册");
		}
		return b2;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("欢 迎 使 用 即 时 通 信 系 统");
			label.setForeground(Color.MAGENTA);
			label.setFont(new Font("微软雅黑", Font.PLAIN, 17));
			label.setBounds(84, 41, 229, 44);
		}
		return label;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel(" ");
			lblNewLabel.setIcon(new ImageIcon("E:\\\u5B66\u4E60\\\u5B9E\u8BAD\\2013-\u5B9E\u8BAD2\\QQ\\images\\login1.jpg"));
			lblNewLabel.setBounds(0, 0, 345, 260);
		}
		return lblNewLabel;
	}
}  //  @jve:decl-index=0:visual-constraint="253,77"
