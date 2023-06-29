import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

@SuppressWarnings("unused")
public class Solution{
	
	static long inf = (long)1e18+100;
	static final long mod = (long)1e9+7;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		FastScanner fs = new FastScanner();
    	PrintWriter out = new PrintWriter(System.out);
    	
    	int tt = 1;
    	outer:
    	while(tt-->0) {
    		
    		int n = fs.nextInt(), T = fs.nextInt();
    		int[] t = new int[n], g = new int[n];
    		
    		for(int i=0;i<n;i++) {
    			t[i] = fs.nextInt(); g[i] = fs.nextInt();
    		}
    		
    		//dp[mask][pre] -- number of ways to order mask songs last song has prev genre
    		long[][] dp = new long[1<<n][4];
    		dp[0][0] = 1;
    		
    		long ans = 0;
    		
    		for(int mask=0;mask<(1<<n);mask++) {
    			for(int pre=0;pre<=3;pre++) {
    				for(int i=0;i<n;i++)
    					if((mask&(1<<i))==0 && g[i]!=pre) 
    						dp[mask^(1<<i)][g[i]] = add(dp[mask^(1<<i)][g[i]], dp[mask][pre]);
    				int sum = 0;
    				for(int i=0;i<n;i++) {
    					if((mask&(1<<i))!=0) sum += t[i];
    				}
    				if(sum==T) ans = add(ans, dp[mask][pre]);
    			}
    		}
    		
    		out.println(ans);
    		
    		
    		
    		
    		
    		
    	}
    	
    	out.close();
    }
	
	static long add(long a, long b) {
		a += b;
		if(a>mod) return a - mod;
		return a;
	}
	
	
    static final Random random=new Random();
    
    static <T> void shuffle(T[] arr) {
    	int n = arr.length;
    	for(int i=0;i<n;i++	) {
    		int k = random.nextInt(n);
    		T temp = arr[k]; arr[k] = arr[i]; arr[i] = temp;
    	}
    }
    
    	
    static void ruffleSort(int[] a) {
    	int n=a.length;//shuffle, then sort 
    	for (int i=0; i<n; i++) {
    		int oi=random.nextInt(n); int temp=a[oi];
    		a[oi]=a[i]; a[i]=temp;
    	}
    	Arrays.sort(a);
    }
    
    static void ruffleSort(long[] a) {
    	int n=a.length;//shuffle, then sort 
    	for (int i=0; i<n; i++) {
    		int oi=random.nextInt(n); long temp=a[oi];
    		a[oi]=a[i]; a[i]=temp;
    	}
    	Arrays.sort(a);
    }
   
  
    
    static void reverse(int[] arr, int l, int r) {
    	for(int i=l;i<l+(r-l)/2;i++){
    		int temp = arr[i]; arr[i] = arr[r-i+l-1]; arr[r-i+l-1] = temp;
    	}
    }
    
    static void reverse(long[] arr, int l, int r) {
    	for(int i=l;i<l+(r-l)/2;i++){
    		long temp = arr[i]; arr[i] = arr[r-i+l-1]; arr[r-i+l-1] = temp;
    	}
    }
    
    
    static <T> void reverse(T[] arr, int l, int r) {
    	for(int i=l;i<l+(r-l)/2;i++) {
    		T temp = arr[i]; arr[i] = arr[r-i+l-1]; arr[r-i+l-1] = temp;
    	}
    }
    	
    	
    static class FastScanner{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer("");
     
    	public String next(){
    		while(!st.hasMoreElements()){
    			try{
    				st = new StringTokenizer(br.readLine());
    			} catch(IOException e){
    				e.printStackTrace();
    			}
    		}
    		return st.nextToken();
    	}
    		
    	public String nextLine() throws IOException {
    		return br.readLine();
    	}
    		
    	public int nextInt(){
    		return Integer.parseInt(next());
    	}
     
    	public int[] readArray(int n){
    		int[] a = new int[n];
    		for(int i=0;i<n;i++)
    			a[i] = nextInt();
    		return a;
    	}
    		
    	public long nextLong() {
    		return Long.parseLong(next());
    	}
    		
    	public char nextChar() {
    		return next().toCharArray()[0];
    	}
    }


   	
}
