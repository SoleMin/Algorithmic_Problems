import java.util.*;
import java.io.*;
import static java.lang.Math.*;
public class Main {
    static final long MOD = 1_000_000_007, INF = 1_000_000_000_000_000_000L;
    static final int INf = 1_000_000_000;
    static FastReader reader;
    static PrintWriter writer;
    public static void main(String[] args) {
        Thread t = new Thread(null, new O(), "Integer.MAX_VALUE", 100000000);
        t.start();
    }
    static class O implements Runnable {
        public void run() {
            try {
                magic();
            }
            catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }
    static class FastReader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public FastReader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public FastReader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[1000000];
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg) return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg) return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
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
    static void magic() throws IOException {
        reader = new FastReader();
        writer = new PrintWriter(System.out, true);
        Map<Integer, ArrayList<Pair>> map = new HashMap<>();
        int n = reader.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;++i) {
            arr[i] = reader.nextInt();
        }
        for(int i=0;i<n;++i) {
            int sum = 0;
            for(int j=i;j<n;++j) {
                sum+=arr[j];
                ArrayList<Pair> list = map.get(sum);
                if(list==null) {
                    list = new ArrayList<>();
                }
                list.add(new Pair(i+1,j+1));
                map.put(sum, list);
            }
        }
        int ans = 0,at = -1;
        for(int e : map.keySet()) {
            ArrayList<Pair> list = map.get(e);
            Collections.sort(list);
//            writer.println("Pairs having sum: "+e);
//            for(Pair p : list) {
//                writer.print(p);
//                writer.print(" ");
//            }
//            writer.println();
            int ispe = 0;
            int len = list.size();
            for(int i=0;i<len;++i) {
                ispe++;
                int r = list.get(i).y;
                while(i+1<len && list.get(i+1).x<=r) {
                    i++;
                }
            }
            if(ans<ispe) {
                ans = ispe;
                at = e;
            }
        }
        writer.println(ans);
        ArrayList<Pair> list = map.get(at);
        Collections.sort(list);
        int len = list.size();
        for(int i=0;i<len;++i) {
            writer.println(list.get(i).x+" "+list.get(i).y);
            int r = list.get(i).y;
            while(i+1<len && list.get(i+1).x<=r) {
                i++;
            }
        }
    }
    static class Pair implements Comparable<Pair> {
        int x,y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int compareTo(Pair other) {
            if(this.y!=other.y) {
                return this.y - other.y;
            }
            return this.x - other.x;
        }
        public String toString() {
            return "{" + x + "," + y + "}";
        }
    }
}