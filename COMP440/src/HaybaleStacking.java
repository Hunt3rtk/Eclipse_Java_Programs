import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class HaybaleStacking {
	public static void main(String[] args) throws IOException {
		Scanner kb = new Scanner(new File("stacking.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("stacking.out"));
		
		int n = kb.nextInt();
		int k = kb.nextInt();
		int[] x = new int[n+1];
		int h = 0;
		
		for(int i=0; i<=n ; i++) {
			x[i] = 0;
		}
		for(int j=0; j<k; j++) {
			int y = kb.nextInt() - 1;
			int z = kb.nextInt() - 1;
			
			x[y] += 1;
			x[z+1] -= 1;
		}
		
		for(int i=0; i<n ; i++) {
			
			h += x[i];
			x[i] = h;
		}
		
		Arrays.sort(x);
		bw.write(String.format("%d\n",x[x.length/2]));
		bw.close();
	}
}
