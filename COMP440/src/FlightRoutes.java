import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FlightRoutes {
	
	static boolean visited[];
	
	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int m = kb.nextInt();
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
			adjRev.add(new ArrayList<>());
		}
		for(int i = 0; i < m; i++ ) {
			int a = kb.nextInt()-1;
			int b = kb.nextInt()-1;
			adj.get(a).add(b);
			adjRev.get(b).add(a);
		}
		
		visited = new boolean[n];
		dfs(0, adj);
		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				System.out.println("NO");
				System.out.println(1 + " " + i);
				return;
			}
		}
		
		visited = new boolean[n];
		dfs(0, adjRev);
		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				System.out.println("NO");
				System.out.println(i + " " + 1);
				return;
			}
		}
		
		System.out.println("YES");
	}
	public static void dfs(int node,  ArrayList<ArrayList<Integer>> adj) {
		visited[node] = true;
		for(int i : adj.get(node)) {
			if (!visited[i]) {
				dfs(i, adj);
			}
		}
	}
}
