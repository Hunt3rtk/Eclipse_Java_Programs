/**
 * Implementation and correctness testing of Merge Sort 
 */


import java.util.Arrays;

/**
 * @author Malaka Walpola
 * @author Hunter Klassen
 * @email 300174049
 */
public class MergeSort {
	
	private static boolean visualize = false; 

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testCorrectness();
		showSortingSteps();
	}
	
	public static void showSortingSteps() {
		System.out.println("\n\nShowing Sorting Steps fpor Merge Sort\n");
		visualize = true;
		int [] input = {5, 4, 3, 2, 1};
		mergeSort(input);
		visualize = false;
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
			inputs[i] = mergeSort(inputs[i]);
			if(Arrays.equals(inputs[i], outputs[i]))
				System.out.println("Test " + (i+1) + " pass!");
			else
				System.out.println("Test " + (i+1) + " fail!");
		}
	}

	public static int[] mergeSort(int[] A) {
		return mergeSort(A, 0, A.length-1);
	}
	
	public static int[] mergeSort(int[] A, int p, int r) {
		if(visualize)
			System.out.println("Merge Sort Called with p:" + p + " r:" + r + " and A:" + Arrays.toString(A));
		if(p < r) {
			int q = (p + r)/2;
	 		A = mergeSort(A, p, q); 
	 		A = mergeSort(A, q + 1, r);
	 		A = merge(A, p, q, r);
		}
		if(visualize)
			System.out.println("\tMerge Sort Call Return (p:" + p + " r:" + r + ") A:" + Arrays.toString(A));
		return A;
	}
	
	public static int[] merge(int[] A, int p, int q, int r) {
		if(visualize)
			System.out.println("\t\tMerge Called with p:" + p + " q:" + q + " r:" + r + " and A:" + Arrays.toString(A));
		int n1 = q - p + 1;
		int n2 = r - q;
		//create arrays L[0………n1 ] and R[0………n2] and copy elements
		int [] L = new int[n1+1];
		int [] R = new int[n2+1];
		for (int i=0; i<n1; i++)
		 	L[i] = A[p+i];
		for (int j=0; j<n2; j++)
		 	R[j] = A[(q+1)+j];
		L[n1] = Integer.MAX_VALUE; 
		R[n2] = Integer.MAX_VALUE;
		//Copy elements back to the original array in sorted order.
		int i = 0; 
		int j = 0; 
		for (int k=p; k<=r; k++) {
		 	if (L[i] <= R[j]) {
		 		A[k] = L[i];
		 		i = i + 1;
		 	}
		 	else {
		 		A[k] = R[j];
		 		j = j + 1;
		 	}
		}
		if(visualize)
			System.out.println("\t\tMerge Return (p:" + p + " q:" + q + " r:" + r + ") A:" + Arrays.toString(A));
		return A;
	}
}
