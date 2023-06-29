
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public class q1 {
    public static MyScanner in = new MyScanner();
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out), true);
    public static MyViewer view = new MyViewer();
    public static BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
    public static Random rand = new Random(System.currentTimeMillis());

    public static class Pair<A, B> {
        private final A first;
        private final B second;

        public Pair(A first, B second) {
            super();
            this.first = first;
            this.second = second;
        }

        public int hashCode() {
            int hashFirst = first != null ? first.hashCode() : 0;
            int hashSecond = second != null ? second.hashCode() : 0;

            return (hashFirst + hashSecond) * hashSecond + hashFirst;
        }

        public boolean equals(Object other) {
            if (other instanceof Pair) {
                Pair otherPair = (Pair) other;
                return
                        ((this.first == otherPair.first ||
                                (this.first != null && otherPair.first != null &&
                                        this.first.equals(otherPair.first))) &&
                                (this.second == otherPair.second ||
                                        (this.second != null && otherPair.second != null &&
                                                this.second.equals(otherPair.second))));
            }

            return false;
        }

        public String toString() {
            return "(" + first + ", " + second + ")";
        }

        public A getFirst() {
            return first;
        }

        public B getSecond() {
            return second;
        }
    }

    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;
        private boolean randomInput = false;
        private Random rand;

        void randomInput(boolean r) {
            randomInput = r;
            rand = new Random(System.currentTimeMillis());
            //rand = new Random(42);
        }

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public MyScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public int nextInt(int val) {
            return randomInput ? val : Integer.parseInt(next());
        }

        public int nextInt(int low, int high) {
            if (randomInput) {
                return rand.nextInt(high - low + 1) + low;
            } else {
                return Integer.parseInt(next());
            }
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        long nextLong(long val) {
            return randomInput ? val : Long.parseLong(next());
        }

        long nextLong(long low, long high) {
            if (randomInput) {
                return low + ((long) (rand.nextDouble() * (high - low + 1)));
            } else {
                return Long.parseLong(next());
            }
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        int[] arrayInt(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        int[] arrayInt(int n, int low, int high) {
            int[] a = new int[n];
            if (randomInput) {
                for (int i = 0; i < n; i++) {
                    a[i] = rand.nextInt(high - low + 1) + low;
                }
            } else {
                for (int i = 0; i < n; i++) {
                    a[i] = nextInt();
                }
            }
            return a;
        }

        ArrayList<Integer> list(int n) {
            ArrayList<Integer> a = new ArrayList<Integer>(n);
            for (int i = 0; i < n; i++) {
                a.add(nextInt());
            }
            return a;
        }

        ArrayList<Integer> list(int n, int low, int high) {
            ArrayList<Integer> a = new ArrayList<Integer>(n);
            if (randomInput) {
                for (int i = 0; i < n; i++) {
                    a.add(rand.nextInt(high - low + 1) + low);
                }
            } else {
                for (int i = 0; i < n; i++) {
                    a.add(nextInt());
                }
            }
            return a;
        }

        long[] arrayLong(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextLong();
            }
            return a;
        }

        long[] arrayLong(int n, long low, long high) {
            long[] a = new long[n];
            if (randomInput) {
                for (int i = 0; i < n; i++) {
                    double r = rand.nextDouble();
                    a[i] = (long) (r * (double) (high - low + 1)) + low;
                    if (a[i] == 0) {
                        out.println("Ouch : " + r);
                    }
                }
            } else {
                for (int i = 0; i < n; i++) {
                    a[i] = nextLong();
                }
            }
            return a;
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

        void close() {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ArrayList<ArrayList<Integer>> randomTree(int n) {
            ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                edges.add(new ArrayList<>());
            }

            for (int i = 1; i < n; i++) {
                int par = rand.nextInt(i);
                edges.get(par).add(i);
            }
            return edges;
        }
    }

    static class MyViewer {
        private static boolean print = true;

        public void on() {
            print = true;
        }

        public void off() {
            print = false;
        }

        public <T extends List> void list(T a) {
            if (!print) return;
            if (a == null) {
                out.println("List: NULL");
                return;
            }
            if (a.size() == 0) {
                out.println("List: []");
                return;
            }
            out.print("List: [" + a.get(0));
            for (int i = 1; i < a.size(); i++) {
                out.print(", " + a.get(i));
            }
            out.println("] Len: " + a.size());
        }

        public <T> void array(T[] a) {
            if (!print) return;
            if (a == null) {
                out.println("Array: NULL");
                return;
            }
            if (a.length == 0) {
                out.println("Array: []");
                return;
            }
            out.print("Array: [" + a[0]);
            for (int i = 1; i < a.length; i++) {
                out.print(", " + a[i]);
            }
            out.println("] Len: " + a.length);
        }

        public void array(boolean[] a) {
            if (!print) return;
            if (a == null) {
                out.println("boolean[]: NULL");
                return;
            }
            if (a.length == 0) {
                out.println("boolean[]: Len: 0");
                return;
            }
            out.print("boolean[] Len: " + a.length + " [");
            for (boolean x : a) {
                out.print(x + ", ");
            }
            out.println("\b\b]");
        }

        public void array(int[] a) {
            if (!print) return;

            if (a == null) {
                out.println("Array: NULL");
                return;
            }
            if (a.length == 0) {
                out.println("Array: []");
                return;
            }
            out.print("int[] Len: " + a.length + " [");
            for (int x : a) {
                out.print(x + ", ");
            }
            out.println("\b\b]");
        }

        public void array(long[] a) {
            if (!print) return;
            if (a == null) {
                out.println("Array: NULL");
                return;
            }
            if (a.length == 0) {
                out.println("Array: []");
                return;
            }
            out.print("long Array: [");
            for (long x : a) {
                out.print(x + ", ");
            }
            out.println("\b\b] Len: " + a.length);
        }

        public void matrix(int[][] a, int cutoff) {
            if (cutoff == 0)
                cutoff = Integer.MAX_VALUE;
            if (a == null) {
                out.println("Matrix: NULL");
                return;
            }
            for (int i = 0; i < a.length; i++) {
                if (i < cutoff) {
                    printMatrixRow(a[i], cutoff);
                } else {
                    out.println("     ...");
                    printMatrixRow(a[a.length - 1], cutoff);
                    break;
                }
            }
        }

        public void matrix(long[][] a, long cutoff) {
            if (cutoff == 0)
                cutoff = Long.MAX_VALUE;
            if (a == null) {
                out.println("Matrix: NULL");
                return;
            }
            for (int i = 0; i < a.length; i++) {
                if (i < cutoff) {
                    printMatrixRow(a[i], cutoff);
                } else {
                    out.println("     ...");
                    printMatrixRow(a[a.length - 1], cutoff);
                    break;
                }
            }
        }

        public void matrix(boolean[][] a, int cutoff) {
            if (cutoff == 0)
                cutoff = Integer.MAX_VALUE;
            if (a == null) {
                out.println("Matrix: NULL");
                return;
            }
            for (int i = 0; i < a.length; i++) {
                if (i < cutoff) {
                    printMatrixRow(a[i], cutoff);
                } else {
                    out.println("     ...");
                    printMatrixRow(a[a.length - 1], cutoff);
                    break;
                }
            }
        }

        private void printMatrixRow(int[] a, int cutoff) {
            for (int j = 0; j < a.length; j++) {
                if (j < cutoff) {
                    out.printf("%6d  ", a[j]);
                } else {
                    out.printf(" ... %6d", a[a.length - 1]);
                    break;
                }
            }
            out.println();
        }

        private void printMatrixRow(long[] a, long cutoff) {
            for (int j = 0; j < a.length; j++) {
                if (j < cutoff) {
                    out.printf("%6d  ", a[j]);
                } else {
                    out.printf(" ... %6d", a[a.length - 1]);
                    break;
                }
            }
            out.println();
        }

        private void printMatrixRow(boolean[] a, int cutoff) {
            for (int j = 0; j < a.length; j++) {
                if (j < cutoff) {
                    out.print(a[j] ? "T " : "F ");
                } else {
                    out.print(" ... " + (a[a.length - 1] ? "T" : "F"));
                    break;
                }
            }
            out.println();
        }

    }

    public static void main(String[] args) throws IOException {
        int n = in.nextInt();
        int d = in.nextInt();

        int[] a = in.arrayInt(n);

        int count = 2;

        for(int i = 0 ;i < n-1; i++) {
            if( a[i+1] - a[i] == 2 * d )
                count += 1;
            if( a[i+1] - a[i] > 2 * d)
                count += 2;
        }

        out.println(count);



        log.flush();
        in.close();
    }
}
