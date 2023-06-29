import java.util.*;
import java.io.*;

public class Main{

	static int mod=(int)1e9+7;
	
	public static void main(String[] args) throws IOException {
		PrintWriter out=new PrintWriter(System.out);
		Reader in=new Reader(System.in);	
		int ts=1;
//		ts=in.nextInt();
		outer: while(ts-->0) {
			
			int n=in.nextInt();
			int k=in.nextInt();
			
			int a[]=in.readArray(n);
			Set<Integer> st=new HashSet<>();
			
			for(int i=0; i<n; ++i) {
				st.add(a[i]);
				if(st.size()==k) {
					Set<Integer> stmp=new HashSet<>();
					for(int j=i; j>=0; --j) {
						stmp.add(a[j]);
						if(stmp.size()==k) {
							out.println((j+1)+" "+(i+1));
							continue outer;
						}
					}
				}
			}
			out.println("-1 -1");
			
		}
		out.close();	
	}
	
	static void sort(int [] a) {
		List<Integer> l=new ArrayList<>();
		for(int i: a) l.add(i);
		Collections.sort(l);
		for(int i=0; i<a.length; i++) a[i]=l.get(i);
	}
	
	static class Reader{
		BufferedReader br;
		StringTokenizer to;
		Reader(InputStream stream){
			br=new BufferedReader(new InputStreamReader(stream));
			to=new StringTokenizer("");
		}
		String next() {
			while(!to.hasMoreTokens()) {
				try {
					to=new StringTokenizer(br.readLine());	
				}catch(IOException e) {}
				
			}
			return to.nextToken();
		}
		int nextInt() {
			return Integer.parseInt(next());
		}
		long nextLong() {
			return Long.parseLong(next());
		}
		
		int [] readArray(int n) {
			int a[]=new int[n];
			for(int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
	}	
	
}