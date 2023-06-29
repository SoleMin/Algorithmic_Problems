

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Vector;





public class con67 {
	

	
	
	public static void main(String[] args) throws IOException 
	{
//	System.out.println(power(2,9,1000000007));
	long x=l();
	long k=l();
if(x!=0)
{
	long f=x%1000000007;
	long s=(f*power(2,k+1,1000000007))%1000000007;
	//out.println(s);
	long e=	(power(2,k,1000000007)-1)%1000000007;
	//out.println(e);
	long ans=(s-e+1000000007)%1000000007;
	
	out.println(ans);
	
}
else
{
	out.println(0);
}
	out.close();
	}
	 
	static long power(long x, long y, long p)
    {
        // Initialize result
        long res = 1;     
        
        // Update x if it is more  
        // than or equal to p
        x = x % p; 
     
        while (y > 0)
        {
            // If y is odd, multiply x
            // with result
            if((y & 1)==1)
                res = (res * x) % p;
     
            // y must be even now
            // y = y / 2
            y = y >> 1; 
            x = (x * x) % p; 
        }
        return res;
    }
	  
	 static InputReader in = new InputReader(System.in);
	    static OutputWriter out = new OutputWriter(System.out);
	    
	    static int i()
	    {
	    	return in.readInt();
	    }
	    
	    static long l()
	    {
	    	return in.readLong();
	    }
	    
	    static double d()
	    {
	    	return in.readDouble();
	    }
	    
	    static String s()
	    {
	    	return in.readString();
	    }
	    
	    static void Iarr( int[] array, int no )
	    {
	    	for( int i=0 ; i<no ; i++ )
	    	{
	    		array[i] = i(); 
	    	}
	    }
	    
	    static void Larr( long[] array, int no )
	    {
	    	for( int i=0 ; i<no ; i++ )
	    	{
	    		array[i] = l(); 
	    	}
	    }
	    
	    static void Darr( double[] array, int no )
	    {
	    	for( int i=0 ; i<no ; i++ )
	    	{
	    		array[i] = d(); 
	    	}
	    }
	    
	    static void Sarr( String[] array, int no )
	    {
	    	for( int i=0 ; i<no ; i++ )
	    	{
	    		array[i] = s(); 
	    	}
	    }
	    
	    private static class InputReader
	    {
	        private InputStream stream;
	        private byte[] buf = new byte[1024];
	        private int curChar;
	        private int numChars;
	        private SpaceCharFilter filter;
	 
	        public InputReader(InputStream stream)
	        {
	            this.stream = stream;
	        }
	 
	        
	        
	        
	        
	        
	        
	        public int read()
	        {
	            if (numChars == -1)
	                throw new InputMismatchException();
	            if (curChar >= numChars)
	            {
	                curChar = 0;
	                try
	                {
	                    numChars = stream.read(buf);
	                } catch (IOException e)
	                {
	                    throw new InputMismatchException();
	                }
	                if (numChars <= 0)
	                    return -1;
	            }
	            return buf[curChar++];
	        }
	 
	        public int readInt()
	        {
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
	 
	        public String readString()
	        {
	            int c = read();
	            while (isSpaceChar(c))
	                c = read();
	            StringBuilder res = new StringBuilder();
	            do
	            {
	                res.appendCodePoint(c);
	                c = read();
	            } while (!isSpaceChar(c));
	            return res.toString();
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
	        public boolean isSpaceChar(int c)
	        {
	            if (filter != null)
	                return filter.isSpaceChar(c);
	            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	        }
	 
	        public String next()
	        {
	            return readString();
	        }
	 
	        public interface SpaceCharFilter
	        {
	            public boolean isSpaceChar(int ch);
	        }
	    }
	 
	    private static class OutputWriter
	    {
	        private final PrintWriter writer;
	 
	        public OutputWriter(OutputStream outputStream)
	        {
	            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
	        }
	 
	        public OutputWriter(Writer writer)
	        {
	            this.writer = new PrintWriter(writer);
	        }
	 
	        public void print(Object... objects)
	        {
	            for (int i = 0; i < objects.length; i++)
	            {
	                if (i != 0)
	                    writer.print(' ');
	                writer.print(objects[i]);
	            }
	        }
	 
	        public void println(Object... objects)
	        {
	            print(objects);
	            writer.println();
	        }
	 
	        public void close()
	        {
	            writer.close();
	        }
	 
	        public void flush()
	        {
	            writer.flush();
	        }
	     }
	
	 
}
