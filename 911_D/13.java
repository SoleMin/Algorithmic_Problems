//>>>BaZ<<<//
import java.util.*;
import java.io.*;
import static java.lang.Math.*;
public class Main
{  
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,1,-1};
    static long MOD = 1000000007;
    static int INF = Integer.MAX_VALUE/10;
    static PrintWriter pw;
    static Reader scan;
    //static MyFileReader scan;
    //static MyFileReader1 ss;
    static int ni() throws IOException{return scan.nextInt();}
    static long nl() throws IOException{return scan.nextLong();}
    static double nd() throws IOException{return scan.nextDouble();}
    static void pl() throws IOException{pw.println();}
    static void pl(Object o) throws IOException{pw.println(o);}
    static void p(Object o) throws IOException {pw.print(o+" ");}
    static void psb(StringBuilder sb) throws IOException {pw.print(sb);}
    public static void main(String[] args){
        new Thread(null,null,"BaZ",99999999)
        {
            public void run()
            {
                try
                {
                    solve();
                }
                catch(Exception e)
                {  
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }.start();
    }
    static void solve() throws IOException
    {  
        Calendar CAL1 = Calendar.getInstance();
        CAL1.setTime(new Date());
        scan = new Reader();
        //scan = new MyFileReader();
        //ss = new MyFileReader1();
        pw = new PrintWriter(System.out,true);
        //pw = new PrintWriter(new File("C://Users/Aman deep/Desktop/output.txt"));  
        StringBuilder sb = new StringBuilder();
        int n = ni();
        int inv = 0;
        int arr[] = new int[n];
        for(int i=0;i<n;++i)
        {
            arr[i] = ni();
            for(int j=0;j<i;++j)
                if(arr[j]>arr[i])
                    inv = 1-inv;
        }
        int q = ni();
        while(q-->0)
        {
            int l = ni();
            int r = ni();
            int par = c2(r-l+1);
            par&=1;
            if(par!=0)
                inv = 1-inv;
            if(inv==0)
                sb.append("even\n");
            else sb.append("odd\n");
        }
        psb(sb);
        Calendar CAL2 = Calendar.getInstance();
        CAL2.setTime(new Date());
        double Execution_Time = (double)(CAL2.getTimeInMillis()-CAL1.getTimeInMillis())/1000.000;
        //System.out.println("Execution time : "+Execution_Time+" seconds");
        pw.flush();
        pw.close();
    }
    static int c2(int n)
    {
        return (n*(n-1))>>1;
    }
    static class Reader {
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public Reader() {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public Reader(String file_name) throws IOException {
        din = new DataInputStream(new FileInputStream(file_name));
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public String readLine() throws IOException {
        byte[] buf = new byte[64];
        int cnt = 0, c;
        while ((c = read()) != -1) {
            if (c == '\n') break;
            buf[cnt++] = (byte) c;
        }
        return new String(buf, 0, cnt);
    }

    public int nextInt() throws IOException {
        int ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (neg) return -ret;
        return ret;
    }

    public long nextLong() throws IOException {
        long ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (neg) return -ret;
        return ret;
    }

    public double nextDouble() throws IOException {
        double ret = 0, div = 1;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (c == '.') while ((c = read()) >= '0' && c <= '9') ret += (c - '0') / (div *= 10);
        if (neg) return -ret;
        return ret;
    }

    private void fillBuffer() throws IOException {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1) buffer[0] = -1;
    }

    private byte read() throws IOException {
        if (bufferPointer == bytesRead) fillBuffer();
        return buffer[bufferPointer++];
    }

    public void close() throws IOException {
        if (din == null) return;
        din.close();
    }
}
     static class MyFileReader                                          //File input template
    {
        StringTokenizer st;
        BufferedReader br;
        MyFileReader() throws IOException
        {
            br = new BufferedReader(new FileReader("C://Users/Aman deep/Desktop/input.txt"));
        }
        String nextLine() throws IOException
        {
            return br.readLine();
        }
        String next() throws IOException
        {
            if(st==null || !st.hasMoreTokens())
                st = new StringTokenizer(nextLine());
            return st.nextToken();
        }
        int nextInt() throws IOException
        {
            return Integer.parseInt(next());
        }
        long nextLong() throws IOException
        {
            return Long.parseLong(next());
        }
        double nextDouble() throws IOException
        {
            return Double.parseDouble(next());
        }
    }
     static class MyFileReader1                                          //File input template
    {
        StringTokenizer st;
        BufferedReader br;
        MyFileReader1() throws IOException
        {
            br = new BufferedReader(new FileReader("C://Users/Aman deep/Desktop/output.txt"));
        }
        String nextLine() throws IOException
        {
            return br.readLine();
        }
        String next() throws IOException
        {
            if(st==null || !st.hasMoreTokens())
                st = new StringTokenizer(nextLine());
            return st.nextToken();
        }
        int nextInt() throws IOException
        {
            return Integer.parseInt(next());
        }
        long nextLong() throws IOException
        {
            return Long.parseLong(next());
        }
        double nextDouble() throws IOException
        {
            return Double.parseDouble(next());
        }
    }
}
