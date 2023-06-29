import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		long[] a = new long[n];

		for (int i = 0; i < a.length; i++) {
			a[i] = Long.parseLong(st.nextToken());
		}

		long[] sum = new long[n];
		sum[0] = a[0];
		for (int i = 1; i < sum.length; i++) {
			sum[i] = sum[i - 1] + a[i];
		}

		solve(a, sum);

	}

	private static void solve(long[] a, long[] sum) {
		int n = a.length;

		Map<Long, List<Pair>> map = new HashMap<>();

		for (int j = 0; j < sum.length; j++) {
			for (int i = 0; i <= j; i++) {
				long k = getSum(sum, i, j);
				if (map.containsKey(k)) {
					map.get(k).add(new Pair(i, j));
				} else {
					List<Pair> arr = new ArrayList<>();
					arr.add(new Pair(i, j));
					map.put(k, arr);
				}
			}
		}

		int max = -1;
		List<Pair> ans = null;
		for (Map.Entry<Long, List<Pair>> entry : map.entrySet()) {
			List<Pair> pairs = entry.getValue();

			int prev = -1;
			int count = 0;
			List<Pair> temp = new ArrayList<Pair>();
			for (Pair p : pairs) {
				if (p.x > prev) {
					prev = p.y;
					temp.add(p);
					count++;
				}
			}

			if (count > max) {
				ans = temp;
				max = count;
			}
		}
		if (max != -1) {
			System.out.println(ans.size());
			for (Pair p : ans) {
				System.out.println((p.x + 1) + " " + (p.y + 1));
			}
		}
	}

	private static long getSum(long[] sum, int l, int r) {
		if (l == 0) {
			return sum[r];
		}
		return sum[r] - sum[l - 1];
	}
}

class Pair {

	int x;
	int y;

	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		int h = 171 << 4;
		h = h * x;
		h = h * y;
		return h;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Pair) {
			Pair other = (Pair) o;
			return this.x == other.x && this.y == other.y;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Pair [x=" + x + ", y=" + y + "]";
	}

}