import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		long n = sc.nextLong();
		Long S = sc.nextLong();
		
		long l = 0;
		long h = n;
		
		long ans = n;
		
		while(l <= h) {
			long mid = (l + h) / 2;
			long t = mid;
			long sum = 0;
			
			while(t > 0) {
				sum += t % 10;
				t /= 10;
			}
			
			if(mid - sum < S) {
				ans = mid;
				l = mid + 1;
			}else
				h = mid - 1;
		}
		
		out.println(n - ans);

		out.flush();
		out.close();
	}



	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream System){br = new BufferedReader(new InputStreamReader(System));}
		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}
		public String nextLine()throws IOException{return br.readLine();}
		public int nextInt() throws IOException {return Integer.parseInt(next());}
		public double nextDouble() throws IOException {return Double.parseDouble(next());}
		public char nextChar()throws IOException{return next().charAt(0);}
		public Long nextLong()throws IOException{return Long.parseLong(next());}
		public boolean ready() throws IOException{return br.ready();}
		public void waitForInput(){for(long i = 0; i < 3e9; i++);}
	}


}