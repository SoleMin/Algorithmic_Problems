//>>>BaZ<<<//
import java.util.*;
import java.io.*;
import static java.lang.Math.*;
public class Main
{  
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,1,-1};
    static long MOD = 1000000007;
    static int INF = Integer.MAX_VALUE/10;
    static PrintWriter pw;
    static InputReader scan;
    //static MyFileReader1 ss;
    //static MyFileReader scan;
    static int ni() throws IOException{return scan.nextInt();}
    static long nl() throws IOException{return scan.nextLong();}
    static double nd() throws IOException{return scan.nextDouble();}
    static String ne() throws IOException{return scan.next();}
    static void pl() throws IOException {pw.println();}
    static void pl(Object o) throws IOException {pw.println(o);}
    static void p(Object o) throws IOException {pw.print(o+" ");}
    static void psb(StringBuilder sb) throws IOException {pw.print(sb);}
    public static void main(String[] args) {
        new Thread(null,null,"BaZ",99999999)
        {
            public void run()
            {
                try
                {
                    solve();
                }
                catch(Exception e)
                {  
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }.start();
    }
    static void solve() throws IOException
    {  
        Calendar CAL1 = Calendar.getInstance();
        CAL1.setTime(new Date());
        scan = new InputReader(System.in);
        pw = new PrintWriter(System.out,true);
        //pw = new PrintWriter(new File("C://Users/Aman deep/Desktop/output.txt"));  
        //ss = new MyFileReader1();
        //scan = new MyFileReader();
        StringBuilder sb = new StringBuilder();
        int n = ni();
        double r = ni();
        double x[] = new double[n];
        for(int i=0;i<n;++i)
            x[i] = nd();
        double y[] = new double[n];
        y[0] = r;
        for(int i=1;i<n;++i)
        {  
            double max = -1;
            for(int j=0;j<i;++j)
            {
                double xx = 4*r*r-(x[i]-x[j])*(x[i]-x[j]);
                if(xx>=0)
                    max = max(max,sqrt(xx)+y[j]);
            }
            if(max==-1)
                max = r;
            y[i] = max;
        }
        for(int i=0;i<n;++i)
            p(y[i]);
        pl();
        Calendar CAL2 = Calendar.getInstance();
        CAL2.setTime(new Date());
        double Execution_Time = (double)(CAL2.getTimeInMillis()-CAL1.getTimeInMillis())/1000.000;
        //System.out.println("Execution time : "+Execution_Time+" seconds");
        pw.flush();
        pw.close();
    }
    static class InputReader     //NoSuchElementException -> EOF
	{
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;
		
		public InputReader(InputStream stream)
		{
			this.stream = stream;
		}
		
		public int read()
		{
			if (numChars==-1) 
				throw new InputMismatchException();
			
			if (curChar >= numChars)
			{
				curChar = 0;
				try 
				{
					numChars = stream.read(buf);
				}
				catch (IOException e)
				{
					throw new InputMismatchException();
				}
				
				if(numChars <= 0)				
					return -1;
			}
			return buf[curChar++];
		}
	 
		public String nextLine()
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
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
		public int nextInt()
		{
			int c = read();
			
			while(isSpaceChar(c)) 
				c = read();
			
			int sgn = 1;
			
			if (c == '-') 
			{
				sgn = -1;
				c = read();
			}
			
			int res = 0;
			do 
			{
				if(c<'0'||c>'9') 
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			}
			while (!isSpaceChar(c)); 
			
			return res * sgn;
		}
		
		public long nextLong() 
		{
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') 
			{
				sgn = -1;
				c = read();
			}
			long res = 0;
			
			do 
			{
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			}
			while (!isSpaceChar(c));
				return res * sgn;
		}
		
		public double nextDouble() 
		{
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') 
			{
				sgn = -1;
				c = read();
			}
			double res = 0;
			while (!isSpaceChar(c) && c != '.') 
			{
				if (c == 'e' || c == 'E')
					return res * Math.pow(10, nextInt());
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			}
			if (c == '.') 
			{
				c = read();
				double m = 1;
				while (!isSpaceChar(c)) 
				{
					if (c == 'e' || c == 'E')
						return res * Math.pow(10, nextInt());
					if (c < '0' || c > '9')
						throw new InputMismatchException();
					m /= 10;
					res += (c - '0') * m;
					c = read();
				}
			}
			return res * sgn;
		}
		
		public String readString() 
		{
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do 
			{
				res.appendCodePoint(c);
				c = read();
			} 
			while (!isSpaceChar(c));
			
			return res.toString();
		}
	 
		public boolean isSpaceChar(int c) 
		{
			if (filter != null)
				return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
	 
		public String next() 
		{
			return readString();
		}
		
		public interface SpaceCharFilter 
		{
			public boolean isSpaceChar(int ch);
		}
	}
    static class MyFileReader                                          //File input template
    {
        StringTokenizer st;
        BufferedReader br;
        MyFileReader() throws IOException
        {
            br = new BufferedReader(new FileReader("C://Users/Aman deep/Desktop/input.txt"));
        }
        String nextLine() throws IOException
        {
            return br.readLine();
        }
        String next() throws IOException
        {
            if(st==null || !st.hasMoreTokens())
                st = new StringTokenizer(nextLine());
            return st.nextToken();
        }
        int nextInt() throws IOException
        {
            return Integer.parseInt(next());
        }
        long nextLong() throws IOException
        {
            return Long.parseLong(next());
        }
        double nextDouble() throws IOException
        {
            return Double.parseDouble(next());
        }
    }
    static class MyFileReader1                                          //File input template
    {
        StringTokenizer st;
        BufferedReader br;
        MyFileReader1() throws IOException
        {
            br = new BufferedReader(new FileReader("C://Users/Aman deep/Desktop/output.txt"));
        }
        String nextLine() throws IOException
        {
            return br.readLine();
        }
        String next() throws IOException
        {
            if(st==null || !st.hasMoreTokens())
                st = new StringTokenizer(nextLine());
            return st.nextToken();
        }
        int nextInt() throws IOException
        {
            return Integer.parseInt(next());
        }
        long nextLong() throws IOException
        {
            return Long.parseLong(next());
        }
        double nextDouble() throws IOException
        {
            return Double.parseDouble(next());
        }
    }
}
