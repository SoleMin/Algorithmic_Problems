//package round85;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class C2 {
	Scanner in;
	PrintWriter out;
	String INPUT = "";
	
	void solve()
	{
		int n = ni();
		int m = ni();
		boolean[][] f = new boolean[99][99];
		cache = new HashSet<Long>();
		out.println(n*m-rec(f, n, m, 0, 0, 0));
	}
	
	Set<Long> cache;
	
	long hash(boolean[][] f, int n, int m, int r, int c, int cur)
	{
		long x = 0;
		for(int i = 0;i < n;i++){
			for(int j = 0;j < m;j++){
				if(f[i][j])x |= 1L<<i*m+j;
			}
		}
		x = x * n + r;
		x = x * m + c;
		x = x * 41 + cur;
		return x;
	}
	
	int rec(boolean[][] f, int n, int m, int r, int c, int cur)
	{
		if(r == n)return cur;
		if(c >= m)return rec(f, n, m, r+1, 0, cur);
		long h = hash(f, n, m, r, c, cur);
		if(cache.contains(h))return 99999;
		cache.add(h);
		int min = f[r][c] ? rec(f, n, m, r, c+1, cur) : 99999;
		{
			boolean[] memo = new boolean[]{f[r][c], f[r+1][c], f[r][c+1]};
			f[r][c] = true;
			f[r+1][c] = true;
			f[r][c+1] = true;
			min = Math.min(min, rec(f, n, m, r, c+2, cur+1));
			f[r][c] = memo[0];
			f[r+1][c] = memo[1];
			f[r][c+1] = memo[2];
		}
		{
			boolean[] memo = new boolean[]{f[r][c], f[r+1][c], f[r+2][c], f[r+1][c+1], c-1>=0 ? f[r+1][c-1] : false};
			f[r][c] = true;
			f[r+1][c] = true;
			f[r+2][c] = true;
			f[r+1][c+1] = true;
			if(c-1 >= 0)f[r+1][c-1] = true;
			min = Math.min(min, rec(f, n, m, r, c+1, cur+1));
			f[r][c] = memo[0];
			f[r+1][c] = memo[1];
			f[r+2][c] = memo[2];
			f[r+1][c+1] = memo[3];
			if(c-1 >= 0)f[r+1][c-1] = memo[4];
		}
		{
			boolean[] memo = new boolean[]{f[r][c], f[r][c+1], f[r][c+2], f[r+1][c+1]};
			f[r][c] = true;
			f[r][c+1] = true;
			f[r][c+2] = true;
			f[r+1][c+1] = true;
			min = Math.min(min, rec(f, n, m, r, c+3, cur+1));
			f[r][c] = memo[0];
			f[r][c+1] = memo[1];
			f[r][c+2] = memo[2];
			f[r+1][c+1] = memo[3];
		}
		return min;
	}

	int count(int n, int m, int p, int step)
	{
		int[] dr = {1, 0, -1, 0, 0};
		int[] dc = {0, 1, 0, -1, 0};
		
		// (0,i)
		int ct = 0;
		boolean[][] f = new boolean[n][m];
		for(int j = 0;j < n;j++){
			for(int k = 0;k < m;k++){
				if(k % 5 == p){
					ct++;
					for(int l = 0;l < 5;l++){
						int nr = j+dr[l];
						int nc = k+dc[l];
						if(nr >= 0 && nr < n && nc >= 0 && nc < m){
							f[nr][nc] = true;
						}
					}
				}
			}
			p = (p+step)%5;
		}
		
		for(int j = 0;j < n;j++){
			for(int k = 0;k < m;k++){
				if(!f[j][k]){
					ct++;
					for(int l = 0;l < 5;l++){
						int nr = j+dr[l];
						int nc = k+dc[l];
						if(nr >= 0 && nr < n && nc >= 0 && nc < m){
							f[nr][nc] = true;
						}
					}
				}
			}
		}
		return ct;
	}
	
	void run() throws Exception
	{
		in = oj ? new Scanner(System.in) : new Scanner(INPUT);
		out = new PrintWriter(System.out);

		long s = System.currentTimeMillis();
		solve();
		out.flush();
		tr(System.currentTimeMillis()-s+"ms");
	}
	
	public static void main(String[] args) throws Exception
	{
		new C2().run();
	}
	
	int ni() { return Integer.parseInt(in.next()); }
	long nl() { return Long.parseLong(in.next()); }
	double nd() { return Double.parseDouble(in.next()); }
	boolean oj = System.getProperty("ONLINE_JUDGE") != null;
	void tr(Object... o) { if(!oj)System.out.println(Arrays.deepToString(o)); }
}
