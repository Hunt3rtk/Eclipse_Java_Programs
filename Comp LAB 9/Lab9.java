import java.util.Arrays;
//Include your details here

public class Lab9 {
	
	static final double ERROR_MARGIN = 1e-10;

	public static void main(String[] args) {
		// TODO Write code to test the two methods here.

		// Your code to test  calculateCost method.
	
		String flower1 = "petunia";
		int flowerC = 10;
		double cost = 25.0;
		double total = calculateCost(flower1, flowerC);
		if(Math.abs(cost - total) < Lab9.ERROR_MARGIN)
			System.out.println("Answer is correct");
		else {
			System.out.println("Answer is wrong.");
			System.out.println("Data: ");
			System.out.println("\tFlower Name: " + flower1);
			System.out.println("\tNumber of Flowers: " + flowerC);
			System.out.println("\tExpected Answer: " + cost);
			System.out.println("\tAnswer from Method: " + total);
		}
		
		//Sample code to test and validate the totalCost method.
		//*
		
		
		
		String flowerName = "rose";
		int flowerCount = 10;
		double expectedCost = 15.0;
		double totalCost = calculateCost(flowerName, flowerCount);
		if(Math.abs(expectedCost - totalCost) < Lab9.ERROR_MARGIN)
			System.out.println("Answer is correct");
		else {
			System.out.println("Answer is wrong.");
			System.out.println("Data: ");
			System.out.println("\tFlower Name: " + flowerName);
			System.out.println("\tNumber of Flowers: " + flowerCount);
			System.out.println("\tExpected Answer: " + expectedCost);
			System.out.println("\tAnswer from Method: " + totalCost);
		}
		//*/
		
		//Alternate code to validate the totalCost method using Assertions.
		//Note that you will have to enable assertions for this code to work.
		//It will not give any messages if the program works fine. If there is an error, the program will throw an exception.
		//*
		
		
		
		
		
		/*
		String [] flowerNameA = { "petunia", "pansy", "rose", "violet", "carnation"};
		int [] flowerCountA = { 10, 20, 10, 15, 20};
		double [] expectedCostA = {25.0, 75.0, 15.0, 37.5, 36.0};
		double answerToCheck;
		for(int  i=0; i<flowerNameA.length; i++) {
			answerToCheck = calculateCost(flowerNameA[i], flowerCountA[i]);
			assert (Math.abs(answerToCheck - expectedCostA[i]) < Lab9.ERROR_MARGIN);
		}
		
		*/
		
		
		
		
		
		//*/
		
		// Your code to test  findFigure method.

		//System.out.print
		
		/*
		double [][] picture = { {1.2, 1.3, 4.5, 6.0, 2.7}, {1.7, 3.3, 4.4, 10.5, 17.0}, {1.1, 4.5, 2.1, 25.3, 9.2}, {1.0, 9.5, 8.3, 2.9, 2.1} };
		double threshold = 1.4;
		
		System.out.print(findFigure(picture, threshold));;
		*/
		
		
		//Sample code to test and validate the findFigure method.
		
		
		
		
		double [][] picture = { {1.2, 1.3, 4.5, 6.0, 2.7}, {1.7, 3.3, 4.4, 10.5, 17.0}, {1.1, 4.5, 2.1, 25.3, 9.2}, {1.0, 9.5, 8.3, 2.9, 2.1} };
		double threshold = 1.4;
		double [][] expectedAnswer = { {0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 1.0, 1.0}, {0.0, 0.0, 0.0, 1.0, 1.0}, {0.0, 1.0, 0.0, 0.0, 0.0} };
		double [][] answer = findFigure(picture, threshold);
		if(Arrays.deepEquals(expectedAnswer, answer))
			System.out.println("Answer for findFigure is correct");
		else {
			System.out.println("Answer for findFigure is wrong");
			System.out.println("\tThreshold: "+ threshold);
			System.out.println("\tPicture:" + Arrays.deepToString(picture) );
			System.out.println("\tExpected Answer:" + Arrays.deepToString(expectedAnswer));
			System.out.println("\tAnswer From Method:" + Arrays.deepToString(answer));
		}
		
	
		
		//Using assertions to validate
		assert(Arrays.deepEquals(expectedAnswer, answer));


	
		
		
		
	}
	
	public static double calculateCost (String flowerName, int quantity) {
		//TODO: Implement this method.
		
		String flowerArray [] = { "petunia", "pansy", "rose", "violet", "carnation"};
		double flowerCostArray [] = {2.50,3.75,1.50,2.50,1.80};
		//declaring the array of flowers and the cost respectively 
		
		return ((flowerCostArray[Arrays.binarySearch(flowerArray,flowerName)])*quantity);
		//returning the price array at index flowerArray according to the flowerName inputed times the quantity given
	}
	
	public static double [] [] findFigure (double [][] picture, double threshold) {
		//TODO: Implement this method.
		
		double sum = 0;
		int total = 0;
		double [] [] newAverageArray = picture;
		//declaring variables and array
		
		for(int i2 = 0; i2 < picture.length; i2++) 
		{
			for(int i1 = 0; i1 < picture[i2].length; i1++)
			{
				sum = picture[i2][i1] + sum;
				total++;
			}
		}
		//for loops that create a sum of all the numbers in the array and the total number of numbers in the array.
		
		
		
		double averageCompare = (sum/total)*threshold;
		//declaring the average times the threshold to create the number I will compare to
		
		
		for(int n = 0; n < picture.length; n++) 
		{
			for(int i = 0; i < picture[n].length;i++)
			{
				if(averageCompare < picture[n][i])
				{
					newAverageArray[n][i] = 1;
				}
				else
				{
					newAverageArray[n][i] = 0;
				}
			}
		}
		//comparing all of the numbers to averageCompare
		
		return newAverageArray;
		//returns the new array of numbers compared to the averageCompare
		
	}

	private static Object i(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}
	

}