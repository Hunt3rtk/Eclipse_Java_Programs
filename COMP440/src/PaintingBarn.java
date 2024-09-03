import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PaintingBarn {
	public static void main(String[] args) throws IOException {
		Scanner kb = new Scanner(new File("paintbarn.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("paintbarn.out"));
		
		int n = kb.nextInt();
		int k = kb.nextInt();
		int[] x = new int[n+1];
		int h = 0;
		
		
		
		bw.write(String.format("%d"));
		bw.close();
	}
}
