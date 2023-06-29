import java.io.*;
import java.util.*;


public class Main {

    static StringBuilder data = new StringBuilder();
    final static FastReader in = new FastReader();


    public static void main(String[] args) {
        int n = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        Arrays.sort(a);
        int answ = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] != 0) {
                for (int j = i + 1; j < n; j++) {
                    if (a[j] % a[i] == 0) {
                        a[j] = 0;
                    }
                }
                answ++;
                a[i]=0;
            }
        }
        System.out.println(answ);
    }


    static void fileOut(String s) {
        File out = new File("output.txt");
        try {
            FileWriter fw = new FileWriter(out);
            fw.write(s);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        public FastReader(String path) {
            try {
                br = new BufferedReader(new
                        InputStreamReader(new FileInputStream(path)));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
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

        float nextFloat() {
            return Float.parseFloat(next());
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