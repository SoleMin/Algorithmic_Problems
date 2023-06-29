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
	
	static FastScanner fs = new FastScanner();
	static PrintWriter out = new PrintWriter(System.out);
	static int n, d;
	
	
    public static void main(String[] args) throws IOException {
    	
		
//    	FastScanner fs = new FastScanner();
//    	PrintWriter out = new PrintWriter(System.out);
    		
    	int tt = 1;
    	while(tt-->0) {
    		
    	
    		n = fs.nextInt();
    		int l = 1, r = 1 + n/2;
    		
    		d = getB(l);
    		if(d%2!=0) {
    			out.println("! -1");
    			out.flush();
    			return;
    		}
    		
    		if(d==0) {
    			out.println("! 1");
    			out.flush();
    			return;
    		}
    		
    		
    		
    		
    		
    		
    		
    		while(l<r) {
    			int mid = (l+r)/2;
    			if(check(mid)) {
    				l = mid + 1;
    			}
    			else {
    				r = mid;
    			}
    			int f = 1;
    		}
    		
    		
    		out.println("! "+l);
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    	}
    	
    	out.close();
    		
    }
    
    
    static boolean check(int i) {
    	int k = getB(i);
    	if(sig(d)==sig(k)) {
    		return true;
    	}
    	return false;
    }
    
    
    static int getB(int i) {
    	out.println("? "+i);
    	out.flush();
    	int x1 = fs.nextInt();
    	int j = i + n/2;
    	if(j>n) j -= n;
    	out.println("? "+j);
    	out.flush();
    	int x2 = fs.nextInt();
    	return x1 - x2;
    }
    
    
    static int sig(int x) {
    	if(x>0) return 1;
    	else if(x<0) return -1;
    	return 0;
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
