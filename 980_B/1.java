import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.Stream.*;


public class CodeForces {

    static FastScanner sc = new FastScanner();
    static PrintWriter out=new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        solve();
        out.close();
    }

    private static void solve(){

        int n = sc.nextInt();
        int k = sc.nextInt();
        char[][] ans = new char[4][n];
        for(int i=0; i<4; i++){
            for(int j=0; j<n; j++){
                ans[i][j] = '.';
            }
        }
        int middle = n/2;
        if(k==(2*(n-2))){

            ans[1][middle] = '#';
            ans[2][middle] = '#';
            k -= 2;
        }else if(k%2==1){
            ans[1][middle] = '#';
            k--;
        }
        int i=1, j=1;

        while(k>0){
            if(i%middle==0){
                j++;
                i=1;
                continue;
            }
            ans[j][i] = '#';
            ans[j][n-1-i] = '#';
            i++;
            k -= 2;

        }

        out.println("YES");


        for(i=0; i<4; i++){
            out.println(String.valueOf(ans[i]));
        }







    }

    private static void logintarrayllist(List<Integer> currList){
        for (Integer a: currList) {
            out.print((a) + " ");
        }
        out.println();
    }

    private static void logintarray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            out.print(arr[i] + " ");
        }
        out.println();
    }
    private static void logchararray(char[] arr){
        for (int i = 0; i < arr.length; i++) {
            out.print(arr[i] + " ");
        }
        out.println();
    }


    private static void loglongarray(long[] arr){
        for (int i = 0; i < arr.length; i++) {
            out.print(arr[i] + " ");
        }
        out.println();
    }

    private static void log(Object... args) {
        out.println(args[0]);
        // ...
    }


    static class FastScanner {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in), 32768);
            tokenizer = null;
        }
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
        public int nextInt() {
            return Integer.parseInt(next());
        }
        public long nextLong() {
            return Long.parseLong(next());
        }
        public double nextDouble() {
            return Double.parseDouble(next());
        }
        public String nextLine() {
            try {
                return reader.readLine();
            } catch(IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


}