import java.io.*;
import java.util.*;

public class ranjan {

    public static Reader cin;
    public static PrintWriter cout;
    public static char[][][] dp;
    public static boolean[] visited;
    public static final long bil = (long)1e9+7;
    public static void main(String[] arg) throws IOException {
        //input / output variables
        if(arg.length == 0)
            cin = new Reader(System.in);
        else
            cin = new Reader(new FileInputStream(new File("in"+arg[0]+ ".txt")));
        cout = new PrintWriter(new BufferedOutputStream(System.out));

        //input
        int n = cin.nextInt();
        int[] m = new int[n];
        for(int i=0;i<n;i++) m[i] = cin.nextInt();

        int[] t = new int[n]; //this array will hold minimum number of marks for each
        t[0] = 1; //first day for sure will have a mark (base condition)

        //validating the first condition t(i) >= max(t(i-1),m(i)+1)
        for(int i=1;i<n;i++)
            t[i] = Math.max(t[i-1],m[i]+1);
        //validating second condtition t(i-1) == t(i) or t(i-1) == t(i)-1
        for(int i=n-1;i>0;i--)
            if(t[i] - t[i-1] > 1)
                t[i-1] = t[i]-1;
        long ans = 0;
        //calcualte number of marks below level each day
        for(int i=0;i<n;i++)
            ans += t[i] - m[i]-1;
        cout.print(ans);
        //end
        cout.print("\n");
        cout.close();
    }




    private static class Pair{
        public int a,b;
        public Pair(int a,int b)
        {
            this.a = a;
            this.b = b;
        }	
    }

    //useful functions 
/*   public static void seive(int size)
    {
        prime[0] = prime[1] = false;
        int p = 2;
        while(p*p<= size)
        {
            if(prime[p])
            {
                for(int i=p*p;i<size;i += p)
                    prime[i] = false;
            }
            p++;
        }
    }
    public static long mod_pow(long x,long n,long mod) {
        long res=1;
        while(n>0) {
            if((n&1)==1)res=res*x%mod;
            x=x*x%mod;
            n>>=1;
        }
        return res;
    }
    public static int gcd(int n1, int n2) 
    {
        int r;
        while (n2 != 0) 
        {
            r = n1 % n2;
            n1 = n2;
            n2 = r;
        }
        return n1;
    }
    public static int lcm(int n1, int n2) 
    {
        int answer = (n1 * n2) / (gcd(n1, n2));
        return answer;
    }
*/

    //Fast Reading classes
    static class Reader 
    { 
        final private int BUFFER_SIZE = 1 << 16; 
        private DataInputStream din; 
        private byte[] buffer; 
        private int bufferPointer, bytesRead; 
  
        public Reader(InputStream is) 
        { 
            din = new DataInputStream(is); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public Reader(String file_name) throws IOException 
        { 
            din = new DataInputStream(new FileInputStream(file_name)); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public String nextLine() throws IOException 
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

        public String next() throws IOException 
        { 
            byte[] buf = new byte[64]; // line length 
            int cnt = 0, c; 
            while ((c = read()) != -1) 
            { 
                if (c == ' ' || c == '\n' || c == '\t') 
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
}