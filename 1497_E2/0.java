import java.io.*;
import java.util.*;
 
import java.math.*;
import java.awt.Point;
 
public class CFTemplate {
    static final long MOD = 1000000007L;
    //static final long MOD2 = 1000000009L;
    //static final long MOD = 998244353L;
    //static final long INF = 500000000000L;
    static final int INF = 1100000000;
    static final int NINF = -100000;
    static FastScanner sc;
    static PrintWriter pw;
    static final int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

    public static void main(String[] args) {
        sc = new FastScanner();
        pw = new PrintWriter(System.out);
        
        ArrayList<Integer> primes = new ArrayList<Integer>();
        for (int i = 2; i <= 3200; i++) {
            boolean p = true;
            for (int j = 2; j*j <= i; j++) {
                if (i%j==0) {
                    p = false;
                    break;
                }
            }
            if (p) primes.add(i);
        }
        int Q = sc.ni();
        for (int q = 0; q < Q; q++) {
            int N = sc.ni();
            int K = sc.ni();
            int[] nums = new int[N+1];
            for (int i = 1; i <= N; i++) nums[i] = sc.ni();
            for (int i = 1; i <= N; i++) {
                for (int p: primes) {
                    int c = 0;
                    while (nums[i] % p == 0) {
                        nums[i] /= p;
                        c++;
                    }
                    if (c%2==1) nums[i] *= p;
                }
            }

            TreeSet<Integer> ts = new TreeSet<Integer>();
            HashMap<Integer,Integer> last = new HashMap<Integer,Integer>();

            int[][] dp = new int[N+1][K+1];
            for (int i = 1; i <= N; i++) {
                if (last.containsKey(nums[i])) {
                    ts.add(last.get(nums[i]));
                }
                last.put(nums[i],i);
                int[] inds = new int[K+1];
                int ind = 0;
                for (int x: ts.descendingSet()) {
                    inds[ind] = x;
                    if (ind==K) break;
                    ind++;
                }
                for (int j = 0; j <= K; j++) {
                    dp[i][j] = INF;
                    if (j > 0) dp[i][j] = dp[i][j-1];
                    for (int k = 0; k <= j; k++) {
                        dp[i][j] = Math.min(dp[i][j],dp[inds[k]][j-k]+1);
                    }
                }
            }
            pw.println(dp[N][K]);
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
                return a[1]-b[1];
                //Ascending order.
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