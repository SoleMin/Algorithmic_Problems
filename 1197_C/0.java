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

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        // ________________________________

//        int t = sc.nextInt();
//        StringBuilder output = new StringBuilder();
//
//        while (t-- > 0) {
//
//            output.append(solver()).append("\n");
//        }
//
//        System.out.println(output);
        // _______________________________

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(solver(arr, n, k));
        // ________________________________
    }

    public static int solver(int[] arr, int len, int k) {
        int res = arr[len-1]-arr[0];
        if(k==len)return 0;
        int[] diff = new int[len-1];
        for(int i=0;i<len-1;i++){
            diff[i] += -arr[i+1]+arr[i];
        }
        
        Arrays.sort(diff);
        for(int i=0;i<k-1;i++){
            res+=diff[i];
        }
        return res;
    }
}