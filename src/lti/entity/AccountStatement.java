package lti.entity;
import java.time.Instant;
import java.sql.Date;
public class AccountStatement {
	private String transType;//"cash or transfer"+"credit or debit"
	private double transAmount;
	private Date transdate;
	private String accNum;
	private double finalBalance;
	
	public AccountStatement(String transType, double transAmount,String accNum,double prevBal) {
		this.transType = transType;
		this.transAmount = transAmount;
		this.accNum = accNum;
		setFinalBalance(transType,prevBal);
		setTransdate();
		
	}
	
	public AccountStatement(String transType,Date d,  double transAmount,double finalbalance) {
		this.transType = transType;
		this.transAmount = transAmount;
		this.transdate=d;
		this.finalBalance=finalbalance;
		
		
	}
	public double getFinalBalance() {
		return finalBalance;
	}
	public void setFinalBalance(String type,double finalBalance) {
		if(type.toLowerCase().equals("debit")) {
		this.finalBalance = this.finalBalance-(finalBalance);}
		this.finalBalance = this.finalBalance+(finalBalance);
	}
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	public double getTransAmount() {
		return transAmount;
	}
	public void setTransAmount(double transAmount) {
		this.transAmount = transAmount;
	}
	public Date getTransdate() {
		return transdate;
	}
	public void setTransdate() {
		
		
		this.transdate = new Date(Instant.now().toEpochMilli());
	}
	public String getAccNum() {
		return accNum;
	}
	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}
	
}
