import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class e_g14 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		FastScanner in = new FastScanner(System.in);
		OutputStream outputStream = System.out;
		PrintWriter out = new PrintWriter(outputStream);
		
		int T = 1;
		Solver A = new Solver(in, out); 
		
		for(int aa = 0; aa < T; aa++) {
			A.answer(aa + 1);
		}
		
		
		out.close();
	}
	
	static class Solver {
		FastScanner in;
		PrintWriter out;
		
		int n;
		long m;
		
		long [] fact, pow, choose [], dp[];

		public Solver(FastScanner in, PrintWriter out) {
			this.in = in;
			this.out = out;
		}
		
		public void answer(int aa) throws Exception {
			n = in.nextInt();
			m = in.nextLong();
			
			fact = new long [n+5];
			choose = new long [n+5][n+5];
			dp = new long [n+2][n+2];
			pow = new long [n+2];
			
			init();
			
			dp[0][0] = 1;
			for(int i = 0; i <= n; i++) {
				for(int j = 0; j <= i; j++) {
					for(int k = 1; i+k <= n; k++) {
						dp[i+k+1][j+k] += (dp[i][j]*choose[j+k][k]%m)*pow[k-1];
						dp[i+k+1][j+k] %= m;
					}	
				}
			}
			
			
			long ans = 0;
			for(int i = 0; i <= n; i++) {
				ans += dp[n+1][i];
				ans %= m;
			}
			
			out.println(ans);
		}
		
		public void init() {
			fact[0] = 1;
			for(int i = 1; i <= n+4; i++) {
				fact[i] = (i*fact[i-1])%m;
			}
			
			pow[0] = 1;
			for(int i = 1; i <= n+1; i++) {
				pow[i] = (2*pow[i-1])%m;
			}
			
			for(int i = 0; i <= n+4; i++) {
				for(int j = 0; j <= i; j++) {
					choose[i][j] = choose(i, j);
				}
			}
		}
		
		private long choose(int a, int b) {
			long res = (fact[a] * inv((fact[b] * fact[a-b])%m))%m;
			return res;
		}
		
		private long power (long x, long y) {
			long res = 1;
			while(y > 0) {
				if(y%2 == 1) res = (res*x)%m;
				x = (x*x)%m;
				y /= 2;
			}
			return (res%m);
		}
		
		private long inv (long a) {
			return power(a, m-2);
		}
		
	}

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner(InputStream stream) {
			br = new BufferedReader(new InputStreamReader(stream));
			st = new StringTokenizer("");
		}

		public FastScanner(String fileName) throws Exception {
			br = new BufferedReader(new FileReader(new File(fileName)));
			st = new StringTokenizer("");
		}

		public String next() throws Exception {
			while (!st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine());
			}
			return st.nextToken();
		}

		public int nextInt() throws Exception {
			return Integer.parseInt(next());
		}

		public long nextLong() throws Exception {
			return Long.parseLong(next());
		}

		public Double nextDouble() throws Exception {
			return Double.parseDouble(next());
		}

		public String nextLine() throws Exception {
			if (st.hasMoreTokens()) {
				StringBuilder str = new StringBuilder();
				boolean first = true;
				while (st.hasMoreTokens()) {
					if (first) {
						first = false;
					} else {
						str.append(" ");
					}
					str.append(st.nextToken());
				}
				return str.toString();
			} else {
				return br.readLine();
			}
		}
	}
	
}
