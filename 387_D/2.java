
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.LinkedList;

public class D {
    static LinkedList<Integer>[] E;
    static int[] M;
    static boolean[] visited;
    static int n;
    static int center;

    public static boolean match(int x) {
        if (visited[x])
            return false;
        visited[x] = true;
        for (int y : E[x])
            if (y != center && (M[y] == -1 || match(M[y]))) {
                M[y] = x;
                return true;
            }
        return false;
    }

    public static int maxMatch() {
        int res = 0;
        Arrays.fill(M, -1);
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited, false);
            if (i != center && match(i))
                res++;
        }
        return res;
    }

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        n = in.readInt();
        int m = in.readInt();
        E = new LinkedList[n];
        M = new int[n];
        boolean[][] C = new boolean[n][n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++)
            E[i] = new LinkedList<Integer>();
        for (int i = 0; i < m; i++) {
            int x = in.readInt() - 1;
            int y = in.readInt() - 1;
            C[x][y] = true;
            E[x].add(y);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int res = 0;
            int all = 0;
            for (int j = 0; j < n; j++)
                if (j != i) {
                    all += E[j].size();
                    if (!C[i][j])
                        res++;
                    if (!C[j][i])
                        res++;
                    else
                        all--;
                }
            if (!C[i][i])
                res++;
            center = i;
            int match = maxMatch();
            res += (all - match) + (n - match - 1);
            min = Math.min(min, res);
        }
        System.out.println(min);
    }
}

class InputReader {

    private InputStream stream;
    private byte[] buf = new byte[1000];
    private int curChar, numChars;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    private int read() {
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

    public int readInt() {
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
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public long readLong() {
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

    private boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    private String readLine0() {
        StringBuffer buf = new StringBuffer();
        int c = read();
        while (c != '\n' && c != -1) {
            buf.appendCodePoint(c);
            c = read();
        }
        return buf.toString();
    }

    public String readLine() {
        String s = readLine0();
        while (s.trim().length() == 0)
            s = readLine0();
        return s;
    }

    public String readLine(boolean ignoreEmptyLines) {
        if (ignoreEmptyLines)
            return readLine();
        else
            return readLine0();
    }

    public char readCharacter() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        return (char) c;
    }

    public double readDouble() {
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
                return res * Math.pow(10, readInt());
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
                    return res * Math.pow(10, readInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                m /= 10;
                res += (c - '0') * m;
                c = read();
            }
        }
        return res * sgn;
    }
}