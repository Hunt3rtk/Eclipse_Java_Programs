import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class OutOfPlace {
	public static void main(String[] args) throws IOException {
		Scanner kb = new Scanner(new File("outofplace.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("outofplace.out"));
		
		int n = kb.nextInt();
		long[] x = new long[n];
		long[] y = new long[n];
		int count = 0;
		for(int i = 0; i<n; i++) {
			x[i] = kb.nextInt();
			y[i] = x[i];
		}
		Arrays.sort(y);
		
		for(int i = 0; i<n; i++) {
			if(y[i] == x[i]) {
				System.out.println(x[i]);
				continue;
			}
			count++;
		}
		count--;
		
		bw.write(String.format("%d\n", count));
		bw.close();
	}
}
