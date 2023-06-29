import java.io.*;
import java.math.*;
import java.util.*;
import java.lang.*;

public class Main
{
    static Input in;
    static Output out;

    public static void main(String[] args) throws IOException
    {
        in = new Input(System.in);
        out = new Output(System.out);
        run();
        out.close();
        System.exit(0);
    }

    private static void run() throws IOException
    {
        int n = in.nextInt(), k = in.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++)
        {
            A[i] = in.nextInt();
        }
        Arrays.sort(A);
        int count = n;
        boolean[] hash = new boolean[n];
        for (int i = n-1; i > 0; i--)
        {
            if(!hash[i])
            {
                int a = A[i];
                if(a % k == 0)
                {
                    int p = a / k;
                    int j = Arrays.binarySearch(A, p);
                    if(j >= 0 && j < i)
                    {
                        hash[j] = true;
                        count--;
                    }
                }
            }
        }
        out.print(count);
    }
}

class Input
{
    final int SIZE = 8192;
    private InputStream in;
    private byte[] buf = new byte[SIZE];
    private int last, current, total;

    public Input(InputStream stream) throws IOException
    {
        in = stream;
        last = read();
    }

    private int read() throws IOException
    {
        if (total == -1) return -1;
        if (current >= total)
        {
            current = 0;
            total = in.read(buf);
            if (total <= 0) return -1;
        }
        return buf[current++];
    }

    private void advance() throws IOException
    {
        while (true)
        {
            if (last == -1) return;
            if (!isValidChar(last)) last = read();
            else break;
        }
    }

    private boolean isValidChar(int c)
    {
        return c > 32 && c < 127;
    }

    public boolean isEOF() throws IOException
    {
        advance();
        return last == -1;
    }

    public String nextString() throws IOException
    {
        advance();
        if (last == -1) throw new EOFException();
        StringBuilder s = new StringBuilder();
        while (true)
        {
            s.appendCodePoint(last);
            last = read();
            if (!isValidChar(last)) break;
        }
        return s.toString();
    }

    public String nextLine() throws IOException
    {
        if (last == -1) throw new EOFException();
        StringBuilder s = new StringBuilder();
        while (true)
        {
            s.appendCodePoint(last);
            last = read();
            if (last == '\n' || last == -1) break;
        }
        return s.toString();
    }

    public String nextLine(boolean ignoreIfEmpty) throws IOException
    {
        if (!ignoreIfEmpty) return nextLine();
        String s = nextLine();
        while (s.trim().length() == 0) s = nextLine();
        return s;
    }

    public int nextInt() throws IOException
    {
        advance();
        if (last == -1) throw new EOFException();
        int n = 0, s = 1;
        if (last == '-')
        {
            s = -1;
            last = read();
            if (last == -1) throw new EOFException();
        }
        while (true)
        {
            n = n * 10 + last - '0';
            last = read();
            if (!isValidChar(last)) break;
        }
        return n * s;
    }

    public long nextLong() throws IOException
    {
        advance();
        if (last == -1) throw new EOFException();
        int s = 1;
        if (last == '-')
        {
            s = -1;
            last = read();
            if (last == -1) throw new EOFException();
        }
        long n = 0;
        while (true)
        {
            n = n * 10 + last - '0';
            last = read();
            if (!isValidChar(last)) break;
        }
        return n * s;
    }

    public BigInteger nextBigInt() throws IOException
    {
        return new BigInteger(nextString());
    }

    public char nextChar() throws IOException
    {
        advance();
        return (char) last;
    }

    public double nextDouble() throws IOException
    {
        advance();
        if (last == -1) throw new EOFException();
        int s = 1;
        if (last == '-')
        {
            s = -1;
            last = read();
            if (last == -1) throw new EOFException();
        }
        double n = 0;
        while (true)
        {
            n = n * 10 + last - '0';
            last = read();
            if (!isValidChar(last) || last == '.') break;
        }
        if (last == '.')
        {
            last = read();
            if (last == -1) throw new EOFException();
            double m = 1;
            while (true)
            {
                m = m / 10;
                n = n + (last - '0') * m;
                last = read();
                if (!isValidChar(last)) break;
            }
        }
        return n * s;
    }

    public BigDecimal nextBigDecimal() throws IOException
    {
        return new BigDecimal(nextString());
    }

    public void close() throws IOException
    {
        in.close();
        in = null;
    }

}

class Output
{
    final int SIZE = 8192;
    private Writer out;
    private char cb[] = new char[SIZE];
    private int nChars = SIZE, nextChar = 0;
    private char lineSeparator = '\n';

    public Output(OutputStream stream)
    {
        out = new OutputStreamWriter(stream);
    }

    void flushBuffer() throws IOException
    {
        if (nextChar == 0) return;
        out.write(cb, 0, nextChar);
        nextChar = 0;
    }

    void write(int c) throws IOException
    {
        if (nextChar >= nChars) flushBuffer();
        cb[nextChar++] = (char) c;
    }

    void write(String s, int off, int len) throws IOException
    {
        int b = off, t = off + len;
        while (b < t)
        {
            int a = nChars - nextChar, a1 = t - b;

            int d = a < a1 ? a : a1;
            s.getChars(b, b + d, cb, nextChar);
            b += d;
            nextChar += d;
            if (nextChar >= nChars) flushBuffer();
        }
    }

    void write(String s) throws IOException
    {
        write(s, 0, s.length());
    }

    public void print(Object obj) throws IOException
    {
        write(String.valueOf(obj));
    }

    public void println(Object obj) throws IOException
    {
        write(String.valueOf(obj));
        write(lineSeparator);
    }

    public void printf(String format, Object... obj) throws IOException
    {
        write(String.format(format, obj));
    }

    public void close() throws IOException
    {
        flushBuffer();
        out.close();
        out = null;
    }
}