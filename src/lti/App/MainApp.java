package lti.App;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import lti.dao.accountserv.AccountServiceImpl;
import lti.dao.customerserv.CustomerServiceImpl;
import lti.dbcon.DBConnection;
import lti.ui.HomeUI;

public class MainApp {
	
	public static void main(String[] args) {
		
		System.out.println("HomeUI initiated");
		
		HomeUI home=new HomeUI();
		
//		CustomerServiceImpl cs=new CustomerServiceImpl();
//		AccountServiceImpl as=new AccountServiceImpl();
//		System.out.println("initiated data");
//		as.initCustomerBalanceSheet();
//		System.out.println("initiated data");
		
	}
	
	public static void initialiseMiniDatabase() {

		try {
			DBConnection db=new DBConnection();
			Connection con=db.getConnection();;
			
			Statement stt = con.createStatement();
			
			//stt.execute("DROP TABLE IF EXISTS LTI");
			stt.execute("CREATE TABLE Customer (name varchar2(10),address VARCHAR2(15),password VARCHAR2(5),username VARCHAR2(5),adhaar number(12),pan VARCHAR2(11),email VARCHAR2(),mobile number(10),accnum varchar2(15) primary key,active number(1))");
			
//			stt.execute("CREATE TABLE CustomerMeta("password VARCHAR2(5),username VARCHAR2(5)"); do this later GO LEAN
   
		    }
			
			
			
			catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
