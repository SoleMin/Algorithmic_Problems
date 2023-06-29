//بسم الله الرحمن الرحيم
import java.util.*;
import java.lang.*;
import java.nio.*;
import java.io.*;
public class as {
	static class Reader 
    { 
        final private int BUFFER_SIZE = 1 << 16; 
        private DataInputStream din; 
        private byte[] buffer; 
        private int bufferPointer, bytesRead; 
  
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
            byte[] buf = new byte[100000000]; // line length 
            int cnt = 0, c; 
            while ((c = read()) != -1) 
            { 
                if (c == '\n') 
                    break; 
                buf[cnt++] = (byte) c; 
            } 
            return new String(buf, 0, cnt); 
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
	/////////////////////////////////////////////////////////////
	public static void main(String[] args) throws Exception {
		Reader sc=new Reader();
		StringBuilder finalAnswer=new StringBuilder();
		//finalAnswer.append(1).append('\n');
		int t=sc.nextInt();
		while(t-->0) {
			int count=0;
			int n=sc.nextInt();
			if(n==2 || n==4) {
				finalAnswer.append("YES").append('\n');
				count++;
			}
			if(n%2==0 && count==0){
				n/=2;
				if((int)Math.sqrt(n)*(int)Math.sqrt(n)==n) {
					finalAnswer.append("YES").append('\n');
					count++;
				}
				else {
					n*=2;
				}
			}
			if(n%4==0 && count==0) {
				n/=4;
				if((int)Math.sqrt(n)*(int)Math.sqrt(n)==n) {
					finalAnswer.append("YES").append('\n');
					count++;
				}
			}
			if(count==0){
				finalAnswer.append("NO").append('\n');
			}
		}
		System.out.println(finalAnswer);
	}
	/////////////////////////////////////////////////////////
	
	public static long gcd(long a, long b)
	{
	    while (b > 0)
	    {
	        long temp = b;
	        b = a % b; // % is remainder
	        a = temp;
	    }
	    return a;
	}
	public static long lcm(long a, long b)
	{
	    return a * (b / gcd(a, b));
	}
	static boolean containsDigit(int number, int digit)
	{
	    while (number > 0)
	    {
	        int curr_digit = number % 10;
	        if (curr_digit == digit) return true;
	        number /= 10;
	    }

	    return false;
	}
	static boolean isPalindrome(String s) {
		  int n = s.length();
		  for (int i = 0; i < (n/2); ++i) {
		     if (s.charAt(i) != s.charAt(n - i - 1)) {
		         return false;
		     }
		  }

		  return true;
	}
	void sieveOfEratosthenes(int n)
    {
        // Create a boolean array 
        // "prime[0..n]" and
        // initialize all entries 
        // it as true. A value in
        // prime[i] will finally be 
        // false if i is Not a
        // prime, else true.
        boolean prime[] = new boolean[n + 1];
        for (int i = 0; i <= n; i++)
            prime[i] = true;
 
        for (int p = 2; p * p <= n; p++) 
        {
            // If prime[p] is not changed, then it is a
            // prime
            if (prime[p] == true) 
            {
                // Update all multiples of p
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }
 
        // Print all prime numbers
        for (int i = 2; i <= n; i++)
        {
            if (prime[i] == true)
                System.out.print(i + " ");
        }
    }
}

