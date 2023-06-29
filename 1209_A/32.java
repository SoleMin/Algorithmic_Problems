
import java.io.*;
import java.util.*;
import java.lang.*;
import static java.lang.Math.*;

public class TaskA implements Runnable {
    long m = (int) 1e9 + 7;
    PrintWriter w;
    InputReader c;
    /*Global Variables*/

    public void run() {
        c = new InputReader(System.in);
        w = new PrintWriter(System.out);
        int n = c.nextInt();
        int a[] = scanArrayI(n);
        boolean vis[] = new boolean[n];
        Arrays.sort(a);
        int ans=0;
        for(int i=0;i<n;i++){
            if(vis[i]) continue;
            vis[i] = true;
            for(int j=i+1;j<n;j++){
                if(a[j]%a[i] == 0){
                    vis[j] = true;
                }
            }
            ans++;
            boolean check = false;
            for(int j=0;j<n;j++){
                if(!vis[j]) check = true;
            }
            if(!check) break;
        }

        w.println(ans);

        w.close();
    }

    class pair{
        int x,y,step;

        @Override
        public String toString() {
            return "pair{" +
                    "x=" + x +
                    ", y=" + y +
                    ", step=" + step +
                    '}';
        }

        public pair(int x, int y, int s) {
            this.x = x;
            this.y = y;
            step = s;
        }
    }
    /*Template Stuff*/
    class HashMapUtil<T, U> {
        void addHash(HashMap<T, Integer> hm, T a) {
            if (hm.containsKey(a)) hm.put(a, hm.get(a) + 1);
            else hm.put(a, 1);
        }

        void iterateHashMap(HashMap<T, U> hm) {
            for (Map.Entry<T, U> e : hm.entrySet()) {
                T key = e.getKey();
                U value = e.getValue();
            }
        }
    }
    public int search(int input[], int search) {
        int low = 0;
        int high = input.length - 1;
        int mid;
        while (low <= high) {
            mid = low + ((high - low) / 2);
            if (input[mid] == search) {
                return mid;
            } else if (input[mid] < search) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    public void sort(int arr[]) {
        int n = arr.length, mid, h, s, l, i, j, k;
        int[] res = new int[n];
        for (s = 1; s < n; s <<= 1) {
            for (l = 0; l < n - 1; l += (s << 1)) {
                h = min(l + (s << 1) - 1, n - 1);
                mid = min(l + s - 1, n - 1);
                i = l;
                j = mid + 1;
                k = l;
                while (i <= mid && j <= h) res[k++] = (arr[i] <= arr[j] ? arr[i++] : arr[j++]);
                while (i <= mid) res[k++] = arr[i++];
                while (j <= h) res[k++] = arr[j++];
                for (k = l; k <= h; k++) arr[k] = res[k];
            }
        }
    }
    public int nextPowerOf2(int num) {
        if (num == 0) {
            return 1;
        }
        if (num > 0 && (num & (num - 1)) == 0) {
            return num;
        }
        while ((num & (num - 1)) > 0) {
            num = num & (num - 1);
        }
        return num << 1;
    }
    static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
    public static void sortbyColumn(int arr[][], int col) {
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return (Integer.valueOf(o1[col]).compareTo(o2[col]));
            }
        });

    }
    public void printArray(int[] a) {
        for (int i = 0; i < a.length; i++)
            w.print(a[i] + " ");
        w.println();
    }
    public int[] scanArrayI(int n) {
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = c.nextInt();
        return a;
    }
    public long[] scanArrayL(int n) {
        long a[] = new long[n];
        for (int i = 0; i < n; i++)
            a[i] = c.nextLong();
        return a;
    }
    public void printArray(long[] a) {
        for (int i = 0; i < a.length; i++)
            w.print(a[i] + " ");
        w.println();
    }
    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();

            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }

                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public int nextInt() {
            int c = read();

            while (isSpaceChar(c))
                c = read();

            int sgn = 1;

            if (c == '-') {
                sgn = -1;
                c = read();
            }

            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));

            return res * sgn;
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;

            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
            return res * sgn;
        }

        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E')
                        return res * Math.pow(10, nextInt());
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            }
            while (!isSpaceChar(c));

            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
    public static void main(String args[]) throws Exception {
        new Thread(null, new TaskA(), "TaskA", 1 << 26).start();
    }
}