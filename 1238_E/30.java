import java.util.*;
import java.lang.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.*;
import java.math.*;
public class Main {
    public void dfs(ArrayList<Integer>[] graph,int[] visited,int source) {
        
    }
    public static void main(String[] args) throws Exception{
        Reader.init(System.in);
        PrintWriter out = new PrintWriter(System.out);
        Main mm =new Main();
        int n=Reader.nextInt();
        int m=Reader.nextInt();
        String s=Reader.next();
        int[][] count=new int[m][m];
        for(int i=1;i<n;i++) {
            count[s.charAt(i)-'a'][s.charAt(i-1)-'a']++;
            count[s.charAt(i-1)-'a'][s.charAt(i)-'a']++;
        }
        int[] dp=new int[1<<m];
        Arrays.fill(dp, Integer.MAX_VALUE/10);
        for(int i=0;i<m;i++) {
            dp[1<<i]=0;
        }
        for(int i=0;i<(1<<m);i++) {
            int extra=0;
            for(int j=0;j<m;j++) {
                if((i&(1<<j))>0) {
                for(int k=0;k<m;k++) {
                    if(j!=k &&  (i&(1<<k))==0) {
                        extra+=count[j][k];
                    }
                }
               }
            }
            for(int j=0;j<m;j++) {
                if((i&(1<<j))==0) {
                    dp[i|(1<<j)]=Math.min(dp[i|(1<<j)], dp[i]+extra);
                }
            }
        }
        out.println(dp[(1<<m)-1]);
        out.close();
}
}
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;
    /** call this method to initialize reader for InputStream */
    static void init() throws IOException {
         reader = new BufferedReader(
                 new FileReader("input.txt"));
    tokenizer = new StringTokenizer("");
    }
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }
    /** get next word */
    static String nextLine() throws IOException{
        return reader.readLine();
    }
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }
    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
    static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}