import java.io.*; 
import java.math.BigInteger;
import java.util.*;
  
public class Main {
    public static void main(String[] args) throws IOException {
        FastScanner sc=new FastScanner();
        long K = sc.nextLong();
        long nums = 9;
        int digits = 1;
        while (K > nums*digits) {
        	K -= nums*digits;
        	nums *= 10;
        	digits++;
        }
        long removal = (K-1)/digits;
        int pos = (int)((K-1)%digits);
        long base = (long)Math.pow(10,digits-1);
        String num = Long.toString(base+removal);
        System.out.println(num.charAt(pos));
    }
    
    static class FastScanner
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastScanner() 
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
}