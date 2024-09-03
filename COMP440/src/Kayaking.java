import java.util.*;

public class Kayaking {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] x = new int[2*n];
		int[] y = new int[n];
		y[0] = 0;
		for (int i = 0; i<2*n; i++) {
			x[i] = kb.nextInt();
		}
		
		Arrays.sort(x);
		
		for(int j = 0, z = 0; z<n; j += 2, z++) {
			if(j == 0) {
				y[z] = x[j+1] - x[j];
			}
			else {
				y[z] = Math.min(x[j+1] - x[j], x[j] - x[j-1]);
			}
		}
		
		Arrays.sort(y);
		for(int k = 0; k<n-1; k++) {
			System.out.printf("y[%d] = " + y[k], k);
		}
		
		int ans = 0;
		
		for(int k = 0; k<n-1; k++) {
			ans += Math.abs(y[k]);
		}
		
		System.out.println(ans);
	}
}
