import java.io.PrintWriter;
import java.util.Scanner;

public class D {
	
	public void solve(Scanner in, PrintWriter out) {
		int n = in.nextInt();
		int[] a = new int[n + 1];
		for(int i = 1; i <= n; ++i) a[i] = in.nextInt();
		
		int[] rangeInv = new int[n + 1];

		BIT bit = new BIT(n + 1);
		for(int i = 1; i <= n; ++i) {
			int cur = a[i];
			int inv = (int) bit.sum(cur, n);
			rangeInv[i] = rangeInv[i - 1] + inv;
			bit.add(cur, 1);
		}
		
		int m = in.nextInt();
		int curTotal = rangeInv[n];
		
		for(int qq = 0; qq < m; ++qq) {
			int l = in.nextInt();
			int r = in.nextInt();
			
			int N = r - l + 1;
			int total = N * (N - 1) / 2;
			
			int cur = rangeInv[r] - rangeInv[l - 1];
			
			int newInv = total - cur;
			
			curTotal -= cur;
			curTotal += newInv;
			
			if(curTotal % 2 == 0) {
				out.println("even");
			} else {
				out.println("odd");
			}
		}
		
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		new D().solve(in, out);

		in.close();
		out.close();
	}
	
	class BIT {

	    long[] tree;
	    int n;

	    public BIT(int n) {
	        this.n = n;
	        tree = new long[n + 1];
	    }

	    public void add(int i, long val)
	    {
	        while(i <= n)
	        {
	            tree[i] += val;
	            i += i & -i;
	        }
	    }

	    public long sum(int to)
	    {
	        long res = 0;
	        for(int i = to; i >= 1; i -= (i & -i))
	        {
	            res += tree[i];
	        }
	        return res;
	    }

	    public long sum(int from, int to) {
	        return sum(to) - sum(from - 1);
	    }
	}
}
