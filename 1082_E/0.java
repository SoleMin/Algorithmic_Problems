import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class Solution{
	
	static final int N = (int)5e5+10;
	static int[] cnt;
	static ArrayList<Integer>[] seg;
	static int[] last;
	
	
    public static void main(String[] args) throws IOException {
    	
		
    	FastScanner fs = new FastScanner();
    	PrintWriter out = new PrintWriter(System.out);
    	
    	
    		
    	int tt = 1;
    	while(tt-->0) {
    		
    		int n = fs.nextInt(), c = fs.nextInt();
    		
    		cnt = new int[N];
    		
    		seg = new ArrayList[N];
    		for(int i=0;i<N;i++) seg[i] = new ArrayList<Integer>();
    		
    		last = new int[N]; Arrays.fill(last, -1);
    		
    		int[] a = new int[n];
    		
    		for(int i=0;i<n;i++) {
    			a[i] = fs.nextInt();
    			cnt[i+1] = cnt[i] + ((a[i]==c)?1:0);
    		}
    		
    		
    		for(int i=0;i<n;i++) {
    			seg[a[i]].add(-getCnt(last[a[i]]+1, i-1));
    			last[a[i]] = i;
    			seg[a[i]].add(1);
    		}
    		
    		
    		int ans = 0;
    		
    		for(int i=0;i<N;i++) {
    			if(i==c) continue;
    			if(seg[i].isEmpty()) continue;
    			ans = Math.max(ans, maxSeg(seg[i]));
    		}
    		
    		out.println(getCnt(0, n-1) + ans);
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    	}
    	
    	out.close();
    		
    }
    

    static int getCnt(int l, int r) {
    	return cnt[r+1]-cnt[l];
    }
    
    
    static int maxSeg(ArrayList<Integer> l) {
    	int max = 0;
    	int cur = 0;
    	for(int a: l) {
    		cur = Math.max(0, cur + a);
    		max = Math.max(max, cur);
    	}
    	return max;
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
