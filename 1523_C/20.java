import java.io.*;
import java.util.*;

public class tank {

    static final FastScanner fs = new FastScanner();

    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = fs.nextInt();
        while(t-->0) {
            run_case();
        }

        out.close();
    }

    static void run_case() {
        int n = fs.nextInt(), prevLen = 1, one = 1;
        int[] arr = fs.readArray(n);
        int[] len = new int[1001];
        StringBuilder[] prev = new StringBuilder[1001];

        len[1] = 1;
        out.println(1);

        for (int i = 0; i < 1001; i++) {
            prev[i] = new StringBuilder();
        }

        prev[1].append("1");

        for (int i = 1; i < n; i++) {
            if(arr[i] == 1) {
                prev[prevLen + 1] = new StringBuilder(prev[prevLen]);
                prev[prevLen + 1].append(".1");
                out.println(prev[prevLen + 1]);

                prevLen++;

                len[prevLen] = 1;
            }else {
                for (int j = 1000; j > 0; j--) {
                    if(len[j] == arr[i] - 1 && j <= prevLen) {
                        char[] tmp = prev[j].toString().toCharArray();

                        if(fn(tmp)) {
                            prev[j] = new StringBuilder("" + (len[j] + 1));
                        }else {
                            prev[j] = new StringBuilder();
                            int ub = fn2(tmp);
                            for (int k = 0; k <= ub; k++) {
                                prev[j].append(tmp[k]);
                            }

                            prev[j].append(len[j] + 1);
                        }

                        out.println(prev[j]);

                        len[j] = len[j] + 1;

                        prevLen = j;
                        break;
                    }

                    if(j == 1) {
                        prev[j] = new StringBuilder("" + (one + 1));

                        out.println(prev[j]);

                        len[j] = one + 1;

                        prevLen = j;

                        one++;
                    }
                }
            }
        }
    }

    static boolean fn(char[] arr) {
        for(char c: arr) {
            if(c == '.') return false;
        }

        return true;
    }

    static int fn2(char[] arr) {
        int ret = 0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == '.') ret = i;
        }

        return ret;
    }

    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        String nextLine(){
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return "";
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a=new int[n];
            for (int i=0; i<n; i++) a[i]=nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}