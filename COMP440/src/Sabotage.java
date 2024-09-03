import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Sabotage {
	public static void main(String[] args) throws IOException {
		Scanner kb = new Scanner(new File("sabotage.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("sabotage.out"));
		double n = kb.nextInt();
		double[] row = new double[(int) n];
		double max = 0;
		double sum = 0;
		for (int i = 0; i < n; ++i) {
			row[i] = kb.nextInt();
			sum += row[i];
			if (i == n-1) {
				break;
			}
			if (i < 2) {
				continue;
			}
			max = Math.max(row[i]+row[i-1], max);		
		}
		double result = (sum - max)/(n-2);
		
		bw.write(String.format("%.3f\n",result));
		bw.close();
	}
}
