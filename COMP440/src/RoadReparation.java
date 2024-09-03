import java.io.*;
import java.util.*;


public class RoadReparation {
	
	public static class Edge implements Comparable<Edge> {
		public int node;
		public int adj;
		public long weight;
		public Edge(int node, int adj, long weight) {
			this.weight = weight;
			this.adj = adj;
			this.node = node;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			if(this.weight > o.weight) {
				return 1;
			} else if(this.weight == o.weight) {
				return 0;
			} else {
				return -1;
			}
		}
	}
	
	static int compNum;
	static int disjoint[];
	static int rootSize[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter write = new PrintWriter(System.out);
			StringTokenizer str = new StringTokenizer(kb.readLine());
			int n = Integer.parseInt(str.nextToken());
			int m = Integer.parseInt(str.nextToken());
			compNum = n;
			long ans = 0;
			rootSize = new int[n + 1];
			disjoint = new int[n + 1];
			Arrays.fill(disjoint, -1);
			PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
			for(int i = 0; i < m; i++) {
				str = new StringTokenizer(kb.readLine());
				int a = Integer.parseInt(str.nextToken());
				int b = Integer.parseInt(str.nextToken());
				long w = Integer.parseInt(str.nextToken());
				queue.add(new Edge(a,b,w));
			}
			kb.close();
			while (!queue.isEmpty()) {
				Edge edge = queue.poll();
				if (find(edge.node) != find(edge.adj)) {
					union(edge.node, edge.adj);
					ans += edge.weight;
				}
			}
			if(compNum == 1) {
				write.println(ans);
			} else {
				write.println("IMPOSSIBLE");
			}
			write.close();
	}
	public static int find(int x) {
		if (disjoint[x] == -1) {
			return x;
		}
		disjoint[x] = find(disjoint[x]);
		return disjoint[x];
	}
	public static void union(int a, int b) {
		int r1 = find(a);
		int r2 = find(b);
		if (r1 != r2) {
			if (rootSize[r1] < rootSize[r2]) {
				disjoint[r1] = r2;
				rootSize[r2] += rootSize[r1];
				compNum--;
			} else {
				disjoint[r2] = r1;
				rootSize[r1] += rootSize[r2];
				compNum--;
			}
		}
	}
}
