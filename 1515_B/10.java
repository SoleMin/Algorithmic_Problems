import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;



public class B {
	int mod=1000_000_007;
	public static void main(String[] args) throws Exception {
		
		PrintWriter out=new PrintWriter(System.out);
	    FastScanner fs=new FastScanner();
	    int t=fs.nextInt();
	    while(t-->0) {
	    	double n=fs.nextInt();
	    	if(isp(n/2)||isp(n/4)) {
	    		System.out.println("YES");
	    	}
	    	else System.out.println("NO");
	    }
	}
	static boolean isp(double n) {
		if(n==0) return false;
		double a=Math.ceil(Math.sqrt(n));
		double b=Math.floor(Math.sqrt(n));
		return a==b;
	}
	static void mysort(long[] a) {
		//suffle
		int n=a.length;
		Random r=new Random();
		for (int i=0; i<a.length; i++) {
			int oi=r.nextInt(n);
			long temp=a[i];
			a[i]=a[oi];
			a[oi]=temp;
		}
		
		//then sort
		Arrays.sort(a);
	}
	
	// Use this to input code since it is faster than a Scanner
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
		int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		long nextLong() {
			return Long.parseLong(next());
		}
	}
 
}