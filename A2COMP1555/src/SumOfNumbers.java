import java.util.Scanner;
//importing scanner

public class SumOfNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner keyboard = new Scanner(System.in);
		// Create a scanner object to read from the keyboard Scanner keyboard = new Scanner(System.in);
		
		int initialNumber;
		int finalNumber = 0;
		//declaring variables
		
		System.out.print("Enter a nonnegative integer:");
		//asking for a nonnegative integer
		
		initialNumber = keyboard.nextInt();
		//getting the initial number
		
		for(int i = 1; i<= initialNumber; i++)
			//looping to add each number up until the number given
		{
			finalNumber += i;
		}
		
		System.out.print(finalNumber);
		//printing final number

	}

}
