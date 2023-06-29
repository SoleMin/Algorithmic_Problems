import java.util.*;
import java.io.*;

public class Main implements Runnable {
		
	public void solve() throws IOException {
		int N = nextInt();
                int M = nextInt();
                
                int B = nextInt();
                int[][] burn = new int[B][2];
                for(int i = 0; i < B; i++){
                        burn[i][0] = nextInt();
                        burn[i][1] = nextInt();
                }
                
                int ansx = -1;
                int ansy = -1;
                int ans = -1;
                
                for(int i = 1; i <= N; i++){
                        for(int j = 1; j <= M; j++){
                                int burnAt = Integer.MAX_VALUE;
                                for(int k = 0; k < B; k++){
                                        int now = distance(i, j, burn[k][0], burn[k][1]);
                                        burnAt = Math.min(burnAt, now);
                                }
                                //System.out.println(burnAt + " " + i + " " + j);
                                if(burnAt >= ans){
                                        
                                        ans = burnAt;
                                        ansx = i;
                                        ansy = j;
                                        
                                }
                        }
                }
                
                
                out.println(ansx + " " + ansy);
	}
        
        private int distance(int x, int y, int xx, int yy){
                //withour sqrt
                return Math.abs(xx - x) + Math.abs(yy - y);
        }

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//-----------------------------------------------------------
	public static void main(String[] args) {
		new Main().run();
	}

	public void run() {
		try {
			//in = new BufferedReader(new InputStreamReader(System.in));
			in = new BufferedReader(new FileReader(new File("input.txt")));
                        out = new PrintWriter(new FileWriter(new File("output.txt")));
                        tok = null;
			solve();
			in.close();
                        out.close();
		} catch (IOException e) {
			System.exit(0);
		}
	}

	public String nextToken() throws IOException {
		while (tok == null || !tok.hasMoreTokens()) {
			tok = new StringTokenizer(in.readLine());
		}
		return tok.nextToken();
	}

	public int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	public long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	public double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

        PrintWriter out;
	BufferedReader in;
	StringTokenizer tok;
}