import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LookingForOrder {

	static int[] dp = new int[(int) (1 << 24)];
	static int[][] points;
	static int[] sol = new int[1<<24];
	static int sx = 0, sy = 0;

	public static void main(String[] args) {

		sx = in.nextInt();
		sy = in.nextInt();
		Arrays.fill(dp, -2);

		int n = in.nextInt();
		points = new int[n][3];

		for (int i = 0; i < n; i++) {
			points[i][0] = in.nextInt();
			points[i][1] = in.nextInt();
			points[i][2] = (sx - points[i][0]) * (sx - points[i][0]) + (sy - points[i][1]) * (sy - points[i][1]);
		}

		//System.out.println("ANS");
		System.out.println(solve(0));
		
		int mask=0;
		while(true){
			System.out.print(0+" ");
			if (mask==(1<<n)-1) break;
			int x = sol[mask];
			int count=0;
			for(int i=0; i<n; i++){
				if ((x&(1<<i))!=0) {
					count++;
					System.out.print((i+1)+" ");
					mask|=(1<<i);
				}
				if (count==2) break;
				
			}
		}
		System.out.println();

	}

	public static int solve(int mask) {
		
		if (dp[mask]!=-2) return dp[mask];
		
		int n = points.length;
		if (mask == ((1 << n)-1)) {
			return dp[mask]=0;
		}

		int here = -1;
		for (int i = 0; i < n; i++) {
			if ((mask & (1<<i)) == 0) {
				here = i;
				break;
			}
		}
		

		int ans = 2*points[here][2]+solve(mask | (1 << here));
		sol[mask] = 1<<here;

		int x1 = points[here][0];
		int y1 = points[here][1];

		for (int i = here + 1; i < n; i++) {
			if ((mask & (1 << i)) == 0) {
				int x2 = points[i][0];
				int y2 = points[i][1];
				int p = mask|(1<<here);
				p = p|(1<<i);
				if (ans>points[here][2] + points[i][2] + (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)
						+ solve(p)){
					ans=points[here][2] + points[i][2] + (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)
							+ solve(p);
					sol[mask]=(1<<here)|(1<<i);
				}
			}
		}

		return dp[mask]=ans;
	}

	public static class MyScanner {
		BufferedReader br;
		StringTokenizer st;

		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

	}

	static MyScanner in = new MyScanner();

}