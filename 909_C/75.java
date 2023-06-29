import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/*

 */
public class C455 {
	static int N;
	static final int mod = 1_000_000_007;
	static int[][] memo;
	static int[] list;
	public static void main(String[] args) {
		FS scan = new FS(System.in);
		
		N = scan.nextInt();
		list = new int[N];
		for(int i=0;i<N;i++) {
			list[i] = scan.next().equals("s")?0:1;
		}
		if(list[N-1] == 1) {
			System.out.println(0);
			return;
		}
		memo = new int[N+1][N+2];
		Arrays.fill(memo[N], 1);
		int[] sum = new int[N+2];
		
		for(int i=N-1;i>=0;i--) {
			sum[0] = memo[i+1][0];
			for(int j=1;j<sum.length;j++) {
				sum[j] = sum[j-1] + memo[i+1][j];
				sum[j] %= mod;
			}
			for(int j=0;j<=N;j++) {
				if (list[i]==1 && (i==0 || list[i-1]==1))
					memo[i][j] = memo[i+1][j+1];
				else if(i==0 || list[i-1] == 1)
					memo[i][j] = memo[i+1][j];
				else if (list[i]==1){
//					for(int k=0;k<=j;k++) {
//						memo[i][j] += memo[i+1][k+1];
//					}
					memo[i][j] = sum[j+1] - sum[0] + mod;
					memo[i][j] %= mod;
					
				}
				else if (list[i]==0) {
					memo[i][j] = sum[j];
				}
			}
		}
		
//		for(int i=0;i<=N;i++) {
//			for(int j=0;j<=N;j++) {
//				System.out.print(memo[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		System.out.println(memo[0][0]);
	}
	
	private static class FS {
		BufferedReader br;
		StringTokenizer st;
		public FS(InputStream in) {
			br = new BufferedReader(new InputStreamReader(in));
		}
		String next(){
			while(st==null||!st.hasMoreElements()){
				try{st = new StringTokenizer(br.readLine());}
				catch(IOException e){e.printStackTrace();}
			}
			return st.nextToken();
		}
		int nextInt() {return Integer.parseInt(next());}
		long nextLong() {return Long.parseLong(next());}
		double nextDouble() { return Double.parseDouble(next());}
	}
}
