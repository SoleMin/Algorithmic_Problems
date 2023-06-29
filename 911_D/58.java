import java.io.*;
import java.util.*;
public class DD {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int n=sc.nextInt();
		int [] a=new int [n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		int c=0;
		for(int i=0;i<n;i++)
			for(int j=i+1;j<n;j++)
				if(a[i]>a[j])
					c^=1;
		int m=sc.nextInt();
		while(m-->0){
			int l=sc.nextInt()-1;
			int r=sc.nextInt()-1;
			int d=r-l+1;
			d=d*(d-1)/2;
			c^=(d%2);
			pw.println(c==0? "even" : "odd");
		}
		
		pw.flush();
		pw.close();
	}
	
	static class MyScanner {
		BufferedReader br;
		StringTokenizer st;
		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		String next() {while (st == null || !st.hasMoreElements()) {
			try {st = new StringTokenizer(br.readLine());}
			catch (IOException e) {e.printStackTrace();}}
		return st.nextToken();}
		int nextInt() {return Integer.parseInt(next());}
		long nextLong() {return Long.parseLong(next());}
		double nextDouble() {return Double.parseDouble(next());}
		String nextLine(){String str = "";
		try {str = br.readLine();}
		catch (IOException e) {e.printStackTrace();}
		return str;}
	}
}