import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.StringTokenizer;

public class Solution{
	
	static final int mod = 998244353;
	
	
	
    public static void main(String[] args) throws IOException {
    	
		
    	FastScanner fs = new FastScanner();
    	PrintWriter out = new PrintWriter(System.out);
    		
    	int tt = 1;
    	while(tt-->0) {
    		
    		int n = fs.nextInt();
    		int[] a = fs.readArray(n);
    		
    		int[] p = new int[n+1];
    		p[0] = 1;
    		for(int i=1;i<=n;i++) p[i] = mul(p[i-1], 2);
    		
    		
    		int cur = mul(a[0], p[n-1]);
    		int ans = cur;
    		
    		
    		for(int i=0;i<n-1;i++) {
    			cur = sub(cur, mul(a[i], p[n-i-2]));
    			cur = add(cur, mul(a[i+1], p[n-i-2]));
    			ans = add(ans, cur);
    		}
    		
    		out.println(ans);
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    	}
    	
    	out.close();
    		
    }
    
    
    
    static int add(int a, int b) {
    	a += b;
    	if(a>=mod) return a-mod;
    	return a;
    }
    
    
    static int sub(int a, int b) {
    	a -= b;
    	if(a<0) return a + mod;
    	return a;
    }
    
   
    static int mul(int a,int b) {
    	return (int)(((long)a*b)%mod);
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
