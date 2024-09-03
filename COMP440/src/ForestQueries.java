import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ForestQueries {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int q = kb.nextInt();
		int[][] prefix = new int[n+1][n+1];
		Arrays.stream(prefix).forEach(a -> Arrays.fill(a, 0));
		kb.useDelimiter("");
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=n; j++) {
				String x = kb.next();
				while(!x.equals("*") && !x.equals(".")) {
					x = kb.next();
				}
				int y = 0;
				if(x.equals("*")) {
					y = 1;
				}
				prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1] + y;
			}
		}
		kb.useDelimiter(Pattern.compile("\\s+"));
		for(int k = 0; k < q; k++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int c = kb.nextInt();
			int d = kb.nextInt();
			
			int r = prefix[c][d] - prefix[a-1][d] - prefix[c][b-1] + prefix[a-1][b-1];
			
			System.out.println(r);
		}
		
	}
}
