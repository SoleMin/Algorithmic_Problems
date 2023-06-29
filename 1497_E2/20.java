import java.util.*;
import java.io.*;
import java.math.*;
import java.text.*;

public class Main {
    static PrintWriter out;
    static Reader in;
    public static void main(String[] args) throws IOException {
        input_output();
        Main solver = new Main();
        solver.solve();
        out.close(); 
        out.flush(); 
    }

    static long INF = (long)1e18;
    static int MAXN = (int)1e7+5;
    static int mod = 998_244_353;
    static int n, m, q, t;
    static double pi = Math.PI;

    void solve() throws IOException{
    	t = in.nextInt();

    	int[] div = new int[MAXN];
    	Arrays.fill(div, 1);
    	for (int i = 2; i < MAXN; i++) {
    		if (div[i] == 1) {
    			for (int j = i; j < MAXN; j+=i) {
    				div[j] = i;
    			}
    		}
    	}

    	while (t --> 0) {
    		n = in.nextInt();
			int k = in.nextInt();

			int[] arr = new int[n+1];
			for (int i = 1; i <= n; i++) {
				arr[i] = in.nextInt();
				int tmp = arr[i], newn = 1;

				while (div[arr[i]] != 1) {
					int elm = div[arr[i]],
						cnt = 0;
					while (div[arr[i]] == elm) {
						cnt++;
						arr[i] /= elm;
					}
					if (cnt%2 == 1) newn *= elm;
				}
				newn *= arr[i];
				arr[i] = newn;
			}

			int[] close = new int[n+1];
			List<Node> list = new ArrayList<>();
			for (int i = 1; i <= n; i++) list.add(new Node(arr[i], i));
			Collections.sort(list);

			for (int i = 0; i < n; i++) {
				if (i == n-1 || list.get(i+1).val != list.get(i).val) {
					close[list.get(i).idx] = -1;
				} else {
					close[list.get(i).idx] = list.get(i+1).idx;
				}
			}

			int[][] next = new int[n+1][k+1];
			List<Integer> upd = new ArrayList<>();
			List<Integer> nupd = new ArrayList<>();
			for (int i = 0; i <= k; i++) next[n][i] = n;
			for (int i = n-1; i >= 1; i--) {
				nupd.clear();
				if (close[i] == -1) {
					for (int j = 0; j <= k; j++) next[i][j] = next[i+1][j];
				} else {
					int tmp = close[i]-1, cnt = 0;
					if (upd.size() == 0 || tmp < upd.get(0)) {
						nupd.add(tmp);
						tmp = -1;
					}
					for (int j = 0; j < upd.size(); j++) {
						if (nupd.size() < k+1 && tmp != -1 && tmp < upd.get(j)) {
							nupd.add(tmp);
							tmp = -1;
						}
						if (nupd.size() < k+1) nupd.add(upd.get(j));
					}
					if (tmp != -1 && nupd.size() < k+1) nupd.add(tmp);

					for (int j = 0; j < nupd.size(); j++) 
						next[i][j] = nupd.get(j);
					for (int j = nupd.size(); j <= k; j++)
						next[i][j] = n;

					upd.clear();
					for (int j = 0; j < nupd.size(); j++) upd.add(nupd.get(j));
				}

			}
			
			int[][] dp = new int[n+1][k+1];
    		for (int i = 1; i <= n; i++)
    			for (int j = 0; j <= k; j++)
    				dp[i][j] = n;
    		for (int i = 0; i < n; i++) {
    			for (int cur = 0; cur <= k; cur++) {
    				for (int ncur = cur; ncur <= k; ncur++) {
    					dp[next[i+1][ncur-cur]][ncur] = Math.min(dp[next[i+1][ncur-cur]][ncur],
    															 dp[i][cur]+1);
    				}
    			}
    		}

    		int ans = n;
    		for (int i = 0; i <= k; i++) ans = Math.min(ans, dp[n][i]);
    		out.println(ans);
    	}
   	}

    //<>

    static class Node implements Comparable<Node> {
    	int val, idx;

    	Node (int val, int idx) {
    		this.val = val;
    		this.idx = idx;
    	}

    	public int compareTo(Node o) {
    		if (this.val != o.val) return this.val - o.val;
    		return this.idx - o.idx;
    	}
    }

    static class Reader {
 
        private InputStream mIs;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
    
        public Reader() {
            this(System.in);
        }
    
        public Reader(InputStream is) {
            mIs = is;
        }
    
        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
    
        }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = mIs.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }
    
        public String nextLine() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return res.toString();
        }
    
        public String next() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }
    
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
    
        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
    
        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
    
        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    
        public boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
 
    }
    static void input_output() throws IOException {
        File f = new File("in.txt");
        if(f.exists() && !f.isDirectory()) { 
            in = new Reader(new FileInputStream("in.txt"));
        } else in = new Reader();
        f = new File("out.txt");
        if(f.exists() && !f.isDirectory()) {
            out = new PrintWriter(new File("out.txt"));
        } else out = new PrintWriter(System.out);
    }
}