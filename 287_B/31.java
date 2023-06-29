import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B {

	static long n, k;

	static long sum(long mid) {
		long tmpSum = k * (k + 1) / 2;
		long nsum = (mid - 1) * (mid) / 2;
		return tmpSum - nsum;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer sc = new StringTokenizer(br.readLine());
		n = Long.parseLong(sc.nextToken()) - 1;
		k = Long.parseLong(sc.nextToken()) - 1;
		if (n == 0)
			out.println(0);
		else if (sum(1) < n)
			out.println(-1);
		else {
			long lo = 1;
			long hi = k;
			long mid;
			while (lo < hi) {
				mid = (lo + hi) / 2;
				long sum = sum(mid);
				if (n - sum < 0)
					lo = mid + 1;
				else if (n - sum < mid) {
					hi = mid;
				} else
					hi = mid - 1;
			}
			out.println((k - lo + 1) + (n - sum(lo) == 0 ? 0 : 1));
		}
		br.close();
		out.close();
	}
}
