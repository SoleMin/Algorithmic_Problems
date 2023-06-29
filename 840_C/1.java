//package round429;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

// 203530
public class C {
	InputStream is;
	PrintWriter out;
	String INPUT = "";
	
	void solve()
	{
		int n = ni();
		int[] a = na(n);
		for(int i = 0;i < n;i++){
			int v = a[i];
			for(int j = 2;j*j <= v;j++){
				while(v % (j*j) == 0){
					v /= j*j;
				}
			}
			a[i] = v;
		}
		
		Arrays.sort(a);
		int[] f = new int[n];
		int p = 0;
		for(int i= 0;i < n;i++){
			if(i > 0 && a[i] != a[i-1]){
				p++;
			}
			f[p]++;
		}
		f = Arrays.copyOf(f, p+1);
		int mod = 1000000007;
		
		int[][] fif = enumFIF(1000, mod);
		long[] res = countSameNeighborsSequence(f, fif, mod);
		long ans = res[0];
		for(int v : f){
			ans = ans * fif[0][v] % mod;
		}
		
		out.println(ans);
	}
	
	public static int[][] enumFIF(int n, int mod) {
		int[] f = new int[n + 1];
		int[] invf = new int[n + 1];
		f[0] = 1;
		for (int i = 1; i <= n; i++) {
			f[i] = (int) ((long) f[i - 1] * i % mod);
		}
		long a = f[n];
		long b = mod;
		long p = 1, q = 0;
		while (b > 0) {
			long c = a / b;
			long d;
			d = a;
			a = b;
			b = d % b;
			d = p;
			p = q;
			q = d - c * q;
		}
		invf[n] = (int) (p < 0 ? p + mod : p);
		for (int i = n - 1; i >= 0; i--) {
			invf[i] = (int) ((long) invf[i + 1] * (i + 1) % mod);
		}
		return new int[][] { f, invf };
	}

	
	public static long[] countSameNeighborsSequence(int[] a, int[][] fif, int mod)
	{
		int all = 0;
		for(int v : a)all += v;
		
		int len = 0;
		long[] dp = new long[all+1];
		dp[0] = 1;
		for(int v : a){
			long[][] pre = new long[all+1][v+1];
			for(int j = 0;j <= all;j++)pre[j][0] = dp[j];
			for(int j = 0;j < v;j++){
				for(int k = 0;k <= all;k++){
					for(int L = j;L >= 0;L--){
						if(pre[k][L] == 0)continue;
						int ca = 2*(j-L);
						int ab = len+j+1-k-ca-L;
						if(ab < 0)continue;
						if(k-1 >= 0){
							pre[k-1][L] += pre[k][L]*k; // aca
							pre[k-1][L] %= mod;
						}
						if(L+1 <= v){
							pre[k][L+1] += pre[k][L]*(ca+L);
							pre[k][L+1] %= mod;
						}
						pre[k][L] = pre[k][L]*ab%mod;
					}
				}
			}
			
			Arrays.fill(dp, 0);
			for(int k = 0;k <= all;k++){
				for(int L = 0;L <= v && k+L <= all;L++){
					dp[k+L] += pre[k][L];
				}
			}
			for(int k = 0;k <= all;k++){
				dp[k] %= mod;
			}
//			for(int k = 0;k <= all;k++){
//				dp[k] = dp[k] % mod * fif[1][v] % mod;
//			}
			len += v;
		}
		long fifs = 1;
		for(int v : a)fifs = fifs * fif[1][v] % mod;
		for(int k = 0;k <= all;k++)dp[k] = dp[k] * fifs % mod;
		
		return dp;
	}
	
	void run() throws Exception
	{
		is = oj ? System.in : new ByteArrayInputStream(INPUT.getBytes());
		out = new PrintWriter(System.out);
		
		long s = System.currentTimeMillis();
		solve();
		out.flush();
		tr(System.currentTimeMillis()-s+"ms");
	}
	
	public static void main(String[] args) throws Exception { new C().run(); }
	
	private byte[] inbuf = new byte[1024];
	public int lenbuf = 0, ptrbuf = 0;
	
	private int readByte()
	{
		if(lenbuf == -1)throw new InputMismatchException();
		if(ptrbuf >= lenbuf){
			ptrbuf = 0;
			try { lenbuf = is.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); }
			if(lenbuf <= 0)return -1;
		}
		return inbuf[ptrbuf++];
	}
	
	private boolean isSpaceChar(int c) { return !(c >= 33 && c <= 126); }
	private int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }
	
	private double nd() { return Double.parseDouble(ns()); }
	private char nc() { return (char)skip(); }
	
	private String ns()
	{
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while(!(isSpaceChar(b))){ // when nextLine, (isSpaceChar(b) && b != ' ')
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}
	
	private char[] ns(int n)
	{
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while(p < n && !(isSpaceChar(b))){
			buf[p++] = (char)b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}
	
	private char[][] nm(int n, int m)
	{
		char[][] map = new char[n][];
		for(int i = 0;i < n;i++)map[i] = ns(m);
		return map;
	}
	
	private int[] na(int n)
	{
		int[] a = new int[n];
		for(int i = 0;i < n;i++)a[i] = ni();
		return a;
	}
	
	private int ni()
	{
		int num = 0, b;
		boolean minus = false;
		while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
		if(b == '-'){
			minus = true;
			b = readByte();
		}
		
		while(true){
			if(b >= '0' && b <= '9'){
				num = num * 10 + (b - '0');
			}else{
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
	
	private long nl()
	{
		long num = 0;
		int b;
		boolean minus = false;
		while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
		if(b == '-'){
			minus = true;
			b = readByte();
		}
		
		while(true){
			if(b >= '0' && b <= '9'){
				num = num * 10 + (b - '0');
			}else{
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
	
	private boolean oj = System.getProperty("ONLINE_JUDGE") != null;
	private void tr(Object... o) { if(!oj)System.out.println(Arrays.deepToString(o)); }
}
