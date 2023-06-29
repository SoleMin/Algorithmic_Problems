import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;


public class D {	
	BufferedReader reader;
    StringTokenizer tokenizer;
    PrintWriter out;
    
	public void solve() throws IOException {				
		int N = nextInt();
		int M = nextInt();
		boolean[][] graph = new boolean[N][N];
		for (int i = 0; i < M; i++) {
			graph[nextInt()-1][nextInt()-1] = true;
		}		
		
		int best = Integer.MAX_VALUE;
		for (int c = 0; c < N; c++) {
			int withC = 0;
			for (int i = 0; i < N; i++) {
				if (i == c) {
					if (graph[c][i]) withC++;
				} else {
					if (graph[c][i]) withC++;
					if (graph[i][c]) withC++;
				}
			}
			int notC = M - withC;
			
			List<Integer>[] g = new List[N];
			for (int i = 0; i < N; i++) {
				g[i] = new ArrayList<Integer>();
			}			
			for (int i = 0; i < N; i++) {
				if (i == c) continue;
				for (int j = 0; j < N; j++) {
					if (j == c) continue;
					if (!graph[i][j]) continue;
					g[i].add(j);					
				}
			}
			int glen = maxMatching(g, N);
			
//			int src = 2*N;
//			int dst = 2*N+1;
//			int[][] cap  = new int[2*N+2][2*N+2];
//			int[][] cost = new int[2*N+2][2*N+2];
//			for (int i = 0; i < N; i++) {
//				cap[src][i] = 1;
//				cost[src][i] = 1;
//				cap[N+i][dst] = 1;
//				cost[N+i][dst] = 1;
//			}
//			for (int i = 0; i < N; i++) {
//				if (i == c) continue;
//				for (int j = 0; j < N; j++) {
//					if (j == c) continue;
//					if (!graph[i][j]) continue;					
//					cap[i][N+j] = 1;
//					cost[i][N+j] = 1;					
//				}
//			}
//			MinCostMaxFlow flow = new MinCostMaxFlow();
//			int result[] = flow.getMaxFlow(cap, cost, src, dst);
//			int glen = result[0];
			
			int need = (2*N-1 - withC) + (notC - glen) + (N - 1 - glen);
			best = Math.min(best, need);
		}
		out.println(best);
	}
	
	static boolean findPath(List<Integer>[] g, int u1, int[] matching, boolean[] vis) {
	    vis[u1] = true;
	    for (int v : g[u1]) {
	      int u2 = matching[v];
	      if (u2 == -1 || !vis[u2] && findPath(g, u2, matching, vis)) {
	        matching[v] = u1;
	        return true;
	      }
	    }
	    return false;
	  }

	  public static int maxMatching(List<Integer>[] g, int n2) {
	    int n1 = g.length;
	    int[] matching = new int[n2];
	    Arrays.fill(matching, -1);
	    int matches = 0;
	    for (int u = 0; u < n1; u++) {
	      if (findPath(g, u, matching, new boolean[n1]))
	        ++matches;
	    }
	    return matches;
	  }

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new D().run();
	}
	
	public void run() {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
            out = new PrintWriter(System.out);
            solve();
            reader.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
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

    String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

}
