import java.util.Arrays;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		kb.useDelimiter("");
		for(int j = 1; j<=4; j++) {
			String x = kb.next();
			System.out.println(x);
			int y = 0;
			if(x.equals("*")) {
				y = 1;
			}
			System.out.println(y);
		}
	}

}
