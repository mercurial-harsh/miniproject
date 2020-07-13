package lti.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import lti.dao.accountserv.AccountServiceImpl;
import lti.dao.customerserv.CustomerServiceImpl;
import lti.entity.AccountStatement;
import lti.entity.Customer;

public class DashboardUi extends JFrame implements ActionListener{
	JLabel l;
	JButton b;
	JPanel pmain,pnorth,psouth;
	
	private JLabel ltransfertype;
	private JComboBox<String> ctransfertype;
	private Font f1;
	private JLabel laccountnumber;
	private JLabel lifsc;
	private JTextField tifsc;
	private JTextField taccountnumber;
	private JLabel ltransactionbalance;
	private JTextField ttransactionbalance;
	private JButton tbutton;
	private JButton abutton;
	private String accnum;
	
	public DashboardUi(String accnum) {
		super("Transactions");
		
		this.accnum=accnum;
		setSize(600,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false); 
		setVisible(true);
	
		registerUi();
		welcomepanel();
		transactionpanel();
		
		detailspanel();
		
		
	}
	
//	public DashboardUi(){
//		super("Dashboard UI");
//		setSize(600,600);
//		setVisible(true);
//		l=new JLabel("Welcome..to Portal..");
//		b=new JButton("Logout");
//		
//		pmain=new JPanel();
//		
//		pnorth=new JPanel();
//		
//
//		add(pnorth,BorderLayout.SOUTH);
//		add(pmain,BorderLayout.NORTH);
//		
//
//		pmain.setBackground(Color.white);
//		pnorth.setBackground(Color.lightGray);
//		
//		
//		pnorth.add(l);
//		pnorth.add(b);
//		
//		detailspanel();
//		
//		b.addActionListener(this);
//	}
	
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
	public void welcomepanel() {
		l=new JLabel("Welcome..to Portal..");
		 
		b=new JButton("Logout");
		pnorth.add(l);
		pnorth.add(b);
		b.addActionListener(this);
	}
	public void transactionpanel() {
		pmain.setLayout(new GridLayout(5,2));
		
		ltransfertype=new JLabel("Choose Transactions Type");
		String transfertype[]={"IMPS","NEFT","RTGS"};
		ctransfertype=new JComboBox<String>(transfertype);
		
		pmain.add(ltransfertype);
		pmain.add(ctransfertype);
		
		
	}
	
	public void detailspanel() {
//		pmain.setLayout(new GridLayout(4,2));
		laccountnumber=new JLabel("Beneficiary account Number");
		taccountnumber=new JTextField(5);
		
		lifsc=new JLabel("Benefiaciary ifsc code");
		tifsc=new JTextField(5);
		
		ltransactionbalance=new JLabel("enter amount to be transfered");
		ttransactionbalance=new JTextField(10);
		
		pmain.add(laccountnumber);
		pmain.add(taccountnumber);
		
		pmain.add(lifsc);
		pmain.add(tifsc);
		
		pmain.add(ltransactionbalance);
		pmain.add(ttransactionbalance);
		
		tbutton=new JButton("Transact");
		pmain.add(tbutton);
		
		abutton=new JButton("Statement");
		pmain.add(abutton);
		
		
		abutton.addActionListener(this);
		tbutton.addActionListener(this);
		
		
	}
	
	
	public void actionPerformed(ActionEvent e) {

		String str=e.getActionCommand();
		String balance=ttransactionbalance.getText();
		String accountnumber=taccountnumber.getText();
		
		double transbalance=Double.parseDouble(balance);
		
		if(e.getSource()==tbutton) {
		double prevBalance=(double)new CustomerServiceImpl().getcurrentBalance(accnum)	;
		if(transbalance>prevBalance) {
			JOptionPane.showMessageDialog(this, new String("Not enough balance to perform this transaction!"));
		}
		else {
		AccountStatement accst=new AccountStatement("debit",transbalance,accountnumber,prevBalance);	
		
		int i=new AccountServiceImpl().transferfrom(accnum, accst);
		if(i>0) {
			JOptionPane.showMessageDialog(this, new String("Transfer successful"));
			
		}
		}
		
		if(e.getSource()==abutton) {
			new StatementUI(accnum);
		}
			
		}
		
		
		
		
		
		
		if(str.equals("Logout"));
		{
			new HomeUI();
			this.dispose();
		}
	}
}



	
//public void actionPerformed(ActionEvent e) {
//	
//	if(e.getSource()==blogin){
//		String uname=tuname.getText();
//		String upass = new String(tpass.getPassword());
//		System.out.println(uname);
//		System.out.println(upass);
//		System.out.println("harsh was here");
//		
//		if(new CustomerServiceImpl().login(uname,upass)){
//			DashboardUi d=new DashboardUi();
//			
//			System.out.println("got it logged in");
//			this.dispose();
//		}
//		else
//,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
//        {
//
//            JOptionPane.showMessageDialog(null,
//
//               "Incorrect username or password..Try Again with correct detail");
//
//        }
//	}
//	if(e.getSource()==bhome){
//		new HomeUI();
//		this.dispose();
//	}
//}
//}