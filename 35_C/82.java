    import java.awt.Point;
import java.io.*;
    import java.text.*;
    import java.util.*;
import java.util.regex.*;

    public class Main{
        static class Run implements Runnable{
            //TODO parameters
            final boolean consoleIO = false;
            final String inFile = "input.txt";
            final String outFile = "output.txt";
            
            int n,m,k;
            int[][] field;
            boolean[][] visited;
            
            LinkedList<Point> queue;
            int[][] steps = {{0,1},{1,0},{0,-1},{-1,0}};
            
            void wave() {
                for(Point p:queue)
                    visited[p.y][p.x] = true;
                
                while(!queue.isEmpty()) {
                    Point cur = queue.removeFirst();
                    for(int i = 0; i < steps.length; ++i) {
                        Point tmp = new Point(cur.x+steps[i][0],cur.y+steps[i][1]);
                        
                        if(ok(tmp)&&!visited[tmp.y][tmp.x]) {
                            queue.add(tmp);
                            visited[tmp.y][tmp.x] = true;
                            field[tmp.y][tmp.x] = field[cur.y][cur.x]+1;
                        }
                    }
                }
            }
            
            boolean ok(Point p) { 
                return p.x>=0 && p.y>=0 && p.x<n && p.y<m;
            }
            
            @Override
            public void run() {
                n = nextInt();
                m = nextInt();
                k = nextInt();
                
                queue = new LinkedList<Point>();
                for(int i = 0; i < k; ++i) 
                    queue.add(new Point(nextInt()-1,nextInt()-1));
                
                field = new int[m][n];
                visited = new boolean[m][n];
                wave();
                
                Point maxP = new Point(0,0);
                int maxV = Integer.MIN_VALUE;
                
                for(int i = 0; i < m; ++i)
                    for(int j = 0; j < n; ++j) 
                        if(field[i][j] > maxV) {
                            maxV = field[i][j];
                            maxP = new Point(j,i);
                        }
                
                print((maxP.x+1)+" "+(maxP.y+1));
                close();
            }
        //=========================================================================================================================
            BufferedReader in;
            PrintWriter out;
            StringTokenizer strTok;
           
            Run() {
                if (consoleIO) {
                    initConsoleIO();
                }
                else {
                    initFileIO();
                }
            }
           
            void initConsoleIO() {
                in = new BufferedReader(new InputStreamReader(System.in));
                out = new PrintWriter(new OutputStreamWriter(System.out));
            }
           
            void initFileIO() {
                try {
                    in = new BufferedReader(new FileReader(inFile));
                    out = new PrintWriter(new FileWriter(outFile));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
           
            void close() {
                try {
                    in.close();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
           
            int nextInt() {
                return Integer.parseInt(nextToken());
            }
           
            double nextDouble() {
                return Double.parseDouble(nextToken());
            }
           
            float nextFloat() {
                return Float.parseFloat(nextToken());
            }
           
            long nextLong() {
                return Long.parseLong(nextToken());
            }
           
            String nextLine() {
                try {
                    return in.readLine();
                } catch (IOException e) {
                    return "__NULL";
                }
            }
           
            boolean hasMoreTokens() {
                return (strTok == null) || (strTok.hasMoreTokens());
            }
           
            String nextToken() {
                while (strTok == null || !strTok.hasMoreTokens()) {
                    String line;
                    try {
                        line = in.readLine();
                        strTok = new StringTokenizer(line);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
               
                return strTok.nextToken();
            }
           
            void cout(Object o){
                System.out.println(o);
            }
           
            void print(Object o) {
                out.write(o.toString());
            }
            
            void println(Object o) {
                out.write(o.toString() + '\n');
            }
           
            void printf(String format, Object... args) {
                out.printf(format, args);
            }
           
            String sprintf(String format, Object... args) {
            return MessageFormat.format(format, args);
        }
        }
       
        static class Pair<A, B> {
            A a;
            B b;
           
            A f() {
                return a;
            }
           
            B s() {
                return b;
            }
           
            Pair(A a, B b) {
                this.a = a;
                this.b = b;
            }
           
            Pair(Pair<A, B> p) {
                a = p.f();
                b = p.s();
            }
        }
       
        public static void main(String[] args) throws IOException {
            Run run = new Run();
            Thread thread = new Thread(run);
            thread.run();
        }
    }