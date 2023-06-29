import java.util.*;
import java.io.*;

// Solution

public class Main 
{    
  public static void main (String[] argv) 
  {
	  new Main();
  } 
     
     
  
  boolean test = false;  
  int n;
  
  long mod = 1000000007;
  public Main() {
	  FastReader in = new FastReader(new BufferedReader(new InputStreamReader(System.in)));
	  //FastReader in = new FastReader(new BufferedReader(new FileReader("Main.in")));
      long x = in.nextLong();
      long k = in.nextLong();
      
      if (x == 0) {
          System.out.println(0);
          return;
      }
      
      if (k == 0) {
          x %= mod;
          System.out.println((2*x%mod));
          return;
      }
      
      x %= mod;
      
      long f = pow(2, k);
      long ans = ((2 * f * x % mod - f + 1) % mod + mod) % mod;
      
      System.out.println(ans);
     
  }
  
  private long pow(long x, long y) {
      long ans = 1;
      while (y > 0) {
          if (y % 2 == 1) 
              ans = ans * x % mod;
          x = x * x % mod;
          y /= 2;
      }
      return ans;
  }
  
  private long gcd(long x, long y) {
      if (y == 0) return x;
      return gcd(y, x % y);
  }
  private int max(int a, int b) {
      return a >  b ? a : b;
  }
  
  private int min(int a, int b) {
      return a >  b ? b : a;
  }
  
  
  static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader(BufferedReader in)
        {            
            br = in;
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    String line = br.readLine();
                    if (line == null || line.length() == 0) return "";
                    st = new StringTokenizer(line);
                }
                catch (IOException  e)
                {
                    return "";
                    //e.printStackTrace();
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
                return "";
                //e.printStackTrace();
            }
            return str;
        }
    }
}