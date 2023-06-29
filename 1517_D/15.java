import java.util.*;
import java.io.*;
public class EdE {
	static long[] mods = {1000000007, 998244353, 1000000009};
	static long mod = mods[0];
	public static MyScanner sc;
    public static PrintWriter out;
    static long[][][] paths;
    static long[] powers501;
	public static void main(String[] havish) throws Exception{
		// TODO Auto-generated method stub
 		sc = new MyScanner();
 		out = new PrintWriter(System.out);
 		int n = sc.nextInt();
 		int m = sc.nextInt();
 		int k = sc.nextInt();
 		paths = new long[n+1][m+1][4]; //up down left right;
 		powers501 = new long[5];
 		powers501[0] = 1;
 		for(int j = 1;j<5;j++){
 			powers501[j] = 501L*powers501[j-1];
 		}
 		long[][][]dp = new long[n+1][m+1][k/2+2];
 		for(int i = 1;i<=n;i++){
 			for(int j = 1;j<=m-1;j++){
 				int val = sc.nextInt();
 				paths[i][j][3] = val;
 				paths[i][j+1][2] = val;
// 				paths.put(powers501[3]*i + powers501[2]*j + powers501[1]*i + powers501[0]*(j+1), val);
// 				paths.put(powers501[3]*i + powers501[2]*(j+1) + powers501[1]*i + powers501[0]*j, val);
 			}
 		}
 		for(int i = 1;i<=n-1;i++){
 			for(int j = 1;j<=m;j++){
 				int val = sc.nextInt();
// 				paths.put(powers501[3]*(i+1) + powers501[2]*j + powers501[1]*i + powers501[0]*j, val);
// 				paths.put(powers501[3]*i + powers501[2]*j + powers501[1]*(i+1) + powers501[0]*j, val);
 				paths[i][j][1] = val;
 				paths[i+1][j][0] = val;
 				
 			}
 		}
 		for(int j = 1;j<=n;j++){
 			for(int i = 1;i<=m;i++){
 				Arrays.fill(dp[j][i],  Integer.MAX_VALUE);
 				dp[j][i][0] = 0;
 			}
 		}
 		for(int steps = 1;steps<k/2+2;steps++){
 			for(int i = 1;i<=n;i++){
 				for(int j = 1;j<=m;j++){
 					if (i-1 > 0) {
 						dp[i][j][steps] = Math.min(dp[i-1][j][steps-1] + getVal(i, j, i-1, j), dp[i][j][steps]);
 					}
 					if (j-1 > 0) {
 						dp[i][j][steps] = Math.min(dp[i][j-1][steps-1] + getVal(i, j, i, j-1), dp[i][j][steps]);
 					}
 					
 					if (i+1 <= n) {
 						dp[i][j][steps] = Math.min(dp[i+1][j][steps-1] + getVal(i, j, i+1, j), dp[i][j][steps]);
 					}
 					if (j+1 <= m) {
 						dp[i][j][steps] = Math.min(dp[i][j+1][steps-1] + getVal(i, j, i, j+1), dp[i][j][steps]);
 					}
 				}
 			}
 		}
 		if (k%2 == 1){
 			for(int j = 1;j<=n;j++){
 				for(int s = 1;s<=m;s++){
 					out.print(-1 + " ");
 				}
 				out.println();
 			}
 		}
 		else{
 			for(int j = 1;j<=n;j++){
 				for(int s = 1;s<=m;s++){
 					out.print(dp[j][s][k/2]*2L + " ");
 				}
 				out.println();
 			}
 		}
 		
 		
	 		
 		out.close();
 	}
	public static long getVal(int x1, int y1, int x2, int y2) {
		if (x2 == x1+1)
			return paths[x1][y1][1];
		else if (x1 == x2+1)
			return paths[x1][y1][0];
		else if (y2 == y1 + 1)
			return paths[x1][y1][3];
		else
			return paths[x1][y1][2];
	}
	public static void sort(int[] array){
		ArrayList<Integer> copy = new ArrayList<>();
		for (int i : array)
			copy.add(i);
		Collections.sort(copy);
		for(int i = 0;i<array.length;i++)
			array[i] = copy.get(i);
	}
	static String[] readArrayString(int n){
		String[] array = new String[n];
		for(int j =0 ;j<n;j++)
			array[j] = sc.next();
		return array;
	}
	static int[] readArrayInt(int n){
    	int[] array = new int[n];
    	for(int j = 0;j<n;j++)
    		array[j] = sc.nextInt();
    	return array;
    }
	static int[] readArrayInt1(int n){
		int[] array = new int[n+1];
		for(int j = 1;j<=n;j++){
			array[j] = sc.nextInt();
		}
		return array;
	}
	static long[] readArrayLong(int n){
		long[] array = new long[n];
		for(int j =0 ;j<n;j++)
			array[j] = sc.nextLong();
		return array;
	}
	static double[] readArrayDouble(int n){
		double[] array = new double[n];
		for(int j =0 ;j<n;j++)
			array[j] = sc.nextDouble();
		return array;
	}
	static int minIndex(int[] array){
		int minValue = Integer.MAX_VALUE;
		int minIndex = -1;
		for(int j = 0;j<array.length;j++){
			if (array[j] < minValue){
				minValue = array[j];
				minIndex = j;
			}
		}
		return minIndex;
	}
	static int minIndex(long[] array){
		long minValue = Long.MAX_VALUE;
		int minIndex = -1;
		for(int j = 0;j<array.length;j++){
			if (array[j] < minValue){
				minValue = array[j];
				minIndex = j;
			}
		}
		return minIndex;
	}
	static int minIndex(double[] array){
		double minValue = Double.MAX_VALUE;
		int minIndex = -1;
		for(int j = 0;j<array.length;j++){
			if (array[j] < minValue){
				minValue = array[j];
				minIndex = j;
			}
		}
		return minIndex;
	}
	static long power(long x, long y){
		if (y == 0)
			return 1;
		if (y%2 == 1)
			return (x*power(x, y-1))%mod;
		return power((x*x)%mod, y/2)%mod;
	}
	static void verdict(boolean a){
        out.println(a ? "YES" : "NO");
    }
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;
        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } 
                catch (IOException e) {
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
            try{
                str = br.readLine();
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
        
    }	
}

//StringJoiner sj = new StringJoiner(" "); 
//sj.add(strings)
//sj.toString() gives string of those stuff w spaces or whatever that sequence is