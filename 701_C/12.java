/*
 * Code Author: Akshay Miterani
 * DA-IICT
 */
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
 
public class A {
 
	static double eps=(double)1e-15;
	static long mod=(int)1e9+7;
	public static void main(String args[]){
		InputReader in = new InputReader(System.in);
		OutputStream outputStream = System.out;
		PrintWriter out = new PrintWriter(outputStream);
		//----------My Code----------
		int n=in.nextInt();
		int l=0,r=0;
		String s=in.nextLine();
		HashSet<Character> size=new HashSet<>();
		for(int i=0;i<n;i++){
			char p=s.charAt(i);
			size.add(p);
		}
		int chk=size.size();
		HashMap<Character, Integer> hm=new HashMap<>();
		int ans=Integer.MAX_VALUE;
		while(l<n){
			if(hm.size()<chk && r<n){
				char p=s.charAt(r);
				if(hm.containsKey(p)){
					hm.put(p, hm.get(p)+1);
				}
				else{
					hm.put(p, 1);
				}
				r++;
			}
			else{
				char p=s.charAt(l);
				if(hm.get(p)==1){
					hm.remove(p);
				}
				else{
					hm.put(p, hm.get(p)-1);
				}
				l++;
			}
			if(hm.size()==chk){
				ans=Math.min(ans, r-l);
			}
		}
		out.println(ans);
		out.close();
		//---------------The End------------------
 
	}
	static class Pair implements Comparable<Pair> {
		int u;
		int v;
 
		public Pair(int u, int v) {
			this.u = u;
			this.v = v;
		}
 
		public int hashCode() {
			int hu = (int) (u ^ (u >>> 32));
			int hv = (int) (v ^ (v >>> 32));
			return 31 * hu + hv;
		}
 
		public boolean equals(Object o) {
			Pair other = (Pair) o;
			return u == other.u && v == other.v;
		}
 
		public int compareTo(Pair other) {
			return Long.compare(u, other.u) != 0 ? Long.compare(u, other.u) : Long.compare(v, other.v);
		}
 
		public String toString() {
			return "[u=" + u + ", v=" + v + "]";
		}
	}
	public static void debug(Object... o) {
		System.out.println(Arrays.deepToString(o));
	}
	static long modulo(long a,long b,long c) {
		long x=1;
		long y=a;
		while(b > 0){
			if(b%2 == 1){
				x=(x*y)%c;
			}
			y = (y*y)%c; // squaring the base
			b /= 2;
		}
		return  x%c;
	}
	static long gcd(long x, long y)
	{
		if(x==0)
			return y;
		if(y==0)
			return x;
		long r=0, a, b;
		a = (x > y) ? x : y; // a is greater number
		b = (x < y) ? x : y; // b is smaller number
		r = b;
		while(a % b != 0)
		{
			r = a % b;
			a = b;
			b = r;
		}
		return r;
	}
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;
 
		public InputReader(InputStream inputstream) {
			reader = new BufferedReader(new InputStreamReader(inputstream));
			tokenizer = null;
		}
 
		public String nextLine(){
			String fullLine=null;
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					fullLine=reader.readLine();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
				return fullLine;
			}
			return fullLine;
		}
		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}
		public long nextLong() {
			return Long.parseLong(next());
		}
		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
}  
