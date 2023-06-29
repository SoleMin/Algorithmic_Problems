import java.util.*;
import java.io.*;
public class EdE {
	static long[] mods = {1000000007, 998244353, 1000000009};
	static long mod = mods[0];
	public static MyScanner sc;
    public static PrintWriter out;
    static ArrayList<Integer> primes;
	public static void main(String[] omkar) throws Exception{
		// TODO Auto-generated method stub
 		sc = new MyScanner();
 		out = new PrintWriter(System.out);
 		int t = sc.nextInt();
 		primes = new ArrayList<>();
 		prime(3165);
 		int[] freq = new int[10000001];
 		while(t--> 0){
 			int n = sc.nextInt();
 			int k = sc.nextInt();
 			int[] arr = readArrayInt(n);
 			for(int j = 0;j<n;j++){
 				arr[j] = factorize(arr[j]);
 			}
 			int[][] left = new int[n][k+1];
 			for(int m = 0;m<=k;m++){
 				int l = 0;
 				int count = 0;
 				for(int i = 0;i<n;i++){
 					if (freq[arr[i]] > 0){
 						count++;
 					}
 					freq[arr[i]]++;
 					while(count > m){
 						freq[arr[l]]--;
 						if (freq[arr[l]] > 0){
 							count--;
 						}
 						l++;
 					}
 					left[i][m] = l;
 				}
 				while(l < n){
 					freq[arr[l]]--;
 					l++;
 				}
 				
 			}
 			long[][] dp = new long[n][k+1];
 			for(int i=0;i<n;i++){
 				Arrays.fill(dp[i],  Integer.MAX_VALUE);
 			}
 			for(int i = 0;i<n;i++){
 				for(int j = 0;j<=k;j++){
 					for(int s = 0;s<=j;s++){
 						if (left[i][s] == 0){
 							dp[i][j] = 1;
 							continue;
 						}
 						dp[i][j] = Math.min(dp[i][j],  dp[left[i][s]-1][j-s]+1);

 					}
 				}
 				
 			}
 			out.println(dp[n-1][k]);
 			
 		}
	 		
 		out.close();
 	}
	static class MS{
//      TreeSet<Long> set;
      HashMap<Long, Integer> map;
      public MS() {
//          set = new TreeSet<Long>();
          map = new HashMap<Long, Integer>();
      }
      public void add(long x) {
          if(map.containsKey(x)){
              map.put(x, map.get(x)+1);
          }
          else{
              map.put(x, 1);
//              set.add(x);
          }
      }
      public void remove(long x) {
          if(!map.containsKey(x))
              return;
          if(map.get(x)==1){
              map.remove(x);
//              set.remove(x);
          }
          else 
              map.put(x, map.get(x)-1);
      }
//      public long getFirst() {
//          return set.first();
//      }
//      public long getLast() {
//          return set.last();
//      }
      public int size() {
          return map.keySet().size();
      }
      public void removeAll(int x) {
          map.remove(x);
      }
      public int getFreq(long x){
      	if (map.containsKey(x))
      		return map.get(x);
      	return 0;
      }
  }
	public static void prime(int n){
		int[] isPrime = new int[n+1];
		Arrays.fill(isPrime, 1);
		for(long i = 2;i<=n;i++){
			if (isPrime[(int)i] == 1){
				for(long j = i*i;j<=n;j+=i){
					isPrime[(int)j] = 0;
				}
			}
		}
		for(int j = 3;j<=n;j++){
			if (isPrime[j] == 1){
				primes.add(j);
			}
		}
	}
	public static int factorize(long n) { 
	 	
	 	long prod = 1;
        int count = 0; 
        while (n%2 == 0){
            n >>= 1; 
            count++; 
        } 
        if (count > 0 && count%2 == 1)
            prod *= 2L;
        for (long i : primes) { 
        	if (i*i > n)
        		break;
            count = 0; 
            while (n % i == 0) { 
                count++; 
                n = n / i; 
            } 
            if (count > 0 && count%2 == 1)
                prod *= i;
        }  
        if (n > 2)
        	prod *= n;
        return (int)prod;
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