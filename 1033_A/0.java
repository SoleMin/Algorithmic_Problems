import java.util.*;
import java.lang.*;
import java.io.*;

 public class CF{

   // static int MOD=1e9+7;
     public static void main (String[] args) 
    {
 
            FastReader scan = new FastReader();
            PrintWriter out = new PrintWriter(System.out);
            Task solver = new Task();
         //   int testcase = scan.nextInt();
                
           int testcase = 1;
            for(int tt = 1; tt <= testcase ; tt++) solver.solve(tt, scan, out);
            out.close();
        
    }


        
    // main code in task 
    
      static class Task {
     
        public void solve(int testNumber, FastReader scan, PrintWriter out) {

            int n = scan.nextInt();

            int q1 = scan.nextInt();
            int q2 = scan.nextInt();

            int k1 = scan.nextInt();
            int k2 = scan.nextInt();


            int r  = scan.nextInt();
            int c = scan.nextInt();

           // boolean ans = false;

            if(q1 > k1 && q2 > k2 && q1 > r && q2 > c ){
                  out.println("YES");
              
            }else if(q1 < k1 && q2 < k2 && q1 < r && q2 < c){

             
                    out.println("YES");
              

            }else if(q1>k1 && q2<k2 && q1 > r && q2 < c ){

                
                  out.println("YES");
               
                
            }else if(q1<k1 && q2 > k2 && q1<r && q2 > c){

               
                 out.println("YES");
               

            }else{
                out.println("NO");
               

            }


           
     

        }
 
    }
        
 
 static class FastReader {
            BufferedReader br;
            StringTokenizer st;
     
            public FastReader() {
                br = new BufferedReader(new InputStreamReader(System.in));
            }
     
            public FastReader(String s) throws FileNotFoundException {
                br = new BufferedReader(new FileReader(new File(s)));
            }
     
            String next() {
                while (st == null || !st.hasMoreElements()) {
                    try {
                        st = new StringTokenizer(br.readLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return st.nextToken();
            }
     
            int nextInt() {
                return Integer.parseInt(next());
            }
     
            long nextLong() {
                return Long.parseLong(next());
            }
     
            double nextDouble() {
                return Double.parseDouble(next());
            }
     
            String nextLine() {
                String str = "";
                try {
                    str = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return str;
            }
            
       

 
 
        }


 }       