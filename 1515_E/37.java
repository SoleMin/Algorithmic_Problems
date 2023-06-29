import java.util.*;
import java.io.*;
public class EdA {
	static long[] mods = {1000000007, 998244353, 1000000009};
	static long mod = mods[0];
	public static MyScanner sc;
    public static PrintWriter out;
	public static void main(String[] havish) throws Exception{
		// TODO Auto-generated method stub
 		sc = new MyScanner();
 		out = new PrintWriter(System.out);
		int n = sc.nextInt();
		mod = sc.nextLong();
		long[] fact = new long[401];
		long[] twopowers = new long[401];
		fact[0] = 1;
		twopowers[0] = 1;
		for(int j = 1;j<=400;j++){
			twopowers[j] = twopowers[j-1] * 2L;
			twopowers[j] %= mod;
			fact[j] = fact[j-1] * j;
			fact[j] %= mod;
		}
		long[][] choose = new long[401][401];
		for(int j = 0;j<=400;j++){
			for(int k = 0;k<=j;k++){
				choose[j][k] = fact[j];
				choose[j][k] *= inv(fact[k]);
				choose[j][k] %= mod;
				choose[j][k] *= inv(fact[j-k]);
				choose[j][k] %= mod;
			}
		}
		long[][] dp = new long[n+1][n+1]; //prefix, # of autos
		for(int j = 1;j<=n;j++){
			dp[j][0] = twopowers[j-1];
		}
		for(int k = 0;k<n;k++){  //number of autos
			for(int j = 1;j<=n;j++){ //prefix
				if (k > j)
					continue;
				for(int add = 2; j+add <= n; add++){
					long prod = dp[j][k] * choose[j-k+add-1][add-1];
					prod %= mod;
					prod *= twopowers[add-2];
					
					dp[j+add][k+1] += prod;
					dp[j+add][k+1] %= mod;
				}
			}
		}
		long ans = 0;
		for(int s = 0;s<=n;s++){
			ans+=dp[n][s];
			ans %= mod;
		}
		out.println(ans);
 		out.close();
 		
 	}
	public static long inv(long n){
		return power(n, mod-2);
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