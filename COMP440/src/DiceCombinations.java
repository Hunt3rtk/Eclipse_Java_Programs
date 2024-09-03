import java.util.Scanner;

public class DiceCombinations {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] x = new int[n+1];
		x[0] = 1;
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=6; j++) {
				if(i-j < 0) {
					break;
				}
				x[i] += x[i-j];
				x[i] %= 1000000007;
			}
		}
		System.out.println(x[n]);
	}
}
