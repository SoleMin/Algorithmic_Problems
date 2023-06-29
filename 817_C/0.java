import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class ques3 {
	static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
 
        public InputReader(InputStream stream) {
            this.stream = stream;
        }
 
        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
 
        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                        numChars = stream.read(buf);
                } catch (IOException e) {
                        throw new InputMismatchException();
                }
                if (numChars <= 0) {
                        return -1;
                }
            }
            return buf[curChar++];
        }
 
        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }
 
        public interface SpaceCharFilter {
 
            public boolean isSpaceChar(int ch);
        }
 
        public String next() {
            return nextString();
        }
        
        public char nextChar(){
        	int c=read();
        	while (isSpaceChar(c)) {
                c = read();
            }
        	return (char)c;
        }
 
        public String nextString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }
 
        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
 
        public Long nextLong() {
            return Long.parseLong(nextString());
        }
 
        public Double nextDouble() {
            return Double.parseDouble(nextString());
        }
    }

	public static void main(String[] args) {
		InputReader sc=new InputReader(System.in);
		long n=sc.nextLong();
		long s=sc.nextLong();
		
		long start=0,end=n;
		while(start<end)
		{
			long mid=(start+end)/2;
			if(func(mid)>=s)
				end=mid;
			else 
				start=mid+1;
		}
		if(func(start)>=s)
			System.out.println(n-start+1);
		else
			System.out.println(0);
	}
	
	public static long func(long n)
	{
		long temp=n;
		int sum=0;
		while(temp>0)
		{
			sum+=temp%10;
			temp/=10;
		}
		return n-sum;
	}
}