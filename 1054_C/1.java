import java.util.*;
// import java.lang.*;
import java.io.*;

//           THIS TEMPLATE MADE BY AKSH BANSAL.

public class Solution {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
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
    private static boolean[] isPrime;
    private static void primes(){
        int num = (int)1e6; // PRIMES FROM 1 TO NUM
        isPrime = new boolean[num];
     
        for (int i = 2; i< isPrime.length; i++) {
           isPrime[i] = true;
        }
        for (int i = 2; i< Math.sqrt(num); i++) {
           if(isPrime[i] == true) {
              for(int j = (i*i); j<num; j = j+i) {
                 isPrime[j] = false;
              }
           }
        }
    }
    private static long gcd(long a, long b){
        if(b==0)return a;
        return gcd(b,a%b);
    }
    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        // primes();
        // ________________________________

        // _______________________________

        int n = sc.nextInt();
        int[] left =new int[n];
        int[] right =new int[n];
        for(int i=0;i<n;i++){
            left[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            right[i] = sc.nextInt();
        }
        solver(n,left, right, out);
        // ________________________________
        out.flush();
    }

    public static void solver(int n, int[] left, int[] right, PrintWriter out) {
        if(left[0]+right[n-1]>0){
            out.println("NO");
            return;
        }
        boolean isPossible = false;
        for(int i=0;i<n;i++){
            if(left[i]+right[i]==0){
                isPossible = true;
                break;
            }
        }
        if(!isPossible){
            out.println("NO");
            return;
        }
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            res[i] = n-left[i]-right[i];
        }
        for(int i=0;i<n;i++){
            int lcount = 0, rcount = 0;
            for(int j=i+1;j<n;j++){
                if(res[i]<res[j])rcount++;
            }
            for(int j=i-1;j>=0;j--){
                if(res[i]<res[j])lcount++;
            }
            if(left[i]!=lcount || right[i]!=rcount){
                // System.out.println("__"+ i);
                out.println("NO");
                return;
            }
        }

        out.println("YES");
        for(int i=0;i<n;i++){
            out.print(res[i]+" ");
        }
    }
}