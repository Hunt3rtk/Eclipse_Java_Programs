import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class CourseSchedule {
	public static void main(String[] args) throws IOException {
		BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter write = new PrintWriter(System.out);
		StringTokenizer str = new StringTokenizer(kb.readLine());
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		Stack<Integer> ans = new Stack<Integer>();
		int n = Integer.parseInt(str.nextToken());
		int m = Integer.parseInt(str.nextToken());
		PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
		int[] deg = new int[n];
		for(int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}
		for(int i = 0; i < m; i++) {
			str = new StringTokenizer(kb.readLine());
			int a = Integer.parseInt(str.nextToken())-1;
			int b = Integer.parseInt(str.nextToken())-1;
			adj.get(b).add(a);
		}
		kb.close();
		for(int i = 0; i < n; i++) {
			for (int v : adj.get(i)) {
				deg[v]++;
			}
		}
		for (int i = 0; i < n; i++) {
			if (deg[i] == 0) {
				queue.add(i);
			}
		}
		while (!queue.isEmpty()) {
			int node = queue.poll();
			ans.push(node+1);
			for (int v : adj.get(node)) {
				--deg[v];
				if (deg[v] == 0) {
					queue.add(v);
				}
			}
		}
		for(int i = 0; i < n; i++) {
			write.print(ans.pop() + " ");
		}
		write.println("");
		write.close();
	}
}
