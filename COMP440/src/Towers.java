import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Towers {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int max = 0;
		ArrayList<Stack<Integer>> t = new ArrayList<Stack<Integer>>();
		
		breakend:
		for(int i =0; i<n; i++) {
			int k = kb.nextInt();
			if(k >= max) {
				max = k;
				t.add(new Stack<Integer>());
				t.get(t.size()-1).push(k);
				continue breakend;
			}
			for(int j = 0; j<t.size(); j++) {
				
				if(k < t.get(j).peek() ) {
					if(t.get(j).peek() == max) {
						k = max;
					}
					t.get(j).push(k);
					continue breakend;
				}
			}
			t.add(new Stack<Integer>());
			t.get(t.size()-1).push(k);
		}
		System.out.println(t.size());
	}

}
