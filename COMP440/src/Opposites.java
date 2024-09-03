import java.util.Scanner;

public class Opposites {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int t = kb.nextInt();
		for (int i = 0; i < t; ++i) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int c = kb.nextInt();
			int d = -1;
			int diff = Math.abs(a-b);
			
			if (a <= diff*2 &&  b <= diff*2 && c <= diff*2 ) {
				d = c + diff;
				if (d > diff*2) {
					d = c - diff;
				}
			}
			
			System.out.println(d);
		}
	}

}
