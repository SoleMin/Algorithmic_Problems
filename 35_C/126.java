import java.util.*;
import java.io.*;

public class C {

	private static int[] dx = {1, -1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception{
		Thread t = new Thread(null, null, "~", Runtime.getRuntime().maxMemory()){
			@Override
			public void run(){
				try {
					solve();
				} catch(Exception e) {
					System.err.println("ERROR");
				}
			}
		};

		t.start();
		t.join();	
	}

	public static void solve() throws Exception {
		Scanner in = new Scanner(new File("input.txt"));
		PrintWriter out = new PrintWriter(new File("output.txt"));

		int n = in.nextInt();
		int m = in.nextInt();

		int[][] time = new int[n][m];
		for(int i = 0; i < n; ++i) {
			Arrays.fill(time[i], Integer.MAX_VALUE);
		}

		int qq = in.nextInt();
		int[] xs = new int[qq];
		int[] ys = new int[qq];

		for(int i = 0; i < qq; ++i){
			xs[i] = in.nextInt() - 1;
			ys[i] = in.nextInt() - 1;
		}


		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < m; ++j) {
				for(int k = 0; k < qq; ++k) {
					int dist = Math.abs(i - xs[k]) + Math.abs(j - ys[k]);
					time[i][j] = Math.min(time[i][j], dist);
				}
			}
		}

		int max = -1;
		int x = -1;
		int y = -1;

		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < m; ++j) if(max < time[i][j]) {

				max = time[i][j];
				x = i + 1;
				y = j + 1;
			} 
		}

		out.println(x + " " + y);

		out.flush();
		out.close();
	}

	private static class Pair {
		int f, s;
		int time;

		public Pair(int f, int s) {
			this.f = f;
			this.s = s;
		}

		public Pair(int f, int s, int time) {
			this(f, s);
			this.time = time;
		}

	}
}