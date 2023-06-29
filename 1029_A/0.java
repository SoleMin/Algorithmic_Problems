  import java.util.*;
import java.io.*;
  public class A{
    public static void taskSolver(FastReader sc){
     int n=sc.nextInt();
     int k=sc.nextInt();
     String s=sc.next();
      int index=0;
      String part="";
      for(int i=1;i<n;i++){
          part=s.substring(0,i);
          if(s.endsWith(part))index=i;
     }
      part=s.substring(index);
      System.out.print(s);
      for(int i=1;i<k;i++){
          System.out.print(part);
      }
      System.out.println();
  }
    public static void main(String args[]){
       FastReader sc=new FastReader();
        
       
           taskSolver(sc);
       
   } 
    static class FastReader 
    { 
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
  
       
 }
  