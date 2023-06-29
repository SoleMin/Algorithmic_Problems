import java.io.*;
import java.util.*;

public class B {

	static int n,t[],g[],MOD=(int)1e9+7;
	static int [][]memo;
	static int dp(int msk,int rem,int lastG) {
		if(rem==0)
			return 1;
		if(memo[lastG][msk]!=-1)
			return memo[lastG][msk];
		int ans=0;
		for(int i=0;i<n;i++) {
			if((msk & (1<<i))==0 && rem>=t[i] && g[i]!=lastG)
				ans+=dp(msk|1<<i,rem-t[i],g[i]);
				if(ans>=MOD)
					ans-=MOD;
		}
		return memo[lastG][msk]=ans;
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter out = new PrintWriter(System.out);
		n=sc.nextInt();
		int T=sc.nextInt();
		t=new int [n];
		g=new int [n];
		
		for(int i=0;i<n;i++) {
			t[i]=sc.nextInt();
			g[i]=sc.nextInt()-1;
		}
		memo=new int [4][1<<n];
		for(int []x:memo)
			Arrays.fill(x, -1);
		out.println(dp(0, T, 3));
		out.close();

	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		Scanner(String fileName) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(fileName));
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		String nextLine() throws IOException {
			return br.readLine();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}

		double nextDouble() throws NumberFormatException, IOException {
			return Double.parseDouble(next());
		}

		boolean ready() throws IOException {
			return br.ready();
		}

	}

}