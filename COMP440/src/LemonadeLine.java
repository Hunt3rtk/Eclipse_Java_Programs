import java.io.*;
import java.util.*;

public class LemonadeLine {

	public static void main(String[] args) throws IOException {
		Scanner kb = new Scanner(new File("lemonade.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("lemonade.out"));
		
		int n = kb.nextInt();
		long[] x = new long[n];
		long sum = 0;
		int count = 0;
		for (int i = 0; i<n; i++) {
			x[i] = kb.nextLong();
		}
		
		Arrays.sort(x);
		
		for(int j = n-1; j>=0; j--) {
			if(count > x[j]) {
				continue;
			}
			count++;
		}
		
		bw.write(String.format("%d\n",count));
		bw.close();
	}
}
