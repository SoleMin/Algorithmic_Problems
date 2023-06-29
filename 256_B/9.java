import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class B {
    static Scanner in; static int next() throws Exception {return in.nextInt();};
//	static StreamTokenizer in; static int next() throws Exception {in.nextToken(); return (int) in.nval;}
//	static BufferedReader in;
    static PrintWriter out;

    public static long count(long k, long x, long y, long n) {
        long sum = 2*k*(k+1)+1;
        if (k >= x-1) {
            sum -= (k-x+1)*(k-x+1);
        }
        if (k >= y-1) {
            sum -= (k-y+1)*(k-y+1);
        }
        if (k + x >= n) {
            sum -= (k+x-n)*(k+x-n);
        }
        if (k + y >= n) {
            sum -= (k+y-n)*(k+y-n);
        }

        if (k > x+y-1) {
            sum += ((k+1-x-y)*(k+1-x-y+1))/2;
        }

        if (k > n-x+y) {
            sum += ((k+x-n-y)*(k+x-n-y+1))/2;
        }

        if (k > n-y+x) {

            sum += ((k+y-n-x)*(k+y-n-x+1))/2;
        }

        if (k > 2*n-x-y+1) {

            sum += ((k-2*n+x+y-1)*(k-2*n+x+y))/2;
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        in = new Scanner(System.in);
//		in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
//		in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);

        long n = in.nextLong(), x = in.nextLong(), y = in.nextLong(), c = in.nextLong();

        long res = 0;
        while (count(res, x, y, n) < c) res++;
        out.println(res);


        out.println();
        out.close();
    }
}