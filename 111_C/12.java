import java.lang.*;
import java.math.BigInteger;
import java.io.*;
import java.util.*;

public class Solution implements Runnable{
    public static BufferedReader br;
    public static PrintWriter out;
    public static StringTokenizer stk;
    public static boolean isStream = true;

    public static void main(String[] args) throws IOException {
    	if (isStream) {
            br = new BufferedReader(new InputStreamReader(System.in));
        } else {
            br = new BufferedReader(new FileReader("in.txt"));
        }
        out = new PrintWriter(System.out);
        new Thread(new Solution()).start();
    }

    public void loadLine() {
        try {
            stk = new StringTokenizer(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String nextLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public String nextWord() {
        while (stk==null||!stk.hasMoreTokens()) loadLine();
        return stk.nextToken();
    }

    public Integer nextInt() {
        while (stk==null||!stk.hasMoreTokens()) loadLine();
        return Integer.valueOf(stk.nextToken());
    }

    public Long nextLong() {
        while (stk==null||!stk.hasMoreTokens()) loadLine();
        return Long.valueOf(stk.nextToken());
    }

    public Double nextDouble() {
        while (stk==null||!stk.hasMoreTokens()) loadLine();
        return Double.valueOf(stk.nextToken());
    }
    
    public Float nextFloat() {
        while (stk==null||!stk.hasMoreTokens()) loadLine();
        return Float.valueOf(stk.nextToken());
    }
    
    public void run() {
    	int n = nextInt();
    	int m = nextInt();
    	if (n > m) {
    		int sw = n;
    		n = m;
    		m = sw;
    	}
    	int[][] A = new int[1<<n][1<<n];
    	for (int m1 = 0; m1 < 1<<n; ++m1) { // Who goes out
    		for (int m2 = 0; m2 < 1<<n; ++m2) {  // Who comes
    			int[] arr = new int[n]; // Who remains
    			for (int i = 0; i < n; ++i) {
    				arr[i] = (~(m1>>i))&1; 
    			}
    			int[] m2a = new int[n];
    			for (int i = 0; i < n; ++i) {
    				m2a[i] = (m2>>i)&1; 
    			}
    			int cnt = 0;
    			for (int i = 0; i < n; ++i) {
    				if (arr[i] == 1) {
    					if (i > 0 && m2a[i-1] == 1) {
    						continue;
    					}
    					if (i < n-1 && m2a[i+1] == 1) {
    						continue;
    					}
    					if (m2a[i] == 1) {
    						continue;
    					}
    					if (i < n-1) {
    						m2a[i+1] = 1;
    					} else {
    						m2a[i] = 1;
    					}
    				}
    			}
    			for (int i = 0; i < n; ++i) {
    				if (m2a[i] == 1) {
    					cnt++;
    				}
    			}
    			A[m1][m2] = cnt;
    		}
    	}
    	int MAX = 10000;
    	int[][][] dp = new int[m+1][1<<n][1<<n];
    	for (int i = 0; i < m+1; i++) {
    		for (int m1 = 0; m1 < 1<<n; ++m1) {
    			Arrays.fill(dp[i][m1], MAX);
    		}
    	}
    	
		dp[0][0][0] = 0;
    	
    	for (int i = 0; i < m; i++) {
    		for (int m1 = 0; m1 < 1<<n; ++m1) {
    			for (int m2 = 0; m2 < 1<<n; ++m2) {
    				if (dp[i][m1][m2] != MAX) {
	    				for (int nm1 = 0; nm1 < 1<<n; ++nm1) {
	    	    			for (int nm2 = 0; nm2 < 1<<n; ++nm2) {
	    	        			if ((m1 & nm1) == 0) {
	    	        				int sm1 = m1|nm1;
	    	        				int sm2 = m2|nm2;
	    	        				int cnt = A[sm1][sm2];
	    	        				dp[i+1][nm2][nm1] = Math.min(dp[i+1][nm2][nm1], dp[i][m1][m2]+cnt);
	    	        			}
	    	        		}
	    	    		}
    				}
        		}
    		}
    	}
    	
    	out.println(n*m-dp[m][0][0]);
    	out.flush();
    }
}
