import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;



public class Tt {

	public static void main(String[] args) throws IOException {
		FastScanner fs=new FastScanner(System.in);
		int j = fs.nextInt();
		ArrayList<Integer> a =new ArrayList<Integer>();
		for(int i=0;i<j;i++) {
			a.add(fs.nextInt());
		}
		Collections.sort(a);
		Collections.reverse(a);
		int c=0;
		while(a.size()!=0) {
			int f=a.get(a.size()-1);
			c+=1;
			for(int q=a.size()-1;q>-1;q--)
			if(a.get(q)%f==0) {
				a.remove(q);
			}
		}
		System.out.println(c);
		}
	static class FastScanner {
	    BufferedReader br;
	    StringTokenizer st;
	    public FastScanner(InputStream i){
	        br = new BufferedReader(new InputStreamReader(i));
	        st = new StringTokenizer("");
	    }
	    public String next() throws IOException{
	        if(st.hasMoreTokens()) return st.nextToken();
	        else st = new StringTokenizer(br.readLine());
	        return next();
	    }
	    public long nextLong() throws IOException{ return Long.parseLong(next()); }
	    public int nextInt() throws IOException { return Integer.parseInt(next()); }
	    public double nextDouble() throws IOException { return Double.parseDouble(next()); }
	    public String nextLine() throws IOException {
	        if(!st.hasMoreTokens()) 
	            return br.readLine();
	        String ret = st.nextToken();
	        while(st.hasMoreTokens()) 
	            ret += " " + st.nextToken();
	        return ret;
	    }
	}}

