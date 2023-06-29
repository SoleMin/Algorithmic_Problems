import java.io.*;
import java.util.*;

import org.omg.PortableServer.ForwardRequestHelper;

public class A{     
        
        private BufferedReader in;  
        private StringTokenizer st;
        
        void solve() throws IOException{
            
            int n = nextInt();
            int i = 0;
            int[]nums = new int[n];
            int numeven = 0;
            int numodd = 0;
            while(n-->0){
                nums[i] = nextInt();
                if(nums[i]%2==0) numeven++;
                else numodd++;
                i++;
            }
            for (int j = 0; j < nums.length; j++) {
                if(numeven==1&&nums[j]%2==0){
                    System.out.println(j+1); break;
                }
                if(numodd==1&&nums[j]%2!=0){
                    System.out.println(j+1); break;
                }
            }
            
            
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
