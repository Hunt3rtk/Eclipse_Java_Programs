
public class CheckingAccount extends Account{

	double overdraftLimit;
	
	public CheckingAccount(double balance, double overdraftLimit) {
		// TODO Auto-generated constructor stub
		super(balance);
		this.overdraftLimit = overdraftLimit;
	}
	public void chequeDeposit(double deposit)
	{
		balance += deposit;
	}
	
	public String toString()
	{
		return "The Account balance is: " + balance + "\nThe overdraft limit is: " + overdraftLimit;
	}
	
	public void withdraw(double moneyOutput, double overdraftLimit)
	{
		if(moneyOutput <= overdraftLimit)
		{
			balance -= moneyOutput;
		}
		else
			return;
	}
}
