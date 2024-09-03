import java.io.*;
import java.util.*;

public class BuildingRoads {
	
	public static ArrayList<Integer> adj[];
	public static boolean visited[];
	public static ArrayList<Integer> city = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException{	
		BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter write = new PrintWriter(System.out);
		StringTokenizer str = new StringTokenizer(kb.readLine());
		int n = Integer.parseInt(str.nextToken());
		long m = Long.parseLong(str.nextToken());
		adj = new ArrayList[n+1];
		visited = new boolean[n+1];
		
		for(int i = 0; i <= n; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		for(long i = 0; i < m; i++ ) {
			str = new StringTokenizer(kb.readLine());
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}
		kb.close();
		
		int count = count();
		
		write.println(count-1);
		for(int i = 1; i < count; i++) {
			write.println(city.get(i-1) + " " + city.get(i));
		}
		write.close();
	}
	public static void dfs(int node) {
		visited[node] = true;
		for(int i : adj[node]) {
			if (!visited[i]) {
				dfs(i);
			}
		}
	}
	public static int count() {
		int count = 0;
		for (int i = 1; i <= (adj.length - 1); i++) {
			if (!visited[i]) {
				count++;
				city.add(i);
				dfs(i);
			}
		}
		return count;
	}
}
