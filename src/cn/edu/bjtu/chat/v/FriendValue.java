package cn.edu.bjtu.chat.v;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JSlider;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTextField;

public class FriendValue extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = new JPanel();
	private JTextField textField;
	
	public FriendValue() {
		super();
		initialize();
	}
	
	private void initialize() {
		this.setSize(300, 500);
		this.setContentPane(getJContentPane());
		jContentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("头像");
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
		lblId.setBounds(20, 93, 46, 24);
		jContentPane.add(lblId);
		
		JLabel label_4 = new JLabel("\u9B45\u529B\u503C:");
		label_4.setBounds(10, 122, 56, 15);
		jContentPane.add(label_4);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(76, 119, 177, 21);
		jContentPane.add(lblNewLabel_1);
		
		JLabel label_6 = new JLabel("New label");
		label_6.setBounds(76, 93, 177, 21);
		jContentPane.add(label_6);
		
		JLabel label_11 = new JLabel("\u4E8B\u4EF6:");
		label_11.setBounds(20, 147, 33, 15);
		jContentPane.add(label_11);
		
		JLabel label_15 = new JLabel("\u6DFB\u52A0\u4E8B\u4EF6:");
		label_15.setBounds(10, 305, 66, 15);
		jContentPane.add(label_15);
		
		JButton btnNewButton_1 = new JButton("\u6DFB\u52A0");
		btnNewButton_1.setBounds(204, 407, 70, 23);
		jContentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("删除");
		btnNewButton_2.setBounds(204, 283, 70, 23);
		jContentPane.add(btnNewButton_2);
		
		JLabel label_19 = new JLabel("New label");
		label_19.setBounds(145, 45, 139, 21);
		jContentPane.add(label_19);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(63, 147, 211, 138);
		jContentPane.add(textArea);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(63, 147, 211, 138);
		jContentPane.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane((Component) null);
		scrollPane_1.setBounds(63, 320, 211, 46);
		jContentPane.add(scrollPane_1);
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);
		
		JLabel label_1 = new JLabel("\u8BBE\u7F6E\u9B45\u529B\u503C:");
		label_1.setBounds(10, 372, 66, 15);
		jContentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(63, 388, 211, 21);
		jContentPane.add(textField);
		textField.setColumns(10);
		this.setTitle("用户详细信息");
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
