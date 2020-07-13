package lti.entity;

public class Account {
	
	private String accNumber;
	
	private double balance;

	

	public Account(String accNumber, double balance) {
		this.accNumber=accNumber;
		this.balance = balance;
	}

	public String getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(String accNumber) {
		this.accNumber = "LTI"+accNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	

	
	
	//make additional changes regarding balance sheet statement
}
