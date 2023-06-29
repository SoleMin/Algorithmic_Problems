import java.io.*;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.*;

import java.math.BigInteger;

import static java.lang.Math.*;
import static java.math.BigInteger.*;
import static java.util.Arrays.*;


public class Main{

    void run(){
        Locale.setDefault(Locale.US);
        boolean oj = System.getProperty("ONLINE_JUDGE") != null;
//        boolean oj = true;
        try{
            if( oj ){
                sc  = new FastScanner( new InputStreamReader(System.in  ) );
                out = new PrintWriter(   new OutputStreamWriter(System.out) );
            } else{
                sc  = new FastScanner(new FileReader("in.txt") );
//                sc  = new FastScanner(new FileReader("D:\\JavaOlymp\\FatalError\\output.txt") );
                out = new PrintWriter(   new FileWriter("out.txt") );
            }
        } catch (Exception e) {
            System.exit(-1);
        }
        long tB = System.currentTimeMillis();
        solve();
        if( !oj ) System.err.println( "Time: " + (System.currentTimeMillis()-tB)/1e3 );
        out.flush();
    }


    class FastScanner{
        BufferedReader br;
        StringTokenizer st = new StringTokenizer("");
        FastScanner( InputStreamReader a ){
            br = new BufferedReader(a);
        }
        FastScanner( FileReader a ){
            br = new BufferedReader(a);
        }
        String next(){
            while( !st.hasMoreTokens() )
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    return null;
                }
            return st.nextToken();
        }
        String readLine(){
            try {
                return br.readLine();
            } catch (Exception e) {
                return null;
            }
        }
        int nextInt(){ return Integer.parseInt(next()); }
        long nextLong(){ return Long.parseLong(next()); }
    }

    FastScanner sc;
    PrintWriter out;



    public static void main(String[] args){
        new Main().run();
//        new Thread( null, new Runnable() {
//            @Override
//            public void run() {
//                new Main().run();
//            }
//            }, "LOL", 256L * 1024 * 1024 / 2 ).run();
//        }, "LOL", 2000 * 1024 * 1024 ).run();
    }



    void TLE(){ for(;;); }

    void MLE(){
        int[][] adj = new int[1024*1024][];
        for( int i = 0; i < adj.length; ++i )
            adj[i] = new int[1024*1024];
    }

    void exit( int val ){
        out.flush();
        System.exit(val);
    }
    //////////////////////////////////////////////////////////////////////////////////////////

    int n, m;
    boolean[][] grid;
    ArrayList<Integer>[] gr;
    int c;
    int[] mt;
    boolean[] u;


    boolean try_kuhn( int v ){
        if( u[v] ) return false;
        u[v] = true;
        for( int to : gr[v] ){
            if( to == c || !grid[v][to] ) continue;
            if( mt[to]==-1 || try_kuhn(mt[to]) ){
                mt[to] = v;
                return true;
            }
        }
        return false;
    }

    void solve(){
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new boolean[n+1][n+1];
        gr = new ArrayList[n+1];
        for( int v = 1; v <= n; ++v ) gr[v] = new ArrayList<Integer>();
        for( int it = 0; it < m; ++it ){
            int a = sc.nextInt();
            int b = sc.nextInt();
            grid[a][b] = true;
            gr[a].add(b);
        }

        int ans = Integer.MAX_VALUE;
        for( c = 1; c <= n; ++c ){
            int curAns = 0;
            for( int v = 1; v <= n; ++v )
                if( v != c ){
                    if( !grid[c][v] ) ++curAns;
                    if( !grid[v][c] ) ++curAns;
                }
            if( !grid[c][c] ) ++curAns;

            mt = new int[n+1];
            fill( mt, -1 );
            for( int i = 1; i <= n; ++i )
                if( i != c ){
                    u = new boolean[n+1];
                    try_kuhn(i);
                }

            int szMt = 0;
            for( int i = 1; i <= n; ++i )
                if( mt[i] != -1 )
                    ++szMt;
            curAns += n - 1 - szMt;

            for( int a = 1; a <= n; ++a ){
            for( int b = 1; b <= n; ++b ){
                if( a==c || b==c || !grid[a][b]
                ) continue;
                if(!( a==mt[b] ))
                    ++curAns;
            }
            }

//            out.printf( "%d %d\n", c, curAns );
            ans = min( ans, curAns );
        }
        out.println( ans );
    }



}
