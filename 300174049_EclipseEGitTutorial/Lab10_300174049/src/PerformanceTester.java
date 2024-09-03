/**
 * Class to test and record performance of Sorting Algorithms.
 */


import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

/**
 * @author Malaka Walpola
 * @author Hunter Klassen
 * @email 300174049
 */
public class PerformanceTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testPerformance();
	}

	public static void testPerformance() {

		//Parameters for testing
		int [] arraySize = { 100, 1000, 5000, 10000, 25000, 50000, 75000, 100000}; // You can add/remove sizes as you prefer
		int numTestCasesPerSize = 2; //You may change this to change the number of test cases for each input size
		int numTestsPerSample = 3; //You may change this to change the number of tests conducted for each sample (test case)

		//Parameters for writing results to a file 
		boolean writeToFle = true; //set this to true if you want the results to be written to a file as well.
		String resultsFileName = "Lab10Results.csv"; //This will create a file in your project folder. 
		//Change the file name to match your system if you want to change the location file is created/saved. e.g. "C:\\MWWork\\COMP251\\Lab2Results.csv"; (If you are using Linux or MacOS the separators might need changing)
		//Important Note: If your results file already exists, this program will overwrite the existing file.

		try {
			FileWriter csvWriter = null;

			DateFormat dateFormat = new SimpleDateFormat("yyyy MMM dd @ hh:mm:ss");  
			System.out.println(dateFormat.format(Calendar.getInstance().getTime()));
			System.out.println( "\tSize S - Input I - Test T\tInsertion Sort\tBubble Sort\tMerge Sort" );
			if(writeToFle) {
				csvWriter = new FileWriter(resultsFileName); //Create file for writing.
				csvWriter.append("Sorting Algorithms - Performance Testing : " + dateFormat.format(Calendar.getInstance().getTime()) + "\n"); //Write to file
				csvWriter.append("Size,Input,Test,Insertion Sort,Bubble Sort,Merge Sort\n"); //Write to file
			}

			for(int i=0; i<arraySize.length; i++) {
				for(int j=0; j<numTestCasesPerSize; j++) {
					//Create a random array of given size;
					int [] sampleInput = getSampleInput(arraySize[i]);
					for(int k=0; k<numTestsPerSample; k++) {
						//Insertion Sort Timing
						int[] inputArr = Arrays.copyOf(sampleInput, sampleInput.length);
						long startTimeS1 = System.currentTimeMillis();
						InsertionSort.insertionSort(inputArr);
						long finishTimeS1 = System.currentTimeMillis();
						long timeS1 = finishTimeS1-startTimeS1;

						//Bubble Sort Timing
						inputArr = Arrays.copyOf(sampleInput, sampleInput.length);
						long startTimeS2 = System.currentTimeMillis();
						BubbleSort.bubbleSort(inputArr);
						long finishTimeS2 = System.currentTimeMillis();
						long timeS2 = finishTimeS2-startTimeS2;

						//Merge Sort Timing
						inputArr = Arrays.copyOf(sampleInput, sampleInput.length);
						long startTimeS3 = System.currentTimeMillis();
						MergeSort.mergeSort(inputArr);
						long finishTimeS3 = System.currentTimeMillis();
						long timeS3 = finishTimeS3-startTimeS3;
						

						System.out.println( "\tSize " + arraySize[i] + "- Input " + (j+1) + " - Test " + (k+1) + "\t" + timeS1 + "\t" + timeS2 + "\t" + timeS3);
						if(writeToFle)
							csvWriter.append(arraySize[i]+","+ (j+1) + "," + (k+1) + "," + timeS1 +"," + timeS2 +"," + timeS3 +"\n"); //Write to file
					}
				}
			}


			if(writeToFle) {
				csvWriter.flush(); //Flush the stream to make sure everything is written to the file.
				csvWriter.close(); //Close the file.
			}
		}
		catch (IOException ioe) { //File access generates I/O exceptions.
			System.out.println("Error in creating/openign the file!");
			System.out.println("Type: " + ioe.getClass() + "\n" + "Message: " + ioe.getMessage());
		}
	}

	public static int[] getSampleInput(int size) {
		int[] retArr = new int[size]; 
		for(int i=0; i<size; i++)
			retArr[i] = (int)Math.round((Math.random()*size)-(size/2.0));
		return retArr;
	}

}
