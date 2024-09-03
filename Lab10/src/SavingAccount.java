
public class SavingAccount extends BankAccount{
	
	private double rate = .025; //annual rate
	 private int savingsNumber = 0;
	 private String accountNumber;

	public SavingAccount(String name, double bal) {
		// TODO Auto-generated constructor stub
		
		super(name, bal);
		
		accountNumber = super.getAccountNumber() + "-" + savingsNumber;
	}
	
	 public SavingAccount(SavingAccount oldAccount, double bal)
	 {
	  super(oldAccount, bal);
	  savingsNumber = oldAccount.savingsNumber + 1;
	  accountNumber = super.getAccountNumber() + "-" + savingsNumber;
	 } 
	
	public void postInterest()
	 {
	  //rate is an annual rate, and we only one one month's worth of interest.
	  double newBalance = getBalance() * (1 +rate/12);
	  setBalance(newBalance);
	 }
	
	 public String getAccountNumber()
	 {
	  return accountNumber; 
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
