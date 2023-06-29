import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class F11141 {
	static class Solver {

		ArrayList<int[]> ranges[];
		HashMap<Long, Integer> hm = new HashMap<>();

		int id(long s) {
			if (!hm.containsKey(s))
				hm.put(s, hm.size());
			return hm.get(s);
		}
		
		// max disjoint range set in ranges[r]
		int[] memo;
		int go(int r) {
			memo[N] = 0;
			int last = N;
			for(int[] a : ranges[r]) {
				while(a[0] < last) {
					memo[last - 1] = memo[last];
					last--;
				}
				memo[a[0]] = Math.max(memo[a[0]], Math.max(memo[a[0]], 1 + memo[a[1] + 1]));
				last = a[0];
			}
			return memo[last];
		}

		ArrayDeque<int[]> ans = new ArrayDeque<>();
		
		void go2(int r) {
			memo[N] = 0;
			int last = N;
			int minAt[] = new int[N], oo = 987654321;
			Arrays.fill(minAt, oo);
			for(int[] a : ranges[r]) {
				minAt[a[0]] = Math.min(minAt[a[0]], a[1] - a[0]);
				while(a[0] < last) {
					memo[last - 1] = memo[last];
					last--;
				}
				memo[a[0]] = Math.max(memo[a[0]], Math.max(memo[a[0]], 1 + memo[a[1] + 1]));
				last = a[0];
			}
			while(0 < last) {
				memo[last - 1] = memo[last];
				last--;
			}
			int k = 0;
			for(; k < N;) {
				if(minAt[k] == oo || memo[k] != 1 + memo[k + minAt[k] + 1]) k++;
				else {
					ans.push(new int[] {k, k + minAt[k]});
					k += minAt[k] + 1;
				}
			}
		}
		
		@SuppressWarnings("unchecked")
		Solver() {
			ranges = new ArrayList[2250001];
			for (int i = 0; i < ranges.length; i++)
				ranges[i] = new ArrayList<>();
		}

		int N, LID;
		long[] a;

		void solve(Scanner s, PrintWriter out) {
			N = s.nextInt();
			a = new long[N + 1];
			for (int i = 1; i <= N; i++)
				a[i] = s.nextLong() + a[i - 1];
			for (int i = N; i >= 1; i--)
				for (int j = i; j <= N; j++) {
					int x = id(a[j] - a[i - 1]);
					ranges[x].add(new int[] { i - 1, j - 1 });
				}
			
			int best = 0, bid = -1;
			memo = new int[N + 1];
			Arrays.sort(ranges, (a, b) -> b.size() - a.size());
			for(int i = 0; i < ranges.length; i++, LID++) {
				if(ranges[i].size() <= best) break;
				int ans = go(i);
				if(ans > best) {
					best = ans;
					bid = i;
				}
			}
			
			// backtrack on bid
			out.println(best);
			go2(bid);
						
			while(!ans.isEmpty()) {
				int[] c = ans.pop();
				out.println(++c[0] + " " + ++c[1]);
			}
			
		}

	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		Solver solver = new Solver();
		solver.solve(s, out);

		out.close();

	}
}