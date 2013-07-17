package cn.edu.bjtu.chat.v;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.xml.internal.ws.Closeable;

import cn.edu.bjtu.chat.m.pojo.UserInfo;

public class UserInfoQueryFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = new JPanel();
	private UserInfo u = null;
	//private Socket socket = null;

	public UserInfoQueryFrame(UserInfo u) {
		super();
		this.u = u;
		initialize();
	}
//	public UserInfoQueryFrame(Socket s, UserInfo u) {
//		// TODO Auto-generated constructor stub
//		super();
//		this.s = s;
//		this.u = u;
//		initialize();
//	}


	private void initialize() {
		this.setSize(300, 500);
		this.setContentPane(getJContentPane());
		jContentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("ͷ��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		btnNewButton.setBounds(10, 10, 87, 73);
		jContentPane.add(btnNewButton);
		
		JLabel label = new JLabel("\u6635\u79F0");
		label.setBounds(107, 43, 33, 24);
		jContentPane.add(label);
		
		JComboBox<String> stateComboBox = new JComboBox<String>();
		stateComboBox.setBounds(107, 12, 70, 21);
		stateComboBox.addItem("--��ѡ��--");
		stateComboBox.addItem("����");
		stateComboBox.addItem("����");
		stateComboBox.addItem("æµ");
		stateComboBox.addItem("�뿪");
		stateComboBox.addItem("�������");
		stateComboBox.addItem("Q�Ұ�");
		stateComboBox.addItem("����");
		//String[] aList = {"����","����","æµ","�뿪","�������","Q�Ұ�","����"};
		//��ѯ�û���Ϣ��Э�� 106|״̬\0�ǳ�\0ID\0����\0����ǩ��\0�Ա�\0����\0����\0ע��ʱ��\0Ȩ��
		stateComboBox.setSelectedIndex(u.getState());
		jContentPane.add(stateComboBox);
		
		JLabel lblId = new JLabel("  ID:");
		lblId.setBounds(20, 93, 46, 24);
		jContentPane.add(lblId);
		
		JLabel label_2 = new JLabel("��ʵ����:");
		label_2.setBounds(20, 127, 54, 15);
		jContentPane.add(label_2);
		
		JLabel label_3 = new JLabel("�Ա�:");
		label_3.setBounds(30, 220, 46, 15);
		jContentPane.add(label_3);
		
		JLabel label_4 = new JLabel("����:");
		label_4.setBounds(30, 248, 46, 15);
		jContentPane.add(label_4);
		
		JLabel label_1 = new JLabel("����ǩ��:");
		label_1.setBounds(20, 158, 54, 24);
		jContentPane.add(label_1);
		
		JLabel lable20 = new JLabel(u.getMail());
		lable20.setBounds(76, 245, 177, 21);
		jContentPane.add(lable20);
		
		JLabel label_6 = new JLabel(u.getInfo());
		label_6.setBounds(76, 93, 177, 21);
		jContentPane.add(label_6);
		
		JLabel label_7 = new JLabel(u.getName());
		label_7.setBounds(76, 126, 177, 21);
		jContentPane.add(label_7);
		
		JLabel label_9 = new JLabel(u.getInfo());
		label_9.setBounds(76, 160, 177, 47);
		jContentPane.add(label_9);
		
		JLabel label_10 = new JLabel(u.getSex());
		label_10.setBounds(76, 217, 177, 21);
		jContentPane.add(label_10);
		
		JLabel label_11 = new JLabel("����:");
		label_11.setBounds(30, 276, 46, 15);
		jContentPane.add(label_11);
		
		JLabel label_12 = new JLabel(String.valueOf(u.getAge()));//int   to  string
		label_12.setBounds(76, 273, 188, 21);
		jContentPane.add(label_12);
		
		JLabel label_13 = new JLabel("Ȩ��:");
		label_13.setBounds(30, 304, 46, 15);
		jContentPane.add(label_13);
		
		JLabel label_14 = new JLabel(u.getPower());
		label_14.setBounds(76, 301, 177, 21);
		jContentPane.add(label_14);
		
		JLabel label_15 = new JLabel("ע��ʱ��:");
		label_15.setBounds(10, 332, 66, 15);
		jContentPane.add(label_15);
		
		String creattimeString = "";
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		creattimeString = format.format(u.getCreatetime());
		JLabel label_16 = new JLabel(creattimeString); //timestamp  to string
		label_16.setBounds(76, 329, 177, 21);
		jContentPane.add(label_16);
		
		JLabel label_17 = new JLabel("����ʱ��:");
		label_17.setBounds(10, 360, 66, 15);
		jContentPane.add(label_17);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd HH:MM:SS");
		String vTimestamp = df.format(new Date());
		Timestamp creaTimestamp = Timestamp.valueOf(vTimestamp);
		long timeLong = creaTimestamp.getTime() - u.getCreatetime().getTime();
		long day=timeLong/(24*60*60*1000);
	    long hour=(timeLong/(60*60*1000)-day*24);
	    long min=((timeLong/(60*1000))-day*24*60-hour*60);
	    long sec=(timeLong/1000-day*24*60*60-hour*60*60-min*60);
	      // System.out.println(""+day+"��"+hour+"Сʱ"+min+"��"+sec+"��");
		
		JLabel label_18 = new JLabel(""+day+"��"+hour+"Сʱ"+min+"��"+sec+"��");
		label_18.setBounds(76, 357, 188, 21);
		jContentPane.add(label_18);
		
		JButton btnNewButton_1 = new JButton("�޸�");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UserInfoModifyFrame(u);
			}
		});
		btnNewButton_1.setBounds(10, 428, 70, 23);
		jContentPane.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("����");//��ť��actionû��д������������������������������
//		btnNewButton_3.addAncestorListener(new WindowAdapter() {  
//		        
//		            public void windowClosing(WindowEvent e) {  
//		                // TODO Auto-generated method stub  
//		                // super.windowClosing(e);  
//		                System.exit(0);  
//		            }  
//		        });  
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.exit(0);
			}
		});
		btnNewButton_3.setBounds(204, 428, 70, 23);
		jContentPane.add(btnNewButton_3);
		
		JLabel label_19 = new JLabel(u.getPetname());
		label_19.setBounds(145, 45, 139, 21);
		jContentPane.add(label_19);
		this.setTitle("�û���ϸ��Ϣ");
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
