package cn.edu.bjtu.chat.v;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.PortUnreachableException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import cn.edu.bjtu.chat.m.pojo.UserInfo;

public class UserFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JButton picButton = null;
	private JLabel petnameLable = null;
	private JLabel infoLabel = null;
	private JComboBox<String> stateComboBox = null;
	private JButton jButton = null;
	private JLabel jLabel = null;
	private JButton jButton1 = null;
	private JLabel jLabel1 = null;
	private JButton jButton2 = null;
	private JTextField infoL;
	private UserInfo userInfo = null;
	
	 private JPanel jframeFriendList = null;
	 private JPanel jframeFriendList_1;
	 private JPanel jpanelFrendList = null;
	 private JButton jbtnOnlineFriendList = null; 
	 private JButton jbtnMyGroupChat = null;
	 private JList<DefaultMutableTreeNode> jlistOnlineFriendList = null;
	 private DefaultListModel<DefaultMutableTreeNode> defaultListModel = null;
	 private JScrollPane jscrollPaneOnlineFriendList = null;
	 private JScrollPane jscrollPaneOnlineFriendListJTree = null;
	 // ������
	 private JTree jtree = null;
	 // ���ýڵ�(�˽ڵ�Ϊ���ڵ�)
	 private DefaultMutableTreeNode dmtnRoot = null;
	 private DefaultMutableTreeNode dmtnOnlineUsersRoot = null;
	 private DefaultMutableTreeNode dmtnMyGroup = null;
	 private DefaultMutableTreeNode dmtnUnknownUsers  = null;
	 private DefaultMutableTreeNode dmtnBlackName = null;
	 // ���ýڵ�(�˽ڵ�Ϊ�����б�ڵ�)
	 private DefaultMutableTreeNode dmtnLeaf = null;
	 private DefaultMutableTreeNode dmtnGroup = null; 
     
    
	/**
	 * This is the default constructor
	 */
	public UserFrame() {
		super();
		userInfo = UserInfo.getInstance();//uֻ������û��new����������ָ��ͬһ������
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 500);
		this.setContentPane(getJContentPane());
		this.setTitle("��ʱͨ��ϵͳ");
		this.setVisible(true);
	}
	/**
	 * This method initializes jContentPane
	 * s
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(128, 82, 40, 20));
			jLabel1.setText("����");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(40, 83, 40, 20));
			jLabel.setText("����");
			infoLabel = new JLabel();
			infoLabel.setBounds(new Rectangle(94, 45, 48, 27));
			infoLabel.setText("����ǩ��");
			
			petnameLable = new JLabel();
			petnameLable.setBounds(new Rectangle(188, 7, 30, 27));
			petnameLable.setText("�ǳ�");
			
			
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			
//			JComboBox<?> comboBox = new JComboBox();
//			JLabel image1 = new JLabel();
//			JLabel image2 = new JLabel();
//			comboBox.setBounds(63, 60, 26, 16);
//			jContentPane.add(comboBox);
//			comboBox.add(image1);
//			comboBox.add(image2);
			jContentPane.add(getPicButton(), null);
			jContentPane.add(petnameLable, null);
			
			JLabel petnameL = new JLabel(userInfo.getPetname());
			petnameL.setBounds(220, 10, 64, 21);
			jContentPane.add(petnameL);
			jContentPane.add(infoLabel, null);
			jContentPane.add(getstateComboBox(), null);
			jContentPane.add(getJButton(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(getJButton1(), null);
			jContentPane.add(getJButton2(), null);
			jContentPane.add(jLabel1, null);
			//System.out.println("output");
			jContentPane.add(getfriendJPanel(),null);
			jbtnOnlineFriendList = new JButton("ȫ������");
			jbtnOnlineFriendList.setBounds(0, 1, 104, 23);
			jframeFriendList_1.add(jbtnOnlineFriendList);
			jbtnOnlineFriendList.setEnabled(false);
			//System.out.println("end");
			
			infoL = new JTextField(userInfo.getInfo());
			infoL.setBounds(152, 51, 131, 18);
			jContentPane.add(infoL);
			infoL.setColumns(10);
			
			
			//this.setJMenuBar(remindmenu);
			
			//jContentPane.add(getJPanel(), null);
			//jContentPane.add(remindPanel);
		
		}
		return jContentPane;
	}
	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getPicButton() {
		if (picButton == null) {
			picButton = new JButton();
			picButton.setBounds(new Rectangle(5, 5, 87, 73));
			picButton.setText("ͷ��");
			picButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						String request = "106|"+userInfo.getName();
						PrintStream p = new PrintStream(s.getOutputStream());
						p.println(request);
						p.flush();
						//���շ������˵Ļ�ֵ
						//System.out.println("���շ������˵Ļ�ֵ");
						InputStreamReader i =new InputStreamReader(s.getInputStream());
						BufferedReader b = new BufferedReader(i);
						String response = b.readLine();
						
						int index = response.indexOf("|");
						String head = response.substring(0,index);
						//��ѯ�û���Ϣ  �����û����ǳ�
						//��ѯ�û���Ϣ��Э�� 106|״̬\0�ǳ�\0ID\0����\0����ǩ��\0�Ա�\0����\0����\0ע��ʱ��\0Ȩ��
						if(head.equals("true")){
							String ss = response.substring(index+1);
							String v[] = ss.split("\\|\\|");
							
							userInfo.setState(Integer.parseInt(v[0]));
							userInfo.setPetname(v[1]);
							userInfo.setId(Integer.parseInt(v[2]));
							userInfo.setName(v[3]);
							userInfo.setInfo(v[4]);
							userInfo.setSex(v[5]);
							userInfo.setMail(v[6]);
							userInfo.setAge(Integer.parseInt(v[7]));
							
							SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd HH:MM:SS");
							v[8] = df.format(new Date());
							Timestamp creaTimestamp = Timestamp.valueOf(v[8]);
							userInfo.setCreatetime(creaTimestamp);
							userInfo.setPower(v[9]);
							
							new UserInfoQueryFrame(s,userInfo);
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						display("��������ʧ��");
					}
				}
			});
		}
		return picButton;
	}
	/**
	 * This method initializes jComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox<String> getstateComboBox() {
		if (stateComboBox == null) {
			stateComboBox = new JComboBox<String>();
			//String[] aList = {"����","����","æµ","�뿪","�������","Q�Ұ�","����"};
			
			stateComboBox.addItem("---��ѡ��---");
			stateComboBox.addItem("����");
			stateComboBox.addItem("����");
			stateComboBox.addItem("æµ");
			stateComboBox.addItem("�뿪");
			stateComboBox.addItem("�������");
			stateComboBox.addItem("Q�Ұ�");
			stateComboBox.addItem("����");
			
			stateComboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					userInfo.setState(stateComboBox.getSelectedIndex());
				}
			});
			
			stateComboBox.setBounds(new Rectangle(102, 12, 75, 18));
		}
		return stateComboBox;
	}
	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(0, 84, 30, 18));
			jButton.setText("����");
		}
		return jButton;
	}
	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new Rectangle(88, 83, 30, 18));
			jButton1.setText("����");
		}
		return jButton1;
	}
	
	/**
	 * This method initializes jButton2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setBounds(new Rectangle(0, 437, 91, 23));
			jButton2.setText("���Һ���");
		}
		return jButton2;
	}
	
	public void display(String value){
		JOptionPane.showMessageDialog(this, value);
	}
	
	private JPanel getfriendJPanel(){
		
		jframeFriendList_1 = new JPanel();  
		jframeFriendList_1.setLocation(0, 104);
        jpanelFrendList = new JPanel();  
        jpanelFrendList.setBounds(190, 165, 1, 1);
        defaultListModel = new DefaultListModel<DefaultMutableTreeNode>();  
        // jlistOnlineFriendList = new JList(defaultListModel);  
        jlistOnlineFriendList = new JList<DefaultMutableTreeNode>();  
  
        System.out.println("list");
        jbtnMyGroupChat = new JButton("ģ��QQ���");  
        jbtnMyGroupChat.setEnabled(false);  
        jpanelFrendList.setLayout(null);  
        
        dmtnRoot = new DefaultMutableTreeNode(); 
        dmtnOnlineUsersRoot = new DefaultMutableTreeNode("�ҵĺ���"); 
        dmtnMyGroup = new DefaultMutableTreeNode("�ҵ�Ⱥ");  
        dmtnUnknownUsers = new DefaultMutableTreeNode("İ����"); 
        dmtnBlackName = new DefaultMutableTreeNode("������");  
        dmtnGroup = new DefaultMutableTreeNode("Ⱥ��");  
        
        //System.out.println("add nodes");
        dmtnRoot.add(dmtnOnlineUsersRoot);  
        dmtnRoot.add(dmtnMyGroup);  
        dmtnRoot.add(dmtnUnknownUsers);  
        dmtnRoot.add(dmtnBlackName);  
        dmtnMyGroup.add(dmtnGroup);  
        jscrollPaneOnlineFriendList = new JScrollPane(jlistOnlineFriendList);  
         jscrollPaneOnlineFriendList.getViewport()  
         .setView(jlistOnlineFriendList);
        jscrollPaneOnlineFriendList.setBounds(0, 30, 250, 570);  
        //System.out.println("tree ");
        // �б���ʾ  
        // dmtnRoot.add(dmtnLeaf);  
        jtree = new JTree(dmtnRoot);  
        // ���ø��ڵ��Ƿ���ʾ  
        jtree.setRootVisible(true);  //??????????????????????important??????????????????????
        jtree.putClientProperty("JTree.lineStyle", "None");// �����  
        jframeFriendList_1.setLayout(null);
        jtree.setShowsRootHandles(true);// ����ͼ��  
        //System.out.println("done add nodes");
  
        jscrollPaneOnlineFriendListJTree = new JScrollPane(jtree);  
        jscrollPaneOnlineFriendListJTree.setBounds(0, 22, 250, 306);
        jframeFriendList_1.add(jscrollPaneOnlineFriendListJTree);
        jbtnMyGroupChat.setBounds(0, 595, 250, 30);
        // jpanelFrendList.add(jscrollPaneOnlineFriendList);  
  
        jpanelFrendList.add(jbtnMyGroupChat);  
        jframeFriendList_1.add(jpanelFrendList);  
  
        jframeFriendList_1.setSize(250, 323);  
        //jframeFriendList.setResizable(false);  
        //jframeFriendList.setLocationRelativeTo(null);  
        //jframeFriendList  
               // .setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        jframeFriendList_1.setVisible(true);  
        
        //ѡ���������
        jtree.addMouseListener(new MouseAdapter() {  
            
            public void mouseClicked(MouseEvent e) {  
                // TODO Auto-generated method stub  
                // super.mouseClicked(e);  
            	
                int count = jtree.getRowForLocation(e.getX(), e.getY());
                if (e.getClickCount() == 1)  
                    System.out.println(count);  
                if (count != -1) {  
                    String strFriendUsername = jtree  
                            .getLastSelectedPathComponent().toString(); 
                    if (e.getClickCount() == 2 && count != 0  
                            && !strFriendUsername.equals("İ����")  
                            && !strFriendUsername.equals("������")  
                            && !strFriendUsername.equals("�ҵ�Ⱥ")) { 
                        if (jtree.isRowSelected(jtree.getRowForLocation(  
                                e.getX(), e.getY()))) {  
                        	UserInfo friendInfo = new UserInfo();
                        	friendInfo.setName(strFriendUsername);
                        	new P2PChat(friendInfo, s);//
                            System.out.println("��˫���ˣ�" + strFriendUsername);  
                        } 
                    }  
                }  
            }  
        });     
        return jframeFriendList_1;
	}
	
	 //��ʾ���ѷ���
    public class actionl implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			//��ѯ���Ѽ�������Ϣ  �����û����ǳ�
			//��ѯ���Ѽ�������Ϣ 113|����\0������\0��Ϊ����ʱ��\0����ֵ\0������\0��ע\0������
			String request = "113|"+userInfo.getName(); //��������
			try {
				PrintStream p = new PrintStream(s.getOutputStream());
				p.println(request);
				p.flush();
				//System.out.println("flush");
				//���շ������˵Ļ�ֵ
				InputStreamReader i =new InputStreamReader(s.getInputStream());
				BufferedReader b = new BufferedReader(i);
				String response = b.readLine();
				
				int index = response.indexOf("|");
				String head = response.substring(0,index);
				//System.out.println("lianjie");
				if(head.equals("true"))
				{
				     //���������б�
					// 113|����\0������\0��Ϊ����ʱ��\0����ֵ\0������\0��ע\0������
				    String ss = response.substring(index+1); 
				    String onlineUsers = null;
				    String v[] = ss.split("\\|\\|");
				    for (int j = 0; j < Integer.parseInt(v[6]); j++) {  
				        onlineUsers = v[j];  
				        dmtnLeaf = new DefaultMutableTreeNode(onlineUsers);  
				        boolean flag = false;
				        String nodeString = dmtnRoot.getFirstLeaf().toString();
				        DefaultMutableTreeNode temp = new DefaultMutableTreeNode();  
				        for (int k = 0; k < dmtnRoot.getChildCount(); k++) {
							if (v[4].endsWith(nodeString)) {
								flag = true;
								temp = dmtnRoot;
								break;
							}
							nodeString = dmtnRoot.getNextLeaf().toString();
							//dmtnRoot++;
						}
				        if (flag == true) {
				        	temp.add(dmtnLeaf);
						}
				        else {
				        	DefaultMutableTreeNode newGroup = new DefaultMutableTreeNode(v[4]);
				        	newGroup.add(dmtnLeaf);
						}
				       // dmtnOnlineUsersRoot.add(dmtnLeaf);  
				        //dmtnRoot.add(dmtnOnlineUsersRoot);  
				        //dmtnRoot.add(dmtnMyGroup);  
				    }  
				    jtree.updateUI(); 
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
//					p.println("113|"+f.getName()+":"+f.getFriendname()+":"+f.getBftime()
//							+":"+f.getValue()+":"+f.getGroup()+":"+f.getRemark());
////					System.out.println(f.getName()+":"+f.getFriendname()+":"+f.getBftime()
////							+":"+f.getValue()+":"+f.getGroup()+":"+f.getRemark());	
		}
    }
			
//	        // �ر��¼�  
//	        jframeFriendList.addAncestorListener(new WindowAdapter() {  
//	        
//	            public void windowClosing(WindowEvent e) {  
//	                // TODO Auto-generated method stub  
//	                // super.windowClosing(e);  
//	                System.exit(0);  
//	            }  
//	        });  
//	  
}