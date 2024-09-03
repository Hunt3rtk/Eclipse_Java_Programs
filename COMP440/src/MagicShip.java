import java.io.*;
import java.util.Arrays;

public class MagicShip {
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		long[] atPos = Arrays.stream(read.readLine().split(" "))
				.mapToLong(Long::parseLong)
				.toArray();
		
		long[] destination = Arrays.stream(read.readLine().split(" "))
				.mapToLong(Long::parseLong)
				.toArray();
		
		read.readLine();  // wind length won't be used
		char[] winds = read.readLine().toUpperCase().toCharArray();

		if (!reachable(atPos, destination, Long.MAX_VALUE / 2, winds)) {
			System.out.println(-1);
			System.exit(0);
		}

		long lo = 0;
		long hi = Long.MAX_VALUE / 2;
		long valid = -1;
		while (lo <= hi) {
			long mid = lo / 2 + hi / 2;
			if (reachable(atPos, destination, mid, winds)) {
					valid = mid;
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
		}
		System.out.println(valid);
	}

	private static boolean reachable(
		long[] from, long[] to, long time, char[] windPattern
	) {
		long windX = 0;
		long windY = 0;
		// calculate the net change by the wind through one cycle
		for (char w : windPattern) {
			switch (w) {
				case 'U':
					windY++;
					break;
				case 'D':
					windY--;
					break;
				case 'L':
					windX--;
					break;
				case 'R':
					windX++;
					break;
			}
		}
		
		/*
		 * to speed things up, we can multiply
		 * the blown amount by the complete cycle amount
		 */
		windX *= time / windPattern.length;
		windY *= time / windPattern.length;
		long remainder = time % windPattern.length;
		for (int i = 0; i < remainder; i++) {  // calculate the remaining wind
		switch (windPattern[i]) {
			case 'U':
				windY++;
				break;
			case 'D':
				windY--;
				break;
			case 'L':
				windX--;
				break;
			case 'R':
				windX++;
				break;
			}
		}

		return manhattanDist(
			new long[] {from[0] + windX, from[1] + windY}, to
		) <= time;
	}

	private static long manhattanDist(long[] from, long[] to) {
		return Math.abs(from[0] - to[0]) + Math.abs(from[1] - to[1]);
	}
}
