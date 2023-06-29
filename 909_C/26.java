import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class C {
	
	//why am I MLE'ing???
	
	int n;
	char[] a;
	long[][] memo;
	long mod = (long) 1e9 + 7;
	
	boolean lastFor(int i) {
		if(i == 0) return false;
		return a[i - 1] == 'f';
	}
	
	long dp(int ind, int curIndent) {
		if(ind == n) return 1;
		if(curIndent < 0) return 0;
		if(memo[ind][curIndent] != -1) return memo[ind][curIndent];
		long ans = 0;
		if(a[ind] == 'f' && lastFor(ind)) {
			ans += dp(ind + 1, curIndent + 1);
		} else if(a[ind] == 'f' && !lastFor(ind)) {
			ans += dp(ind, curIndent - 1);
			ans += dp(ind + 1, curIndent + 1);
//			for(int indent = 1; indent <= curIndent + 1; ++indent) {
//				ans += dp(ind + 1, indent);
//			}
		} else if(a[ind] == 's' && lastFor(ind)) {
			ans += dp(ind + 1, curIndent);
		} else if(a[ind] == 's' && !lastFor(ind)) {
			ans += dp(ind + 1, curIndent);
			ans += dp(ind, curIndent - 1);
//			for(int indent = 0; indent <= curIndent; ++indent) {
//				ans += dp(ind + 1, indent);
//			}
		}
		return memo[ind][curIndent] = ans % mod;
	}
	
	public void solve(Scanner in, PrintWriter out) {
		n = in.nextInt();
		a = new char[n];
		int forCount = 0;
		int[] fc = new int[n + 1];
		for(int i = 0; i < n; ++i) {
			a[i] = in.next().charAt(0);
			if(a[i] == 'f') ++forCount;
			fc[i] = forCount;
		}
		fc[n] = fc[n - 1];
//		long time = System.currentTimeMillis();
		memo = new long[n][forCount + 1];
		for(long[] aa : memo) {
			Arrays.fill(aa, -1);
		}
		for(int i = n; i >= 0; --i) {
			for(int indent = fc[i] - 1; indent >= 0; --indent) {
				dp(i, indent);
			}
		}
		out.println(dp(0, 0) % mod);
//		System.out.println(System.currentTimeMillis() - time);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		new C().solve(in, out);

		in.close();
		out.close();
	}
}
