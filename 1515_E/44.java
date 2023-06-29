import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;


public class CF_2020_GlobalRound_E {
	static boolean verb=true;
	static void log(Object X){if (verb) System.err.println(X);}
	static void log(Object[] X){if (verb) {for (Object U:X) System.err.print(U+" ");System.err.println("");}}
	static void log(int[] X){if (verb) {for (int U:X) System.err.print(U+" ");System.err.println("");}}
	static void log(int[] X,int L){if (verb) {for (int i=0;i<L;i++) System.err.print(X[i]+" ");System.err.println("");}}
	static void log(long[] X){if (verb) {for (long U:X) System.err.print(U+" ");System.err.println("");}}

	static InputReader reader;

	static long[][] binom;

	static void buildBinom(int N){
		int MAX=N+1;
		binom=new long[MAX+1][];
		for (int i=0;i<MAX+1;i++)
			binom[i]=new long[i+1];
		binom[0][0]=1;
		for (int i=1;i<MAX;i++){
			binom[i][0]=1;
			binom[i][i]=1;
			for (int j=0;j<i;j++) {
				binom[i+1][j+1]=(binom[i][j]+binom[i][j+1])%mod;
			}
			//log(binom[i]);
		}
		log("binom done");
	}
	static long mod;
	
	static long solve(int n) {
		long[] pow2=new long[n+1];
		pow2[0]=1;
		for (int i=1;i<=n;i++) {
			pow2[i]=pow2[i-1]<<1;
			while (pow2[i]>=mod)
				pow2[i]-=mod;
		}
		buildBinom(n);
		
	
		long[][] dp=new long[n+1][n+1];
		dp[1][1]=1;
		for (int i=1;i<=n;i++) {
			dp[i][i]=pow2[i-1];
			//log("base:"+dp[i][i]);
			for (int j=1;j<i-1;j++){
				int me=i-j-1;
				for (int cn=1;cn<=j;cn++) {
					//log("j:"+j+" cn:"+cn+" dp:"+dp[j][cn]);
					//log("perm:"+binom[cn+me][cn]);
					dp[i][cn+me]+=(((dp[j][cn]*binom[cn+me][cn])%mod)*pow2[me-1])%mod;
					dp[i][cn+me]%=mod;
				}
			}
		}
		long ans=0;
		for (int i=0;i<=n;i++) {
			ans+=dp[n][i];
			ans%=mod;
		}
		return ans;
	}

	public static void main(String[] args) throws Exception  {

		log(400*400*400);
		reader=new InputReader(System.in);
		int n=reader.readInt();
		mod=reader.readInt();
		
		System.out.println(solve(n));

	}


	static final class InputReader {
		private final InputStream stream;
		private final byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;

		public InputReader(InputStream stream) {
			this.stream = stream;
		}

		private int read() throws IOException {
			if (curChar >= numChars) {
				curChar = 0;
				numChars = stream.read(buf);
				if (numChars <= 0) {
					return -1;
				}
			}
			return buf[curChar++];
		}


		public final String readString() throws IOException {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			StringBuilder res=new StringBuilder();
			do {
				res.append((char)c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public final int readInt() throws IOException {
			int c = read();
			boolean neg=false;
			while (isSpaceChar(c)) {
				c = read();
			}
			char d=(char)c;
			//log("d:"+d);
			if (d=='-') {
				neg=true;
				c = read();
			}
			int res = 0;
			do {
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			//log("res:"+res);
			if (neg)
				return -res;
			return res;

		}

		public final long readLong() throws IOException {
			int c = read();
			boolean neg=false;
			while (isSpaceChar(c)) {
				c = read();
			}
			char d=(char)c;
			//log("d:"+d);
			if (d=='-') {
				neg=true;
				c = read();
			}
			long res = 0;
			do {
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			//log("res:"+res);
			if (neg)
				return -res;
			return res;

		}



		private boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
	}
}
