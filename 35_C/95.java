import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class ProblemC {
	
	static int[] dx = {1, 0, 0, -1};
	static int[] dy = {0, 1, -1, 0};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader s = new BufferedReader(new FileReader("input.txt"));
		PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
//		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		
		String[] nm = s.readLine().split(" ");
		int n = Integer.valueOf(nm[0]);
		int m = Integer.valueOf(nm[1]);
		int k = Integer.valueOf(s.readLine());
		
		int[][] dp = new int[n][m];
		for (int i = 0 ; i < n ; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		String[] st = s.readLine().split(" ");
		int[][] trees = new int[k][2];
		for (int l = 0 ; l < k ; l++) {
			trees[l][0] = Integer.valueOf(st[l*2])-1;
			trees[l][1] = Integer.valueOf(st[l*2+1])-1;
		}
		
		int maxtime = -1;
		int max_x = -1;
		int max_y = -1;
		for (int i = 0 ; i < n ; i++) {
			for (int j = 0 ; j < m ; j++) {
				int minDist = n+m;
				for (int l = 0 ; l < k ; l++) {
					minDist = Math.min(minDist, Math.abs(i - trees[l][0]) + Math.abs(j - trees[l][1]));
				}
				if (maxtime < minDist) {
					maxtime = minDist;
					max_x = i+1;
					max_y = j+1;
				}
			}
		}
		
		
		
		out.println(max_x + " " + max_y);
		out.flush();
	}


	public static void debug(Object... os){
		System.err.println(Arrays.deepToString(os));
	}
}