import java.util.Scanner;

public class DRSQ {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int q = kb.nextInt();
		long[] sum = new long[n];
		
		for (int i = 0; i < n; i++) {
			long x = kb.nextInt();
			if (i == 0) {
				sum[i] = x;
			}
			else {
				sum[i] = x + sum[i-1];
			}
		}
		
		
		for (int j = 0; j < q; j++) {
			int w = kb.nextInt();
			
			if(w == 1)
			{
				int k = kb.nextInt();
				int u = kb.nextInt();
				long sub =(sum[k-1]-sum[k-2]) - u;
				
				for(int l = k-1; l < n; l++) {
					sum[l] -= sub;
				}
				
				
			}
			else {
				int a = kb.nextInt();
				int b = kb.nextInt();
				if (a == 1) {
					System.out.println(sum[b-1]);
				}
				else {
					System.out.println(sum[b-1] - sum[a-2]);
				}
			}
		}
	}
}
