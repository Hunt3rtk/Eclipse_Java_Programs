//Include your details here

public class Lab10 {
	
	static final double ERROR_MARGIN = 1e-10;

	
	public static void main(String[] args) {
		// Write code to test the two methods here.

		// TODO Your code to test  recursiveFactorial method.
		
		int [] inputArray1 = {0, 2, 5, 6, 8, 9};
		int [] factorialArray1 = {1, 2, 120, 720, 40320, 362880};
		System.out.println("Recursive Factorial Check:");
		for(int k=0; k<inputArray1.length; k++) {
			System.out.print("\tInput: " + inputArray1[k] + "  & Expected Result: " + factorialArray1[k] + " - ");
			if(recursiveFactorial(inputArray1[k]) == factorialArray1[k])
				System.out.println("Answer is correct");
			else
				System.out.println("Answer is wrong.");
			//code to validate my recursiveFactorial method
		}
		// TODO Your code to test  recursivePalindromeCheck  method.
		
		String [] inputString = {"racecar", "papa", "tat", "on jaw waj no", "aba", "b", "", "festiva", "cool beans"};
		boolean [] isPalindormes = {true, false, true, true, true, true, true, false, false};
		System.out.println("Recursive Palindrome Check:");
		for(int i=0; i<inputString.length; i++) {
			System.out.println("\tInput: " + inputString[i] + "  & Expected Result: " + isPalindormes[i] + " - Answer:" + recursivePalindromeCheck(inputString[i]));
			//validates and tests the recursivePalindromeCheck method
			
		}
		
		//Sample code to test and validate the recursiveFactorial method.
		//*
		int [] inputArray2 = {0, 1, 2, 5, 7, 10};
		int [] factorialArray2 = {1, 1, 2, 120, 5040, 3628800};
		System.out.println("Recursive Factorial Check:");
		for(int i=0; i<inputArray2.length; i++) {
			System.out.print("\tInput: " + inputArray2[i] + "  & Expected Result: " + factorialArray2[i] + " - ");
			if(recursiveFactorial(inputArray2[i]) == factorialArray2[i])
				System.out.println("Answer is correct");
			else
				System.out.println("Answer is wrong.");
		}
		//*/
		
		//Sample code to test and validate the recursivePalindromeCheck method.
		String [] inputStrings = {"mom", "dad", "redder", "noon", "civic", "a", "", "avid diva", "step on no pets", "Not palindrome", "redber", "a ", "abc cbd"};
		boolean [] isPalindorme = {true, true, true, true, true, true, true, true, true, false, false, false, false};
		System.out.println("Recursive Palindrome Check:");
		for(int i=0; i<inputStrings.length; i++) {
			System.out.println("\tInput: " + inputStrings[i] + "  & Expected Result: " + isPalindorme[i] + " - Answer:" + recursivePalindromeCheck(inputStrings[i]));
		}
		//*
		

	}
	
	public static int recursiveFactorial (int n) {
		//TODO: Implement this method.
		
		int result = 0;
		//declaring result as integer
		
		if(n == 0)
		{
			return 1;
			//returns 1 if n is equal to 0
		}
		else
		{
			result = n*recursiveFactorial(n-1);
			//factorial equation that utilizes recursiveFactorial method to change n until it is 0
		}
		
		return result;
		//returning result after the factorial equation is finished 
		
	}
	
	public static boolean recursivePalindromeCheck (String text) {
		//TODO: Implement this method.
		
		if(text.length() >= 2)
			//proceeds if the text has more than or equal to 2 characters else it returns true
		{
			if(text.charAt(0) == text.charAt((text.length()-1)))
			{
			
					return recursivePalindromeCheck(text.substring(1,(text.length()-1)));
					// returns the recursivePalindromeCheck method as a substring deleting the first and last character if they were equal to eachother
			}
			
			else
			{
				return false;
				//returns false because the characters were not equal
			}
		}
		else
		{
			return true;
		}
		
	}	
}