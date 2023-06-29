import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

@SuppressWarnings("unused")
public class C{
	
	static long inf = (long)1e15;
	
    public static void main(String[] args) throws IOException {
    	
		
    	FastScanner fs = new FastScanner();
    	PrintWriter out = new PrintWriter(System.out);
  		
    	int tt = fs.nextInt();
    	outer:
    	while(tt-->0) {
    		
    		int n = fs.nextInt();
    		int[] a = fs.readArray(n);
    		
    		ArrayList<Integer>[] l = new ArrayList[n];
    		for(int i=0;i<n;i++) l[i] = new ArrayList<Integer>();
    		
    		l[0].add(1);
    		
    		for(int i=1;i<n;i++) {
    			if(a[i]==1) {
    				for(int j=0;j<l[i-1].size();j++) l[i].add(l[i-1].get(j));
    				l[i].add(1);
    			}
    			else {
    				int ind = -1;
    				for(int j=l[i-1].size()-1;j>=0;j--) {
    					if(l[i-1].get(j)+1==a[i]) {
    						ind = j; break;
    					}
    				}
    				for(int j=0;j<ind;j++) l[i].add(l[i-1].get(j));
    				l[i].add(a[i]);
    			}
    		}
    		
    		for(int i=0;i<n;i++) {
    			out.print(l[i].get(0));
    			for(int j=1;j<l[i].size();j++) out.print("."+l[i].get(j));
    			out.println();
    		}
    		
    		
    		
    		
    	}
    	
    	out.close();
    		
    	
    	
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
    	
    	public double nextDouble() {
    		return Double.parseDouble(next());
    	}
    		
    	public char nextChar() {
    		return next().toCharArray()[0];
    	}
    	
    	
    }
   	
}
