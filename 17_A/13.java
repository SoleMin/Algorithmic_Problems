import java.io.*;
import java.util.*;

public class Solution {

	Scanner in;
	PrintWriter out;

	boolean isPrime(int x) {
		for (int i = 2; i * i <= x; ++i) {
			if (x % i == 0) {
				return false;
			}
		}
			return true;
	}

	void solve() throws IOException {
		in = new Scanner(System.in);
		//in = new Scanner(new FileReader("input.txt"));
		out = new PrintWriter(System.out);
		int N = in.nextInt();
		int K = in.nextInt();
		List<Integer> primes = new ArrayList<Integer>();
		for (int i = 2; i <= N; ++i) {
			if (isPrime(i)) {
				primes.add(i);
			}
		}
		int c = 0;
		for (int i = 2; i <= N; ++i) {
			if (!isPrime(i)) continue;
			for (int j = 0; j + 1 < primes.size(); ++j) {
				int p1 = primes.get(j);
				int p2 = primes.get(j + 1);
				if (p1 + p2 + 1 == i) {
					++c;
					//out.println(i);
					break;
				}
			}
		}
		if (c >= K) out.println("YES");
		else out.println("NO");
		out.close();		
	}

	public static void main(String args[]) throws IOException {
		new Solution().solve();
	}
}
