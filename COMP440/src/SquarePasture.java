import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SquarePasture {
	public static void main(String[] args) throws IOException {
		Scanner kb = new Scanner(new File("square.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("square.out"));
		
		int p1x1 = kb.nextInt();
		int p1y1 = kb.nextInt();
		
		int p1x2 = kb.nextInt();
		int p1y2 = kb.nextInt();
		
		
		int p2x1 = kb.nextInt();
		int p2y1 = kb.nextInt();
		
		int p2x2 = kb.nextInt();
		int p2y2 = kb.nextInt();
		
		int sqX = (Math.max(p1x1,Math.max(p1x2,Math.max(p2x1,p2x2)))) - (Math.min(p1x1,Math.min(p1x2,Math.min(p2x1,p2x2))));
		int sqY = (Math.max(p1y1,Math.max(p1y2,Math.max(p2y1,p2y2)))) - (Math.min(p1y1,Math.min(p1y2,Math.min(p2y1,p2y2))));
		
		bw.write((Math.max(sqX,sqY)*Math.max(sqX,sqY)) + "\n");
		bw.close();
		
	}
}
