package cn.edu.bjtu.chat.v;  
  
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
  
public class TestJTreeCount {  
  
    private JFrame jframeFriendList;  
    private JPanel jpanelFrendList;  
  
    private JButton jbtnOnlineFriendList, jbtnMyGroupChat;  
  
    
	private JList<DefaultMutableTreeNode> jlistOnlineFriendList;  
  
    private DefaultListModel<DefaultMutableTreeNode> defaultListModel;  
  
    private JScrollPane jscrollPaneOnlineFriendList;  
    private JScrollPane jscrollPaneOnlineFriendListJTree;  
  
    // ������  
    private JTree jtree;  
    // ���ýڵ�(�˽ڵ�Ϊ���ڵ�)  
    private DefaultMutableTreeNode dmtnRoot = new DefaultMutableTreeNode();  
  
    private DefaultMutableTreeNode dmtnOnlineUsersRoot = new DefaultMutableTreeNode(  
            "�ҵĺ���");  
  
    private DefaultMutableTreeNode dmtnMyGroup = new DefaultMutableTreeNode(  
            "�ҵ�Ⱥ");  
  
    private DefaultMutableTreeNode dmtnUnknownUsers = new DefaultMutableTreeNode(  
            "İ����");  
  
    private DefaultMutableTreeNode dmtnBlackName = new DefaultMutableTreeNode(  
            "������");  
  
    // ���ýڵ�(�˽ڵ�Ϊ�����б�ڵ�)  
    private DefaultMutableTreeNode dmtnLeaf;  
  
    private DefaultMutableTreeNode dmtnGroup = new DefaultMutableTreeNode("Ⱥ��");  
  
    public TestJTreeCount() {  
        // TODO Auto-generated constructor stub  
        initView();  
        acctionListener();  
        setOnlineList();  
    }  
      
    public static void main(String[] args) {  
    	System.out.println("sdfasdffffffff");
        new TestJTreeCount();  
        System.out.println("adfjadfhakdhfkajsdfhaksdj");
    }  
  
    // ��ͼ  
    public void initView() {  
        jframeFriendList = new JFrame();  
        jpanelFrendList = new JPanel();  
        defaultListModel = new DefaultListModel<DefaultMutableTreeNode>();  
        // jlistOnlineFriendList = new JList(defaultListModel);  
        jlistOnlineFriendList = new JList<DefaultMutableTreeNode>();  
  
        jbtnOnlineFriendList = new JButton("�����û�");  
        jbtnOnlineFriendList.setEnabled(false);  
        jbtnMyGroupChat = new JButton("ģ��QQ���");  
        jbtnMyGroupChat.setEnabled(false);  
        jpanelFrendList.setLayout(null);  
        //System.out.println("tree ");
        // �б���ʾ  
        // dmtnRoot.add(dmtnLeaf);  
        jtree = new JTree(dmtnRoot);  
        // ���ø��ڵ��Ƿ���ʾ  
        jtree.setRootVisible(true);  //??????????????????????important??????????????????????
        jtree.putClientProperty("JTree.lineStyle", "None");// �����  
        jtree.setShowsRootHandles(true);// ����ͼ��  
        //System.out.println("add nodes");
        dmtnRoot.add(dmtnOnlineUsersRoot);  
        dmtnRoot.add(dmtnMyGroup);  
        dmtnRoot.add(dmtnUnknownUsers);  
        dmtnRoot.add(dmtnBlackName);  
        dmtnMyGroup.add(dmtnGroup);  
        //System.out.println("done add nodes");
  
        jscrollPaneOnlineFriendListJTree = new JScrollPane(jtree);  
        jscrollPaneOnlineFriendList = new JScrollPane(jlistOnlineFriendList);  
         jscrollPaneOnlineFriendList.getViewport()  
         .setView(jlistOnlineFriendList);  
        jbtnOnlineFriendList.setBounds(0, 0, 250, 30);  
        jscrollPaneOnlineFriendList.setBounds(0, 30, 250, 570);  
        jscrollPaneOnlineFriendListJTree.setBounds(0, 30, 250, 570);  
        jbtnMyGroupChat.setBounds(0, 595, 250, 30);  
  
        jpanelFrendList.add(jbtnOnlineFriendList);  
  
        jpanelFrendList.add(jscrollPaneOnlineFriendListJTree);  
        // jpanelFrendList.add(jscrollPaneOnlineFriendList);  
  
        jpanelFrendList.add(jbtnMyGroupChat);  
        jframeFriendList.add(jpanelFrendList);  
  
        jframeFriendList.setSize(250, 650);  
        jframeFriendList.setResizable(false);  
        jframeFriendList.setLocationRelativeTo(null);  
        jframeFriendList  
                .setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        jframeFriendList.setVisible(true);  
    }  
  
