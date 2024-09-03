import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HCLC {
	public static void main(String[] args) throws IOException {
		Scanner kb = new Scanner(new File("cardgame.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("cardgame.out"));
		
		int n = kb.nextInt();
		ArrayList<Integer> x = new ArrayList<>();
		int[] y = new int[n];
		int count = 0;
		for(int i = 1; i <= 2*n; i++){
		    x.add(i);
		}
		for(int i = 0; i<n; i++) {
			y[i] = kb.nextInt();
			x.remove(Integer.valueOf(y[i]));
		}
		Arrays.sort(y);
		
		for(int i = n/2-1; i>=0; i--) {
			if(x.get(i) > y[(n/2-1)-i]) {
				count++;
				x.remove(x.get(i));
			}
		}
		for(int i = 0; i<n/2; i++) {
			if(x.get(i) < y[(n/2-1)-i]) {
				count++;
				x.remove(x.get(i));
			}
		}
		
		bw.write(String.format("%d\n", count));
		bw.close();
	}
}
