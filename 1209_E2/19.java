import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) {new Main().run();}

	FastReader in = new FastReader();
	PrintWriter out = new PrintWriter(System.out);
	void run(){
		int t=in.nextInt();
		for(int i=0;i<t;i++) {
			out.println(work());
		}
		out.flush();
	}
	long mod=1000000007;
	long gcd(long a,long b) {
		return b==0?a:gcd(b,a%b);
	}
	int work() {
		int n=in.nextInt();
		int m=in.nextInt();
		int[][] A=new int[n][m];
		int[][] B=new int[n][m];
		int[][] R=new int[m][2];
		for(int i=0;i<m;i++)R[i][1]=i;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				A[i][j]=in.nextInt();
				R[j][0]=Math.max(R[j][0], A[i][j]);
			}
		}
		Arrays.sort(R,new Comparator<int[]>() {
			public int compare(int[] arr1,int[] arr2) {
				return arr2[0]-arr1[0];
			}
		});
		for(int j=0;j<m;j++) {
			int index=R[j][1];
			for(int i=0;i<n;i++) {
				B[i][j]=A[i][index];
			}
		}
		m=Math.min(n, m);
		int[][] dp=new int[m][1<<n];
		int[][] rec=new int[m][1<<n];
		for(int j=0;j<m;j++) {
			for(int s=0;s<n;s++) {//转
				for(int i=1;i<1<<n;i++) {
					int sum=0;
					for(int b=0;b<n;b++) {
						if(((1<<b)&i)>0) {
							sum+=B[(b+s)%n][j];
						}
					}
					rec[j][i]=Math.max(sum, rec[j][i]);
				}
			}
		}
		
		for(int j=0;j<m;j++) {
			for(int i=0;i<1<<n;i++) {
				if(j==0) {
					dp[j][i]=rec[j][i];
				}else {
					for(int p=i+1;;p++) {
						if(p>=1<<n)break;
						p=p|i;
						dp[j][p]=Math.max(dp[j][p], rec[j][i]+dp[j-1][p^i]);
					}
				}
			}
		}
		return dp[m-1][(1<<n)-1];
	}
}



class FastReader
{
	BufferedReader br;
	StringTokenizer st;

	public FastReader()
	{
		br=new BufferedReader(new InputStreamReader(System.in));
	}

	public String next() 
	{
		if(st==null || !st.hasMoreElements())
		{
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	public int nextInt() 
	{
		return Integer.parseInt(next());
	}

	public long nextLong()
	{
		return Long.parseLong(next());
	}
}