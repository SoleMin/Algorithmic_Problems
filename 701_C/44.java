import java.io.*;
import java.util.InputMismatchException;


public class Cf2207C {

    private static InputReader in = new InputReader(System.in);
    private static OutputWriter out = new OutputWriter(System.out);

    private static void solve() throws Exception {
        int n = in.readInt();
        String s = in.readString();
        int[] count = new int[200];
        boolean[] flag = new boolean[200];
        for(int i=0; i<n; ++i){
            flag[s.charAt(i)] = true;
        }
        int ref = 0;
        for(int i=0; i<200; ++i){
            if(flag[i]){
                ref++;
            }
        }

        int total = 0;
        int min  = Integer.MAX_VALUE;
        int j = 0;
        for(int i=0; i<n; ++i){
            if((j==n)&&(total<ref)){
                break;
            }
            if(total==ref){
                min = Math.min(min,j-i);
                count[s.charAt(i)]--;
                if(count[s.charAt(i)]==0){
                    total--;
                }
                continue;
            }
            for(;j<n; ++j){
                count[s.charAt(j)]++;
                if(count[s.charAt(j)]==1){
                    total++;
                }
                if(total==ref){
                    min = Math.min(min,j-i+1);
                    j++;
                    break;
                }
            }

            count[s.charAt(i)]--;
            if(count[s.charAt(i)]==0){
                total--;
            }

        }
        out.println(min);
    }

    public static void main(String[] args) throws Exception {
        solve();
        out.close();
    }

    private static class InputReader {
        private InputStream stream;
        private byte[] buffer;
        private int currentIndex;
        private int bytesRead;

        public InputReader(InputStream stream) {
            this.stream = stream;
            buffer = new byte[16384];
        }

        public InputReader(InputStream stream, int bufferSize) {
            this.stream = stream;
            buffer = new byte[bufferSize];
        }

        private int read() throws IOException {
            if (currentIndex >= bytesRead) {
                currentIndex = 0;
                bytesRead = stream.read(buffer);
                if (bytesRead <= 0) {
                    return -1;
                }
            }
            return buffer[currentIndex++];
        }

        public String readString() throws IOException {
            int c = read();
            while (!isPrintable(c)) {
                c = read();
            }
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = read();
            } while (isPrintable(c));
            return result.toString();
        }

        public int readInt() throws Exception {
            int c = read();
            int sign = 1;
            while (!isPrintable(c)) {
                c = read();
            }
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int result = 0;
            do {
                if ((c < '0') || (c > '9')) {
                    throw new InputMismatchException();
                }
                result *= 10;
                result += (c - '0');
                c = read();
            } while (isPrintable(c));
            return sign * result;
        }

        public long readLong() throws Exception {
            int c = read();
            int sign = 1;
            while (!isPrintable(c)) {
                c = read();
            }
            if (c == '-') {
                sign = -1;
                c = read();
            }
            long result = 0;
            do {
                if ((c < '0') || (c > '9')) {
                    throw new InputMismatchException();
                }
                result *= 10;
                result += (c - '0');
                c = read();
            } while (isPrintable(c));
            return sign * result;
        }

        public double readDouble() throws Exception {
            int c = read();
            int sign = 1;
            while (!isPrintable(c)) {
                c = read();
            }
            if (c == '-') {
                sign = -1;
                c = read();
            }
            boolean fraction = false;
            double multiplier = 1;
            double result = 0;
            do {
                if ((c == 'e') || (c == 'E')) {
                    return sign * result * Math.pow(10, readInt());
                }
                if ((c < '0') || (c > '9')) {
                    if ((c == '.') && (!fraction)) {
                        fraction = true;
                        c = read();
                        continue;
                    }
                    throw new InputMismatchException();
                }
                if (fraction) {
                    multiplier /= 10;
                    result += (c - '0') * multiplier;
                    c = read();
                } else {
                    result *= 10;
                    result += (c - '0');
                    c = read();
                }
            } while (isPrintable(c));
            return sign * result;
        }

        private boolean isPrintable(int c) {
            return ((c > 32) && (c < 127));
        }
    }

    private static class OutputWriter {
        private PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void println(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

        public void flush() {
            writer.flush();
        }
    }

}