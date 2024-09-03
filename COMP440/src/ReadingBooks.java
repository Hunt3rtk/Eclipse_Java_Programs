import java.util.Scanner;

public class ReadingBooks {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        long[] t = new long[n];
        long sum = 0;
        long max = 0;
        for (int i = 0; i < n; i++) {
            t[i] = kb.nextInt();
            sum += t[i];
            max = Math.max(max, t[i]);
        }
        System.out.println(Math.max(max*2,sum));
    }
}