import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SubSequencesSummingtoSevens {
	public static void main(String[] args) throws IOException {
		Scanner kb = new Scanner(new File("div7.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("div7.out"));
		
		int n = kb.nextInt();
		int[] x = new int[n];
		int[] indCount = new int[7];
		Arrays.fill(indCount, -1);
		indCount[0] = 0;
		int max = 0;
		for (int i = 0; i<n; i++) {
			if (i==0) {
				x[i] = kb.nextInt()%7;
			}
			else {
				x[i] = (x[i-1] + kb.nextInt())%7;
			}
			
			if(indCount[x[i]] == -1) {
				indCount[x[i]] = i;
			}
			else {
				max = Math.max(max, i-indCount[x[i]]);
			}
		}
		
		
		
		bw.write(String.format("%d\n",max));
		bw.close();
	}
}
