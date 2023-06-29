import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException, URISyntaxException {
        Reader.init(new FileInputStream("input.txt"));
        StringBuilder s=new StringBuilder();
        boolean[][]vis=new boolean[Reader.nextInt()][Reader.nextInt()];
        int k=Reader.nextInt(),r,c;
        Queue<Point>q=new LinkedList<Point>();
        while(k-->0) {
            r=Reader.nextInt()-1;
            c=Reader.nextInt()-1;
            vis[r][c]=true;
            q.add(new Point(r,c));
        }
        Point end=null;
        int[]x={0,0,1,-1},y={1,-1,0,0};
        int a,b,i;
        while(!q.isEmpty()) {
            end=q.poll();
            for(i=0;i<4;i++) {
                a=end.x+x[i];
                b=end.y+y[i];
                if(a>=0&&b>=0&&a<vis.length&&b<vis[a].length&&!vis[a][b]) {
                    vis[a][b]=true;
                    q.add(new Point(a,b));
                }
            }
        }
        s.append(end.x+1).append(' ').append(end.y+1);
        PrintWriter p=new PrintWriter("output.txt");
        p.println(s);
        p.close();
    }
}

class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) throws UnsupportedEncodingException {
        reader = new BufferedReader(
                     new InputStreamReader(input, "UTF-8") );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }
    
    static String nextLine() throws IOException {
        return reader.readLine();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
    
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
    
    static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }
}