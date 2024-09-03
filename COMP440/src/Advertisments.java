import java.util.Scanner;

public class Advertisments {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int max = 0;
		int[] k = new int [n];
		for (int i = 0; i < n; i++) {
			k[i] = kb.nextInt();
			int min = 999999999;
			for (int j = i; j >= 0; --j) {
				min = Math.min(k[j],min);
				max = Math.max(((i-j+1)*min), max);
			}
		}
		System.out.println(max);
	}
}
