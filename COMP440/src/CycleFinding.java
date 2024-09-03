import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class CycleFinding {
	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int m = kb.nextInt();
		long INF = (long) 1e18;
		int [][] edge = new int[m][2];
		long[] weight = new long[m];
		long[] dist = new long[n];
		int[] parent = new int[n];
		for(int i = 0; i < m; i++) {
			int a = kb.nextInt()-1;
			int b = kb.nextInt()-1;
			long c = kb.nextLong();
			edge[i][0] = a;
			edge[i][1] = b;
			weight[i] = c;
		}
		Arrays.fill(dist, INF);
		dist[0] = 0;
		int last = 0;
		for (int i = 1; i < n; i++) {
			last = -1;
			for(int j = 0; j < edge.length; j++) {
				int u = edge[j][0];
				int v = edge[j][1];
				long c = weight[j];
				if(dist[u] == INF) {
					continue;
				}
				if(dist[v] > dist[u] + c) {
					dist[v] = dist[u] + c;
					parent[v] = u;
					last = v;
				}
			}
		}
		if(last == -1) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
			ArrayList<Integer> cycle = new ArrayList<Integer>();
			for (int i = 0; i < n - 1; i++) {
				last = parent[last];
			}
			for (int x = last;; x = parent[x]) {
				cycle.add(x);
				if (x == last && cycle.size() > 1) {
					break;
				}
			}
			Collections.reverse(cycle);
			for (int x : cycle) {
				System.out.print((x+1) + " ");
			}
			System.out.println("");
		}
	}
}
