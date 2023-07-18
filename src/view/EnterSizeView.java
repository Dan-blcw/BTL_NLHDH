package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.EnterSizeController;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.net.URL;
// import java.awt.BorderLayout;


public class EnterSizeView extends JFrame{
    private JTextField jTextFieldKeyWord;
    private JLabel jLabel_Result;
    private JLabel background_image;
    private JPanel background;
    private JPanel content;
    public EnterSizeView(){
        this.inIt();
    }
    public void inIt(){
        this.setSize(350,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        
        Font font = new java.awt.Font("sansserif", 3, 14);
        Font font_title = new java.awt.Font("sansserif", 3, 18);
        
        EnterSizeController  sr = new EnterSizeController(this);
        
        JButton jButton_statistical = new JButton("Enter Size");
        jButton_statistical.setFont(font);
        jButton_statistical.addActionListener(sr);
        jButton_statistical.setBackground(Color.WHITE);
        background= new JPanel();
        content= new JPanel();
        background_image=new JLabel();	
        background_image.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(EnterSizeView.class.getResource("main.png"))));
        background.add(background_image);
        jLabel_Result = new JLabel();
        jLabel_Result.setFont(font);
        JLabel jLabelKeyWord = new JLabel(" Please enter the size of Program !!!");
        jLabelKeyWord.setFont(font_title);
        jTextFieldKeyWord = new  JTextField();
        jTextFieldKeyWord.setFont(font);
        content.setLayout(new BorderLayout());
        content.add(jLabelKeyWord, BorderLayout.NORTH);
        content.add(jTextFieldKeyWord, BorderLayout.CENTER);
        content.add(jButton_statistical,BorderLayout.SOUTH);
        this.setLayout(new BorderLayout());
        this.add(background,BorderLayout.NORTH);
        this.add(content,BorderLayout.SOUTH);
        this.setVisible(true);
    }
    public void createMainFramework() {
    	if(jTextFieldKeyWord.getText() != null) {
    		String jText = jTextFieldKeyWord.getText();
    		int size = Integer.parseInt(jText);
    		new SampleView(size);
    		this.dispose();
    	}else {
    		ShowMesseger("Error !!! Please type something");
    	}
	}
    public void ShowMesseger(String decripl) {
		JOptionPane.showMessageDialog(this, decripl);
	}
    
}
