
public class AccountTester {

	public static void main(String[] args) {
		
		Account account [] = new Account[5];
		
		account[0] = new Account(1000);
		account[1] = new Account(1000);
		account[2] = new CheckingAccount(1000, 500);
		account[4] = new Account(1000);
		account[3] = new SavingAccount(1000, 0.02);
		
		account[0].deposit(500);
		
		account[1].getBalance();
		
		((CheckingAccount) account[2]).chequeDeposit(200);
		
		((SavingAccount) account[3]).addInterest(.03);
		
		account[4].withdraw(300);
		
		System.out.println(account[0].toString());
		System.out.println(account[1].toString());
		System.out.println(account[2].toString());
		System.out.println(account[3].toString());
		System.out.println(account[4].toString());
	}

}
