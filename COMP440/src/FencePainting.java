import java.util.*;
import java.io.*;

public class FencePainting {

	public static void main(String[] args) throws IOException {
		Scanner kb = new Scanner(new File("paint.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("paint.out"));
		
		int a = kb.nextInt();
		int b = kb.nextInt();
		int c = kb.nextInt();
		int d = kb.nextInt();
		
		if (a <= c && b >= d) {
			bw.write(b-a + "\n");
			bw.close();
		}
		else if ( c <= a && d >= b) {
			bw.write(d-c + "\n");
			bw.close();
		}
		else if (b < c) {
			bw.write((b-a)+(d-c) + "\n");
			bw.close();
		}
		else if (d < a){
			bw.write((b-a)+(d-c) + "\n");
			bw.close();
		}
		else if (a <= c && b >= c){
			bw.write((d-a) + "\n");
			bw.close();
		}
		else if (c <= a && d >= a){
			bw.write((b-c) + "\n");
			bw.close();
		}
	}

}
