import java.io.*;
import java.util.*;

public class Main { 
    public static void main(String[] args) throws IOException { 
        //InputStream input = System.in;
        //OutputStream output = System.out;
        InputReader in = new InputReader(new FileReader(new File("input.txt")));
        PrintWriter out = new PrintWriter(new FileWriter(new File("output.txt")));
        //InputReader in = new InputReader(input);
        //PrintWriter out = new PrintWriter(output);
        Solution s = new Solution();
        s.solve(1, in, out);
        out.close();
    }

    static class Solution { 
        
        double EPS = 0.0000001;
        public void solve(int cs, InputReader in, PrintWriter out) {

            int n = in.nextInt(), m = in.nextInt();
            Graph g = new Graph(n, m);
            int k = in.nextInt();
            for (int[] v : g.vis)
                Arrays.fill(v, -1);
            while (k-- > 0) {
                Pair start = new Pair(in.nextInt()-1, in.nextInt()-1);
                g.bfs(start);
            }
            int idx1 = 0, idx2 = 0, max = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; ++j) {
                    if (g.vis[i][j] > max) {
                        idx1 = i;
                        idx2 = j;
                        max = g.vis[i][j];
                    }
                }
            }
            out.println((idx1+1) + " " + (idx2+1));
        }

        static class Pair {
            int x, y;

            public Pair(int x, int y) {
                this.x = x ;
                this.y = y;
            }
        }

        static class Graph {
            LinkedList<Integer> adj[];
            int n, e;
            int[][] vis;

            @SuppressWarnings("unchecked")
            public Graph(int n, int e) {
                this.n = n;
                this.e = e;
                adj = new LinkedList[n];
                for (int i = 0; i < n; ++i)
                    adj[i] = new LinkedList<>();
                vis = new int[n][e];
            }
            
            int[] dx = {0, 0, 1, -1};
            int[] dy = {1, -1, 0, 0};

            void bfs(Pair src) {
                Queue<Pair> q = new LinkedList<>();
                vis[src.x][src.y] = 0;
                q.add(src);
                while (!q.isEmpty()) {
                    Pair p = q.poll();
                    for (int k = 0; k < 4; k++) {
                        int ni = p.x+dx[k];
                        int nj = p.y+dy[k];
                        if (isValid(ni, nj) && (vis[ni][nj] == -1 || vis[p.x][p.y]+1 < vis[ni][nj])) {
                            vis[ni][nj] = vis[p.x][p.y]+1;
                            q.add(new Pair(ni, nj));
                        }
                    }
                    
                }
            }

            boolean isValid(int i, int j) {
                return i >= 0 && i < n && j >= 0 && j < e;
            }
        }
    }

    static class InputReader { 
        BufferedReader br;
        StringTokenizer st;
        
        public InputReader(InputStream i) {
            br = new BufferedReader(new InputStreamReader(i), 32768);
            st = null;
        }

        public InputReader(FileReader s) {
            br = new BufferedReader(s);
            st = null;
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try { 
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int nextInt() { 
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() { 
            try { 
                return br.readLine();
            } catch (IOException e) { 
                throw new RuntimeException(e);
            }
        }
    }
    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
        public Reader(){
            din=new DataInputStream(System.in);
            buffer=new byte[BUFFER_SIZE];
            bufferPointer=bytesRead=0;
        }

        public Reader(String file_name) throws IOException{
            din=new DataInputStream(new FileInputStream(file_name));
            buffer=new byte[BUFFER_SIZE];
            bufferPointer=bytesRead=0;
        }

        public String readLine() throws IOException{
            byte[] buf=new byte[64]; // line length
            int cnt=0,c;
            while((c=read())!=-1){
                if(c=='\n')break;
                buf[cnt++]=(byte)c;
            }
            return new String(buf,0,cnt);
        }

        public int nextInt() throws IOException{
            int ret=0;byte c=read();
            while(c<=' ')c=read();
            boolean neg=(c=='-');
            if(neg)c=read();
            do{ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');
            if(neg)return -ret;
            return ret;
        }

        public long nextLong() throws IOException{
            long ret=0;byte c=read();
            while(c<=' ')c=read();
            boolean neg=(c=='-');
            if(neg)c=read();
            do{ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');
            if(neg)return -ret;
            return ret;
        }

        public double nextDouble() throws IOException{
            double ret=0,div=1;byte c=read();
            while(c<=' ')c=read();
            boolean neg=(c=='-');
            if(neg)c = read();
            do {ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');
            if(c=='.')while((c=read())>='0'&&c<='9')
                ret+=(c-'0')/(div*=10);
            if(neg)return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException{
            bytesRead=din.read(buffer,bufferPointer=0,BUFFER_SIZE);
            if(bytesRead==-1)buffer[0]=-1;
        }

        private byte read() throws IOException{
            if(bufferPointer==bytesRead)fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException{
            if(din==null) return;
            din.close();
        }
    }
}

