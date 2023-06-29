import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;

import static java.lang.Math.*;

public class Main implements Runnable {
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
            if (numChars==-1)
                throw new InputMismatchException();

            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                }
                catch (IOException e) {
                    throw new InputMismatchException();
                }

                if(numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
        public int nextInt() {
            int c = read();

            while(isSpaceChar(c))
                c = read();

            int sgn = 1;

            if (c == '-') {
                sgn = -1;
                c = read();
            }

            int res = 0;
            do {
                if(c<'0'||c>'9')
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
        new Thread(null, new Main(),"Main",1<<26).start();
    }


    public void run() {
        InputReader sc = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n=sc.nextInt();
        String a[]=new String[n];
        String b[]=new String[n];
        int freaa[][]=new int[5][4];
        for (int i = 0; i <n ; i++) {
            a[i]=sc.next();
            int ll=a[i].length();
            for (int j = 0; j <a[i].length() ; j++) {
                if(a[i].charAt(j)=='X')
                    freaa[ll][0]++;
                if(a[i].charAt(j)=='L')
                    freaa[ll][1]++;
                if(a[i].charAt(j)=='M')
                    freaa[ll][2]++;
                if(a[i].charAt(j)=='S')
                    freaa[ll][3]++;
            }
        }
        int frebb[][]=new int[5][4];
        for (int i = 0; i <n ; i++) {
            b[i]=sc.next();
            int ll=b[i].length();
            for (int j = 0; j <b[i].length() ; j++) {
                if(b[i].charAt(j)=='X')
                    frebb[ll][0]++;
                if(b[i].charAt(j)=='L')
                    frebb[ll][1]++;
                if(b[i].charAt(j)=='M')
                    frebb[ll][2]++;
                if(b[i].charAt(j)=='S')
                    frebb[ll][3]++;
            }
        }
        int ans=0;
        for (int i = 1; i <5 ; i++) {
            for (int j = 0; j <4 ; j++) {
                if(freaa[i][j]<frebb[i][j]){
                    ans+=frebb[i][j]-freaa[i][j];
                }
            }
        }
        out.println(ans);
        out.close();
    }


}