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
  
  
  
  public Main()  {
	  FastReader in = new FastReader(new BufferedReader(new InputStreamReader(System.in)));
	  //FastReader in = new FastReader(new BufferedReader(new FileReader("Main.in")));
      int n = in.nextInt();
      int nM = 0;
      int[] nS = new int[4];
      int[] nL = new int[4];
      for (int i = 0; i < n; i++) {
          String s = in.next();
          int ns = s.length();
          if (s.charAt(0) == 'M') nM++;
          else if (s.charAt(ns - 1) == 'S') nS[ns-1]++;
          else nL[ns-1]++;
      }
      int c = 0;
      int[] nSr = new int[4];
      int[] nLr = new int[4];
      int nMr = 0;
      for (int i = 0; i < n; i++) {
          String s = in.next();
          int ns = s.length();
          if (s.charAt(0) == 'M') {
              if (nM > 0) --nM;
              else ++nMr;
          }else if (s.charAt(ns - 1) == 'S') {
              if (nS[ns-1] > 0) --nS[ns-1];
              else ++nSr[ns-1];
          }else {
              if (nL[ns-1] > 0) --nL[ns-1];
              else ++nLr[ns-1];
          }     
      }
      
      for (int i = 0; i < 4; i++) c += nS[i] + nL[i];
      c += nM;
      
      System.out.println(c);
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