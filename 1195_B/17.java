import java.io.*; 
import java.util.*; 


public class b{
	
	static class FastReader{ 
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
				catch (IOException e) 
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

	public static void main(String[] args) 
	{ 
        FastReader sc = new FastReader(); 
        //PrintWriter out = new PrintWriter(System.out); 
        double n = (double)sc.nextLong();
        double k = (double)sc.nextLong();
        
        double div = 9+8*n+8*k;
        double ss = Math.sqrt(div);
        //System.out.println(ss);

        ss =  (ss-3)/2;
        System.out.println( (int)(n-ss) );
	}
}
