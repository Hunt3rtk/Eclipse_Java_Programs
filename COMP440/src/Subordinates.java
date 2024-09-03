import java.io.*;
import java.util.*;

public class Subordinates {
	public static void main(String[] args) throws IOException{
		Scanner kb = new Scanner(System.in);
		PrintWriter write = new PrintWriter(System.out);
		int n = kb.nextInt();
		LinkedList<Integer> sub[] = new LinkedList[n];
		for(int i = 0; i < n; i++) {
			sub[i] = new LinkedList<>();
		}
		for(int i = 1; i <= n-1; i++) {
			int a = kb.nextInt()-1;
			sub[a].add(i);
		}
		for(int i = 0; i < n; i++) {
			int count = 0;
			ArrayDeque<Integer> queue = new ArrayDeque<>();
			queue.add(i);
			while (!queue.isEmpty()) {
				int u = queue.poll();
				for( int v : sub[u]) {
					count++;
					queue.add(v);
				}
			}
			write.print(count + " ");
		}
		write.close();
	}
}
