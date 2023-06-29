/**
 * Created by Aminul on 12/12/2017.
 */


import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class CF903D {
    public static void main(String[] args) throws Exception {
        FastReader in = new FastReader(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = in.nextInt();
        int a[] = new int[n+1];
        int b[] = new int[n+1];
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 1; i <= n; i++){
            a[i] = in.nextInt();
            set.add(a[i]);
        }
        int k = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int last = set.first();
        for(int i : set){
            if(i - last > 1) k += 2;
            else k += 1;
            map.put(i, k);
            last = i;
        }

        for(int i = 1; i <= n; i++){
            b[i] = map.get(a[i]);
        }

        BinaryIndexTree bit = new BinaryIndexTree(k);
        BinaryIndexTree freq = new BinaryIndexTree(k);


        BigInteger res = BigInteger.ZERO;

        for(int i = n; i >= 1; i--){
            long l = bit.query(1, b[i]-2), r = bit.query(b[i]+2, k);
            long lf = freq.query(1, b[i]-2), rf = freq.query(b[i]+2, k);

            res = res.add(BigInteger.valueOf(r));
            res = res.add(BigInteger.valueOf(l));
            res = res.subtract(BigInteger.valueOf(rf*a[i]));
            res = res.subtract(BigInteger.valueOf(lf*a[i]));
            
            bit.add(b[i], a[i]);
            freq.add(b[i], 1);
        }

        pw.println(res);

        pw.close();
    }

    static class BinaryIndexTree{
        public long bit[];
        int n, len;

        public BinaryIndexTree(int nn){
            n = nn;
            bit = new long[n+1];
            len = bit.length;
        }

        public void add(int index, long value){
            for(; index < len;index = index + ( index & -index)){
                bit[index] += value;
            }
        }

        public long sum(int index){
            if(index <= 0) return 0;
            long sum = 0;
            for(; index > 0;index = index - (index & -index)){
                sum += bit[index];
            }
            return sum;
        }

        public long query(int i, int j){
            if(j < i) return 0;
            return sum(j) - sum(i-1);
        }



    }


    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj));
    }

    static class FastReader {
        InputStream is;
        private byte[] inbuf = new byte[1024];
        private int lenbuf = 0, ptrbuf = 0;
        static final int ints[] = new int[128];

        public FastReader(InputStream is) {
            for (int i = '0'; i <= '9'; i++) ints[i] = i - '0';
            this.is = is;
        }

        public int readByte() {
            if (lenbuf == -1) throw new InputMismatchException();
            if (ptrbuf >= lenbuf) {
                ptrbuf = 0;
                try {
                    lenbuf = is.read(inbuf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (lenbuf <= 0) return -1;
            }
            return inbuf[ptrbuf++];
        }

        public boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }

        public int skip() {
            int b;
            while ((b = readByte()) != -1 && isSpaceChar(b)) ;
            return b;
        }

        public String next() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public int nextInt() {
            int num = 0, b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }

            while (true) {
                if (b >= '0' && b <= '9') {
                    num = (num << 3) + (num << 1) + ints[b];
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        public long nextLong() {
            long num = 0;
            int b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }

            while (true) {
                if (b >= '0' && b <= '9') {
                    num = (num << 3) + (num << 1) + ints[b];
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
       /* public char nextChar() {
            return (char)skip();
        }*/

        public char[] next(int n) {
            char[] buf = new char[n];
            int b = skip(), p = 0;
            while (p < n && !(isSpaceChar(b))) {
                buf[p++] = (char) b;
                b = readByte();
            }
            return n == p ? buf : Arrays.copyOf(buf, p);
        }

        /*private char buff[] = new char[1005];
        public char[] nextCharArray(){
            int b = skip(), p = 0;
            while(!(isSpaceChar(b))){
                buff[p++] = (char)b;
                b = readByte();
            }
            return Arrays.copyOf(buff, p);
        }*/
    }
}