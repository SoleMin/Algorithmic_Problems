


import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@SuppressWarnings("Duplicates")

public class solveLOL {
    FastScanner in;
    PrintWriter out;
    boolean systemIO = true, multitests = false;
    int INF = Integer.MAX_VALUE / 2;


    void solve() {
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        boolean used[] = new boolean[n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                used[i] = true;
                for (int j = i + 1; j < n; j++) {
                    if (!used[j] && arr[j] % arr[i] == 0) {
                        used[j] = true;
                    }
                }
                k++;
            }
        }
        System.out.println(k);



    }

    class pair implements Comparable<pair> {
        int a;
        int b;

        pair(int A, int B) {
            this.a = A;
            this.b = B;
        }

        public int compareTo(pair o) {
            return a != o.a ? Double.compare(a, o.a) : b - o.b;
        }
    }

    void shuffleArray(long[] ar) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            long a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    void printArray(long[] ar) {
        for (long k : ar) {
            System.out.print(k + " ");
        }
        System.out.println();
    }

    void reverseArray(long[] ar) {
        for (int i = 0, j = ar.length - 1; i < j; i++, j--) {
            long a = ar[i];
            ar[i] = ar[j];
            ar[j] = a;
        }
    }

    private void run() throws IOException {
        if (systemIO) {
            in = new solveLOL.FastScanner(System.in);
            out = new PrintWriter(System.out);
        } else {
            in = new solveLOL.FastScanner(new File("input.txt"));
            out = new PrintWriter(new File("output.txt"));
        }
        for (int t = multitests ? in.nextInt() : 1; t-- > 0; )
            solve();

        out.close();
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        FastScanner(InputStream f) {
            br = new BufferedReader(new InputStreamReader(f));
        }

        String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                return null;
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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

    }

    public static void main(String[] arg) throws IOException {
        new solveLOL().run();
    }

}