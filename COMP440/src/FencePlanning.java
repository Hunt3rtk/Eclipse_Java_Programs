import java.util.ArrayList;
import java.util.Scanner;

public class FencePlanning {
	
	public static int[] x;
	public static int[] y;
	public static ArrayList<Integer> adj[];
	public static boolean visited[];
	public static int ans = 999999999;
	
	public static int maxX;
	public static int minX;
	public static int maxY;
	public static int minY;
	
	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int m = kb.nextInt();
		adj = new ArrayList[n+1];
		x = new int[n+1];
		y = new int[n+1];
		
		visited = new boolean[n+1];
		
		for(int i = 0; i <= n; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		
		for(int i = 1; i <= n; i++ ) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			x[i] = a;
			y[i] = b;
		}
		for(int i = 1; i <= m; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			adj[a].add(b);
			adj[b].add(a);
		}
		
		
		
		for(int i = 1; i <= n; i++) {
			if(!visited[i]) {
				maxX = -1;
				maxY = -1;
				minX = 999999999;
				minY = 999999999;
				dfs(i);
				ans = Math.min(ans,((2*(maxX-minX)) + (2*(maxY-minY))));
			}
		}
		System.out.println(ans);
		
	}
	public static void dfs(int node) {
		visited[node] = true;
		if(maxX < x[node]) {
			maxX = x[node];
		}
		if(minY > y[node]) {
			minY = y[node];
		}
		if(maxY < y[node]) {
			maxY = y[node];
		}
		if(minX > x[node]) {
			minX = x[node];
		}
		for(int i : adj[node]) {
			if (!visited[i]) {
				dfs(i);
			}
		}
	}
}

