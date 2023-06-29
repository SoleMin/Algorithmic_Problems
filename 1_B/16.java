import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Pattern;

//Stephen Fulwider
//Parser class for efficient input in Java
//  Use just as you would Scanner.
//  Make sure any method that uses this class throws Exception.
//  Email any bugs or problems found to knightry@gmail.com

class Parser
{
    final private int BUFFER_SIZE = 1 << 16;

    private java.io.DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public Parser(java.io.InputStream in)
    {
        din = new java.io.DataInputStream(in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public int nextInt() throws Exception
    {
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = c == '-';
        if (neg)
            c = read();
        int ret = 0;
        do
        {
            ret = ret * 10 + c - '0';
            c = read();
        } while (c > ' ');
        bufferPointer--;
        if (neg)
            return -ret;
        return ret;
    }

    public long nextLong() throws Exception
    {
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = c == '-';
        if (neg)
            c = read();
        long ret = 0;
        do
        {
            ret = ret * 10 + c - '0';
            c = read();
        } while (c > ' ');
        bufferPointer--;
        if (neg)
            return -ret;
        return ret;
    }

    public double nextDouble() throws Exception
    {
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = c == '-';
        if (neg)
            c = read();
        boolean seenDot = false;
        double div = 1;
        double ret = 0;
        do
        {
            if (c == '.')
                seenDot = true;
            else
            {
                if (seenDot)
                    div *= 10;
                ret = ret * 10 + c - '0';
            }
            c = read();
        } while (c > ' ');
        bufferPointer--;
        ret /= div;
        if (neg)
            return -ret;
        return ret;
    }

    public char nextChar() throws Exception
    {
        byte c = read();
        while (c <= ' ')
            c = read();
        return (char) c;
    }

    public String next() throws Exception
    {
        StringBuilder ret = new StringBuilder();
        byte c = read();
        while (c <= ' ')
            c = read();
        do
        {
            ret.append((char) c);
            c = read();
        } while (c > ' ');
        bufferPointer--;
        return ret.toString();
    }

    // read a string into an ALREADY ALLOCATED array, returns the number of characters read
    public int next(char[] ret) throws Exception
    {
        byte c = read();
        while (c <= ' ')
            c = read();
        int bRead = 0;
        do
        {
            ret[bRead++] = (char) c;
            c = read();
        } while (c > ' ');
        bufferPointer--;
        return bRead;
    }

    public String nextLine() throws Exception
    {
        StringBuilder ret = new StringBuilder();
        byte c = read();
        while (c != '\r' && c != '\n' && c != -1)
        {
            ret.append((char) c);
            c = read();
        }
        if (c == '\r')
            read();
        return ret.toString();
    }

    public boolean hasNext() throws Exception
    {
        byte c;
        do
        {
            c = read();
            if (c == -1)
            {
                bufferPointer--;
                return false;
            }
        } while (c <= ' ');
        bufferPointer--;
        return true;
    }

    private void fillBuffer() throws Exception
    {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
    }

    private byte read() throws Exception
    {
        if (bufferPointer == bytesRead) fillBuffer();
        if (bytesRead == -1) return -1;
        return buffer[bufferPointer++];
    }
}

class Printer
{
    final private int BUFFER_SIZE = 1 << 16;

    private java.io.DataOutputStream dout;
    private byte[] buffer;
    private int bufferPointer;

    Printer(java.io.OutputStream out) throws Exception
    {
        dout = new java.io.DataOutputStream(out);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = 0;
    }

    public void println() throws Exception
    {
        write((byte) '\n');
    }

    // print int
    public void println(int n) throws Exception
    {
        print(n);
        println();
    }

    public void print(int n) throws Exception
    {
        if (n >= 0)
            print(n, true);
        else
        {
            write((byte) '-');
            print(-n, true);
        }
    }

    private void print(int n, boolean first) throws Exception
    {
        if (n == 0)
        {
            if (first)
                write((byte) (n + '0'));
        }
        else
        {
            print(n / 10, false);
            write((byte) ((n % 10) + '0'));
        }
    }

    // print long
    public void println(long n) throws Exception
    {
        print(n);
        println();
    }

    public void print(long n) throws Exception
    {
        if (n >= 0)
            print(n, true);
        else
        {
            write((byte) '-');
            print(-n, true);
        }
    }

    private void print(long n, boolean first) throws Exception
    {
        if (n == 0)
        {
            if (first)
                write((byte) (n + '0'));
        }
        else
        {
            print(n / 10, false);
            write((byte) ((n % 10) + '0'));
        }
    }

    // print double
    public void println(double d) throws Exception
    {
        print(d);
        println();
    }

    public void print(double d) throws Exception
    {
        print("double printing is not yet implemented!");
    }

    // print char
    public void println(char c) throws Exception
    {
        print(c);
        println();
    }

    public void print(char c) throws Exception
    {
        write((byte) c);
    }

    // print String
    public void println(String s) throws Exception
    {
        print(s);
        println();
    }

    public void print(String s) throws Exception
    {
        int len = s.length();
        for (int i = 0; i < len; i++)
            print(s.charAt(i));
    }

    public void close() throws Exception
    {
        flushBuffer();
    }

    private void flushBuffer() throws Exception
    {
        dout.write(buffer, 0, bufferPointer);
        bufferPointer = 0;
    }

    private void write(byte b) throws Exception
    {
        buffer[bufferPointer++] = b;
        if (bufferPointer == BUFFER_SIZE)
            flushBuffer();
    }
}

public class Main
{
    public static void main(String[] args) throws Exception
    {
        new Main();
    }

    final int oo = (int)1e9;
    
//  InputStream stream = new FileInputStream("in");
    InputStream stream = System.in;
    Parser in = new Parser(stream);
    Printer out = new Printer(System.out);
    Printer err = new Printer(System.err);
    long start_time = System.nanoTime();
    // PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    // PrintWriter err = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.err)));
    
    int Sn;
    char[] S = new char[1000];
    char[] B = new char[1000];
    
    Main() throws Exception
    {
        for (int T=in.nextInt(); T-->0; )
        {
            Sn = in.next(S);
            if (matchRxCy())
                toLet();
            else
                toNum();
        }
        
        long end_time = System.nanoTime();
        err.println("Time: " + ((end_time-start_time)/1e9) + "(s).");
        if (stream instanceof FileInputStream)
        {
            err.println("~~~~~~~~~~~~~~~~~~~~~~~~~~!!!!!!!!!!!!!!!!!!!!!!!!!~~~~~~~~~~~~~~~~~~~~~~~~~~");
            err.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~CHANGE INPUT STREAM~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            err.println("~~~~~~~~~~~~~~~~~~~~~~~~~~!!!!!!!!!!!!!!!!!!!!!!!!!~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
        out.close();
        err.close();
    }
    
    boolean matchRxCy()
    {
        boolean ok=S[0]=='R'&&(S[1]>='0'&&S[1]<='9');
        if (!ok) return false;
        int i;
        for (i=2; i<Sn && S[i]!='C'; ++i);
        return i<Sn;
    }
    
    void toLet() throws Exception
    {
        int r = 0;
        int i=1;
        while (S[i]!='C')
            r=r*10+S[i++]-'0';
        int c = 0;
        ++i;
        while (i<Sn)
            c=c*10+S[i++]-'0';
                
        int bi=0;
        while (c>0)
        {
            B[bi++]=(char)((c-1)%26+'A');
            c=(c-1)/26;
        }
        
        for (int j=bi-1; j>=0; --j)
            out.print(B[j]);
        i=1;
        while (S[i]!='C')
            out.print(S[i++]);
        out.println();
    }
    
    void toNum() throws Exception // this works fine now, i think
    {
        int c=0;
        int i=0;
        int v=1;
        while (Character.isLetter(S[i++]))
            v*=26;
        v/=26;
        i=0;
        while (Character.isLetter(S[i]))
        {
            c+=v*(S[i++]-'A'+1);
            v/=26;
        }
        
        int r=0;
        while (i<Sn)
            r=r*10+S[i++]-'0';
        
        out.print('R');
        out.print(r);
        out.print('C');
        out.print(c);
        out.println();
    }
}
