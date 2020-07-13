package lti.dao.accountserv;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lti.dbcon.DBConnection;
import lti.entity.AccountStatement;
import lti.entity.Customer;

public class AccountServiceImpl {
	DBConnection db=new DBConnection();
	Connection con;
	int i=0;
	
	
	public boolean initCustomerBalanceSheet(String accountnumber) {
		
		try {
			con=db.getConnection();
			Statement stt = con.createStatement();
			//String s="LTI508384845198";
			//stt.execute("DROP TABLE IF EXISTS LTI");
			stt.execute("CREATE TABLE "+accountnumber+" (transtype varchar(10),transAmount Decimal(7,2), transdate date,amount decimal(7,2))");
			
			return true;
			
		    }
			
			
			
			catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		return false;
		
	}
	
	public int transferfrom(String accountnumber,AccountStatement as) {
		
	
		con=db.getConnection();
		try {
			PreparedStatement pstate=con.prepareStatement("insert into "+accountnumber+" values(?,?,?,?)");
			pstate.setString(1,as.getTransType());
			pstate.setDouble(2,as.getTransAmount());
			pstate.setDate(3, as.getTransdate());
			as.setFinalBalance(as.getTransType(),as.getTransAmount());
			pstate.setDouble(4,as.getFinalBalance());
//			pstate.setInt(5,s.getAdhar());
//			pstate.setString(6,s.getPan());
//			pstate.setString(7,s.getEmail());
//			pstate.setInt(8,s.getMobile());
//			pstate.setInt(1,c.getAccountNumber());
//			pstate.setInt(2,c.getActive());
			i=pstate.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return i;
	}
	
	public void transferinto(String accountnumber,AccountStatement as) {
		
		
		con=db.getConnection();
		try {
			PreparedStatement pstate=con.prepareStatement("insert into "+accountnumber+" values(?,?,CURRENT_TIMESTAMP,?)");
			pstate.setString(1,as.getTransType());
			pstate.setDouble(2,as.getTransAmount());
			as.setFinalBalance(as.getTransType(),as.getTransAmount());
			pstate.setDouble(3,as.getFinalBalance());
//			pstate.setInt(5,s.getAdhar());
//			pstate.setString(6,s.getPan());
//			pstate.setString(7,s.getEmail());
//			pstate.setInt(8,s.getMobile());
//			pstate.setInt(1,c.getAccountNumber());
//			pstate.setInt(2,c.getActive());
			i=pstate.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<AccountStatement> getTransactions(String accnumber){
		
		ArrayList<AccountStatement> asl=new ArrayList<AccountStatement>();
	
		con=db.getConnection();
		try {
			PreparedStatement pstate=con.prepareStatement("select * from "+accnumber);
			
			
			 ResultSet rs = pstate.executeQuery();
			 
			 if(rs.next()){
				 	
					String transtype= rs.getString(1);
					double transamount= rs.getDouble(2);
					Date d=rs.getDate(3);
					double finalbalance=rs.getDouble(4);
					
					
					asl.add(new AccountStatement(transtype,d,transamount,finalbalance));
				 	
					
					}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return asl;
	
}
}
