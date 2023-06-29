import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CTask {


    public static void main(String[] args) throws IOException {
        MyInputReader in = new MyInputReader(System.in);
        HashMap<Character, Integer> m = new HashMap<Character, Integer>();
        int n = in.nextInt();
        char[] s = in.next().toCharArray();

        for (int i = 0; i < n; i++) {
            m.put(s[i], 0);
        }
        int mx = m.size();
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        int cur = 0;
        while (end < n) {
            while (end < n && cur != mx) {
                int x = m.get(s[end]);
                if (x == 0) {
                    cur += 1;
                }
                m.put(s[end], x + 1);
                end += 1;
            }
            while (start <= end && cur == mx) {
                int x = m.get(s[start]);
                m.put(s[start], x - 1);
                if (x - 1 == 0) {
                    cur -= 1;
                }
                start += 1;
            }
            min = Math.min(min, end - start + 1);
        }
        System.out.println(min);
    }


    static class Pair {

        long x;
        long y;

        public Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (x != pair.x) return false;
            return y == pair.y;

        }

        @Override
        public int hashCode() {
            int result = (int) (x ^ (x >>> 32));
            result = 31 * result + (int) (y ^ (y >>> 32));
            return result;
        }
    }

    static class MyInputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public MyInputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
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

    }

}