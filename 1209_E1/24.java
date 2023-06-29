import java.io.*; 
import java.math.*;
import java.util.*;
 
public class Main {
	static final long MOD = 998244353;
	//static final long MOD = 1000000007;
	static boolean[] visited;
    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner();
        int Q = sc.nextInt();
        for (int q = 0; q < Q; q++) {
        	int N = sc.nextInt();
        	int M = sc.nextInt();
        	int[][] grid = new int[N][M];
        	int[][] maxes = new int[M][2];
        	for (int i = 0; i < M; i++)
        		maxes[i][1] = i;
        	for (int i = 0; i < N; i++) {
        		for (int j = 0; j < M; j++) {
        			grid[i][j] = sc.nextInt();
        			maxes[j][0] = Math.max(maxes[j][0],grid[i][j]);
        		}
        	}
        	maxes = sort(maxes);
        	int[] keyCols = new int[Math.min(M, N)];
        	for (int i = 0; i < keyCols.length; i++)
        		keyCols[i] = maxes[i][1];
        	
        	int ans = 0;
        	for (int x = 0; x < (int)Math.pow(N,N); x++) {
        		int[] base = baseN(keyCols.length,x);
        		int ansx = 0;
        		for (int i = 0; i < N; i++) {
            		int r = 0;
            		for (int j = 0; j < keyCols.length; j++) {
            			r = Math.max(r,grid[(i+base[j])%N][keyCols[j]]);
            		}
            		ansx += r;
        		}
        		ans = Math.max(ans,ansx);
        	}
        	System.out.println(ans);
        }
    }
    
    public static int[] baseN(int N, int num) {
    	int[] ans = new int[N];
    	for (int i = N-1; i >= 0; i--) {
    		int pow = (int)Math.pow(N,i);
    		ans[i] = num/pow;
    		num -= ans[i]*pow;
    	}
    	return ans;
    }
    
    public static int[][] sort(int[][] array) {
    	//Sort an array (immune to quicksort TLE)
		Random rgen = new Random();
		for (int i = 0; i< array.length; i++) {
		    int randomPosition = rgen.nextInt(array.length);
		    int[] temp = array[i];
		    array[i] = array[randomPosition];
		    array[randomPosition] = temp;
		}
		Arrays.sort(array, new Comparator<int[]>() {
			  @Override
			  public int compare(int[] arr1, int[] arr2) {
				  //Descending order
				  return arr2[0]-arr1[0];
			  }
		});
		return array;
	}
    
    static class FastScanner { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastScanner() { 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next() { 
            while (st == null || !st.hasMoreElements()) { 
                try { 
                    st = new StringTokenizer(br.readLine());
                } catch (IOException  e) { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
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