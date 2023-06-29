
/**
* @author: Prasad Chaudhari
* @linkedIn: https://www.linkedin.com/in/prasad-chaudhari-841655a6/
* @git: https://github.com/Prasad-Chaudhari
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws Exception {
        FastIO in = new FastIO(args);
        int t = in.ni();
        while (t-- > 0) {
            int n = in.ni();
            LinkedList<Integer> l = new LinkedList<>();
            ArrayList<LinkedList<Integer>> al = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int p = in.ni();
                if (p == 1) {
                    l.addFirst(1);
                } else {
                    while (true) {
                        if (l.peekFirst() == p - 1) {
                            l.addFirst(l.removeFirst() + 1);
                            break;
                        } else {
                            l.removeFirst();
                        }
                    }
                }
                al.add(new LinkedList<>(l));
            }
            for (LinkedList<Integer> ll : al) {
                while (ll.size() > 1) {
                    System.out.print(ll.removeLast() + ".");
                }
                System.out.println(ll.remove());
            }
            System.out.println();
        }
        in.bw.flush();
    }

    static boolean willbealive(int i, int a[]) {
        if (i < 0 || i >= a.length)
            return false;
        if (a.length == 1)
            return false;
        if (a[i] == 1)
            return false;
        if (i == 0)
            return a[1] == 1;
        else if (i == a.length - 1)
            return a[i - 1] == 1;
        else
            return (a[i - 1] == 1) ^ (a[i + 1] == 1);
    }

    static class Data implements Comparable<Data> {

        int a, b;

        public Data(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Data o) {
            if (a == o.a) {
                return Integer.compare(b, o.b);
            }
            return Integer.compare(a, o.a);
        }

        public static void sort(int a[]) {
            Data d[] = new Data[a.length];
            for (int i = 0; i < a.length; i++) {
                d[i] = new Data(a[i], 0);
            }
            Arrays.sort(d);
            for (int i = 0; i < a.length; i++) {
                a[i] = d[i].a;
            }
        }
    }

    static class FastIO {

        private final BufferedReader br;
        private final BufferedWriter bw;
        private String s[];
        private int index;

        public FastIO(String[] args) throws IOException {
            if (args.length > 1) {
                br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(args[0]))));
                bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(args[1]))));
            } else {
                br = new BufferedReader(new InputStreamReader(System.in));
                bw = new BufferedWriter(new OutputStreamWriter(System.out, "UTF-8"));
            }
            s = br.readLine().split(" ");
            index = 0;
        }

        public int ni() throws IOException {
            return Integer.parseInt(nextToken());
        }

        public double nd() throws IOException {
            return Double.parseDouble(nextToken());
        }

        public long nl() throws IOException {
            return Long.parseLong(nextToken());
        }

        public String next() throws IOException {
            return nextToken();
        }

        public String nli() throws IOException {
            try {
                return br.readLine();
            } catch (IOException ex) {

            }
            return null;
        }

        public int[] gia(int n) throws IOException {
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = ni();
            }
            return a;
        }

        public int[] gia(int n, int start, int end) throws IOException {
            validate(n, start, end);
            int a[] = new int[n];
            for (int i = start; i < end; i++) {
                a[i] = ni();
            }
            return a;
        }

        public double[] gda(int n) throws IOException {
            double a[] = new double[n];
            for (int i = 0; i < n; i++) {
                a[i] = nd();
            }
            return a;
        }

        public double[] gda(int n, int start, int end) throws IOException {
            validate(n, start, end);
            double a[] = new double[n];
            for (int i = start; i < end; i++) {
                a[i] = nd();
            }
            return a;
        }

        public long[] gla(int n) throws IOException {
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = nl();
            }
            return a;
        }

        public long[] gla(int n, int start, int end) throws IOException {
            validate(n, start, end);
            long a[] = new long[n];
            for (int i = start; i < end; i++) {
                a[i] = nl();
            }
            return a;
        }

        public void print(String s) throws IOException {
            bw.write(s);
        }

        public void println(String s) throws IOException {
            bw.write(s);
            bw.newLine();
        }

        public void print(int s) throws IOException {
            bw.write(s + "");
        }

        public void println(int s) throws IOException {
            bw.write(s + "");
            bw.newLine();
        }

        public void print(long s) throws IOException {
            bw.write(s + "");
        }

        public void println(long s) throws IOException {
            bw.write(s + "");
            bw.newLine();
        }

        public void print(double s) throws IOException {
            bw.write(s + "");
        }

        public void println(double s) throws IOException {
            bw.write(s + "");
            bw.newLine();
        }

        private String nextToken() throws IndexOutOfBoundsException, IOException {
            if (index == s.length) {
                s = br.readLine().split(" ");
                index = 0;
            }
            return s[index++];
        }

        private void validate(int n, int start, int end) {
            if (start < 0 || end >= n) {
                throw new IllegalArgumentException();
            }
        }
    }
}
