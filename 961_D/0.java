import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.StringTokenizer;

public class Solution{
	
	
	static int n;
	static Point[] pt;
	static boolean[] used;
	
	
    public static void main(String[] args) throws IOException {
    	
		
    	FastScanner fs = new FastScanner();
    	PrintWriter out = new PrintWriter(System.out);
    		
    	int tt = 1;
    	while(tt-->0) {
    		
    		n = fs.nextInt();
    		
    		pt = new Point[n];
    		for(int i=0;i<n;i++) {
    			pt[i] = new Point(fs.nextLong(), fs.nextLong());
    		}
    		used = new boolean[n];
    		
    		if(n<=2) {
    			out.println("YES");
    			out.flush();
    			return;
    		}
    		
    		if(check(pt[0], pt[1]) || check(pt[0], pt[2]) || check(pt[1], pt[2])) {
    			out.println("YES");
    		}
    		else {
    			out.println("NO");
    		}
    		
    		
    		
    		
    		
    		
    		
    		
    	}
    	
    	out.close();
    		
    }
    
    
    static boolean check(Point p1, Point p2) {
    	Arrays.fill(used, false);
    	for(int i=0;i<n;i++) {
    		if(new Vector(p1.x-p2.x, p1.y-p2.y).cross(new Vector(p1.x-pt[i].x, p1.y-pt[i].y))==0) {
    			used[i] = true;
    		}
    	}
    	return check2();
    }
    
    
    static boolean check2() {
    	Point p1=null, p2 = null;
    	for(int i=0;i<n;i++) {
    		if(used[i]) continue;
    		if(p1==null) p1 = pt[i];
    		else if(p2==null) p2 = pt[i];
    	}
    	
    	if(p2==null) return true;
    	
    	for(int i=0;i<n;i++) {
    		if(used[i]) continue;
    		if(new Vector(p1.x-p2.x, p1.y-p2.y).cross(new Vector(p1.x-pt[i].x, p1.y-pt[i].y))!=0) return false;
    	}
    	return true;
    }
    
    
    
    static class Point{
    	long x,y;
    	
    	Point(long x,long y){
    		this.x = x;
    		this.y = y;
    	}
    	
    }
    
    
    static class Vector{
    	long x,y;
    	
    	Vector(long x,long y){
    		this.x = x;
    		this.y = y;
    	}
    	
    	long cross(Vector v) {
    		return this.x*v.y - this.y*v.x;
    	}
    	
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
