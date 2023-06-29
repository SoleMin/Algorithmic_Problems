import java.util.*;
import java.io.*;

public class Songs { 

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
            byte[] buf = new byte[1000000]; // line length 
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

    static int findPos(int x, int ar[]){
        for(int i=0;i<ar.length;i++){
            if(ar[i]==x)
                return (i+1);
        }
        return -20;
    }

    public static void main(String args[])throws IOException{
        Reader sc=new Reader();
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int i,j;
        int n=sc.nextInt();
        int tt=sc.nextInt();
        int t[]=new int[n];
        int g[]=new int[n];
        int last=0;
        int M=1000000007;
        long sum=0;
        for(i=0;i<n;i++){
            t[i]=sc.nextInt();
            g[i]=sc.nextInt()-1;
        }
        int d[][]=new int[1<<n][4];
        d[0][3]=1;
        for(i=0;i<(1<<n);i++){
            for(last=0;last<4;last++){
                for(j=0;j<n;j++){
                    if(g[j]!=last&&((i&(1<<j)))==0){
                        d[i^(1<<j)][g[j]]=(d[i^(1<<j)][g[j]]+d[i][last])%M;
                        // System.out.println((i|(1<<j))+" "+(g[j])+" "+d[i|(1<<j)][g[j]]);
                    }
                }
            }
            int dur=0;
            for(j=0;j<n;j++){
                if((i&(1<<j))>0){
                    dur+=t[j];
                }
            }
            if(dur==tt){
                // System.out.println(i);
                sum=(sum+d[i][0]+d[i][1]+d[i][2])%M;
            }
        }
        pw.println(sum);
        pw.close();
    }
}