import java.io.*;
import java.util.*;

import static java.lang.Math.*;
import static java.util.Arrays.fill;
import static java.util.Arrays.binarySearch;
import static java.util.Arrays.sort;

public class Main {
	public static void main(String[] args) throws IOException {
		new Thread(null, new Runnable() {
			public void run() {
				try {
					try {
						if (new File("input.txt").exists())
							System.setIn(new FileInputStream("input.txt"));
					} catch (SecurityException e) {}
					new Main().run();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}, "1", 1L << 24).start(); 
	}

	BufferedReader in;
	PrintWriter out;
	StringTokenizer st = new StringTokenizer("");
	
	int N;
	int M;
	boolean[][] used;
	Queue<Integer> queue;
	
	int[] dx = { -1, 0, 1, 0 };
	int[] dy = { 0, -1, 0, 1 };
	int ans = -1;
	
	void run() throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter("output.txt");
		
		N = nextInt();
		M = nextInt();
		used = new boolean [N][M];
		queue = new ArrayDeque<Integer> (N * M);
		for (int K = nextInt(); K --> 0; )
			addState(nextInt() - 1, nextInt() - 1);
		while (!queue.isEmpty()) {
			int cv = queue.poll();
			int cx = cv / M;
			int cy = cv % M;
			for (int d = 0; d < dx.length; d++) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];
				if (0 <= nx && nx < N && 0 <= ny && ny < M && !used[nx][ny])
					addState(nx, ny);
			}
		}
		out.println((1 + ans / M) + " " + (1 + ans % M));
		out.close();
	}
	
	void addState(int x, int y) {
		used[x][y] = true;
		queue.add(ans = code(x, y));
	}

	int code(int x, int y) {
		return x * M + y;
	}

	String nextToken() throws IOException {
		while (!st.hasMoreTokens()) {
			st = new StringTokenizer(in.readLine());
		}
		
		return st.nextToken();
	}
	
	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}
	
	long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}
	
	double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}
	
	String nextLine() throws IOException {
		st = new StringTokenizer("");
		return in.readLine();
	}
	
	boolean EOF() throws IOException {
		while (!st.hasMoreTokens()) {
			String s = in.readLine();
			
			if (s == null) {
				return true;
			}
			
			st = new StringTokenizer(s);
		}
		
		return false;
	}
}
