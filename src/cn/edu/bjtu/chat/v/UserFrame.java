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
	 // 设置树
	 private JTree jtree = null;
	 // 设置节点(此节点为跟节点)
	 private DefaultMutableTreeNode dmtnRoot = null;
	 private DefaultMutableTreeNode dmtnOnlineUsersRoot = null;
	 private DefaultMutableTreeNode dmtnMyGroup = null;
	 private DefaultMutableTreeNode dmtnUnknownUsers  = null;
	 private DefaultMutableTreeNode dmtnBlackName = null;
	 // 设置节点(此节点为好友列表节点)
	 private DefaultMutableTreeNode dmtnLeaf = null;
	 private DefaultMutableTreeNode dmtnGroup = null; 
     
    
	/**
	 * This is the default constructor
	 */
	public UserFrame() {
		super();
		userInfo = UserInfo.getInstance();//u只申明，没有new，所以两者指向同一个对象
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
		this.setTitle("即时通信系统");
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
			jLabel1.setText("评论");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(40, 83, 40, 20));
			jLabel.setText("提醒");
			infoLabel = new JLabel();
			infoLabel.setBounds(new Rectangle(94, 45, 48, 27));
			infoLabel.setText("个人签名");
			
			petnameLable = new JLabel();
			petnameLable.setBounds(new Rectangle(188, 7, 30, 27));
			petnameLable.setText("昵称");
			
			
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
			jbtnOnlineFriendList = new JButton("全部好友");
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
			picButton.setText("头像");
			picButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						String request = "106|"+userInfo.getName();
						PrintStream p = new PrintStream(s.getOutputStream());
						p.println(request);
						p.flush();
						//接收服务器端的回值
						//System.out.println("接收服务器端的回值");
						InputStreamReader i =new InputStreamReader(s.getInputStream());
						BufferedReader b = new BufferedReader(i);
						String response = b.readLine();
						
						int index = response.indexOf("|");
						String head = response.substring(0,index);
						//查询用户信息  根据用户的昵称
						//查询用户信息的协议 106|状态\0昵称\0ID\0姓名\0个人签名\0性别\0邮箱\0年龄\0注册时间\0权限
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
						display("网络连接失败");
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
			//String[] aList = {"在线","隐身","忙碌","离开","请勿打扰","Q我吧","离线"};
			
			stateComboBox.addItem("---请选择---");
			stateComboBox.addItem("在线");
			stateComboBox.addItem("隐身");
			stateComboBox.addItem("忙碌");
			stateComboBox.addItem("离开");
			stateComboBox.addItem("请勿打扰");
			stateComboBox.addItem("Q我吧");
			stateComboBox.addItem("离线");
			
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
			jButton.setText("提醒");
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
			jButton1.setText("评论");
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
			jButton2.setText("查找好友");
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
        jbtnMyGroupChat = new JButton("模拟QQ设计");  
        jbtnMyGroupChat.setEnabled(false);  
        jpanelFrendList.setLayout(null);  
        
        dmtnRoot = new DefaultMutableTreeNode(); 
        dmtnOnlineUsersRoot = new DefaultMutableTreeNode("我的好友"); 
        dmtnMyGroup = new DefaultMutableTreeNode("我的群");  
        dmtnUnknownUsers = new DefaultMutableTreeNode("陌生人"); 
        dmtnBlackName = new DefaultMutableTreeNode("黑名单");  
        dmtnGroup = new DefaultMutableTreeNode("群聊");  
        
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
        // 列表显示  
        // dmtnRoot.add(dmtnLeaf);  
        jtree = new JTree(dmtnRoot);  
        // 设置根节点是否显示  
        jtree.setRootVisible(true);  //??????????????????????important??????????????????????
        jtree.putClientProperty("JTree.lineStyle", "None");// 清除线  
        jframeFriendList_1.setLayout(null);
        jtree.setShowsRootHandles(true);// 设置图标  
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
        
        //选择好友聊天
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
                            && !strFriendUsername.equals("陌生人")  
                            && !strFriendUsername.equals("黑名单")  
                            && !strFriendUsername.equals("我的群")) { 
                        if (jtree.isRowSelected(jtree.getRowForLocation(  
                                e.getX(), e.getY()))) {  
                        	UserInfo friendInfo = new UserInfo();
                        	friendInfo.setName(strFriendUsername);
                        	new P2PChat(friendInfo, s);//
                            System.out.println("你双击了：" + strFriendUsername);  
                        } 
                    }  
                }  
            }  
        });     
        return jframeFriendList_1;
	}
	
	 //显示好友分组
    public class actionl implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			//查询好友及分组信息  根据用户的昵称
			//查询好友及分组信息 113|姓名\0好友名\0成为好友时间\0魅力值\0所在组\0备注\0好友数
			String request = "113|"+userInfo.getName(); //给服务器
			try {
				PrintStream p = new PrintStream(s.getOutputStream());
				p.println(request);
				p.flush();
				//System.out.println("flush");
				//接收服务器端的回值
				InputStreamReader i =new InputStreamReader(s.getInputStream());
				BufferedReader b = new BufferedReader(i);
				String response = b.readLine();
				
				int index = response.indexOf("|");
				String head = response.substring(0,index);
				//System.out.println("lianjie");
				if(head.equals("true"))
				{
				     //设置在线列表
					// 113|姓名\0好友名\0成为好友时间\0魅力值\0所在组\0备注\0好友数
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
			
//	        // 关闭事件  
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