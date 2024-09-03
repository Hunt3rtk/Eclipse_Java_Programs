import java.io.*;
import java.util.*;

public class TreeDistanceI {
	public static void main(String[] args) throws IOException{
		Scanner kb = new Scanner(System.in);
		//PrintWriter write = new PrintWriter(System.out);
		int n = kb.nextInt();
		LinkedList<Integer> adj[] = new LinkedList[n];
		boolean[] visited;
		int maxCount = 0;
		for(int i = 0; i < n; i++) {
			adj[i] = new LinkedList<>();
		}
		for(int i = 0; i < n-1; i++) {
			int a = kb.nextInt()-1;
			int b = kb.nextInt()-1;;
			adj[a].add(b);
			adj[b].add(a);
		}
		for(int i = 0; i < n; i++) {
			int count = -1;
			ArrayDeque<Integer> queue = new ArrayDeque<>();
			visited = new boolean[n];
			queue.add(i);
			while (!queue.isEmpty()) {
				int breadth = queue.size();
				while(breadth-- != 0) {
					int u = queue.poll();
					visited[u] = true;
					for(int v : adj[u]) {
						if(!visited[v]) {
							queue.add(v);
						}
					}
				}
				count++;
			}
			maxCount = Math.max(maxCount, count);
		}
		System.out.println(maxCount);
		//write.close();
	}
}
