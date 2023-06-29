/*Talent is something you make bloom , instinct is something you polish*/
import java.io.*;
import java.math.*;
import java.util.*;
public class Main
{
    static long mod=((long)1e9)+7;//toString
    public static int gcd(int a,int b){if(b==0)return a;else return gcd(b,a%b);}
    public static long pow_mod(long x,long y){long res=1;x=x%mod;while(y > 0){if((y & 1)==1)res=(res * x)%mod;y=y>>1;x =(x * x)%mod;}return res;}
    public static int lower_bound(int[]arr,int val){int lo=0;int hi=arr.length-1;while(lo<hi){int mid=lo+((hi-lo+1)/2);if(arr[mid]==val){return mid;}else if(arr[mid]>val){hi=mid-1;}else lo=mid;}if(arr[lo]<=val)return lo;else return -1;}
    public static int upper_bound(int[]arr,int val){int lo=0;int hi=arr.length-1;while(lo<hi){int mid=lo+((hi-lo)/2);if(arr[mid]==val){return mid;}else if(arr[mid]>val){hi=mid;;}else lo=mid+1;}if(arr[lo]>=val)return lo;else return -1;}
    
    public static void main (String[] args) throws java.lang.Exception
    {
        Reader sn = new Reader();
        Print p = new Print();
        int n = sn.nextInt();
        while((n--) > 0){
             int a = sn.nextInt();
             int b = sn.nextInt();
             int small = Math.min(a , b);
             int large = Math.max(a , b);
             long steps = 0;
             while(small != 0){
                  steps += (long)(large/small);
                  int large1 = small;
                  small = large % small;
                  large = large1;
             }
             p.printLine(Long.toString(steps));
        }
        p.close();
    }
}
class Pair implements Comparable<Pair> {
		int val;
		int in;
		Pair(int a, int b){
			val=a;
	        in=b;
		}
		@Override
		public int compareTo(Pair o) {
			if(val==o.val)
			return Integer.compare(in,o.in);
			else
			return Integer.compare(val,o.val);
		}}
class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
        public boolean isSpaceChar(int c) { return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1; }
        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }
        
        public String readWord()throws IOException
        {
		int c = read();
		while (isSpaceChar(c)) c = read();        
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = read();
		}while (!isSpaceChar(c));
		return res.toString();
	    } 
	
        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');
 
            if (neg)
                return -ret;
            return ret;
        }
 
        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }
 
        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
 
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
 
            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }
 
            if (neg)
                return -ret;
            return ret;
        }
 
        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
 
        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
 
        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
class Print
{
    private final BufferedWriter bw;
    public Print()
    {
        bw=new BufferedWriter(new OutputStreamWriter(System.out));
    }
    public void print(String str)throws IOException
    {
        bw.append(str);
    }
    public void printLine(String str)throws IOException
    {
        print(str);
        bw.append("\n");
    }
    public void close()throws IOException
    {
        bw.close();
    }}