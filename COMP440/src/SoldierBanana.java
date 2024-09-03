import java.util.Scanner;

public class SoldierBanana {
			public static void main(String[] args) {
				Scanner kb = new Scanner(System.in);
				int k = kb.nextInt();
				int n = kb.nextInt();
				int w = kb.nextInt();
				int s = (int) ((k*Math.pow(w,2)+k*w)/2)-n;
				if(s < 0) {
					System.out.print(0);
				}
				else {
					System.out.print(s);
				}
		}

	}
