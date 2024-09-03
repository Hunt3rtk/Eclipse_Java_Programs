
public class Account {

	double balance;
	
	Account(double balance) {
		// TODO Auto-generated constructor stub
		
		this.balance = balance;
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	public void deposit(double moneyInput)
	{
		balance += moneyInput;
	}
	
	public void withdraw(double moneyOutput)
	{
		balance -= moneyOutput;
	}
	public String toString()
	{
		return "The Account balance is: " + balance;
	}
}
