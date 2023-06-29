import java.io.*;
import java.util.*;

public class E {

	static int R,C;
	static int [][] grid;
	
	static int[] colsToRot, rot;
	
	static int res;
	
	public static void main(String args[]) {
		FS in = new FS();
		PrintWriter out = new PrintWriter(System.out);
		
		// Put all numbers in a list sorted by large to small
		// Pick numbers until R different columns selected
		// Fix 1st column, brute force remaining ones
		
		int T = in.nextInt();
		for(int runs = 1; runs <= T; runs++) {
			R = in.nextInt();
			C = in.nextInt();
			grid = new int[R][C];
			Num nums[] = new Num[R*C];
			int ni = 0;
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					grid[i][j] = in.nextInt();
					nums[ni++] = new Num(grid[i][j], j);
				}
			}
			Arrays.sort(nums);
			
			int have = 0;
			boolean[] used = new boolean[C];
			for(int i = 0; i < nums.length; i++) {
				if(!used[nums[i].column]) {
					used[nums[i].column] = true;
					have++;
					if(have >= R) break;
				}
			}
			
			// Now brute force positions of all of the rows
			colsToRot = new int[have];
			rot = new int[have];
			int hi = 0;
			for(int i = 0; i < C; i++) {
				if(used[i]) colsToRot[hi++] = i;
			}
//			System.out.println(Arrays.toString(colsToRot));
			res = 0;
			dfs(1);
			out.println(res);
		}
		
		out.close();
	}
	
	static void dfs(int id) {
		if(id >= colsToRot.length) {
			int[] max = new int[R];
			for(int i = 0; i < colsToRot.length; i++) {
				for(int j = 0; j < R; j++) {
					max[(j+rot[i])%R] = Math.max(max[(j+rot[i])%R], grid[j][colsToRot[i]]);
				}
			}
			int cur = 0;
			for(int ii : max) cur += ii;
			res = Math.max(res, cur);
			
		}
		else {
			for(int ro = 0; ro < R; ro++) {
				rot[id] = ro;
				dfs(id+1);
			}
		}
	}
	
	static class Num implements Comparable<Num>{
		int val, column;
		public Num(int vv, int cc) {
			val=vv;
			column=cc;
		}
		@Override
		public int compareTo(Num o) {
			return o.val-val;
		}
	}
	
	static class FS{
		BufferedReader br;
		StringTokenizer st;
		public FS() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		String next() {
			while(st == null || !st.hasMoreElements()) {
				try {st = new StringTokenizer(br.readLine());}
				catch(Exception e) {}
			}
			return st.nextToken();
		}
		int nextInt() { return Integer.parseInt(next());}
		long nextLong() { return Long.parseLong(next());}
		double nextDouble() { return Double.parseDouble(next());}
	}
}
