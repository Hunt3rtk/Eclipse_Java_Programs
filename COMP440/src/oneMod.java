import java.util.Scanner;
import java.util.Stack;

public class oneMod {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		long n = kb.nextInt();
		Stack<Integer> x = new Stack<Integer>();
		long p = 1;
		
		for(int i = 1; i < n; ++i) {
			if(gcdiv(i,n)==1) {
				x.push(i);
				p = (p*i)%n;
			}
		}
		if(p!=1) {
			x.pop();
		}
		System.out.println(x.size());
		for(long i : x) {
			System.out.print(i + " ");
		}
	}
	private static long gcdiv(long a, long b) {
		if(b==0) {
			return a;
		}
		return gcdiv(b, a%b);
	}
}
