import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Main {

	static class Task {
		
		int NN = 1000006;
		int MOD = 998244353;
		int INF = 2000000000;
		long INFINITY = 1000000000000000000L;
		
		long [][] a;
		long [][] w, w1;
		long [][] dp;
		
		int countBit(int num) {
			int ret = 0;
			while(num > 0) {
				if((num&1)!=0)
					++ret;
				num >>= 1;
			}
			return ret;
		}
		
		long rec(int at, int mask, int n, int start) {
			long ans = -INFINITY;
			if(dp[at][mask] != -1)
				return dp[at][mask];
			if(countBit(mask) == n) {
				return dp[at][mask] = w1[start][at];
			}
			for(int i=0;i < n;++i) {
				if(((mask>>i)&1)==0) {
					ans = Math.max(ans, 
							Math.min(w[at][i], rec(i, mask | (1<<i), n, start)));
				}
			}
			return dp[at][mask] = ans;
		}
		
		public void solve(InputReader in, PrintWriter out) {
			int n  = in.nextInt(), m = in.nextInt();
			dp = new long[n][1<<n];
			a = new long[n][m];
			w = new long[n][n];
			w1 = new long[n][n];
			for(int i=0;i<n;++i) {
				for(int j=0;j<m;++j) {
					a[i][j] = in.nextLong();
				}
			}
			for(int i=0;i<n;++i) {
				for(int j=0;j<n;++j) {
					w[i][j] = INFINITY;
					if(i == j)
						continue;
					for(int k=0;k<m;++k) {
						w[i][j] = Math.min(w[i][j], Math.abs(a[j][k] - a[i][k]));
					}
				}
			}
			for(int i=0;i<n;++i) {
				for(int j=0;j<n;++j) {
					w1[i][j] = INFINITY;
					for(int k=1;k<m;++k) {
						w1[i][j] = Math.min(w1[i][j], Math.abs(a[i][k] - a[j][k - 1]));
					}
				}
			}
			long ans = 0;
			for(int start = 0;start < n;++start) {
				for(int i=0;i<n;++i) {
					for(int j=0;j<(1<<n);++j)
						dp[i][j] = -1;
				}
				ans = Math.max(ans, rec(start, 1<<start, n, start));
			}
			out.println(ans);
		}
		
		class Pair {
			Integer first, second;
			public Pair() {
			}
			public Pair(int first, int second) {
				this.first = first;
				this.second = second;
			}
			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + getOuterType().hashCode();
				result = prime * result + first;
				result = prime * result + second;
				return result;
			}
			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				Pair other = (Pair) obj;
				if (!getOuterType().equals(other.getOuterType()))
					return false;
				if (first != other.first)
					return false;
				if (second != other.second)
					return false;
				return true;
			}
			private Task getOuterType() {
				return Task.this;
			}
			
		}
		
	}
	
	static void prepareIO(boolean isFileIO) {
		Task solver = new Task();
		// Standard IO
		if(!isFileIO) {
			InputStream inputStream = System.in;
	        OutputStream outputStream = System.out;
	        InputReader in = new InputReader(inputStream);
	        PrintWriter out = new PrintWriter(outputStream);
	        solver.solve(in, out);
	        out.close();
		}
        // File IO
		else {
			String IPfilePath = System.getProperty("user.home") + "/Downloads/ip.in";
	        String OPfilePath = System.getProperty("user.home") + "/Downloads/op.out";
	        InputReader fin = new InputReader(IPfilePath);
	        PrintWriter fout = null;
	        try {
				fout = new PrintWriter(new File(OPfilePath));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
	        solver.solve(fin, fout);
	        fout.close();
		}
	}
	
	public static void main(String[] args) {
        prepareIO(false);
	}
	
	static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }
        
        public InputReader(String filePath) {
        	File file = new File(filePath);
            try {
				reader = new BufferedReader(new FileReader(file));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            tokenizer = null;
        }
        
        public String nextLine() {
        	String str = "";
        	try {
				str = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	return str;
        }
        
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
        	return Double.parseDouble(next());
        }
        
    }

}