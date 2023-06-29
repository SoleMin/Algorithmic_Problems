import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class GeorgeAndInterestingGraph {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        int[] edgeFrom = new int[M];
        int[] edgeTo = new int[M];
        for (int i = 0; i < M; i++) {
        	edgeFrom[i] = sc.nextInt();
        	edgeTo[i] = sc.nextInt();
        }
        
        int best = Integer.MAX_VALUE;
    	boolean[][] adjMat = makeAdjMat(N, edgeFrom, edgeTo);
        for (int i = 0; i < N; i++) {
        	boolean[][] mat = copyOfArray2d(adjMat);
        	best = Math.min(best, count(mat, M, i));
        }
        
        System.out.println(best);
    }
    
    public static boolean[][] copyOfArray2d(boolean[][] arr) {
    	int N = arr.length;
    	int M = arr[0].length;
    	boolean[][] copy = new boolean[N][M];
    	for (int i = 0; i < N; i++) {
    		System.arraycopy(arr[i], 0, copy[i], 0, M);
    	}
    	return copy;
    }
    
    public static int count(boolean[][] mat, int M, int center) {
//    	int N = mat.length;
//    	int M = mat[0].length;
//
//    	int centerConnect = (mat[center][center]) ? 0 : 1;
//    	for (int i = 0; i < N; i++) {
//			if (i != center) {
//				if (!mat[i][center]) {
//					centerConnect++;
//				}
//				if (!mat[center][i]) {
//					centerConnect++;
//				}
//			}
//	    	mat[i][center] = false;
//	    	mat[center][i] = false;
//		}
//    	
//    	int[][] adjMat = new int[2 * N + 2][2 * N + 2];
//    	for (int i = 0; i < N; i++) {
//    		for (int j = 0; j < N; j++) {
//    			int idx = N + j;
//    			adjMat[i][idx] = (mat[i][j]) ? 1 : 0;
//    		}
//    	}
//    	int s = 2 * N;
//    	int t = 2 * N + 1;
//    	for (int i = 0; i < N; i++) {
//    		adjMat[s][i] = 1;
//    	}
//    	for (int i = N; i < 2 * N; i++) {
//    		adjMat[i][t] = 1;
//    	}
//    	
//    	int matches = fordFulkerson(adjMat, s, t);
//    	
//    	return centerConnect + matches;
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	int N = mat.length;
//    	int M = mat[0].length;
    	
    	int cntWithI = (mat[center][center]) ? 1 : 0;
    	for (int i = 0; i < N; i++) {
    		if (i != center) {
    			if (mat[i][center]) {
    				cntWithI++;
    			}
    			if (mat[center][i]) {
    				cntWithI++;
    			}
    		}
        	mat[i][center] = false;
        	mat[center][i] = false;
    	}
    	
    	int other = M - cntWithI;
    	
//    	int centerConnect = (mat[center][center]) ? 0 : 1;
//    	
//    	for (int i = 0; i < N; i++) {
//    		if (i != center) {
//    			if (!mat[i][center]) {
//    				centerConnect++;
//    			}
//    			if (!mat[center][i]) {
//    				centerConnect++;
//    			}
//    		}
//        	mat[i][center] = false;
//        	mat[center][i] = false;
//    	}
    	
    	int matches = bipartiteMatching(mat);
    	
    	return (2 * N - 1 - cntWithI + other - matches + N - 1 - matches);
//    	return (centerConnect + N - 1 - matches);
    }
    
    public static boolean[][] makeAdjMat(int N, int[] edgeFrom, int[] edgeTo) {
    	boolean[][] mat = new boolean[N][N];
    	for (int i = 0; i < edgeFrom.length; i++) {
    		int from = edgeFrom[i] - 1;
    		int to = edgeTo[i] - 1;
    		mat[from][to] = true;
    	}
    	return mat;
    }
    
    /**
     * Returns true if there is a path from the source 's' to the sink 't' in the residual graph.
     * Also fills parent[] to store the path.
     * See here for more info:  http://www.geeksforgeeks.org/ford-fulkerson-algorithm-for-maximum-flow-problem/
     */
    public static boolean fordFulkersonHelper(int[][] resid, int s, int t, int[] parent) {
    	int V = resid.length;
    	boolean[] visited = new boolean[V];
    	LinkedList<Integer> q = new LinkedList<Integer>();
    	q.push(s);
    	visited[s] = true;
    	parent[s] = -1;
    	
    	while (!q.isEmpty()) {
    		int u = q.pop();
    		for (int v = 0; v < V; v++) {
    			if (!visited[v] && resid[u][v] > 0) {
    				q.push(v);
    				parent[v] = u;
    				visited[v] = true;
    			}
    		}
    	}
    	
    	return visited[t];
    }
    
    /**
     * Returns the maximum flow from 's' to 't' in the given graph.
     * See here for more info:  http://www.geeksforgeeks.org/ford-fulkerson-algorithm-for-maximum-flow-problem/
     */
    public static int fordFulkerson(int[][] graph, int s, int t) {
    	int V = graph.length;
    	int[][] resid = new int[V][V];
    	int[] parent = new int[V];
    	int maxFlow = 0;
    	
    	for (int u = 0; u < V; u++) {
    		for (int v = 0; v < V; v++) {
    			resid[u][v] = graph[u][v];
    		}
    	}
    	
    	while (fordFulkersonHelper(resid, s, t, parent)) {
    		int pathFlow = Integer.MAX_VALUE;
    		for (int v = t; v != s; v = parent[v]) {
    			int u = parent[v];
    			pathFlow = Math.min(pathFlow,  resid[u][v]);
    		}
    		for (int v = t; v != s; v = parent[v]) {
    			int u = parent[v];
    			resid[u][v] -= pathFlow;
    			resid[v][u] += pathFlow;
    		}
    		maxFlow += pathFlow;
    	}
    	
    	return maxFlow;
    }
    
    /**
     * Returns true if a matching for vertex 'u' is possible.
     * See here for more info:  http://www.geeksforgeeks.org/maximum-bipartite-matching/
     */
    public static boolean bipartiteMatchingHelper(boolean[][] bpGraph, int u, boolean[] seen, int[] matchR) {
    	int N = bpGraph[0].length;
    	for (int v = 0; v < N; v++) {
    		if (bpGraph[u][v] && !seen[v]) {
    			seen[v] = true;
    			if (matchR[v] < 0 || bipartiteMatchingHelper(bpGraph, matchR[v], seen, matchR)) {
    				matchR[v] = u;
    				return true;
    			}
    		}
    	}
    	return false;
    }
    
    /**
     * Returns the maximum bipartite matching from an an adjacency matrix.
     * Note:  bpGraph[i][j] = true if there is an edge from i to j.
     * Note:  matchIJ (array of length M) is an output variable containing the matchings, such that matchIJ[i] = j means that there is a match from i to j.
     * Note:  matchJI (array of length N) is an output variable containing the matchings, such that matchJI[j] = i means that there is a match from i to j.
     * See here for more info:  http://www.geeksforgeeks.org/maximum-bipartite-matching/
     */
    public static int bipartiteMatching(boolean[][] bpGraph, int[] matchIJ, int[] matchJI) {
    	int ans = bipartiteMatching(bpGraph, matchJI);
    	
    	for (int i = 0; i < matchJI.length; i++) {
    		matchIJ[i] = -1;
    	}
    	
    	for (int j = 0; j < matchJI.length; j++) {
    		int i = matchJI[j];
    		if (i >= 0) {
    			matchIJ[i] = j;
    		}
    	}
    	
    	return ans;
    }
    
    /**
     * Returns the maximum bipartite matching from an an adjacency matrix.
     * Note:  bpGraph[i][j] = true if there is an edge from i to j.
     * Note:  matchJI (array of length N) is an output variable containing the matchings, such that matchJI[j] = i means that there is a match from i to j.
     * See here for more info:  http://www.geeksforgeeks.org/maximum-bipartite-matching/
     */
    public static int bipartiteMatching(boolean[][] bpGraph, int[] matchJI) {
    	int M = bpGraph.length;
    	int N = bpGraph[0].length;
    	
    	for (int i = 0; i < N; i++) {
    		matchJI[i] = -1;
    	}
    	
    	int ans = 0;
    	for (int u = 0; u < M; u++) {
    		boolean[] seen = new boolean[N];
    		if (bipartiteMatchingHelper(bpGraph, u, seen, matchJI)) {
    			ans++;
    		}
    	}
    	
    	return ans;
    }
    
    /**
     * Returns the maximum bipartite matching from an an adjacency matrix.
     * Overload of the bipartiteMatching function without output parameters.
     * See here for more info:  http://www.geeksforgeeks.org/maximum-bipartite-matching/
     */
    public static int bipartiteMatching(boolean[][] bpGraph) {
    	int N = bpGraph[0].length;
    	int[] matchJI = new int[N];
    	return bipartiteMatching(bpGraph, matchJI);
    }
    
    /**
     * Overload of the bipartiteMatching function taking an adjacency matrix of int[][] instead of boolean[][].
     */
    public static int bipartiteMatching(int[][] intGraph) {
    	boolean[][] bpGraph = intToBooleanAdjMat(intGraph);
    	return bipartiteMatching(bpGraph);
    }

    /**
     * Overload of the bipartiteMatching function taking an adjacency matrix of int[][] instead of boolean[][].
     * Note:  matchJI (array of length N) is an output variable containing the matchings, such that matchJI[j] = i means that there is a match from i to j.
     */
    public static int bipartiteMatching(int[][] intGraph, int[] matchJI) {
    	boolean[][] bpGraph = intToBooleanAdjMat(intGraph);
    	return bipartiteMatching(bpGraph, matchJI);
    }

    /**
     * Overload of the bipartiteMatching function taking an adjacency matrix of int[][] instead of boolean[][].
     * Note:  matchIJ (array of length M) is an output variable containing the matchings, such that matchIJ[i] = j means that there is a match from i to j.
     * Note:  matchJI (array of length N) is an output variable containing the matchings, such that matchJI[j] = i means that there is a match from i to j.
     */
    public static int bipartiteMatching(int[][] intGraph, int[] matchIJ, int[] matchJI) {
    	boolean[][] bpGraph = intToBooleanAdjMat(intGraph);
    	return bipartiteMatching(bpGraph, matchIJ, matchJI);
    }
    
    /**
     * Converts an integer adjacency matrix of 1's and 0's to a boolean adjacency matrix.
     * Useful with bipartiteMatching, which takes adjancency matrix of boolean[][] as input (instead of int[][]).
     */
    public static boolean[][] intToBooleanAdjMat(int[][] mat) {
    	int M = mat.length;
    	int N = mat[0].length;
    	boolean[][] bMat = new boolean[M][N];
    	for (int i = 0; i < M; i++) {
    		for (int j = 0; j < N; j++) {
    			bMat[i][j] = (mat[i][j] != 0);
    		}
    	}
    	return bMat;
    }

    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
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

        String nextLine() {
            String str = "";
            try { str = br.readLine(); }
            catch (IOException e) { e.printStackTrace(); }
            return str;
        }
    }
}