import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task483A {

    public static void main(String... args) throws NumberFormatException,
            IOException {
        Solution.main(System.in, System.out);
    }

    static class Scanner {

        private final BufferedReader br;
        private String[] cache;
        private int cacheIndex;

        Scanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
            cache = new String[0];
            cacheIndex = 0;
        }

        int nextInt() throws IOException {
            if (cacheIndex >= cache.length) {
                cache = br.readLine().split(" ");
                cacheIndex = 0;
            }
            return Integer.parseInt(cache[cacheIndex++]);
        }

        long nextLong() throws IOException {
            if (cacheIndex >= cache.length) {
                cache = br.readLine().split(" ");
                cacheIndex = 0;
            }
            return Long.parseLong(cache[cacheIndex++]);
        }

        String next() throws IOException {
            if (cacheIndex >= cache.length) {
                cache = br.readLine().split(" ");
                cacheIndex = 0;
            }
            return cache[cacheIndex++];
        }

        void close() throws IOException {
            br.close();
        }

    }


    static class Solution {


        public static void main(InputStream is, OutputStream os)
                throws NumberFormatException, IOException {
            PrintWriter pw = new PrintWriter(os);
            Scanner sc = new Scanner(is);

            long l = sc.nextLong();
            long r = sc.nextLong();

            long interval = r-l;

            if(interval == 0 || interval == 1 || (interval == 2 && l % 2 ==1 )){
                pw.println(-1);
            } else {
                if(l % 2 == 1){
                    l++;
                }
                pw.print(l);
                pw.print(" ");
                pw.print(l+1);
                pw.print(" ");
                pw.print(l+2);
            }



            pw.flush();
            sc.close();
        }
    }

}