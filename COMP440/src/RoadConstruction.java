import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class RoadConstruction {
	static int disjoint[];
	public static void main(String[] args) throws IOException {
		BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter write = new PrintWriter(System.out);
			StringTokenizer str = new StringTokenizer(kb.readLine());
			int n = Integer.parseInt(str.nextToken());
			int m = Integer.parseInt(str.nextToken());
			int compNum = n;
			int compSize = 1;
			disjoint = new int[n];
			Arrays.fill(disjoint, -1);
			for(int i = 0; i < m; i++) {
				str = new StringTokenizer(kb.readLine());
				int a = Integer.parseInt(str.nextToken())-1;
				int b = Integer.parseInt(str.nextToken())-1;
				int size = union(a, b);
				if(size != 0) {
					compNum--;
					compSize = Math.max(compSize, size);
				}
				write.println(compNum + " " + compSize);
			}
			kb.close();
			write.close();
	}
	public static int find(int x) {
		if (disjoint[x] < 0) {
			return x;
		}
		disjoint[x] = find(disjoint[x]);
		return disjoint[x];
	}
	public static int union(int a, int b) {
		int r1 = find(a);
		int r2 = find(b);
		if (r1 != r2) {
			if (disjoint[r1] < disjoint[r2]) {
				disjoint[r1] += disjoint[r2];
				disjoint[r2] = r1;
				return -disjoint[r1];
			} else {
				disjoint[r2] += disjoint[r1];
				disjoint[r1] = r2;
				return -disjoint[r2];
			}
		} else {
			return 0;
		}
	}
}
