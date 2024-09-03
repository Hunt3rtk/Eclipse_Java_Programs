import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class ShortestRoutesI {
	public static class Edge {
		int adj;
		long weight;
		public Edge(int adj, long weight) {
			this.adj = adj;
			this.weight = weight;
		}
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		PrintWriter write = new PrintWriter(System.out);
		int n = kb.nextInt();
		int m = kb.nextInt();
		LinkedList<Edge> adj[] = new LinkedList[n];
		long[] dist = new long[n];
		for(int i = 0; i < n; i++) {
			adj[i] = new LinkedList<>();
		}
		for(int i = 0; i < m; i++) {
			int a = kb.nextInt()-1;
			int b = kb.nextInt()-1;
			long c = kb.nextInt();
			adj[a].add(new Edge(b, c));
		}
		Arrays.fill(dist, -1);
		dist[0] = 0;
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.add(0);
		while (!queue.isEmpty()) {
			int u = queue.poll();
			for(Edge v : adj[u]) {
				if(dist[v.adj] == -1 ) {
					dist[v.adj] = dist[u] + v.weight;
					queue.add(v.adj);
				} else if(dist[v.adj] > dist[u] + v.weight) {
					dist[v.adj] = dist[u] + v.weight;
					queue.add(v.adj);
				}
			}
		}
		for(int j = 0; j < n; j++) {
			write.print(dist[j] + " ");
		}
		write.close();
	}
}
