import java.util.*;
import java.math.*;
import java.io.*;

public class Main
    {
    public static void main(String args[]) throws IOException
        {
        Scanner c=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);
        long N=c.nextLong()-1;
        long K=c.nextLong()-1;
        long tot=(K*(K+1))/2;
        //System.out.println(tot);
        if(N>tot)
            {
            System.out.println(-1);
            return;
            }
        long lo=1;
        long hi=K;
        while(hi-lo>=10)
            {
            long mid=(hi+lo)/2;
            //maximum outlets using mid pipes
            long sum=(mid*(mid-1))/2;
            long left=mid*K-sum;
            if(left>=N)
                hi=mid+1;
            else
                lo=mid-1;
            }
        for(int num=(int)lo-1000;num<lo+1000;num++)
            {
            if(num>=0)
                {
                long sum=((long)num*(num-1))/2;
                long left=(long)num*K-sum;
                if(left>=N)
                    {
                    System.out.println(num);
                    return;
                    }
                }
            }
        out.close();
        }
    }

class InputReader
    {
    private InputStream stream;
    private byte[] buf=new byte[1024];
    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;

    public InputReader(InputStream stream)
        {
        this.stream=stream;
        }

    public int read()
        {
        if(numChars==-1)
            throw new InputMismatchException();
        if(curChar>=numChars)
            {
            curChar=0;
            try
                {
                numChars=stream.read(buf);
                } catch (IOException e)
                {
                throw new InputMismatchException();
                }
            if(numChars<=0)
                return -1;
            }
        return buf[curChar++];
        }

    public int readInt()
        {
        int c=read();
        while (isSpaceChar(c))
            c=read();
        int sgn=1;
        if(c=='-')
            {
            sgn=-1;
            c=read();
            }
        int res=0;
        do
            {
            if(c<'0'||c>'9')
                throw new InputMismatchException();
            res*=10;
            res+=c-'0';
            c=read();
            } while (!isSpaceChar(c));
        return res*sgn;
        }

    public boolean isSpaceChar(int c)
        {
        if(filter!=null)
            return filter.isSpaceChar(c);
        return isWhitespace(c);
        }

    public static boolean isWhitespace(int c)
        {
        return c==' '||c=='\n'||c=='\r'||c=='\t'||c==-1;
        }

    public char readCharacter()
        {
        int c=read();
        while (isSpaceChar(c))
            c=read();
        return (char) c;
        }

    public interface SpaceCharFilter
        {
        public boolean isSpaceChar(int ch);
        }
    }
