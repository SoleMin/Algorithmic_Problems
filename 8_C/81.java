import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CF8C {
	static int n;
	static int[] mem;
	static HashMap<Integer, String> map;
	static int INF = (int) 1e9;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		MyScanner sc = new MyScanner(System.in);
		String s = sc.nextLine();
		n = sc.nextInt();
		mem = new int[1 << n];
		Arrays.fill(mem, -1);
		map = new HashMap<>();
		map.put(0, s);
		for (int i = 1; i <= n; i++) {
			map.put(i, sc.nextLine());
		}
		int val = dp(0);
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(val);
		sb = new StringBuilder();
		sb.append("0 ");
		build(0);
		pw.println(sb);
		pw.flush();
	}

	// node == 0 -- > count 0 // state == 0 has 1 // state == 1 has 2

	private static int dp(int msk) {
		if (msk == (1 << n) - 1)
			return 0;

		if(mem[msk] != -1)
			return mem[msk];

		boolean foundFirst = false;
		int val = (int)1e9; 
		int mark = -1;
		for (int i = 1; i <= n; i++) {
			if ((msk & 1 << (i - 1)) == 0){
				if(!foundFirst){
					foundFirst = true;
					mark = i;
					val = dist(0, mark)*2 + dp(msk | 1 << (mark - 1));
				}else{
					val = Math.min(val, dist(0, mark) + dist(mark, i) + dist(i, 0) + dp((msk|1 << (mark - 1))|1 << (i - 1)));
				}
			}
		}
		return mem[msk] = val;
	}

	private static int dist(int node, int i) {
		String from = map.get(i);
		String to = map.get(node);
		String[] fromco = from.split(" ");
		String[] toco = to.split(" ");
		int xs = Integer.parseInt(fromco[0]);
		int ys = Integer.parseInt(fromco[1]);
		int xf = Integer.parseInt(toco[0]);
		int yf = Integer.parseInt(toco[1]);
		return (xs - xf) * (xs - xf) + (ys - yf) * (ys - yf);
	}

	private static void build(int msk) {
		if (msk == (1 << n) - 1) 
			return;
		boolean foundFirst = false;
		int ans = dp(msk);
		int mark = -1;
		int val = (int)1e9;
		for (int i = 1; i <= n; i++) {
			if ((msk & 1 << (i - 1)) == 0){
				if(!foundFirst){
					foundFirst = true;
					mark = i;
					val = dist(0, mark)*2 + dp(msk | 1 << (mark - 1));
					if(val == ans){
						sb.append(mark + " 0 ");
						build(msk | 1 << (mark - 1));
						return;
					}
				}else{
					val = dist(0, mark) + dist(mark, i) + dist(i, 0) + dp(msk|1 << (mark - 1)|1 << (i - 1));
					if(val == ans){
						sb.append(mark + " " + i + " 0 ");
						build(msk|1 << (mark - 1)|1 << (i - 1));
						return;
					}
				}
			}
		}
	}

	static class MyScanner {
		StringTokenizer st;
		BufferedReader br;

		public MyScanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public MyScanner(String s) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(new File(s)));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}
}
