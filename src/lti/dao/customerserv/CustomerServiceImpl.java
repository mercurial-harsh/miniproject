package lti.dao.customerserv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lti.dbcon.DBConnection;
import lti.entity.Customer;

public class CustomerServiceImpl {

	DBConnection db=new DBConnection();
	Connection con;
	int i=0;
	
	public int addcustomer(Customer c){
		con=db.getConnection();
		try {
			PreparedStatement pstate=con.prepareStatement("insert into Customer values(?,?,?,?,?,?,?,?,?,?)");
			pstate.setString(1,c.getName());
			pstate.setString(2,c.getAddress());
			pstate.setString(3,c.getPassword());
			pstate.setString(4,c.getUsername());
			pstate.setString(5,c.getAdhar());
			pstate.setString(6,c.getPan());
			pstate.setString(7,c.getEmail());
			pstate.setString(8,c.getMobile());
			pstate.setString(9,c.getAccountNumber());
			pstate.setInt(10,c.getActive());
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
	
	public String login(String uname,String upass) {

		System.out.println("harsh was here");
		con=db.getConnection();
		String accnum=null;
		try {
			
			PreparedStatement ps = con.prepareStatement("select accnum from Customer where username=? and password=?");

            ps.setString(1, uname);

            ps.setString(2, upass);

            ResultSet rs = ps.executeQuery();
			if(rs.next()){
			accnum= rs.getString(1);
				System.out.println("harsh was here too");
				return accnum;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return accnum;
	}
	
	public double getcurrentBalance(String accnumber) {

		System.out.println("harsh was here");
		con=db.getConnection();
		Double balance=(double)0.0;
		try {
			
			PreparedStatement ps = con.prepareStatement("Select amount from "+accnumber+" where transdate =(select max(transdate) from "+accnumber+")");

           

            ResultSet rs = ps.executeQuery();
			if(rs.next()){
			balance= rs.getDouble(1);
				System.out.println("harsh was here too");
				return balance;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return balance;
	}
	

}
