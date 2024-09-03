import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CowTipping {
	public static void main(String[] args) throws IOException {
		Scanner kb = new Scanner(new File("cowtip.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("cowtip.out"));
		
		int n = Integer.parseInt(kb.nextLine());
		int[][] x = new int[n][n];
		int count = 0;
		for(int i = 0; i<n; i++) {
			String row = kb.nextLine();
			for(int j = 0; j<n; j++) {
				x[i][j] = row.charAt(j) - '0';
			}
		}
		
		for(int i = n-1; i>=0; i--) {
			for(int j = n-1; j>=0; j--) {
				if(x[i][j] == 1) {
					x = flip(x,i,j);
					count++;
				}
			}
		}
		
		
		bw.write(String.format("%d\n", count));
		bw.close();
	}
	public static int[][] flip(int[][] x, int k, int q) {
		for(int i = 0; i<=k; i++) {
			for(int j = 0; j<=q; j++) {
				if(x[i][j] == 1) {
					x[i][j] = 0;
				}
				else {
					x[i][j] = 1;
				}
			}
		}
		
		return x;
		
	}
}