    // �����¼�  
    public void acctionListener() {  
        // ѡ���������  
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
                            System.out.println("��˫���ˣ�" + strFriendUsername);  
                        }  
                    }  
                }  
            }  
        });  
  
        // �ر��¼�  
        jframeFriendList.addWindowListener(new WindowAdapter() {  
        
            public void windowClosing(WindowEvent e) {  
                // TODO Auto-generated method stub  
                // super.windowClosing(e);  
                System.exit(0);  
            }  
        });  
    }  
  
    // ���������б�  
    public void setOnlineList() {  
        String onlineUsers = null;  
        for (int i = 0; i < 5; i++) {  
            onlineUsers += "go";  
            dmtnLeaf = new DefaultMutableTreeNode(onlineUsers);  
            dmtnOnlineUsersRoot.add(dmtnLeaf);  
        }  
        jtree.updateUI();  
    }  
}




//
//boolean flag = false;
//String nodeString = dmtnRoot.getFirstLeaf().toString();
//DefaultMutableTreeNode temp = new DefaultMutableTreeNode();  
//for (int k = 0; k < dmtnRoot.getChildCount(); k++) {
//	if (v[4].endsWith(nodeString)) {
//		flag = true;
//		temp = dmtnRoot;
//		break;
//	}
//	nodeString = dmtnRoot.getNextLeaf().toString();
//	//dmtnRoot++;
//}
//if (flag == true) {
//	temp.add(dmtnLeaf);
//}
//else {
//	DefaultMutableTreeNode newGroup = new DefaultMutableTreeNode(v[4]);
//	newGroup.add(dmtnLeaf);
//}
// dmtnOnlineUsersRoot.add(dmtnLeaf);  
//dmtnRoot.add(dmtnOnlineUsersRoot);  
//dmtnRoot.add(dmtnMyGroup);  


