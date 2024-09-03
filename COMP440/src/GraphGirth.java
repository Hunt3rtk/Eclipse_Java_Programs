import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class GraphGirth {
	
	public static void main(String[] args) throws IOException{
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int m = kb.nextInt();
		LinkedList<Integer> adj[] = new LinkedList[n+1];
		int[] depth = new int[n+1];
		int cycle = 999999999;
		for(int i = 0; i <= n; i++) {
			adj[i] = new LinkedList();
		}
		for(int i = 0; i < m; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			adj[a].add(b);
			adj[b].add(a);
		}
		
		for(int i = 1; i <= n; i++) {
			Arrays.fill(depth, -1);
			ArrayDeque<Integer> queue = new ArrayDeque<>();
			depth[i] = 0;
			queue.add(i);
			while (!queue.isEmpty()) {
				int u = queue.poll();
				for(int v : adj[u]) {
					if(depth[v] == -1) {
						depth[v] = depth[u]+1;
						queue.add(v);
					} else if(depth[v] >= depth[u]) {
						cycle = Math.min((depth[u] + depth[v] + 1), cycle);
					}
				}
			}
		}
		if(cycle == 999999999) {
			cycle = -1;
		}
		System.out.println(cycle);
	}
}
