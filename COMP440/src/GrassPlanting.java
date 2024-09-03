import java.util.Scanner;

public class GrassPlanting {
	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] deg = new int[n];
		int max = 0;
		for(int i = 0; i < n-1; i++) {
			deg[ kb.nextInt()-1]++;
			deg[ kb.nextInt()-1]++;
		}
		for(int i = 0; i < n; i++) {
			if(max < deg[i]) {
				max = deg[i];
			}
		}
		System.out.println(max+1);
	}
}
