import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class DD {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		int n=sc.nextInt();
		int [] a=new int [n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		
		TreeMap<Integer, Integer> map=new TreeMap<Integer, Integer>();
		BigInteger ans=new BigInteger("0");
		long sum=0;
		for(int i=0;i<n;i++){
			sum+=a[i];
			map.put(a[i], map.getOrDefault(a[i], 0)+1);
			int cntSame=map.get(a[i]);
			int cntLess=map.getOrDefault(a[i]-1, 0);
			int cntMore=map.getOrDefault(a[i]+1, 0);
			long sum2=sum;
			sum2-=1L*cntSame*a[i];
			sum2-=1L*cntLess*(a[i]-1);
			sum2-=1L*cntMore*(a[i]+1);
			int cnt=i+1-(cntSame+cntLess+cntMore);
			ans = ans.subtract(BigInteger.valueOf(sum2));
			ans= ans.add(BigInteger.valueOf(1L*cnt*a[i]));
			
		}
		pw.println(ans);
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