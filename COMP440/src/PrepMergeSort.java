import java.util.Scanner;

public class PrepMergeSort {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		long[] arr = new long[n];
		for(int i = 0;i<n; i++) {
			arr[i] = kb.nextLong();
		}
	}
}
