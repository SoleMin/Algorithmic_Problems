    import java.util.*;
    import java.io.*;
    import java.lang.*;
    import java.math.*;
    public class D {
        public static void main(String[] args) throws Exception {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
            // int n = Integer.parseInt(bf.readLine());
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            
            for(int i=0; i<100000; i++) {
              long mult = 1L*i*(i+1)/2;
              long b = 1L*mult - k;
              if(i+b == n*1L) {
                out.println(b);
                out.close(); System.exit(0);
              }
            }
            //out.println(count);
            out.close(); System.exit(0);
        }
    }

    // a(a+1)/2 - b = k;   a+b = n   