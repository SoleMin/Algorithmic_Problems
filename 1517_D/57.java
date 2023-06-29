import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Practice {
	public static long mod = (long) Math.pow(10, 9) + 7;
	public static long[][][]dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		
		// int t = Integer.parseInt(br.readLine());
//		while (t-- > 0) {
		String[] s2 = br.readLine().split(" ");
		int n = Integer.parseInt(s2[0]);
		int m = Integer.parseInt(s2[1]);
		int k = Integer.parseInt(s2[2]);
		dp=new long[n][m][k+1];
		int[][] hori = new int[n][m - 1];
		int[][] verti = new int[n - 1][m];
		for (int i = 0; i < n; i++) {
			String str = (br.readLine());
			String[] s1 = str.split(" ");
			for (int j = 0; j < m - 1; j++) {
				hori[i][j] = Integer.parseInt(s1[j]);
			}
		}
		for (int i = 0; i < n - 1; i++) {
			String str = (br.readLine());
			String[] s1 = str.split(" ");
			for (int j = 0; j < m; j++) {
				verti[i][j] = Integer.parseInt(s1[j]);
			}
		}
		long[][]ans=new long[n][m];
		if(k%2!=0) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					ans[i][j]=-1;
				}
			}
		}else {
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					ans[i][j]=findAns(i,j,k,hori,verti,n,m,Integer.MAX_VALUE);
				}
			}
		}
		for(int i=0;i<n;i++) {
			StringBuilder str=new StringBuilder();
			for(int j=0;j<m;j++) {
				str.append(ans[i][j]+" ");
			}pw.println(str.toString());
		}
		// }

		pw.close();
	}

	private static long findAns(int i, int j, int k, int[][] hori, int[][] verti, int n, int m, int last) {
		// TODO Auto-generated method stub
		if(k==0) {
			return 0;
		}
		if(i<n&&j<m&&i>=0&&j>=0) {
			
		}else {
			return 100000000;
		}
	//	System.out.println(i+" "+j+" "+k);
		if(dp[i][j][k]!=0) {
			return dp[i][j][k];
		}
		long ans=k*((long)last);
		if(j>0) {
			long curr=2*hori[i][j-1];
			curr+=findAns(i, j-1, k-2, hori, verti, n, m, hori[i][j-1]);
			ans=Math.min(ans, curr);
		}
	//	System.out.println(ans+" 0");
		if(j<m-1) {
			long curr=2*hori[i][j];
			curr+=findAns(i, j+1, k-2, hori, verti, n, m, hori[i][j]);
			ans=Math.min(ans, curr);
		}
	//	System.out.println(ans+" 1");
		if(i>0) {
			long curr=2*verti[i-1][j];
			curr+=findAns(i-1, j, k-2, hori, verti, n, m, verti[i-1][j]);
			ans=Math.min(ans, curr);
		}
	//	System.out.println(ans+" 2");
		if(i<n-1) {
			long curr=2*verti[i][j];
			curr+=findAns(i+1, j, k-2, hori, verti, n, m, verti[i][j]);
			ans=Math.min(ans, curr);
		}
	//	System.out.println(ans+" 3");
		dp[i][j][k]=ans;
		return ans;
	}
}

//private static long getGCD(long l, long m) {
//// TODO Auto-generated method stub
//
//long t1 = Math.min(l, m);
//long t2 = Math.max(l, m);
//while (true) {
//	long temp = t2 % t1;
//	if (temp == 0) {
//		return t1;
//	}
//	t2 = t1;
//	t1 = temp;
//}
//}