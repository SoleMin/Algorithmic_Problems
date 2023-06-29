import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class SolutionD {
   BufferedReader in;
   StringTokenizer str;
   PrintWriter out;
   String SK;

   String next() throws IOException {
      while ((str == null) || (!str.hasMoreTokens())) {
      SK = in.readLine();
      if (SK == null)
      return null;
      str = new StringTokenizer(SK);
      }
      return str.nextToken();
   }

   int nextInt() throws IOException {
      return Integer.parseInt(next());
   }

   double nextDouble() throws IOException {
      return Double.parseDouble(next());
   }

   long nextLong() throws IOException {
      return Long.parseLong(next());
   }
   void run() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        //in = new BufferedReader(new FileReader("input.txt"));
        //out = new PrintWriter("output.txt");
        solve();
        out.close();
   }

   public static void main(String[] args) throws IOException {
      new SolutionD().run();
   }
   void solve() throws IOException {
        long l=Long.parseLong(next());
        long r=Long.parseLong(next());
        String low=Long.toBinaryString(l);
        String up=Long.toBinaryString(r);
        
        int n=low.length();
        int m=up.length();
        for(int i=0;i<m-n;i++){
             low="0"+low;
        }
        String ret="";
        boolean fu=false;
        boolean fd=false;
        boolean su=false;
        boolean sd=false;
        if(m>n){
             su=true;
             fd=true;
        }
        for(int i=0;i<m;i++){
           if(low.charAt(i)==up.charAt(i)){
                if(low.charAt(i)=='1'){
                     if(fd){
                          ret+="1";
                          fu=true;
                     }
                     else if(sd){
                          ret+="1";
                          su=true;
                     }
                     else ret+="0";
                }
                else{
                     if(fu){
                          ret+="1";
                          fd=true;
                     }
                     else if(su){
                          ret+="1";
                          sd=true;
                     }
                     else ret+="0";
                }
           }else{
                if(up.charAt(i)=='1'){
                     su=true;
                     fd=true;
                }
                
                ret+="1";
           }
        }
        
        out.println(Long.parseLong(ret, 2));
        
        
      
         
   }
 

}
