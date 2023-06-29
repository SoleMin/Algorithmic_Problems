import java.io.*;
import java.util.*;

public class MainG {
	static StdIn in = new StdIn();
	static PrintWriter out = new PrintWriter(System.out);
	static long M=(long)1e9+7;
	static int n, dig;
	static int[] x;
	static long[] p10, s;
	static long[][][] dp;
	
	public static void main(String[] args) {
		char[] cs = in.next().toCharArray();
		n=cs.length;
		x = new int[n];
		for(int i=0; i<n; ++i)
			x[i]=cs[i]-'0';
		p10 = new long[n];
		p10[0]=1;
		for(int i=1; i<n; ++i)
			p10[i]=p10[i-1]*10%M;
		s = new long[n+1];
		s[n]=1;
		for(int i=n-1; i>=0; --i)
			s[i]=(s[i+1]+x[i]*p10[n-1-i])%M;
		long ans=0;
		dp = new long[2][n][n+1];
		for(dig=1; dig<=9; ++dig) {
			for(int i=0; i<n; ++i) {
				Arrays.fill(dp[0][i], -1);
				Arrays.fill(dp[1][i], -1);
			}
			for(int i=1; i<=n; ++i)
				ans=(ans+p10[i-1]*dp(0, 0, i))%M;
		}
		out.println(ans);
		out.close();
	}
	
	static long dp(int less, int ignore, int need) {
		if(need==0)
			return less==1?p10[n-ignore]:s[ignore];
		if(ignore==n)
			return 0;
		if(dp[less][ignore][need]!=-1)
			return dp[less][ignore][need];
		long res=0;
		int lim=less==1?9:x[ignore];
		for(int i=0; i<=lim; ++i)
			res=(res+dp(less|(i<lim?1:0), ignore+1, need-(i>=dig?1:0)))%M;
		return dp[less][ignore][need]=res;
	}
	
	interface Input {
		public String next();
		public String nextLine();
		public int nextInt();
		public long nextLong();
		public double nextDouble();
	}
	static class StdIn implements Input {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;
		public StdIn() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}
		public StdIn(InputStream in) {
			try{
				din = new DataInputStream(in);
			} catch(Exception e) {
				throw new RuntimeException();
			}
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}
		public String next() {
			int c;
			while((c=read())!=-1&&(c==' '||c=='\n'||c=='\r'));
			StringBuilder s = new StringBuilder();
			while (c != -1)
			{
				if (c == ' ' || c == '\n'||c=='\r')
					break;
				s.append((char)c);
				c=read();
			}
			return s.toString();
		}
		public String nextLine() {
			int c;
			while((c=read())!=-1&&(c==' '||c=='\n'||c=='\r'));
			StringBuilder s = new StringBuilder();
			while (c != -1)
			{
				if (c == '\n'||c=='\r')
					break;
				s.append((char)c);
				c = read();
			}
			return s.toString();
		}
		public int nextInt() {
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do
				ret = ret * 10 + c - '0';
			while ((c = read()) >= '0' && c <= '9');

			if (neg)
				return -ret;
			return ret;
		}
		public int[] readIntArray(int n) {
			int[] ar = new int[n];
			for(int i=0; i<n; ++i)
				ar[i]=nextInt();
			return ar;
		}
		public long nextLong() {
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do
				ret = ret * 10 + c - '0';
			while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}
		public long[] readLongArray(int n) {
			long[] ar = new long[n];
			for(int i=0; i<n; ++i)
				ar[i]=nextLong();
			return ar;
		}
		public double nextDouble() {
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do
				ret = ret * 10 + c - '0';
			while ((c = read()) >= '0' && c <= '9');
			if (c == '.')
				while ((c = read()) >= '0' && c <= '9')
					ret += (c - '0') / (div *= 10);
			if (neg)
				return -ret;
			return ret;
		}
		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}
		private byte read() {
			try{
				if (bufferPointer == bytesRead)
					fillBuffer();
				return buffer[bufferPointer++];
			} catch(IOException e) {
				throw new RuntimeException();
			}
		}
		public void close() throws IOException {
			if (din == null)
				return;
			din.close();
		}
	}
}