package cn.edu.bjtu.chat.v;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.border.*;

/**
 * 作者：李　世贵
 * JDK: 1.6 
 * 来源: http://blog.csdn.net/lishigui 
 * 欢迎转接,请保留作者和来源,谢谢!
 * 2009-4-23 上午10:30:15
 */

public class FontFrame extends JDialog {
    private static final long serialVersionUID = 1L;
    JList fontpolics, fontstyle, fontsize, fontcolor;
    JTextField fontpolict, fontstylet, fontsizet, fontcolort;
    JButton[] ColorButton;
    String example;
    JLabel FontResolvent;
    JButton buttonok, buttoncancel;
    Color[] colors = { Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY,
            Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA,
            Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW };
    String[] colornames = { "BLACK", "BLUE", "CYAN", "DARK_GRAY", "GRAY",
            "GREEN", "LIGHT_GRAY", "MAGENTA", "ORANGE", "PINK", "RED", "WHITE",
            "YELLOW" };

    private JFrame frame;

    public FontFrame(JFrame owner, String title, boolean modal) {
        super(owner, title, modal);
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        this.frame = owner;

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        JPanel FontSet, FontView;
        FontSet = new JPanel(new GridLayout(1, 4));
        FontView = new JPanel(new GridLayout(1, 2));
        example = "AaBbCcDdEe";
        FontResolvent = new JLabel(example, JLabel.CENTER);
        FontResolvent.setBackground(Color.WHITE);

        ListSelectionListener selectionListener = new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (((JList) e.getSource()).getName().equals("polic")) {
                    fontpolict.setText((String) fontpolics.getSelectedValue());
                    FontResolvent.setFont(new Font(fontpolict.getText(), FontResolvent.getFont().getStyle(), FontResolvent.getFont().getSize()));
                }
                if (((JList) e.getSource()).getName().equals("style")) {
                    fontstylet.setText((String) fontstyle.getSelectedValue());
                    FontResolvent.setFont(new Font(FontResolvent.getFont().getFontName(), fontstyle.getSelectedIndex(),FontResolvent.getFont().getSize()));
                }
                if (((JList) e.getSource()).getName().equals("size")) {
                    fontsizet.setText((String) fontsize.getSelectedValue());
                    try {
                        Integer.parseInt(fontsizet.getText());
                    } catch (Exception excepInt) {
                        fontsizet.setText(FontResolvent.getFont().getSize()+ "");
                    }
                    FontResolvent.setFont(new Font(FontResolvent.getFont().getFontName(), FontResolvent.getFont().getStyle(),Integer.parseInt(fontsizet.getText())));
                }
                if (((JList) e.getSource()).getName().equals("color")) {
                    fontcolort.setText(colornames[fontcolor.getSelectedIndex()]);
                    FontResolvent.setForeground(colors[fontcolor.getSelectedIndex()]);
                }
            }
        };
        KeyListener keyListener = new KeyListener() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    if (((JTextField) e.getSource()).getName().equals("polic")) {
                        FontResolvent.setFont(new Font(fontpolict.getText(),FontResolvent.getFont().getStyle(),FontResolvent.getFont().getSize()));
                    }
                    if (((JTextField) e.getSource()).getName().equals("style")) {
                        fontstylet.setText((String) fontstyle.getSelectedValue());
                        FontResolvent.setFont(new Font(FontResolvent.getFont().getFontName(), fontstyle.getSelectedIndex(),FontResolvent.getFont().getSize()));
                    }
                    if (((JTextField) e.getSource()).getName().equals("size")) {
                        try {
                            Integer.parseInt(fontsizet.getText());
                        } catch (Exception excepInt) {
                            fontsizet.setText(FontResolvent.getFont().getSize()+ "");
                        }
                        FontResolvent.setFont(new Font(FontResolvent.getFont().getFontName(), FontResolvent.getFont().getStyle(), Integer.parseInt(fontsizet.getText())));
                    }
                }
            }

            public void keyReleased(KeyEvent e) {
            }

            public void keyTyped(KeyEvent e) {
            }
        };

        // 字体
        JPanel Fontpolic = new JPanel();
        Border border = BorderFactory.createLoweredBevelBorder();
        border = BorderFactory.createTitledBorder(border, "字体");
        Fontpolic.setBorder(border);
        Font[] fonts = java.awt.GraphicsEnvironment
                .getLocalGraphicsEnvironment().getAllFonts();
        int taille = fonts.length;
        String[] policnames = new String[taille];
        for (int i = 0; i < taille; i++) {
            policnames[i] = fonts[i].getName();
        }
        fontpolics = new JList(policnames);
        fontpolics.setName("polic");
        fontpolics.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        fontpolics.addListSelectionListener(selectionListener);
        fontpolics.setVisibleRowCount(6);
        fontpolict = new JTextField(policnames[0]);
        fontpolict.setName("polic");
        fontpolict.addKeyListener(keyListener);
        JScrollPane jspfontpolic = new JScrollPane(fontpolics);
        Fontpolic.setLayout(new BoxLayout(Fontpolic, BoxLayout.PAGE_AXIS));
        Fontpolic.add(fontpolict);
        Fontpolic.add(jspfontpolic);

        // 样式
        JPanel Fontstyle = new JPanel();
        border = BorderFactory.createLoweredBevelBorder();
        border = BorderFactory.createTitledBorder(border, "样式");
        Fontstyle.setBorder(border);
        String[] styles = { "PLAIN", "BOLD", "ITALIC", "BOLD ITALIC" };
        fontstyle = new JList(styles);
        fontstyle.setName("style");
        fontstyle.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        fontstyle.addListSelectionListener(selectionListener);
        fontstyle.setVisibleRowCount(6);
        fontstylet = new JTextField(styles[0]);
        fontstylet.setName("style");
        fontstylet.addKeyListener(keyListener);
        JScrollPane jspfontstyle = new JScrollPane(fontstyle);
        Fontstyle.setLayout(new BoxLayout(Fontstyle, BoxLayout.PAGE_AXIS));
        Fontstyle.add(fontstylet);
        Fontstyle.add(jspfontstyle);

        // 大小
        JPanel Fontsize = new JPanel();
        border = BorderFactory.createLoweredBevelBorder();
        border = BorderFactory.createTitledBorder(border, "大小");
        Fontsize.setBorder(border);
        String[] sizes = { "10", "14", "18", "22", "26", "30" };
        fontsize = new JList(sizes);
        fontsize.setName("size");
        fontsize.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        fontsize.addListSelectionListener(selectionListener);
        fontsize.setVisibleRowCount(6);
        fontsizet = new JTextField(sizes[0]);
        fontsizet.setName("size");
        fontsizet.addKeyListener(keyListener);
        JScrollPane jspfontsize = new JScrollPane(fontsize);
        Fontsize.setLayout(new BoxLayout(Fontsize, BoxLayout.PAGE_AXIS));
        Fontsize.add(fontsizet);
        Fontsize.add(jspfontsize);

        // 颜色
        JPanel Fontcolor = new JPanel();
        Border bordercolor = BorderFactory.createLoweredBevelBorder();
        bordercolor = BorderFactory.createTitledBorder(bordercolor, "颜色");
        Fontcolor.setBorder(bordercolor);
        fontcolor = new JList(colornames);
        fontcolor.setName("color");
        fontcolor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        fontcolor.addListSelectionListener(selectionListener);
        fontcolor.setVisibleRowCount(6);
        fontcolort = new JTextField(colornames[0].toString());
        fontcolort.setName("color");
        fontcolort.addKeyListener(keyListener);
        JScrollPane jspfontcolor = new JScrollPane(fontcolor);
        Fontcolor.setLayout(new BoxLayout(Fontcolor, BoxLayout.PAGE_AXIS));
        Fontcolor.add(fontcolort);
        Fontcolor.add(jspfontcolor);

        FontSet.add(Fontpolic);
        FontSet.add(Fontstyle);
        FontSet.add(Fontsize);
        FontSet.add(Fontcolor);

        FontView.add(FontResolvent);
        panel.add(FontSet);
        panel.add(FontView);

        JPanel panelnorth = new JPanel();
        panelnorth.setLayout(new FlowLayout());
        buttonok = new JButton("确定");
        buttoncancel = new JButton("取消");

        panelnorth.add(buttonok);
        panelnorth.add(buttoncancel);

        buttonok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.testLabel.setFont(FontResolvent.getFont());
                frame.testLabel.setForeground(FontResolvent.getForeground());
                FontFrame.this.setVisible(false);
            }
        });
        buttoncancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	FontFrame.this.setVisible(false);
            }
        });
        container.add(panel, BorderLayout.CENTER);
        container.add(panelnorth, BorderLayout.SOUTH);
        setSize(400, 300);
        this.setVisible(true);
    }
}

