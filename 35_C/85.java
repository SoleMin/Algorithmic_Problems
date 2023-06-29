import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class incendio {
    void dbg(Object...os) { System.err.println(Arrays.deepToString(os)); }
    static StringTokenizer _stk; static BufferedReader input; static PrintWriter output; 
    static String next(){return _stk.nextToken();} static int nextInt(){return Integer.parseInt(next());}
    static String readln()throws IOException {String l=input.readLine();_stk=l==null?null:new StringTokenizer(l," ");return l;}
    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new FileReader("input.txt")); 
        output = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
        new incendio();
        output.close();
    }

    
    incendio() throws IOException {
        readln();
        M = nextInt(); N = nextInt();
        readln();
        final int K = nextInt();
        int xf[]=new int[K], yf[]=new int[K];
        readln();
        for(int i=0; i<K; i++) {
            xf[i]=nextInt();
            yf[i]=nextInt();
        }
        
        int best=-1, xbest=0, ybest=0;
        for(int i=1; i<=M; i++) {
            for(int j=1; j<=N; j++) {
                int dist=Integer.MAX_VALUE;
                for(int k=0; k<K; k++) {
                    dist = Math.min(dist, Math.abs(i-xf[k])+Math.abs(j-yf[k]));
                }
                if(dist>best) {
                    best=dist;
                    xbest=i;
                    ybest=j;
                }
            }
        }
        output.println(xbest+" "+ybest);
    }
    
    int M, N;
}