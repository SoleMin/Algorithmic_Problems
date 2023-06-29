import java.io.*;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.*;

/*
        author : Aditya Aggarwal

        LinkedIn : https://www.linkedin.com/in/aditya7861/

        ' The Dawn does not come twice to awaken the man '  ---->>>  ( My Motivation )

        Believe In yourself, Everything is possible.

        Never Give Up ... Failure is the biggest success
 */

public class Main {
    static class AdityaFastIO{
        final private int BUFFER_SIZE = 1 << 16;
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;
        public BufferedReader br;
        public StringTokenizer st;

        public AdityaFastIO() {
            br = new BufferedReader(new InputStreamReader(System.in));
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public AdityaFastIO(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String word() {
            while (st == null || !st.hasMoreElements()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }

        public String line() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int ni() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do { ret = ret * 10 + c - '0'; }
            while ((c = read()) >= '0' && c <= '9');

            if (neg) return -ret;
            return ret;
        }

        public long nl() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do { ret = ret * 10 + c - '0'; }
            while ((c = read()) >= '0' && c <= '9');
            if (neg) return -ret;
            return ret;
        }

        public double nd() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();

            do { ret = ret * 10 + c - '0'; }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.') while ((c = read()) >= '0' && c <= '9') ret += (c - '0') / (div *= 10);

            if (neg) return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null) return;
            din.close();
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
        String word() {
            while (st == null || !st.hasMoreElements()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }
        String line() {
            String str = "";
            try { str = br.readLine(); }
            catch (IOException e) { e.printStackTrace(); }
            return str;
        }
        int ni() { return Integer.parseInt(word()); }
        long nl() { return Long.parseLong(word()); }
        double nd() { return Double.parseDouble(word()); }
    }

    static int MOD = (int) (1e9 + 7);

    static long powerLL(long x, long n) {
        long result = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                result = result * x % MOD;
            }
            n = n / 2;
            x = x * x % MOD;
        }
        return result;
    }

    static long powerStrings(int i1, int i2) {

        String sa = String.valueOf(i1);
        String sb = String.valueOf(i2);
        long a = 0, b = 0;
        for (int i = 0; i < sa.length(); i++) a = (a * 10 + (sa.charAt(i) - '0')) % MOD;
        for (int i = 0; i < sb.length(); i++) b = (b * 10 + (sb.charAt(i) - '0')) % (MOD - 1);
        return powerLL(a, b);
    }

    static long gcd(long a, long b) { if (a == 0) return b;else return gcd(b % a, a); }
    static long lcm(long a, long b) { return (a * b) / gcd(a, b); }

    static long lower_bound(List<Long> list, long k) {
        int s = 0;
        int e = list.size();

        while (s != e) {
            int mid = (s + e) >> 1;
            if (list.get(mid) < k) s = mid + 1;
            else e = mid;
        }
        if (s == list.size()) return -1;
        return s;
    }

    static int upper_bound(List<Long> list, long k) {
        int s = 0;
        int e = list.size();

        while (s != e) {
            int mid = (s + e) >> 1;
            if (list.get(mid) <= k) s = mid + 1;
            else e = mid;
        }
        if (s == list.size()) return -1;
        return s;
    }

    static void addEdge(ArrayList<ArrayList<Integer>> graph, int edge1, int edge2) {
        graph.get(edge1).add(edge2);graph.get(edge2).add(edge1);
    }

    static class Pair<X, Y> {
        public X first;
        public Y second;
        Pair(X first, Y second) { this.first = first;this.second = second; }
        public static <X, Y> Pair<X, Y> of(X a, Y b) { return new Pair<>(a, b); }
        public String toString() { return "(" + first + "," + second + ")"; }
    }

    static boolean isCollectionsSorted(List<Integer> list) {
        if (list.size() == 0 || list.size() == 1) return true;
        for (int i = 1; i < list.size(); i++) if (list.get(i) < list.get(i - 1)) return false;
        return true;
    }

    public static void main(String[] args) throws java.lang.Exception {
        try {
            AdityaFastIO r = new AdityaFastIO();
            //FastReader r = new FastReader();
            try (OutputStream out = new BufferedOutputStream(System.out)) {
                boolean tc = false;
                int testcases = tc ? r.ni() : 1;
                while (testcases-- > 0){
                    int n = r.ni();
                    long sum = 0;
                    BigInteger bi = new BigInteger("0");
                    HashMap<Long, Long> hm = new HashMap<>();
                    for (int i=0;i<n;i++){
                        long ele = r.nl();
                        hm.put(ele, hm.getOrDefault(ele, 0L)+1);
                        sum+=ele;
                        //ans+=ele*(i+1)-sum+ hm.getOrDefault(ele+1,0L)-hm.getOrDefault(ele-1, 0L);

                        long ans1 = ele*(i+1)-sum+ hm.getOrDefault(ele+1,0L)-hm.getOrDefault(ele-1, 0L);
                        long ans2 = hm.getOrDefault(ele+1,0L)-hm.getOrDefault(ele-1,0L);
                        bi = bi.add(new BigInteger(""+(ans1)));
                    }

//                    DecimalFormat df = new DecimalFormat("0");
//                    df.setMaximumFractionDigits(0);
//                    out.write((df.format(ans) + " ").getBytes());

                    //out.write(((long) ans + " ").getBytes());
                    out.write((bi + " ").getBytes());
                }
            }
        }
        catch(Exception e){}
        finally{}
    }
}

// 2.6667 * 10 - 2.6666 = 9x;
//3.06667*10-3.0666 = 9x