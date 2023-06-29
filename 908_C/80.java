import java.io.*;
import java.util.*;
public class CC {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int n=sc.nextInt();
		int r=sc.nextInt();
		int [] x=new int [n];
		for(int i=0;i<n;i++)
			x[i]=sc.nextInt();
		double [] ans=new double [n];
		ans[0]=r;
		for(int i=1;i<n;i++){
			ans[i]=r;
			for(int j=0;j<i;j++){
				double dx=Math.abs(x[i]-x[j]);
				if(dx>2*r)
					continue;
				double y=Math.sqrt((4*r*r)-(dx*dx));
				ans[i]=Math.max(ans[i], ans[j]+y);
			}
		}
		
		
		for(double z : ans)
			pw.print(z+" ");
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