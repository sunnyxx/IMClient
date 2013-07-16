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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.neusoft.test.c.GetThread;
import com.neusoft.test.pojo.Userinfo;
import com.neusoft.test.v.MainFrame;
import com.neusoft.test.v.QQ;

import cn.edu.bjtu.chat.c.LoginThread;
import cn.edu.bjtu.chat.m.pojo.UserInfo;
import cn.edu.bjtu.chat.util.Network;

import javax.swing.JPasswordField;

public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel lu = null;

	private JTextField tu = null;

	private JLabel lp = null;

	private JButton b1 = null;

	private JButton registerButton = null;
	private JLabel label;
	private JLabel lblNewLabel;
	private JPasswordField tp;

	/**
	 * This is the default constructor
	 */
	public LoginFrame() {
		super();
		setLocation(new Point(300, 200));
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(360, 298);
		//this.setLocation(250,280);
		//this.setResizable(false);
		this.setTitle("µ«¬º");
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
			lp.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
			lp.setBounds(new Rectangle(31, 150, 58, 24));
			lp.setText("√‹     ¬Î");
			lu = new JLabel();
			lu.setForeground(Color.WHITE);
			lu.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
			lu.setBounds(new Rectangle(31, 95, 50, 20));
			lu.setText("”√ ªß √˚");
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
			jContentPane.add(getRegisterButton(), null);
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
			b1.setText("µ«¬º");
			b1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						if (tu.getText().trim().equals("") || tp.getText().trim().equals("")) {
							display("”–ø’÷µ£¨«Î÷ÿ–¬ ‰»Î");
						}
						else {
							
							//µ«¬Ω
							UserInfo userInfo = UserInfo.getInstance();
							userInfo.setName(tu.getText());
							userInfo.setPassw(tp.getPassword().toString());
							boolean loginSuccess = userInfo.requestLogin();
							
							if (loginSuccess) {
								if(userInfo.isAdmin()){
									close();
									AdminFrame m = new AdminFrame();
									System.out.println("adminFrame");
								}
								else{
										close();
										new UserFrame();
										//JLabel petnameL = new JLabel();
										//petnameL.setText(v[1]);
										
										//P2PChat q = new P2PChat(u,s);
										//Thread t = new LoginThread(s,u);
										//t.start();	
									}
							}
							
							else{
								display("”√ªß√˚ªÚ√‹¬Î¥ÌŒÛ");
							}
						}
						
			
					} catch (Exception e1) {
						display("Õ¯¬Á¡¨Ω” ß∞‹");
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
	private JButton getRegisterButton() {
		if (registerButton == null) {
			registerButton = new JButton();
			registerButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e){

					close();

					new RegisterFrame();
					}
				});
			
			registerButton.setBounds(new Rectangle(221, 198, 93, 35));
			registerButton.setText("◊¢≤·");
		}
		return registerButton;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("ª∂ ”≠  π ”√ º¥  ± Õ® –≈ œµ Õ≥");
			label.setForeground(Color.MAGENTA);
			label.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 17));
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
