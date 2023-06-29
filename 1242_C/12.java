import java.io.*;
import java.util.*;

public class Main {

    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }


    public static void main(String[] args) throws IOException {
        Reader sc = new Reader();
        int k = sc.nextInt();
        int[][] buckets = new int[k][];
        long[] bucketSum = new long[k];
        Map<Integer, Integer> map = new HashMap<>(k * 10000);
        long target = 0;
        for (int i = 0; i < k; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
                target += arr[j];
                map.put(arr[j], i);
                bucketSum[i] += arr[j];
            }
            buckets[i] = arr;
        }
        if ((target % k) != 0) {
            System.out.println("No");
            return;
        } else {
            target /= k;
        }

        int[] bitmask = new int[1 << (k )];
        Arrays.fill(bitmask, -1);


        for (int i = 0; i < k; i++) {
            for (int j = 0; j < buckets[i].length; j++) {
                int start = buckets[i][j];
                int next = (int) (target - bucketSum[i]) + start;

                Set<Integer> visited = new HashSet<>();
                Set<Integer> visitedBuckets = new HashSet<>();

                visited.add(start);
                visitedBuckets.add(i);
                int bitset = 1 << i;

                while (map.containsKey(next)) {
                    int bucket = map.get(next);
                    if (start == next) {
                        bitmask[bitset] = start;
                        break;
                    } else if (visited.contains(next)) {
                        break;
                    } else if (visitedBuckets.contains(bucket)) {
                        break;
                    }
                    visited.add(next);
                    visitedBuckets.add(bucket);
                    next = (int) (target - bucketSum[bucket]) + next;
                    bitset |= 1 << bucket;
                }
            }
        }

        boolean[] dp = new boolean[1 << (k ) ];
        Arrays.fill(dp, false);
        int[] build = new int[1 << k];
        Arrays.fill(build, -1);

        for (int i = 0; i < dp.length; i++) {
            dp[i] = bitmask[i] != -1;
        }
        for (int m = 0; m < (1 << k); m++) {
            if (!dp[m]) {
                for (int s = m; s != 0; s = (s - 1) & m) {
                    if (dp[s] && dp[(m ^ s)])   {
                        dp[m] = true;
                        build[m] = s;
                        break;
                    }
                }
            }
        }
        System.out.println(dp[dp.length - 1] ? "Yes" : "No");
        ArrayList<Integer> path = new ArrayList<>();
        rec(path, build, bitmask, (1 << k) - 1);

        int[] picked = new int[k];
        int[] out = new int[k];
        if (dp[dp.length - 1]) {
            for (int i : path) {
                int prev = i;
                int next = (int) (target - bucketSum[map.get(prev)]) + prev;
                picked[map.get(next)] = next;
                out[map.get(next)] = map.get(prev);
                while (next != i) {
                    int t = next;
                    next = (int) (target - bucketSum[map.get(next)]) + next;
                    prev = t;
                    out[map.get(next)] = map.get(prev);
                    picked[map.get(next)] = next;


                }
            }
            for (int i = 0; i < out.length; i++) {
                System.out.println((picked[i]) + " " + (out[i] + 1));
            }
        }
    }

    public static void rec(ArrayList<Integer> path, int[] build, int[] bitmask, int i) {
        if (!(i >= 0 && i < bitmask.length)) {
            return;
        }
        if (bitmask[i] != -1) {
            path.add(bitmask[i]);
        } else {
            rec(path, build, bitmask, build[i]);
            rec(path, build, bitmask, i ^ build[i]);
        }
    }
}

