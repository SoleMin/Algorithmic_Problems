import java.util.*;
import java.io.*;
public class EdA {
	static long[] mods = {1000000007, 998244353, 1000000009};
	static long mod = mods[0];
	public static MyScanner sc;
    public static PrintWriter out;

	public static void main(String[] omkar) throws Exception{
		// TODO Auto-generated method stub
 		sc = new MyScanner();
 		out = new PrintWriter(System.out);
 		
	 	int n = sc.nextInt();
	 	int m = sc.nextInt();
	 	int[][]cnt = new int[m][m];
	 	String s = sc.next();
	 	for(int j =0;j<n-1;j++){
	 		if (s.charAt(j) != s.charAt(j+1)){
	 		cnt[s.charAt(j)-'a'][s.charAt(j+1)-'a']++;
	 		cnt[s.charAt(j+1)-'a'][s.charAt(j)-'a']++;
	 		}
	 	}
	 	int[] st = new int[m+1];
	 	for(int j = 0;j<=m;j++){
	 		st[j] = (1<<j);
	 	}
	 	int[][] arr = new int[m][1<<m];
	 	for(int j = 0;j<m;j++){
	 		for(int k = 1;k<(1<<m);k++){
	 			int z = Integer.lowestOneBit(k);
	 			int count = 0;
	 			while(z!=0 && z%2==0){
	 				z/=2;
	 				count++;
	 			}
	 			arr[j][k] = arr[j][k^(Integer.lowestOneBit(k))] + cnt[j][count];
	 		}
	 	}
	 	int[] dp = new int[1<<m];
	 	Arrays.fill(dp,  Integer.MAX_VALUE);
	 	dp[0] = 0;
	 	for(int j = 1;j<st[m];j++){
	 		
	 		for(int k = 0;k<m;k++){
	 			int y = st[k];
	 			if ((y&j) != 0){
	 				int sum = 2*arr[k][j] - arr[k][(1<<m)-1];
//	 				for(int t = 0;t<m;t++){
//	 					if (t!= k){
//		 					if ((st[t]&j) != 0)
//		 						sum+=cnt[t][k];
//		 					else
//		 						sum-=cnt[t][k];
//	 					}
//	 				}
	 				dp[j] = Math.min(dp[j],  dp[y^j]+sum*Integer.bitCount(j));
	 			}
	 		}
	 	}
	 	out.println(dp[(1<<m)-1]);
 		out.close();	
 	}
	public static void sort(int[] array){
		ArrayList<Integer> copy = new ArrayList<Integer>();
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