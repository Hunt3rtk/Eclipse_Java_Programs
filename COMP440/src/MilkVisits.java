import java.io.*;
import java.util.*;

public class MilkVisits {
	public static void main(String[] args) throws IOException{
		BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter write = new PrintWriter(System.out);
		StringTokenizer f = new StringTokenizer(kb.readLine());
		int n = Integer.parseInt(f.nextToken());
		int m = Integer.parseInt(f.nextToken());
		String type = kb.readLine();
		LinkedList<Integer> adj[] = new LinkedList[n];
		for(int i = 0; i < n; i++) {
			adj[i] = new LinkedList<>();
		}
		for(int i = 0; i < n-1; i++) {
			StringTokenizer z = new StringTokenizer(kb.readLine());
			int a = Integer.parseInt(z.nextToken())-1;
			int b = Integer.parseInt(z.nextToken())-1;
			adj[a].add(b);
			adj[b].add(a);
		}
		int groupNum = 0;
		int[] group = new int[n];
		Arrays.fill(group, -1);
		for(int i = 0; i < n; i++) {
			if(group[i] != -1) {
				continue;
			}
			ArrayDeque<Integer> queue = new ArrayDeque<>();
			queue.add(i);
			int breed = type.charAt(i);
			while (!queue.isEmpty()) {
				int u = queue.poll();
				group[u] = groupNum;
				for( int v : adj[u]) {
					if (type.charAt(v) == breed && group[v] == -1) {
						queue.add(v);
					}
				}
			}
			groupNum++;
		}
		for(int i = 0; i < m; i++) {
			StringTokenizer h = new StringTokenizer(kb.readLine());
			int x = Integer.parseInt(h.nextToken())-1;
			int y = Integer.parseInt(h.nextToken())-1;
			char breed = h.nextToken().charAt(0);
			if(group[x] == group[y]) {
				if(type.charAt(x) == breed) {
					write.print(1);
				} else {
					write.print(0);
				}
			} else {
				write.print(1);
			}
		}
		write.close();
	}
}
