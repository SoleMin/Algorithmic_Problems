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
  
  final int MOD = 998244353;
  
  
  
  
  public Main()   {
	 FastReader in = new FastReader(new BufferedReader(new InputStreamReader(System.in)));
	 //FastReader in = new FastReader(new BufferedReader(new FileReader("Main.in")));
     final int N = 50; //big enough 
     long[] f = new long[N];
     int maxN = 50;
     f[0] = 0;
     for (int i = 1; i < N; i++) {
         if (Long.MAX_VALUE / 4 <= f[i-1]) {
             maxN = i - 1;
             break;
         }
         f[i] = f[i-1] * 4 + 1;
     }
     
     long[] a = new long[N];
     long[] b = new long[N];
          
     int nt = in.nextInt();     
     
     for (int ii = 1; ii <= nt; ii++) {
         int n = in.nextInt(); 
         long k = in.nextLong(); 
         
         if (k == 0) {
             System.out.println("YES " + n);
             continue;
         }
         
         if (n - 1> maxN || k <= 1 + f[n-1]) {
             System.out.println("YES " + (n - 1));
             continue;
         }
         if (n - 1 == maxN) {
             System.out.println("YES " + (n - 2));
             continue;
         }
         
         // now: n <= maxN
         if (k > f[n]) {
             System.out.println("NO");             
             continue;
         }                 
         
         if (n == 2) {
             if (k==3) System.out.println("NO");
             else System.out.println("YES 0");             
             continue;
         }
         
         a[1] = 1;
         b[1] = f[n-1];
         int ret = 0;
         for (int i = 2; i <= n; i++) {
             a[i] = a[i-1] + (1L << i) - 1;
             b[i] = b[i-1] + (2 * (1L << i) - 3) * f[n-i];
             if (a[i] + b[i] >= k) {
                 ret = n - i;
                 break;
             }
         }
         System.out.println("YES " + ret);
     }
  }
  
  
  private int dist(int x, int y, int xx, int yy) {
      return abs(x - xx) + abs(y - yy);
  }
  
  private boolean less(int x, int y, int xx, int yy) {
      return x < xx || y > yy;
  }
  
  private int mul(int x, int y) {
      return (int)(1L * x * y % MOD);
  }
  
  private int add(int x, int y) {
      return (x + y) % MOD;
  }
  
 
  
  private int nBit1(int v) {
      int v0 = v;
      int c = 0;
      while (v != 0) {
          ++c;
          v = v & (v - 1);
      }
      return c;
  }
  
  private long abs(long v) {
      return v > 0 ? v : -v;
  }
  
  private int abs(int v) {
      return v > 0 ? v : -v;
  }
  
  private int common(int v) {
      int c = 0;
      while (v != 1) {
          v = (v >>> 1);
          ++c;
      }
      
      return c;
  }
  
  private void reverse(char[] a, int i, int j) {
      while (i < j) {
          swap(a, i++, j--);
      }
  }
  
  private void swap(char[] a, int i, int j) {
      char t = a[i];
      a[i] = a[j];
      a[j] = t;
  }
  
  private int gcd(int x, int y) {
      if (y == 0) return x;
      return gcd(y, x % y);
  }
  private long gcd(long x, long y) {
      if (y == 0) return x;
      return gcd(y, x % y);
  }
  private int max(int a, int b) {
      return a >  b ? a : b;
  }
  
  private long max(long a, long b) {
      return a >  b ? a : b;
  }
  
  private int min(int a, int b) {
      return a >  b ? b : a;
  }
  
  private long min(long a, long b) {
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