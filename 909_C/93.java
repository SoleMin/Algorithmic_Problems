import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {

	static int N;
	static char[] a;
	static int[][] memo;
	static int[] ind;
	static final int MOD = (int) 1e9 + 7;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		N = sc.nextInt(); a = new char[N];
		for(int i = 0; i < N; i++) a[i] = sc.nextChar();
		
		if(N == 1){out.println(1); out.flush(); return;}
		memo = new int[N][N + 5];
		for(int[] a : memo) Arrays.fill(a, -1);
		
		out.println(dp(0, 1));
		out.flush();
		out.close();
	}
	
	static int dp(int i, int ind)
	{
		if(i == N - 1) return a[i - 1] == 'f'? 1 : ind;
		if(i == 0) return dp(i + 1, a[i] == 's'? 1 : 2);
		if(memo[i][ind] != -1) return memo[i][ind];
		int ans = 0;
		if(a[i - 1] == 'f')
			ans = dp(i + 1, a[i] == 's'? ind : ind + 1);
		else
		{
			if(ind > 1)
				ans = (ans + dp(i, ind -1)) % MOD;
			ans = (ans + dp(i + 1, a[i] == 's'? ind : ind + 1)) % MOD;
		}
		return memo[i][ind] = ans;
	}

	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		Scanner(InputStream system) {br = new BufferedReader(new InputStreamReader(system));}
		Scanner(String file) throws FileNotFoundException {br = new BufferedReader(new FileReader(file));}
		String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}
		String nextLine()throws IOException{return br.readLine();}
		int nextInt() throws IOException {return Integer.parseInt(next());}
		double nextDouble() throws IOException {return Double.parseDouble(next());}
		char nextChar()throws IOException{return next().charAt(0);}
		Long nextLong()throws IOException{return Long.parseLong(next());}
		boolean ready() throws IOException{return br.ready();}
		void waitForInput(){for(long i = 0; i < 3e9; i++);}
	}
}