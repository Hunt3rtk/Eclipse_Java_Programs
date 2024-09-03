import java.util.Scanner;

public class ArrayDivision {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int k = kb.nextInt();
		long[] x = new long[n];
		long maxSum = 0;
		for(int i = 0; i < n; ++i) {
			x[i] = kb.nextInt();
			maxSum += x[i];
		}
		
		long l = 0;
		long h = maxSum;
		long sol = 0;
		
		while (l <= h) {
			long mid = (l + h)/2;
			if (works(mid, n, k, x)) {
				h = mid-1;
				sol = mid;
			}
			else {
				l = mid + 1;
			}
		}
		
		System.out.println(sol);
	}
	
	public static boolean works(long mid, int n, int k, long[] x) {
		
		int divisions = 0;
		long sum = 0;
		for (int i = 0; i < n; i++) {
			if (x[i] > mid) {
				return false;
			}
			if (sum + x[i] > mid) {
				++divisions;
				sum = 0;
			}
			sum += x[i];
		}
		if (sum > 0) {
			++divisions;
		}
		return divisions <= k;
	}
}
