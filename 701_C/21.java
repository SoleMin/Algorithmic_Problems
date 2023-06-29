import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class C {

	static StringTokenizer st;
	static BufferedReader br;
	static PrintWriter pw;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n = nextInt();
		char[]a = next().toCharArray();
		int[]cnt = new int[256];
		for (int i = 0; i < n; i++) {
			cnt[a[i]]++;
		}
		int alldiff = 0;
		for (int i = 0; i < 256; i++) {
			if (cnt[i] > 0)
				alldiff++;
		}
		Arrays.fill(cnt, 0);
		int diff = 0, right = -1, ans = n+5;
		for (int i = 0; i < n; i++) {
			if (right < i) {
				cnt[a[i]]++;
				diff = 1;
				right = i;
			}
			while (right < n-1 && diff < alldiff) {
				right++;
				cnt[a[right]]++;
				if (cnt[a[right]]==1)
					diff++;
			}
			if (diff==alldiff && right-i+1 < ans) {
				ans = right-i+1;
			}
			cnt[a[i]]--;
			if (cnt[a[i]]==0)
				diff--;
		}
		System.out.println(ans);
		pw.close();
	}
	private static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}
	private static long nextLong() throws IOException {
		return Long.parseLong(next());
	}
	private static double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}
	private static String next() throws IOException {
		while (st==null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}
}
