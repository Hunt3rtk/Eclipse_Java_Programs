import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Moocast {
	
	public static boolean[][] inRange;
	public static boolean[] visited;
	
	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		int[] range = new int[n];
		inRange = new boolean[n][n];
		int max = 0;
		
		for(int i = 0; i < n; i++) {
			x[i] = kb.nextInt();
			y[i] = kb.nextInt();
			range[i] = kb.nextInt();
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				int dist = (((x[i] - x[j])*(x[i] - x[j])) + ((y[i] - y[j])*(y[i] - y[j])));
				if(dist <= (range[i]*range[i])) {
					inRange[i][j] = true;
				} else {
					inRange[i][j] = false;
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			visited = new boolean[n];
			max = Math.max(max,inRangeCows(i));
		}
		
		System.out.println(max);
	}
	
	static int inRangeCows(int i) {
		visited[i] = true;
		int connected = 1;
		for(int j = 0; j < inRange.length; j++) {
			if(inRange[i][j] && !visited[j]) {
				visited[j] = true;
				connected += inRangeCows(j);
			}
		}
		return connected;
	}
}
