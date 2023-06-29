import java.io.*;
import java.util.*;
public class Main { 
	
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int n=sc.nextInt(),x=sc.nextInt();
		int a[]=sc.readArray(n);
		boolean flag=false;
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0 ; i<n ; i++) {
			if(map.containsKey(a[i])) {
				flag=true;
			}
			map.put(a[i],1);
		}
		if(flag==true) {
			out.println(0);
		}
		else {
			HashSet<Integer> set = new HashSet<>();
			for(int i=0 ; i<n ; i++) {
				if(map.containsKey(a[i]&x) && (a[i]&x)!=a[i]) {
					flag=true;break;
				}
				set.add(a[i]&x);
			}
			if(flag==true) {
				out.println(1);
			}
			else {
				if(set.size()<n) {
					out.println(2);
				}
				else {
					out.println(-1);
				}
			}
		}
		out.flush();
		out.close();
	}
	static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		int [] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		long nextLong() {
			return Long.parseLong(next());
		}
		double nextDouble() {
			return Double.parseDouble(next());
		}
	}
} 

