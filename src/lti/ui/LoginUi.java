package lti.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
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

import lti.dao.customerserv.CustomerServiceImpl;
import lti.dbcon.DBConnection;

//import lti.dao.EmployeeService;
//import lti.dao.EmployeeServiceImpl;
//import lti.dbcon.DbConnection;
//import lti.entity.Employee;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginUi extends JFrame implements ActionListener{	

	JPanel pmain;
	JLabel luname,lpass;
	JTextField tuname;
	JPasswordField tpass;
	JButton blogin,bhome;

	public LoginUi(){
		super("Login UI");
		setSize(400,200);
		setVisible(true);

		GridLayout gl=new GridLayout(3,2);
		setLayout(gl);

		luname=new JLabel("User Name ");
		lpass=new JLabel("Password");

		tuname=new JTextField();
		tpass=new JPasswordField();

		blogin=new JButton("Login");
		bhome=new JButton("Home");

		add(luname);
		add(tuname);
		add(lpass);
		add(tpass);
		add(blogin);
		add(bhome);
		
		blogin.addActionListener(this);
		bhome.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==blogin){
			String uname=tuname.getText();
			String upass = new String(tpass.getPassword());
			System.out.println(uname);
			System.out.println(upass);
			
			String accnum=new CustomerServiceImpl().login(uname,upass);
			if(accnum!=null){
				new DashboardUi(accnum);
				
				System.out.println("got it logged in");
				this.dispose();
			}
			else

            {

				JOptionPane.showMessageDialog(this, new String("details"));

            }
		}
		if(e.getSource()==bhome){
			new HomeUI();
			this.dispose();
		}
	}
}