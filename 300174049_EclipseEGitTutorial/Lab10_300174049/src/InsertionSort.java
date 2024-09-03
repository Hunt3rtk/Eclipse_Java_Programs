/**
 * Implementation and correctness testing of Insertion Sort 
 */


import java.util.Arrays;

/**
 * @author Malaka Walpola
 * @author Hunter Klassen
 * @email 300174049
 */
public class InsertionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testCorrectness();
	}

	public static void testCorrectness() {
		int [][] inputs = { {9, 8, 7, 6, 5, 4, 3, 2, 1}, 
				{11, 44, 77, 99, 88, 33, 22, 66, 55}, 
				{12, 45, 76, 25, 99, 12, 22, 12, 25}, 
				{11, 22, 33, 44, 55, 66, 77, 88, 99}, 
				{47, 25, 92, 69, 36, 81, 58, 70, 14} };

		int [][] outputs = { {1, 2, 3, 4, 5, 6, 7, 8, 9}, 
				{11, 22, 33, 44, 55, 66, 77, 88, 99}, 
				{12, 12, 12, 22, 25, 25, 45, 76, 99}, 
				{11, 22, 33, 44, 55, 66, 77, 88, 99}, 
				{14, 25, 36, 47, 58, 69, 70, 81, 92} };

		for(int i=0; i<inputs.length; i++) {
			inputs[i] = insertionSort(inputs[i]);
			if(Arrays.equals(inputs[i], outputs[i]))
				System.out.println("Test " + (i+1) + " pass!");
			else
				System.out.println("Test " + (i+1) + " fail!");
		}
	}

	public static int[] insertionSort(int[] A) {
		for (int j = 1 ; j < A.length; j++ ) {
			int key = A[j];
			//Insert A[j] into the sorted sequence A[0, 1, ……, j-1].
			int i = j-1;
			while (i > -1 && A[i] > key) {
				A[i+1] = A[i];
				i = i-1;
			}
			A[i+1] = key;
		}
		return A;
	}

}
