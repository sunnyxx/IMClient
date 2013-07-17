package cn.edu.bjtu.chat.v;

import javax.swing.JFrame;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.event.*;

public class FontFrame extends JPanel implements ActionListener,
  ListSelectionListener {
 private JDialog jd;// ������ʾģ̬�Ĵ���
 private JComboBox fonts;// ����ѡ�������������
 private JList face, size;// ����ѡ�����κ��ֺŵ��б�
 private JTextField sizeJT;// ������ʾѡ�е����κ��ֺ�
 private JButton ok, cancel;// ��ʾѡ�к�ȡ���İ�ť
 private Font current;// ��ʾ��Ȼѡ�е�����
 private GraphicsEnvironment ge;// ��ʾ��ǰ��ͼ�λ���
 private JLabel demo;// ��ʾԤ����label
 private String fontName = "���� ";
 private int fontStyle = Font.PLAIN, fontSize = 20;
 private Frame owner;// ��ʾ������������
 private Hashtable<String, Integer> ht;// ���ֵ���С��ӳ��

 /** Creates a new instance of JFontChooser */
 private FontFrame() {
  initOther();
 }

 private void initOther() {
  current = new Font(fontName, fontStyle, fontSize);
  ht = new Hashtable<String, Integer>();
  sizeJT = new JTextField("20 ");
  sizeJT.setEditable(false);
  sizeJT.setBounds(260, 40, 50, 20);
  ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
  String[] family = ge.getAvailableFontFamilyNames();
  fonts = new JComboBox(family);
  fonts.setEditable(false);
  fonts.setMaximumRowCount(5);
  demo = new JLabel("��ɿƼ�     ABCD   abcd ", JLabel.CENTER);
  demo.setFont(current);
  String[] faceString = { "���� ", "���� ", "б�� ", "����+б�� " };
  String[] sizeString = { "���� ", "С�� ", "һ�� ", "Сһ ", "���� ", "С�� ",
    "���� ", "С�� ", "�ĺ� ", "С�� ", "��� ", "С�� ", "���� ", "С�� ", "�ߺ� ",
    "�˺� ", "5 ", "8 ", "9 ", "10 ", "11 ", "12 ", "14 ", "16 ",
    "18 ", "20 ", "22 ", "24 ", "26 ", "28 ", "36 ", "48 ", "72 " };
  int[] sizeValue = { 42, 36, 26, 24, 22, 18, 16, 15, 14, 12, 11, 9, 7,
    6, 5, 4, 5, 8, 9, 10, 11, 12, 14, 16, 18, 20, 22, 24, 26, 28,
    36, 48, 72 };
  for (int i = 0; i < sizeString.length; i++) {
   ht.put(sizeString[i], sizeValue[i]);
  }
  face = new JList(faceString);
  size = new JList(sizeString);
  face.setSelectedIndex(0);
  size.setSelectedIndex(25);
  fonts.setSelectedItem("���� ");
  face.setVisibleRowCount(4);
  size.setVisibleRowCount(4);
  ok = new JButton("ȷ�� ");
  cancel = new JButton("ȡ�� ");
  ok.addActionListener(this);
  cancel.addActionListener(this);
  fonts.addActionListener(this);
  face.addListSelectionListener(this);
  size.addListSelectionListener(this);
 }

 private void initWindow(String title) {
  this.setLayout(new BorderLayout());
  JLabel fontLabel = new JLabel("���� ");
  JLabel faceLabel = new JLabel("���� ");
  JLabel sizeLabel = new JLabel("�ֺ� ");
  fontLabel.setForeground(Color.RED);
  faceLabel.setForeground(Color.RED);
  sizeLabel.setForeground(Color.RED);
  fontLabel.setBounds(20, 20, 100, 20);
  faceLabel.setBounds(180, 20, 80, 20);
  sizeLabel.setBounds(260, 20, 50, 20);
  fonts.setBounds(10, 40, 127, 21);
  JScrollPane faceScroll = new JScrollPane(face);
  JScrollPane sizeScroll = new JScrollPane(size);
  faceScroll.setBounds(180, 40, 65, 100);
  sizeScroll.setBounds(260, 60, 50, 80);
  JPanel up = new JPanel(null);
  JPanel center = new JPanel(new BorderLayout());
  JPanel bottom = new JPanel();
  up.setPreferredSize(new Dimension(345, 160));
  up.add(fontLabel);
  up.add(faceLabel);
  up.add(sizeLabel);
  up.add(fonts);
  up.add(faceScroll);
  up.add(sizeScroll);
  up.add(sizeJT);
  // up.setBorder(BorderFactory.createTitledBorder( "ѡ���� "));
  center.add(demo, BorderLayout.CENTER);
  center.setBorder(BorderFactory.createTitledBorder("Ԥ�� "));
  bottom.add(ok);
  bottom.add(cancel);
  this.add(up, BorderLayout.NORTH);
  this.add(center, BorderLayout.CENTER);
  this.add(bottom, BorderLayout.SOUTH);
  jd = new JDialog(owner, title, true);
  jd.getContentPane().add(this, BorderLayout.CENTER);
  jd.setSize(360, 360);
  jd.setResizable(false);
  jd.setLocationRelativeTo(owner);
  jd.addWindowListener(new WindowAdapter() {
   public void windowClosing(WindowEvent we) {
    current = null;
    jd.dispose();
   }
  });
  jd.setVisible(true);
 }

 public void actionPerformed(ActionEvent ae) {
  if (ae.getSource() == fonts) {
   fontName = (String) fonts.getSelectedItem();
   current = new Font(fontName, fontStyle, fontSize);
   demo.setFont(current);
   this.repaint();
  } else if (ae.getSource() == ok) {
   jd.dispose();
  } else if (ae.getSource() == cancel) {
   current = null;
   jd.dispose();
  }
 }

 public void valueChanged(ListSelectionEvent le) {
  if (le.getSource() == face) {
   String value = (String) face.getSelectedValue();
   if (value.equals("���� ")) {
    fontStyle = Font.PLAIN;
   } else if (value.equals("���� ")) {
    fontStyle = Font.BOLD;
   } else if (value.equals("б�� ")) {
    fontStyle = Font.ITALIC;
   } else if (value.equals("����+б�� ")) {
    fontStyle = Font.ITALIC | Font.BOLD;
   }
   current = new Font(fontName, fontStyle, fontSize);
   demo.setFont(current);
   this.repaint();
  } else if (le.getSource() == size) {
   String sizeName = (String) size.getSelectedValue();
   sizeJT.setText(sizeName);
   fontSize = ht.get(sizeName);
   current = new Font(fontName, fontStyle, fontSize);
   demo.setFont(current);
   this.repaint();
  }
 }

// public static Font showDialog(Frame owner, String title) {
//  FontFrame jf = new FontFrame();
//  jf.initWindow(title);
//  return jf.current;
// }
// 
// public static void main(String[] args) {
//	  System.out.println(FontFrame.showDialog(null, "����ѡ�� "));
//	 }
}
