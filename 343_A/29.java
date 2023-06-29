import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

import org.omg.CORBA.UNKNOWN;


public class HelloWorld {

    InputReader input;
    PrintWriter output;
    BufferedReader inp;

    void run(){
        output = new PrintWriter(new OutputStreamWriter(System.out));
        input = new InputReader(System.in);
        inp = new BufferedReader(new InputStreamReader(System.in));
        solve();
        output.flush();
    }

    public static void main(String[] args){
        new HelloWorld().run();
    }
    
    long stps;
    
    long gcd(long a, long b) {
        if(b == 0 || a == 0) {
            return 0;
        }
        return a/b + gcd(b, a%b);
    }
    
    void solve() {
        long a = input.readLong();
        long b = input.readLong();
        stps = gcd(a, b);
        output.println(stps);
    }
    
    
    
    class node implements Comparable<node>{
        int destination;
        int direction;
        int distance;
        
        public node(int destination, int distance, int direction) {
            this.direction = direction;
            this.distance = distance;
            this.destination = destination;
        }
        
        public int compareTo(node b) {
            return this.distance - b.distance;
        }
    }
    
    class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars)
            {
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

        public int readInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-')
            {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do
            {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuffer res = new StringBuffer();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public Long readLong() {
            return Long.parseLong(readString());
        }

        public Double readDouble() {
            return Double.parseDouble(readString());
        }

        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    } 

}
