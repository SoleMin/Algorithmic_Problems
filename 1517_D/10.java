import java.io.*;
import java.util.*;
 
import java.math.*;
import java.awt.Point;
 
public class Main {
    static final long MOD = 1000000007L;
    //static final long MOD2 = 1000000009L;
    //static final long MOD = 998244353L;
    //static final long INF = 500000000000L;
    static final int INF =   1000000005;
    static final int NINF = -1000000005;
    //static final long NINF = -1000000000000000000L;
    static FastScanner sc;
    static PrintWriter pw;
    static final int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
 
 
    static final int MO = 1200;
    
    public static void main(String[] args) {
        sc = new FastScanner();
        pw = new PrintWriter(System.out);

        int N = sc.ni();
        int M = sc.ni();
        int K = sc.ni();
        int[][] LR = new int[N][M-1];
        for (int i = 0; i < N; i++) {
            LR[i] = sc.intArray(M-1,0);
        }
        int[][] UD = new int[N-1][M];
        for (int i = 0; i < N-1; i++) {
            UD[i] = sc.intArray(M,0);
        }

        if (K%2==0) {
            int T = K/2;
            int[][] dist = new int[N][M];

            for (int step = 1; step <= T; step++) {
                int[][] newDist = new int[N][M];
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        newDist[i][j] = INF;

                        //up
                        if (i > 0) {
                            newDist[i][j] = Math.min(newDist[i][j],UD[i-1][j]+dist[i-1][j]);
                        }

                        //down
                        if (i < N-1) {
                            newDist[i][j] = Math.min(newDist[i][j],UD[i][j]+dist[i+1][j]);
                        }

                        //left
                        if (j > 0) {
                            newDist[i][j] = Math.min(newDist[i][j],LR[i][j-1]+dist[i][j-1]);
                        }

                        //right
                        if (j < M-1) {
                            newDist[i][j] = Math.min(newDist[i][j],LR[i][j]+dist[i][j+1]);
                        }
                    }
                }
                dist = newDist;
            }
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    pw.print((2*dist[i][j]) + " ");
                }
                pw.println();
            }
        } else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    pw.print("-1 ");
                }
                pw.println();
            }
        }
        pw.close();
    }
 
    public static void sort(int[] arr) {
        Random rgen = new Random();
        for (int i = 0; i < arr.length; i++) {
            int r = rgen.nextInt(arr.length);
            int temp = arr[i];
            arr[i] = arr[r];
            arr[r] = temp;
        }
        Arrays.sort(arr);
    }
 
    public static void sort(long[] arr) {
        Random rgen = new Random();
        for (int i = 0; i < arr.length; i++) {
            int r = rgen.nextInt(arr.length);
            long temp = arr[i];
            arr[i] = arr[r];
            arr[r] = temp;
        }
        Arrays.sort(arr);
    }
 
    //Sort an array (immune to quicksort TLE)
    public static void sort(int[][] arr) {
        Random rgen = new Random();
        for (int i = 0; i < arr.length; i++) {
            int r = rgen.nextInt(arr.length);
            int[] temp = arr[i];
            arr[i] = arr[r];
            arr[r] = temp;
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                int ablock = a[0]/MO;
                int bblock = b[0]/MO;
                if (ablock != bblock)
                    return ablock-bblock;
                else
                    return a[1]-b[1];
            }
        });
    }
    
    public static void sort(long[][] arr) {
        Random rgen = new Random();
        for (int i = 0; i < arr.length; i++) {
            int r = rgen.nextInt(arr.length);
            long[] temp = arr[i];
            arr[i] = arr[r];
            arr[r] = temp;
        }
        Arrays.sort(arr, new Comparator<long[]>() {
            @Override
            public int compare(long[] a, long[] b) {
                if (a[0] > b[0])
                    return 1;
                else if (a[0] < b[0])
                    return -1;
                else
                    return 0;
                //Ascending order.
            }
        });
    }
 
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
 
        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in), 32768);
            st = null;
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
 
        int ni() {
            return Integer.parseInt(next());
        }
 
        int[][] graph(int N, int[][] edges) {
            int[][] graph = new int[N][];
            int[] sz = new int[N];
            for (int[] e: edges) {
                sz[e[0]] += 1;
                sz[e[1]] += 1;
            }
            for (int i = 0; i < N; i++) {
                graph[i] = new int[sz[i]];
            }
            int[] cur = new int[N];
            for (int[] e: edges) {
                graph[e[0]][cur[e[0]]] = e[1];
                graph[e[1]][cur[e[1]]] = e[0];
                cur[e[0]] += 1;
                cur[e[1]] += 1;
            }
            return graph;
        }
 
        int[] intArray(int N, int mod) {
            int[] ret = new int[N];
            for (int i = 0; i < N; i++)
                ret[i] = ni()+mod;
            return ret;
        }
 
        long nl() {
            return Long.parseLong(next());
        }
 
        long[] longArray(int N, long mod) {
            long[] ret = new long[N];
            for (int i = 0; i < N; i++)
                ret[i] = nl()+mod;
            return ret;
        }
 
        double nd() {
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
}