import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.prefs.BackingStoreException;

public class answertillD {
	static ArrayList<Integer>[] adjlist;
	static int[][] adjmatrix;
	static int[][] adjmatrix2;
	static boolean[] vis;
	static boolean[] intialvis;
	static boolean[] vis2;
	static int[] counter;
	static int V, E;
	static Stack<Integer> st;
	static ArrayList<Integer> arrylist;
	static boolean flag;
	static int[] dx = new int[] { 1, -1, 0, 0 };
	static int[] dy = new int[] { 0, 0, 1, -1 };
	static int[] Arr;
	static PrintWriter pw;

	public static long gcd(long u, long v) {
		if (u == 0)
			return v;
		return gcd(v % u, u);
	}

	public static int dfs(int u) {
		vis[u] = true;
		int a = 0;
		for (int v : adjlist[u])
			if (!vis[v])
				a += dfs(v);

		return 1 + a;
	}

	public static void dfs(int u, int num) {
		vis2[u] = true;
		counter[u] = num;
		for (int v : adjlist[u])
			if (!vis2[v])
				dfs(v, num);
	}
static long diff=Long.MAX_VALUE;
	static boolean check(long num, long k) {
		int n=(num+"").length()-1;
		long m=1;
		long sum=0;int i=1;
		while(n-->0)
		{
		sum+=9*m*(i++)	;
		m*=10;
		}
		sum+=(num-m)*i+1;
		if(sum<=k)
			diff=Math.min(diff, k-sum);
		return sum<=k;
	}
		

	static long bin(long k) {
		long left = 1;
		long right = k+1;
		long mid;
		long ans = 1;
		while (left <= right) {
			mid = (left + right) / 2;

			if (check(mid, k)) {
				ans = mid;
				left = mid + 1;
				
			} else
				right = mid - 1;
		}
		return ans;
	}

	public static long power(long x, int i) {
		long r = 1;
		while (i-- > 0) {
			if (r > 1e18 / x)
				return (long) (1e18 + 5);
			r = r * x;
		}
		return r;
	}

	static int m;

	static int calculate(int[] Arrs, int[] Arre, int index, boolean left, boolean targetleft) {
		int ans = 0;
		int n = m + 2;
		
		if (left) {
			ans = Arre[index - 1];
			if ((index != E + 1))
				ans += (targetleft) ? Arre[index - 1] : n - Arre[index - 1] - 1;

		} else {
			ans = n - Arrs[index - 1] - 1;
			if ((index != E + 1))
				ans += ((targetleft) ? Arrs[index - 1] : n - Arrs[index - 1] - 1);
		}
		return ans;
	}

	static int min = Integer.MAX_VALUE;

	static void backtrack(int[] Arrs, int[] Arre, int soFarMin, int index, boolean left) {
		if (index == E) {
			min = Math.min(min, soFarMin - 1);
			return;
		}

		int newmin1 = calculate(Arrs, Arre, index, left, left);
		int newmin2 = calculate(Arrs, Arre, index, left, !left);
		backtrack(Arrs, Arre, soFarMin + newmin1 + 1, index - 1, left);
		backtrack(Arrs, Arre, soFarMin + newmin2 + 1, index - 1, !left);

	}
	public static String add(String str1,String str2){
		Stack<String>st=new Stack<String>();
		int n=str1.length();
		int m=str2.length();		
		int max=Math.max(n, m);
		int sum=0,carry=0;
		for(int i=0;i<max;i++){
			int num1=0,num2=0;
			if(n>=i)
			 num1 = Integer.parseInt(str1.charAt(n-i) + "");
			if(m>=i)
			 num2 = Integer.parseInt(str2.charAt(m-i) + "");
			int z = num1 + num2 + carry;
			if (z >= 10) {
				sum = z / 10;
				carry = z % 10;
			} else {
				sum = z;
				carry=0;
			}
			st.add(sum+"");
		}
		StringBuilder sb=new StringBuilder();
		while(!st.isEmpty()){
			sb.append(st.pop());
		}
		return sb+"";
	}
	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		long k=sc.nextLong();
		long bi=bin(k);
		String str=bi+"";
		System.out.println(str.charAt((int) diff));
		
	
		
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
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
