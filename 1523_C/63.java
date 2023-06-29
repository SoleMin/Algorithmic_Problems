import java.util.*;
import java.io.*;

public class Deltix {
    static PrintWriter out;
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Stack<Integer> s = new Stack<>();
            int [] a = new int[n];
            for (int i = 0; i < n; ++i) a[i] = sc.nextInt();
            for (int i = 0; i < n; i++) {
                if (a[i] == 1) {
                    s.push(1);
                } else {
                    while (s.peek() != a[i] - 1) {
                        s.pop();
                    }
                    s.pop();
                    s.push(a[i]);
                }
                print(s);
            }
        }
        out.close();
    }

    static void print(Stack<Integer> s) {
        ArrayDeque<Integer> a = new ArrayDeque<>();
        while (!s.isEmpty()) {
            a.addFirst(s.pop());
        }
        while (!a.isEmpty()) {
            int x = a.pollFirst();
            out.print(x);
            s.push(x);
            if (a.size() != 0) out.print(".");
        }
        out.println();
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