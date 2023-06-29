import java.io.*;
import java.util.*;
public class Sol2{
	final public static int MXN = (1<<21);
	public static int good[][];
	public static void main(String[] args) throws IOException{
		FastIO sc = new FastIO(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int num[][] = new int[m][m];
		String str = sc.next();
		for(int i=0; i<str.length()-1; i++) {
			int a = str.charAt(i)-'a';
			int b = str.charAt(i+1)-'a';
			num[a][b]++;
			num[b][a]++;
		}
		int lowbit[] = new int[MXN];
		int dp[] = new int[MXN];
		for(int i=0; i<MXN; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		dp[0] = 0;
		good = new int[MXN][m];
		for(int msk = 0; msk<(1<<m); msk++) {
			for(int i=0; i<m; i++) {
				int low = Integer.numberOfTrailingZeros(Integer.lowestOneBit(msk));
				if(low==32) low = 0;
				good[msk][i] = good[msk^(1<<low)][i] + num[i][low];
			}
		}
		for(int msk = 0; msk<(1<<m); msk++) {
			int bits = Integer.bitCount(msk)+1;
			for(int i=0; i<m; i++) {
				if((msk&(1<<i))!=0) continue;
				int nxt = msk|(1<<i);
				dp[nxt] = Math.min(dp[nxt], dp[msk] + bits*(good[msk][i]-good[((1<<m)-1)^nxt][i]));
			}
		}
		out.println(dp[(1<<m)-1]);
		out.close();
	}
	static void shuffle(int[] a) {
		Random get = new Random();
		for (int i = 0; i < a.length; i++) {
			int r = get.nextInt(a.length);
			int temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}
	static class FastIO {
		 
		// Is your Fast I/O being bad?
 
		InputStream dis;
		byte[] buffer = new byte[1 << 17];
		int pointer = 0;
 
		public FastIO(String fileName) throws IOException {
			dis = new FileInputStream(fileName);
		}
 
		public FastIO(InputStream is) throws IOException {
			dis = is;
		}
 
		int nextInt() throws IOException {
			int ret = 0;
 
			byte b;
			do {
				b = nextByte();
			} while (b <= ' ');
			boolean negative = false;
			if (b == '-') {
				negative = true;
				b = nextByte();
			}
			while (b >= '0' && b <= '9') {
				ret = 10 * ret + b - '0';
				b = nextByte();
			}
 
			return (negative) ? -ret : ret;
		}
 
		long nextLong() throws IOException {
			long ret = 0;
 
			byte b;
			do {
				b = nextByte();
			} while (b <= ' ');
			boolean negative = false;
			if (b == '-') {
				negative = true;
				b = nextByte();
			}
			while (b >= '0' && b <= '9') {
				ret = 10 * ret + b - '0';
				b = nextByte();
			}
 
			return (negative) ? -ret : ret;
		}
 
		byte nextByte() throws IOException {
			if (pointer == buffer.length) {
				dis.read(buffer, 0, buffer.length);
				pointer = 0;
			}
			return buffer[pointer++];
		}
 
		String next() throws IOException {
			StringBuffer ret = new StringBuffer();
 
			byte b;
			do {
				b = nextByte();
			} while (b <= ' ');
			while (b > ' ') {
				ret.appendCodePoint(b);
				b = nextByte();
			}
 
			return ret.toString();
		}
 
	}
}

