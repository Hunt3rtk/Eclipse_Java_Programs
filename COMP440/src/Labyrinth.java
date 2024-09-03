import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Labyrinth {
	public static void main(String[] args) throws IOException{
		BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter write = new PrintWriter(System.out);
		StringTokenizer f = new StringTokenizer(kb.readLine());
		int n = Integer.parseInt(f.nextToken());
		int m = Integer.parseInt(f.nextToken());
		boolean[][] visited = new boolean[n][m];
		boolean[][] obsticale = new boolean[n][m];
		int[][] previous = new int[n][m];
		int[] a = new int[2];
		int[] b = new int[2];
		for (int i = 0; i < n; i++) {
			String s = kb.readLine();
			for (int j = 0; j < m; j++) {
				if (s.charAt(j) == '#') {
					obsticale[i][j] = true;
				} else {
					visited[i][j] = false;
					if (s.charAt(j) == 'A') {
						a[0] = i;
						a[1] = j;
						}
					if (s.charAt(j) == 'B') {
						b[0] = i;
						b[1] = j;
						}
				}
			}
		}
		char[] dir = new char[] {'U','D','L','R'};
		int[] numDir = new int[] {-1,1,-1,1};
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.add(a);
		while (!queue.isEmpty()) {
			int[] u = queue.poll();
			for(int i = 0; i < 4; i++) {
				int[] z = new int[2];
				if(i < 2) {
					z[0] = u[0]+numDir[i];	
					z[1] = u[1];
				} else {
					z[0] = u[0];
					z[1] = u[1]+numDir[i];
				}
				if(z[0] >= n || z[1] >= m || z[0] < 0 || z[1] < 0) {
					continue;
				}
				if(visited[z[0]][z[1]] || obsticale[z[0]][z[1]]) {
					continue;
				}
				visited[z[0]][z[1]] = true;
				previous[z[0]][z[1]] = i;
				queue.add(z);
			}
		}
		if(visited[b[0]][b[1]]) {
			write.println("YES");
			ArrayList<Integer> path = new ArrayList<>();
			while(a[0] != b[0] || a[1] != b[1]) {
				int direction = previous[b[0]][b[1]];
				path.add(direction);
				if(direction < 2) {
					b[0] -= numDir[direction];
				} else {
					b[1] -= numDir[direction];
				}
			}
			Collections.reverse(path);
			int size = path.size();
			write.println(size);
			for(int i : path) {
				write.print(dir[i]);
			}
			write.println("");
		} else {
			write.println("NO");
		}
		write.close();
	}
}
