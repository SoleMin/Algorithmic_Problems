import java.util.*;
import java.io.*;

public class _G14 {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int t = sc.nextInt();
        Set<Long> square = new HashSet<>();
        for (long i = 1; i <= (long) 1e5; i++) square.add(i * i);
        while (t-- > 0) {
            long n = sc.nextLong();
            if ((n % 2 ==0 && square.contains(n / 2))|| (n % 4 == 0 &&square.contains(n / 4))) {
                out.println("YES");
            } else {
                out.println("NO");
            }
        }
        out.close();
    }


    static void sort(int[] a) {
        ArrayList<Integer> q = new ArrayList<>();
        for (int i : a) q.add(i);
        Collections.sort(q);
        for (int i = 0; i < a.length; i++) a[i] = q.get(i);
    }

    static void sort(long[] a) {
        ArrayList<Long> q = new ArrayList<>();
        for (long i : a) q.add(i);
        Collections.sort(q);
        for (int i = 0; i < a.length; i++) a[i] = q.get(i);
    }


    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
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

}