import java.io.*;
import java.util.*;
public class CC {
	public static void main(String[] args)throws Throwable {
		MyScanner sc=new MyScanner();
		PrintWriter pw=new PrintWriter(System.out);
		
		n=sc.nextInt();
		s=new char [n];
		for(int i=0;i<n;i++)
			s[i]=sc.next().charAt(0);
		mem=new int [2*n+1][n+1];
		for(int [] x : mem)
			Arrays.fill(x, -1);
		pw.println(dp(0, 0));
		
		pw.flush();
		pw.close();
	}
	static int n;
	static char [] s;
	static int [][] mem;
	
	static int dp(int i,int j){
		if(i==n)
			return j==0? 1 : 0;
		if(mem[i][j]!=-1)
			return mem[i][j];
		int ans=0;
		if(s[i]=='f'){
			ans+=dp(i+1, j+1);
			ans%=mod;
		}else{
			ans+=dp(i+1, j);
			ans%=mod;
			if(j>0){
				ans+=dp(i, j-1);
				ans%=mod;
			}
		}
		
		return mem[i][j]=ans;
	}
	
	static int mod=(int)(1e9+7);

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