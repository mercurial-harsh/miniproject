package lti.ui;

import java.util.regex.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import lti.dao.accountserv.AccountServiceImpl;
import lti.dao.customerserv.CustomerServiceImpl;
import lti.entity.Customer;

//import lti.dao.EmployeeService;
//import lti.dao.EmployeeServiceImpl;
//import lti.entity.Employee;

import java.awt.event.*;

public class CustomerUI extends JFrame implements ActionListener{	
	JFrame fregister;
	JPanel pmain,pnorth,psouth;
	JLabel lbl;
	JLabel lregNo,lfname,luname,lpass,lcpass,laddr,lcity,lstate,lgender;
	JTextField tregNo,tfname;
	JPasswordField tpass,tcpass;
	JTextArea taddr;
	JComboBox<String> ccity;
	JList<String> lststate;

	JButton bregister,breset,bhome,bexit;
	Font f1;
	private JLabel lname;
	private JTextField tname;
	private JLabel laddress;
	private JTextField taddress;
	private JTextField tuname;
	private JLabel ladhar;
	private JTextField tadhar;
	private JLabel lpan;
	private JTextField tpan;
	private JLabel lemail;
	private JTextField temail;
	private JLabel lmobile;
	private JTextField tmobile;
	private JLabel lbalance;
	private JTextField tbalance;
	
	private JButton checkbutton;

	public CustomerUI(){
		super("New Registration");
		setSize(600,600);
		setVisible(true);
	
		registerUi();
		createPanel1();
		createPanel2();
		createPanel3();
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
		lbl=new JLabel("New Customer");
		pnorth.add(lbl);
		lbl.setFont(f1);
	}
	public void createPanel2(){
		//Panel Main..
		GridLayout gl=new GridLayout(10,2);
		pmain.setLayout(gl);
		lname=new JLabel("Name");
		tname=new JTextField(10);

		laddress=new JLabel("Address");
		taddress=new JTextField(10);

		luname=new JLabel("User Name ");
		tuname=new JTextField(5);
		
		lpass=new JLabel("Password");
		tpass=new JPasswordField(5);

		

//		laddr=new JLabel("Address");
//		taddr=new JTextArea(15);
		
		ladhar=new JLabel("Adhar");
		tadhar=new JTextField(12);

		lpan=new JLabel("Pan card");
		tpan=new JTextField(10);


		lpan=new JLabel("Pan card");
		tpan=new JTextField(12);
		
		lemail=new JLabel("Email");
		temail=new JTextField(12);
		
		lmobile=new JLabel("Mobile");
		tmobile=new JTextField(10);
		
		lbalance=new JLabel("Balance");
		tbalance=new JTextField(10);
		
		checkbutton=new JButton("Check");


//		lcity=new JLabel("City");
//		String city[]={"Mumbai","Pune","Chennai"};
//		ccity=new JComboBox<String>(city);
//
//		lstate=new JLabel("State");
//		String state[]={"Maharashtra","TN"};
//		lststate=new JList<String>(state);

		pmain.add(lname);
		pmain.add(tname);
		
		pmain.add(laddress);
		pmain.add(taddress);
		
		pmain.add(luname);
		pmain.add(tuname);
		
		pmain.add(lpass);
		pmain.add(tpass);
		
		pmain.add(ladhar);
		pmain.add(tadhar);
		
		pmain.add(lpan);
		pmain.add(tpan);
		
		pmain.add(lemail);
		pmain.add(temail);
		
		pmain.add(lmobile);
		pmain.add(tmobile);
		
		pmain.add(lbalance);
		pmain.add(tbalance);
		pmain.add(checkbutton);
		
		checkbutton.addActionListener(this);

	}
	public void createPanel3(){
		//panel south button..
		psouth.setLayout(new GridLayout(1,4));
		bregister=new JButton("Registration");
		breset=new JButton("Reset");
		bhome=new JButton("Home Page");
		bexit=new JButton("Exit");
		bregister.setEnabled(false);

		psouth.add(bregister);
		psouth.add(breset);
		psouth.add(bhome);
		psouth.add(bexit);

		bregister.addActionListener(this);
	
		breset.addActionListener(this);
		bhome.addActionListener(this);
		bexit.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==checkbutton) {
			
			if((Pattern.matches("[a-zA-Z0-9]{6}",tuname.getText()))){
				
				if((Pattern.matches("\\d{12}",tadhar.getText()))){
					
					if((Pattern.matches("[A-Z]{5}\\d{5}",tpan.getText()))){
						
						if((Pattern.matches("[789]{1}\\d{9}",tmobile.getText()))){
							
							if((Pattern.matches("\\d{0,7}",tbalance.getText()))){
								String str=temail.getText();
								if((Pattern.matches("^(.+)@(.+)$",str))){
									bregister.setEnabled(true);
								}
								else {
									JOptionPane.showMessageDialog(this, new String("Enter valid email"));
								}
							}
							else {
								JOptionPane.showMessageDialog(this, new String("Enter valid balance"));
							}
						}
						else {
							JOptionPane.showMessageDialog(this, new String("Enter valid Mobile"));
						}
					}
					else {
						JOptionPane.showMessageDialog(this, new String("Enter valid Pan"));
					}
				}
				else {
					JOptionPane.showMessageDialog(this, new String("Enter valid Adhar"));
				}
			}
			else {
				JOptionPane.showMessageDialog(this, new String("Enter valid username of 6 characters"));
			}
		}
			
		
	
		if(e.getSource()==bregister){
			boolean b=true;
			while(b) {
			
			String name=tname.getText();
			String add=taddress.getText();
			String uname=tuname.getText();
			String pass=new String(tpass.getPassword());
//			String ct=ccity.getSelectedItem().toString();
			
//			String st="MH";
			//System.out.println(Integer.parseInt(tadhar.getText()));
			String adhar=tadhar.getText();
			
			
			
			
			
			
			
			
			
			
			
			String mobile=tmobile.getText();
			
			
			
	
			String pan=tpan.getText();
			
			
			
			String email=temail.getText();
			String balance=tbalance.getText();
			
			
			Customer cs=new Customer(name,add,0,pass,uname,adhar,pan,email,mobile,balance);
			CustomerServiceImpl csi=new CustomerServiceImpl();
			AccountServiceImpl asi=new AccountServiceImpl();
			int i=csi.addcustomer(cs);
			
			if(i>0){
				JOptionPane.showMessageDialog(this, new String("Sent details for Admin verification Successfully..."));
				if(asi.initCustomerBalanceSheet(cs.getAccountNumber())==true) {
					JOptionPane.showMessageDialog(this, new String("Your have been initialised for processing"));
				}
				new LoginUi();
				this.dispose();
//				JOptionPane.showMessageDialog(this, new String("Record Save Successfully..."));				
			}
		}
		if(e.getSource()==breset){
			tregNo.setText("");
			tfname.setText("");
			tpass.setText("");
			taddr.setText("");
		}
		if(e.getSource()==bhome){
			new HomeUI();
			this.dispose();
		}
		if(e.getSource()==bexit){
			this.dispose();
		}
	}

}}
