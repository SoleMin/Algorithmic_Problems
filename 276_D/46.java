import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class D {
	static long l, r;
	static long[][][][][] dp;
	public static void main(String[] args) throws IOException {
		InputReader in = new InputReader();
		l = in.nextLong();
		r = in.nextLong();
		dp = new long[65][2][2][2][2];
		for(int i = 0 ; i < 65;i++)
		for(int j = 0 ; j < 2;j++)
		for(int k = 0 ; k < 2;k++)
		for(int a = 0 ; a<2;a++)
		dp[i][j][k][a][0]=dp[i][j][k][a][1]=-1;
		System.out.println(go(63, 0, 0, 0, 0));
	}

	public static long go(int i, int a1, int a2, int b1, int b2) {
		if(i==-1)return 0;
		if(dp[i][a1][a2][b1][b2]!=-1)
			return dp[i][a1][a2][b1][b2];
		
		int f1 = 3, f2 = 3;
		int bl = (int) ((l >> i)) & 1, br = (int) ((r >> i) & 1);
		if (a2 == 0 && br==0)
			f1 &= 1;
		if(a1 == 0 && bl==1)
			f1 &= 2;
		if (b2 == 0 && br==0)
			f2 &= 1;
		if(b1 == 0 && bl==1)
			f2 &= 2;
		long res = 0;
		for(int x = 0 ; x<2;x++){
			for(int y = 0 ; y<2;y++){
				if(((f1>>x)&1) == 1 &&((f2>>y)&1) == 1){
					res = Math.max(res, (((long)(x^y))<<i)+go(i-1,x>bl||a1==1?1:0,x<br||a2==1?1:0,y>bl||b1==1?1:0,y<br||b2==1?1:0));
				}
			}
		}
		return dp[i][a1][a2][b1][b2]=res;
	}

	static class InputReader {
		BufferedReader in;
		StringTokenizer st;

		public InputReader() throws IOException {
			in = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer(in.readLine());
		}

		public String next() throws IOException {
			while (!st.hasMoreElements())
				st = new StringTokenizer(in.readLine());
			return st.nextToken();
		}

		public int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}
	}
}