import java.io.*;
import java.util.*;

public class A{     
        
        private BufferedReader in;  
        private StringTokenizer st;
        
        void solve() throws IOException{
            
            int n = nextInt();
            System.out.println(3 * n/2);
        }
            

        A() throws IOException {
            in = new BufferedReader(new InputStreamReader(System.in));          
            eat("");
            solve();            
        }

        private void eat(String str) {
            st = new StringTokenizer(str);
        }

        String next() throws IOException {
            while (!st.hasMoreTokens()) {
                String line = in.readLine();
                if (line == null) {
                    return null;
                }
                eat(line);
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public static void main(String[] args) throws IOException {
            new A();
        }

        int gcd(int a,int b){
            if(b>a) return gcd(b,a);
            if(b==0) return a;
            return gcd(b,a%b);
        }

}
