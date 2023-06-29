import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DigitSeq {

	static class FastReader { 
		BufferedReader br; 
		StringTokenizer st; 

		public FastReader() 
		{ 
			br = new BufferedReader(new
					InputStreamReader(System.in)); 
		} 

		String next() 
		{ 
			while (st == null || !st.hasMoreElements()) 
			{ 
				try
				{ 
					st = new StringTokenizer(br.readLine()); 
				} 
				catch (IOException  e) 
				{ 
					e.printStackTrace(); 
				} 
			} 
			return st.nextToken(); 
		} 

		int nextInt() 
		{ 
			return Integer.parseInt(next()); 
		} 

		long nextLong() 
		{ 
			return Long.parseLong(next()); 
		} 

		double nextDouble() 
		{ 
			return Double.parseDouble(next()); 
		} 

		String nextLine() 
		{ 
			String str = ""; 
			try
			{ 
				str = br.readLine(); 
			} 
			catch (IOException e) 
			{ 
				e.printStackTrace(); 
			} 
			return str; 
		} 
	}

	public static void main(String[] args) {

		FastReader sc = new FastReader();
		OutputStream outputstream = System.out;
		PrintWriter out = new PrintWriter(outputstream);

		long n = sc.nextLong();
		long[] arr = new long[14];
		for(int i = 1; i <= 13; i++){
			arr[i] = (long)Math.pow(10, i)-(long)Math.pow(10, i-1);
		}
		long total = 0;
		for(int i = 1; i <= 13; i++){
			if(total+(long)i*arr[i]>=n){
				long ans = n-total;
				long rest = ans;
				if(ans%i!=0){
					ans /= i;
					ans++;
				} else {
					ans /= i;
				}
				ans += (long)Math.pow(10, i-1)-1;
				String str = Long.toString(ans);
				int ind = (rest%i==0) ? i-1 : (int)(rest%i)-1;
				out.println(str.charAt(ind));
				break;
			}
			total = total+(long)i*arr[i];
		}
		out.close();
	}

}