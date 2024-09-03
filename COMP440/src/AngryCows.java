import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class AngryCows {

	public static void main(String[] args) throws IOException {
		Scanner kb = new Scanner(new File("angry.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("angry.out"));
		int n = kb.nextInt();
		int k = kb.nextInt();
		int max = 0;
		int min = 999999999;
		int[] position = new int[n];
		for(int i = 0; i < n; ++i) {
			int x = kb.nextInt();
			position[i] = x;
			if (x < min) {
				min = x;
			}
			if (x > max) {
				max = x;
			}
		}
		Arrays.sort(position);
		int r = (int) Math.ceil(((Math.ceil((max - min))/k)-1)/2);
		if (n <= k) {
			r = 0;
		}
		System.out.print(r);
		bw.write(String.valueOf(r));
		bw.close();
	}
}
