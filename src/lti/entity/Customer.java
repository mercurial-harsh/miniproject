package lti.entity;
import java.sql.Date;
public class Customer {
	
	private Account account;
	private AccountStatement accst;
	
	

	private String name;
	private String address;
	
	
	private int active;//0 for inactive 1 for active
	
	private String password;
	private String username;//check uniqueness or deploy reverse logic
	
	private String adhar;
	private String pan;
	
	private String email;
	private String mobile;
	
	
	
	public Customer(String name, String address, int active, String password,
			String username, String adhar, String pan, String email, String mobile,String balance) {
		
		this.name = name;
		this.address = address;
		this.active = active;
		this.password = password;
		this.username = username;
		this.adhar = adhar;
		this.pan = pan;
		this.email = email;
		this.mobile = mobile;
		account=new Account(adhar,Double.parseDouble(balance));
		//accst=new AccountStatement("credit", Double.parseDouble(balance),account.getAccNumber());
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAdhar() {
		return adhar;
	}
	public void setAdhar(String adhar) {
		this.adhar = adhar;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public AccountStatement getAccst() {
		return accst;
	}
	public void setAccst(AccountStatement accst) {
		this.accst = accst;
	}
	public String getAccountNumber() {
		return ("LTI"+adhar);
	}
	
	public double getAccountBalance() {
		return account.getBalance();
	}
	
	

	
	
	
	
}
