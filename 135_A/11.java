

import java.awt.Point;
import java.io.*;
import java.math.BigInteger;
import java.util.*;

import static java.lang.Math.*;

public class A implements Runnable{
    
    final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE")!=null;
    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");
    
    void init() throws FileNotFoundException{
        if (ONLINE_JUDGE){
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        }else{
            in = new BufferedReader(new FileReader("input.txt"));
            out = new PrintWriter("output.txt");
        }
    }
    
    String readString() throws IOException{
        while(!tok.hasMoreTokens()){
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }
    
    int readInt() throws IOException{
        return Integer.parseInt(readString());
    }
    
    long readLong() throws IOException{
        return Long.parseLong(readString());
    }
    
    double readDouble() throws IOException{
        return Double.parseDouble(readString());
    }
    
    public static void main(String[] args){
        new Thread(null, new A(), "", 256 * (1L << 20)).start();
    }
    
    public void run(){
        try{
            long t1 = System.currentTimeMillis();
            init();
            solve();
            out.close();
            long t2 = System.currentTimeMillis();
            System.err.println("Time = "+(t2-t1));
        }catch (Exception e){
            e.printStackTrace(System.err);
            System.exit(-1);
        }
    }
    
    void solve() throws IOException{
        int n = readInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++){
            a[i] = readInt();
        }
        Arrays.sort(a);
        a[n-1] = a[n-1] == 1? 2:1;
        Arrays.sort(a);
        for (int i = 0; i < n; i++){
            out.print(a[i] + " ");
        }
    }
}

