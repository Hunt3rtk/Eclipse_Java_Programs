import java.util.Scanner;

public class EditDistance {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String w1 = kb.next().toLowerCase();
		String w2 = kb.next().toLowerCase();
		int [][] res = new int[w1.length()+1][w2.length()+1];
		
		for(int i = 1; i <= w1.length(); i++) {
			res[i][0] = i;
		}
		for(int i = 1; i <= w2.length(); i++) {
			res[0][i] = i;
		}
		for(int i = 1; i <= w1.length(); i++) {
			for(int j = 1; j <= w2.length(); j++) {
				if(w1.charAt(i-1) == w2.charAt(j-1)) {
					res[i][j] = res[i-1][j-1];
					continue;
				}
				int min = Math.min(res[i - 1][j - 1], Math.min(res[i - 1][j], res[i][j - 1])) + 1;
				res[i][j] = min;
			}
		}
		System.out.println(res[w1.length()][w2.length()]);
	}
}
