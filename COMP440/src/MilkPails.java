import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MilkPails {
	public static void main(String[] args) throws IOException {
		Scanner kb = new Scanner(new File("pails.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("pails.out"));
		int x = kb.nextInt();
		int y = kb.nextInt();
		int m = kb.nextInt();
		int r_1 = m%y;
		int r_2;
		int min = r_1;
		for (int i = 0; i <= Math.floor(m/y); i++) {
			r_2 = (r_1 + i*y)%x;
			if (r_2 < min) {
				min = r_2;
			}
		}
		bw.write(String.format("%d\n",m-min));
		bw.close();
	}
}