//package cn.edu.bjtu.chat.v;
//
//import java.awt.Font;
//import java.awt.GraphicsEnvironment;
//
//import javax.swing.JFrame;
//import javax.swing.JTextArea;
//import javax.swing.JScrollPane;
//
//public class FontFrame extends JFrame {
////	public FontFrame() {
////		getContentPane().setLayout(null);
////		
////		JTextArea textArea = new JTextArea();
////		JScrollPane scrollPane = new JScrollPane(textArea);
////		scrollPane.setBounds(0, 0, 514, 310);
////		getContentPane().add(scrollPane);
////		
////		//textArea.setFont(new Font( name,style,size);	
////		textArea.setFont(new Font(“Arial”,lFont.PLAIN,12));	
////		GraphicsEnvironment ef = GraphicsEnvironment.getLocalGraphicsEnvironment();
////		String[] f = ef.getAvailableFontFamilyNames();
////		
//////		设计字体显示效果 Font mf = new Font(String 字体，int 风格，int 字号);
//////		字体：TimesRoman, Courier, Arial等
//////		风格：三个常量 lFont.PLAIN, Font.BOLD, Font.ITALIC
//////		字号：字的大小（磅数）
//////		设置组件当前使用的字体：setFont(Font fn)
//////		获取组件当前使用的字体：getFont()
////	}
//
//}