//package cn.edu.bjtu.chat.v;  
//  
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//
//import javax.swing.DefaultListModel;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JList;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTree;
//import javax.swing.tree.DefaultMutableTreeNode;
//  
//public class TestJTreeCount {  
//  
//    private JFrame jframeFriendList;  
//    private JPanel jpanelFrendList;  
//  
//    private JButton jbtnOnlineFriendList, jbtnMyGroupChat;  
//  
//    
//	private JList<DefaultMutableTreeNode> jlistOnlineFriendList;  
//  
//    private DefaultListModel<DefaultMutableTreeNode> defaultListModel;  
//  
//    private JScrollPane jscrollPaneOnlineFriendList;  
//    private JScrollPane jscrollPaneOnlineFriendListJTree;  
//  
//    // ������  
//    private JTree jtree;  
//    // ���ýڵ�(�˽ڵ�Ϊ���ڵ�)  
//    private DefaultMutableTreeNode dmtnRoot = new DefaultMutableTreeNode();  
//  
//    private DefaultMutableTreeNode dmtnOnlineUsersRoot = new DefaultMutableTreeNode(  
//            "�ҵĺ���");  
//  
//    private DefaultMutableTreeNode dmtnMyGroup = new DefaultMutableTreeNode(  
//            "�ҵ�Ⱥ");  
//  
//    private DefaultMutableTreeNode dmtnUnknownUsers = new DefaultMutableTreeNode(  
//            "İ����");  
//  
//    private DefaultMutableTreeNode dmtnBlackName = new DefaultMutableTreeNode(  
//            "������");  
//  
//    // ���ýڵ�(�˽ڵ�Ϊ�����б�ڵ�)  
//    private DefaultMutableTreeNode dmtnLeaf;  
//  
//    private DefaultMutableTreeNode dmtnGroup = new DefaultMutableTreeNode("Ⱥ��");  
//  
//    public TestJTreeCount() {  
//        // TODO Auto-generated constructor stub  
//        initView();  
//        acctionListener();  
//        setOnlineList();  
//    }  
//      
//    public static void main(String[] args) {  
//    	System.out.println("sdfasdffffffff");
//        new TestJTreeCount();  
//        System.out.println("adfjadfhakdhfkajsdfhaksdj");
//    }  
//  
//    // ��ͼ  
//    public void initView() {  
//        jframeFriendList = new JFrame();  
//        jpanelFrendList = new JPanel();  
//        defaultListModel = new DefaultListModel<DefaultMutableTreeNode>();  
//        // jlistOnlineFriendList = new JList(defaultListModel);  
//        jlistOnlineFriendList = new JList<DefaultMutableTreeNode>();  
//  
//        jbtnOnlineFriendList = new JButton("�����û�");  
//        jbtnOnlineFriendList.setEnabled(false);  
//        jbtnMyGroupChat = new JButton("ģ��QQ���");  
//        jbtnMyGroupChat.setEnabled(false);  
//        jpanelFrendList.setLayout(null);  
//        //System.out.println("tree ");
//        // �б���ʾ  
//        // dmtnRoot.add(dmtnLeaf);  
//        jtree = new JTree(dmtnRoot);  
//        // ���ø��ڵ��Ƿ���ʾ  
//        jtree.setRootVisible(true);  //??????????????????????important??????????????????????
//        jtree.putClientProperty("JTree.lineStyle", "None");// �����  
//        jtree.setShowsRootHandles(true);// ����ͼ��  
//        //System.out.println("add nodes");
//        dmtnRoot.add(dmtnOnlineUsersRoot);  
//        dmtnRoot.add(dmtnMyGroup);  
//        dmtnRoot.add(dmtnUnknownUsers);  
//        dmtnRoot.add(dmtnBlackName);  
//        dmtnMyGroup.add(dmtnGroup);  
//        //System.out.println("done add nodes");
//  
//        jscrollPaneOnlineFriendListJTree = new JScrollPane(jtree);  
//        jscrollPaneOnlineFriendList = new JScrollPane(jlistOnlineFriendList);  
//         jscrollPaneOnlineFriendList.getViewport()  
//         .setView(jlistOnlineFriendList);  
//        jbtnOnlineFriendList.setBounds(0, 0, 250, 30);  
//        jscrollPaneOnlineFriendList.setBounds(0, 30, 250, 570);  
//        jscrollPaneOnlineFriendListJTree.setBounds(0, 30, 250, 570);  
//        jbtnMyGroupChat.setBounds(0, 595, 250, 30);  
//  
//        jpanelFrendList.add(jbtnOnlineFriendList);  
//  
//        jpanelFrendList.add(jscrollPaneOnlineFriendListJTree);  
//        // jpanelFrendList.add(jscrollPaneOnlineFriendList);  
//  
//        jpanelFrendList.add(jbtnMyGroupChat);  
//        jframeFriendList.add(jpanelFrendList);  
//  
//        jframeFriendList.setSize(250, 650);  
//        jframeFriendList.setResizable(false);  
//        jframeFriendList.setLocationRelativeTo(null);  
//        jframeFriendList  
//                .setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
//        jframeFriendList.setVisible(true);  
//    }  
//  
//    // �����¼�  
//    public void acctionListener() {  
//        // ѡ���������  
//        jtree.addMouseListener(new MouseAdapter() {  
//           
//            public void mouseClicked(MouseEvent e) {  
//                // TODO Auto-generated method stub  
//                // super.mouseClicked(e);  
//                int count = jtree.getRowForLocation(e.getX(), e.getY());  
//                if (e.getClickCount() == 1)  
//                    System.out.println(count);  
//                if (count != -1) {  
//                    String strFriendUsername = jtree  
//                            .getLastSelectedPathComponent().toString();  
//                    if (e.getClickCount() == 2 && count != 0  
//                            && !strFriendUsername.equals("İ����")  
//                            && !strFriendUsername.equals("������")  
//                            && !strFriendUsername.equals("�ҵ�Ⱥ")) {  
//                        if (jtree.isRowSelected(jtree.getRowForLocation(  
//                                e.getX(), e.getY()))) {  
//                            System.out.println("��˫���ˣ�" + strFriendUsername);  
//                        }  
//                    }  
//                }  
//            }  
//        });  
//  
//        // �ر��¼�  
//        jframeFriendList.addWindowListener(new WindowAdapter() {  
//        
//            public void windowClosing(WindowEvent e) {  
//                // TODO Auto-generated method stub  
//                // super.windowClosing(e);  
//                System.exit(0);  
//            }  
//        });  
//    }  
//  
//    // ���������б�  
//    public void setOnlineList() {  
//        String onlineUsers = null;  
//        for (int i = 0; i < 5; i++) {  
//            onlineUsers += "go";  
//            dmtnLeaf = new DefaultMutableTreeNode(onlineUsers);  
//            dmtnOnlineUsersRoot.add(dmtnLeaf);  
//        }  
//        jtree.updateUI();  
//    }  
//}
//
//
//
//
