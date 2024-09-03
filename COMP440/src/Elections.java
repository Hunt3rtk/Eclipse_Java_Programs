import java.util.Scanner;

public class Elections {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int t = kb.nextInt();
		long[][] votes = new long[t][3];
		long win;
		for(int i = 0; i < t; ++i) {
			votes[i][0] = kb.nextInt();
			votes[i][1] = kb.nextInt();
			votes[i][2] = kb.nextInt();
			long v1 = 0;
			long v2 = 0;
			long v3 = 0;
			long max = Math.max(votes[i][2],Math.max(votes[i][1],votes[i][0]));
			
			if (votes[i][0] == max ) {
				v1 = 0;
			}
			else {
				v1 = max - votes[i][0] + 1;
			}
			if (votes[i][1] == max ) {
				v2 = 0;
			}
			else {
				v2 = max - votes[i][1] + 1;
			}
			if (votes[i][2] == max ) {
				v3 = 0;
			}
			else {
				v3 = max - votes[i][2] + 1;
			}
			if (votes[i][0] == votes[i][1] && votes[i][1] == votes[i][2]) {
				v1 = 1;
				v2 = 1;
				v3 = 1;
			}
			else if(votes[i][0] == votes[i][1] && votes[i][0] == max) {
				v1 = 1;
				v2 = 1;
			}
			else if(votes[i][0] == votes[i][2] && votes[i][0] == max) {
				v1 = 1;
				v3 = 1;
			}
			else if(votes[i][1] == votes[i][2] && votes[i][1] == max) {
				v3 = 1;
				v2 = 1;
			}
			
			System.out.println(v1 + " " + v2 + " " + v3);
		}
	}

}
