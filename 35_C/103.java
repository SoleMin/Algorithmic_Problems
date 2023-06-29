import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Watermelon {
    static int[][] ans;static int n,m;static boolean[][] vis;
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(new File("input.txt"));
//        Scanner sc=new Scanner(System.in);
        PrintWriter pw=new PrintWriter("output.txt");
        int n=sc.nextInt(),m=sc.nextInt(),k=sc.nextInt();
        Queue<Integer> pq=new ArrayDeque<>();
        boolean[] vis=new boolean[n*m];
        for(int i=0;i<k;i++){
            int r=sc.nextInt()-1,c=sc.nextInt()-1;
            pq.add(m*r+c);
            vis[m*r+c]=true;
        }
        sc.close();
        int ans=0;
        while(pq.size()!=0){
            int x=pq.remove();

            ans=x;
            if(n!=1 && x%n==0){
                if(x+m<n*m&&!vis[x+m]){
                    pq.add(x+m);
                    vis[x+m]=true;
                }
                if(x-m>=0&&!vis[x-m]){
                    pq.add(x-m);
                    vis[x-m]=true;
                }
                if(x+1<n*m&&!vis[x+1]){
                    pq.add(x+1);
                    vis[x+1]=true;
                }
            }
            else if(n!=1 && (x+1)%n==0){
                if(x+m<n*m&&!vis[x+m]){
                    pq.add(x+m);
                    vis[x+m]=true;
                }
                if(x-m>=0&&!vis[x-m]){
                    pq.add(x-m);
                    vis[x-m]=true;
                }
                if(x-1>=0&&!vis[x-1]){
                    pq.add(x-1);
                    vis[x-1]=true;
                }
            }
            else{
                if(x+m<n*m&&!vis[x+m]){
                    pq.add(x+m);
                    vis[x+m]=true;
                }
                if(x-m>=0&&!vis[x-m]){
                    pq.add(x-m);
                    vis[x-m]=true;
                }
                if(x-1>=0&&!vis[x-1]){
                    pq.add(x-1);
                    vis[x-1]=true;
                }
                if(x+1<n*m&&!vis[x+1]){
                    pq.add(x+1);
                    vis[x+1]=true;
                }
            }
        }
        pw.println((ans/m+1)+" "+(ans%m+1));
        pw.close();
    }

    static class Reader{
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
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }

            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
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

        public double nextDouble() throws IOException {
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

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }


}