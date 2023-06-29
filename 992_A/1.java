import java.util.*;
import java.io.*;
public class A{
	public static void main(String[] args)
	{
		FastScanner fs = new FastScanner();
		int n = fs.nextInt();
		int[] arr = fs.readArray(n);
		Set<Integer> s = new HashSet();
		for(int i:arr)
		{
			if(i!=0)s.add(i);
		}
		System.out.println(s.size());
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


