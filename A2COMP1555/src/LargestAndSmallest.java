import java.util.Scanner;
//import the Scanner class
import java.util.Arrays;
//import the Arrays class
import java.util.ArrayList;
// import the ArrayList class
import java.util.Collections;
//import the Collections class


public class LargestAndSmallest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> series = new ArrayList<Integer>();
		int i = 0;
		int smallest;
		int largest;

		Scanner keyboard = new Scanner(System.in);
		// Create a scanner object to read from the keyboard Scanner keyboard = new Scanner(System.in);
		
		
		do
		{
		System.out.print("Enter a number or enter -99 to end series:");
		//asking for a of numbers
		
		series.add(keyboard.nextInt());
		//getting the next number
		
		++i;
		//incrementing i to move down the array
		}
		while(series.get(i-1) != -99);
		//loops until -99 is inputed
		
		
		Collections.sort(series); 
		//sorting the array of numbers

		largest = series.get(i-1);
		smallest = series.get(1);
		//getting the largest and smallest numbers
				
		System.out.printf("The largest number is %d and the smallest is %d",largest,smallest);
		//printing the largest and smallest numbers
		
	}

}
