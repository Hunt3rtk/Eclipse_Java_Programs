import java.util.ArrayList;
import java.util.Scanner;

public class GreatRevegetation {
	
	public static ArrayList<Integer> adj[];
	public static boolean visited[];
	
	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int m = kb.nextInt();
		adj = new ArrayList[n+1];
		visited = new boolean[n+1];
		
		int count = 1;
		
		for(int i = 0; i <= n; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < m; i++ ) {
			String x = kb.next().toLowerCase();
			int a = kb.nextInt();
			int b = kb.nextInt();
			adj[a].add(b);
			adj[b].add(a);
		}
		
		for(int i = 1; i <= n; i++) {
			if(!visited[i]) {
				count *= 10;
				dfs(i);
			}
		}
		System.out.println(count);
		
	}
	public static void dfs(int node) {
		visited[node] = true;
		for(int i : adj[node]) {
			if (!visited[i]) {
				dfs(i);
			}
		}
	}
}
