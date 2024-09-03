import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Scanner;

public class Mootube {
	public static class Edge {
		int adj;
		int relev;
		public Edge(int adj, int relev) {
			this.adj = adj;
			this.relev = relev;
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		Scanner kb = new Scanner(System.in);
		PrintWriter write = new PrintWriter(System.out);
		int n = kb.nextInt();
		int q = kb.nextInt();
		boolean[] visited;
		LinkedList<Edge> adj[] = new LinkedList[n];
		
		for (int i = 0; i < n; i++) {
			adj[i] = new LinkedList<>();
		}
		for(int i = 0; i < n-1; i++) {
			int a = kb.nextInt()-1;
			int b = kb.nextInt()-1;
			int relev = kb.nextInt();
			adj[a].add(new Edge(b, relev));
			adj[b].add(new Edge(a, relev));
		}
		for(int j = 0; j < q; j++) {
			int bar = kb.nextInt();
			int vid = kb.nextInt()-1;
			int count = 0;
			visited = new boolean[n];
			ArrayDeque<Integer> queue = new ArrayDeque<>();
			queue.add(vid);
			visited[vid] = true;
			while (!queue.isEmpty()) {
				int u = queue.poll();
				visited[u] = true;
				for(Edge v : adj[u]) {
					if(!visited[v.adj] && v.relev >= bar) {
						queue.add(v.adj);
						count++;
					}
				}
			}
			write.println(count);
		}
		write.close();
	}
}
