package cn.edu.bjtu.chat.v;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;

public class FindFriend extends JFrame {
	private JTextField textField;
	public FindFriend() {
		getContentPane().setLayout(null);
		
		JLabel label_friend = new JLabel("\u8981\u67E5\u627E\u7684\u597D\u53CB\u59D3\u540D:");
		label_friend.setBounds(26, 22, 115, 23);
		getContentPane().add(label_friend);
		
		textField = new JTextField();
		textField.setBounds(138, 23, 160, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JPanel Fpanel = new JPanel();
		Fpanel.setBounds(26, 70, 273, 122);
		getContentPane().add(Fpanel);
		Fpanel.setLayout(null);
		
		JLabel label_1 = new JLabel(" ");
		label_1.setBounds(59, 10, 184, 15);
		Fpanel.add(label_1);
		
		JLabel label_2 = new JLabel("\u6635\u79F0:");
		label_2.setBounds(10, 10, 39, 15);
		Fpanel.add(label_2);
		
		JLabel label_3 = new JLabel(" ");
		label_3.setBounds(59, 35, 184, 15);
		Fpanel.add(label_3);
		
		JLabel label_4 = new JLabel("\u6027\u522B:");
		label_4.setBounds(10, 35, 39, 15);
		Fpanel.add(label_4);
		
		JLabel label_5 = new JLabel(" ");
		label_5.setBounds(59, 60, 184, 15);
		Fpanel.add(label_5);
		
		JLabel label_6 = new JLabel("\u5E74\u9F84:");
		label_6.setBounds(10, 60, 39, 15);
		Fpanel.add(label_6);
		
		JButton button = new JButton("\u52A0\u4E3A\u597D\u53CB");
		button.setBounds(289, 202, 93, 23);
		getContentPane().add(button);
	}
}
