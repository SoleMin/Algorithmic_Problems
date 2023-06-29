
import java.io.*;
import java.math.*;
import java.util.*;


public class Main {
    private static final int MAX = 5000 + 10,mod = 1000000007;
    private static char [] S;
    private static int n;
    private static Integer [] [] dp = new Integer[MAX][MAX];

    private static int solve(int pos,int open){
        if(pos == n) return (open == 0) ? 1 : 0;
        if (dp[pos][open] != null) return dp[pos][open];
        int res = 0;
        if (S[pos] == 's') {
            res = solve(pos + 1,open);
            if (open > 0) res += solve(pos,open - 1);
            if (res >= mod) res -= mod;
        }
        else {
            res = solve(pos+1,open + 1);
        }
        return dp[pos][open] = res;
    }

    public static void main(String[] args) throws Exception{
        IO io = new IO(null,null);
        n = io.getNextInt();
        S = new char[n];
        for (int i = 0;i < n;i++) S[i] = io.getNext().charAt(0);
        io.println(solve(0,0));
        io.close();
    }
}



class IO{
    private BufferedReader br;
    private StringTokenizer st;
    private PrintWriter writer;
    private String inputFile,outputFile;

    public boolean hasMore() throws IOException{
        if(st != null && st.hasMoreTokens()) return true;
        if(br != null && br.ready()) return true;
        return false;
    }
    public String getNext() throws FileNotFoundException, IOException{
        while(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }

    public String getNextLine() throws FileNotFoundException, IOException{
        return br.readLine().trim();
    }

    public int getNextInt() throws FileNotFoundException, IOException{
        return Integer.parseInt(getNext());
    }
    public long getNextLong() throws FileNotFoundException, IOException{
        return Long.parseLong(getNext());
    }

    public void print(double x,int num_digits) throws  IOException{
        writer.printf("%." + num_digits + "f" ,x);
    }
    public void println(double x,int num_digits) throws  IOException{
        writer.printf("%." + num_digits + "f\n" ,x);
    }
    public void print(Object o) throws  IOException{
        writer.print(o.toString());
    }

    public void println(Object o) throws  IOException{
        writer.println(o.toString());
    }
    public IO(String x,String y) throws FileNotFoundException, IOException{
        inputFile = x;
        outputFile = y;
        if(x != null) br = new BufferedReader(new FileReader(inputFile));
        else br = new BufferedReader(new InputStreamReader(System.in));
        if(y != null) writer = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)));
        else writer = new PrintWriter(new OutputStreamWriter(System.out));
    }

    protected void close() throws IOException{
        br.close();
        writer.close();
    }
}

