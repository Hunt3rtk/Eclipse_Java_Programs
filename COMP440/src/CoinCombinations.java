import java.util.Arrays;
import java.util.Scanner;

public class CoinCombinations {
	
	public static int n;
	public static int x;
	public static int count = 0;
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		x = kb.nextInt();
		int [] coins = new int [n];
		int [] result = new int[x+1];
		result[0] = 1;
		for(int i = 0; i < n; i++) {
			coins[i] = kb.nextInt();
		}
		
		Arrays.sort(coins);
		
		for(int i = 0; i<=x; i++) {
			for(int j = 0; j<n; j++) {
				if(i - coins[j] < 0) {
					continue;
				}
				result[i] += result[i-coins[j]];
				result[i] %= 1000000007;
			}
		}
		System.out.println(result[x]);
	}
}
