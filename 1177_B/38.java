import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Reader in = new Reader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        BDigitsSequenceHardEdition solver = new BDigitsSequenceHardEdition();
        solver.solve(1, in, out);
        out.close();
    }

    static class BDigitsSequenceHardEdition {
        public void solve(int testNumber, Reader in, PrintWriter out) {
            long k = in.nextLong();
            long start = 1;
            long nDigit = 1;
            while (true) {
                long curr = start * 9 * nDigit;
                if (curr >= k) break;
                start *= 10;
                nDigit += 1;
                k -= curr;
            }
            if (k % nDigit == 0) {
                start += (k / nDigit - 1);
                out.println(start % 10);
            } else {
                long n = start + ((k / nDigit));
                int off = (int) (k % nDigit);
                out.println(Long.toString(n).charAt(off - 1));
            }
        }

    }

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer;
        private int bytesRead;

        public Reader(InputStream in) {
            din = new DataInputStream(in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) {
            try {
                din = new DataInputStream(new FileInputStream(file_name));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public long nextLong() {
            long ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg) {
                return -ret;
            }
            return ret;
        }

        private void fillBuffer() {
            try {
                bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
                if (bytesRead == -1) {
                    buffer[0] = -1;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        private byte read() {
            if (bufferPointer == bytesRead) {
                fillBuffer();
            }
            return buffer[bufferPointer++];
        }

    }
}

