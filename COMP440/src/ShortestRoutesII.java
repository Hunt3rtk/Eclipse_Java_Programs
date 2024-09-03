import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ShortestRoutesII {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		PrintWriter write = new PrintWriter(System.out);
		int n = kb.nextInt();
		int m = kb.nextInt();
		int q = kb.nextInt();
		long INF = (long) 1e18;
		long[][] distance = new long[n+1][n+1];
		for(long[]r: distance) {
			Arrays.fill(r, INF);
		}
		for(int i = 0; i < m; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			long c = kb.nextInt();
			if (c < distance[a][b]) {
				distance[a][b] = c;
				distance[b][a] = c;
			}
		}
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
					for (int j = 1; j <= n; j++) {
							distance[i][j] = distance[j][i] = Math.min(distance[i][j],distance[i][k]+distance[k][j]);
					}
			}
		}
		for(int i = 0; i < q; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			if (distance[a][b] == INF) {
				distance[a][b] = -1;
			} else if(a == b) distance[a][b] = 0;
			write.println(distance[a][b]);
		}
		write.close();
	}
}
