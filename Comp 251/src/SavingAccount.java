
public class SavingAccount extends Account{

	double interestRate;
	
	SavingAccount(double balance, double interestRate) {
		// TODO Auto-generated constructor stub
		super(balance);
		this.interestRate = interestRate;
	}
	
	public void addInterest(double interestRate)
	{
		super.balance +=  super.balance*interestRate;
	}

}
