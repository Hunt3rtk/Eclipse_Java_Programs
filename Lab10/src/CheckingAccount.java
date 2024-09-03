
public class CheckingAccount extends BankAccount{
	
	static double FEE = 0.15;

	public CheckingAccount(String name, double amount) {
		// TODO Auto-generated constructor stub
		
		
		super(name, amount);
		
		String accountNumber = getAccountNumber();
		
		setAccountNumber(accountNumber + "-10");
	}
	
	public boolean withdraw(double amount)
	{

	     amount += FEE;
		 
	     return super.withdraw(amount);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
