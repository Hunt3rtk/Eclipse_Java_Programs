import java.util.Scanner;

public class MilkFactory {
	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int [] degIn = new int[n+1];
		int [] degOut = new int[n+1];
		for(int i =0; i<n-1; i++) {
			degOut[kb.nextInt()]++;
			degIn[kb.nextInt()]++;
		}
		
		boolean sink = false;
		int sinkInd = -1;
		for(int i = 1; i<=n; i++) {
			if(sink && degOut[i] == 0 && degIn[i] > 0) {
				sinkInd = -1;
				break;
			}
			if ( degOut[i] == 0 && degIn[i] > 0) {
				sink = true;
				sinkInd = i;
			}
		}
		System.out.println(sinkInd);
	}
}
