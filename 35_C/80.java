
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static int n,m;
	public static void main(String[] arg) {
		FastScanner scan = null;
		PrintWriter out = null;
		try{
			scan = new FastScanner(new FileInputStream("input.txt"));
			out = new PrintWriter(new FileOutputStream("output.txt"));
		}catch(FileNotFoundException e){
			scan = new FastScanner(System.in);
			out = new PrintWriter(System.out);
		}
		
		 n = scan.nextInt();
		 m = scan.nextInt();
		int k = scan.nextInt();
		int[][] board = new int[n+1][m+1];
		String[] ins = scan.nextLine().split(" ",-1);
		List<Integer> ps = new ArrayList<Integer>();
		for(int i = 0; i < 2 * k; i += 2){
			int a = Integer.parseInt(ins[i]);
			int b = Integer.parseInt(ins[i+1]);
			board[a][b] = 1;
			ps.add(a * 2001 + b);
		}
		
		int retx = 1, rety = 1;
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		while(true){
			boolean find = false;
			List<Integer> ps2 = new ArrayList<Integer>();
			for(Integer p : ps){
				int i = p / 2001;
				int j = p % 2001;
				for(int q = 0; q < 4; q++){
					int nx = i + dx[q];
					int ny = j + dy[q];
					if(in(nx,ny) && board[nx][ny] == 0){
						board[nx][ny] = 1;
						retx = nx;
						rety = ny;
						find = true;
						ps2.add(nx * 2001 + ny);
					}
				}
				board[i][j] = 2;
			}
			ps = ps2;
			if(!find) break;
		}
		out.println(retx + " " + rety);
		out.close();
	}
	public static boolean in(int i, int j){
		return (1 <= i && i <= n) && (1 <= j && j <= m);
	}
	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;
 
		FastScanner(InputStream is) {
			try {
				br = new BufferedReader(new InputStreamReader(is));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
 
		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (Exception e) {
					return null;
				}
			}
			return st.nextToken();
		}
	    
		String nextLine() {
	        try {
	            return br.readLine();
	        }
	        catch (Exception e) {
	            return null;
	        }
	    }
		int nextInt() {
			return Integer.parseInt(next());
		}
 
		long nextLong() {
			return Long.parseLong(next());
		}
 
		double nextDouble() {
			return Double.valueOf(next());
		}
	}
}