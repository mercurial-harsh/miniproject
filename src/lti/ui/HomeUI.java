package lti.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class HomeUI extends JFrame implements ActionListener{
	
	JPanel pmain,pnorth,psouth;
	Font f1;
	JButton bregister,blogin;
	
	public HomeUI(){
		super("Home Page");
		setSize(600,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
       
		
		registerUi();
		createPanel1();
		createPanel2();
	}
	
	public void registerUi(){
		pmain=new JPanel();
		pnorth=new JPanel();
		psouth=new JPanel();
		add(pnorth,BorderLayout.NORTH);
		add(pmain,BorderLayout.CENTER);
		add(psouth,BorderLayout.SOUTH);
		pmain.setBackground(Color.white);
		pnorth.setBackground(Color.lightGray);
		psouth.setBackground(Color.lightGray);
		f1=new Font("Times New Roman",Font.BOLD,44);

	}
	public void createPanel1(){
		//Panel North
		JLabel lbl=new JLabel("AGILE BANKING");
		pnorth.add(lbl);
		lbl.setFont(f1);
	}
	
	public void createPanel2(){
		//Panel Main..
		psouth.setLayout(new GridLayout(4,1));
		bregister=new JButton("Register Customer");
		blogin=new JButton("Customer Login");
		
		psouth.setVisible(true);  
		psouth.add(bregister);
		psouth.add(blogin);
		bregister.addActionListener(this);
		blogin.addActionListener(this);
	
	}
	public void createPanel3() throws IOException{
//		BufferedImage myPicture = ImageIO.read(new File("C:\\Users\\harsh\\Downloads\\images-banking"));
//		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
//		
		JLabel lbl=new JLabel("speed banking at your service");
		pmain.add(lbl);
		lbl.setFont(new Font("Times New Roman",Font.BOLD,33));
		
		pmain.setVisible(true);  
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bregister){
//			NewCustomerUI obj = new NewCustomerUI();
//		    obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		    obj.setSize(250,320);
//		    obj.setVisible(true);
//			this.dispose();
			new CustomerUI();
			this.dispose();
		}
		if(e.getSource()==blogin){
			new LoginUi();
			this.dispose();
		}
	}
}
