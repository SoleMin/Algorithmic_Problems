

import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class ProblemA_23 {
    
    final boolean ONLINE_JUDGE=System.getProperty("ONLINE_JUDGE")!=null;
    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok=new StringTokenizer("");
    
    void init() throws FileNotFoundException{
        if (ONLINE_JUDGE){
            in=new BufferedReader(new InputStreamReader(System.in));
            out =new PrintWriter(System.out);
        }
        else{
            in = new BufferedReader(new FileReader("input.txt"));
            out = new PrintWriter("output.txt");
        }
    }
    
    String readString() throws IOException{
        while(!tok.hasMoreTokens()){
            tok=new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }
    
    int readInt() throws IOException{
        return Integer.parseInt(readString());
    }
    
    public static void main(String[] args){
        new ProblemA_23().run();
    }
    
    public void run(){
        try{
            long t1=System.currentTimeMillis();
            init();
            solve();
            out.close();
            long t2=System.currentTimeMillis();
            System.err.println("Time = "+(t2-t1));
        }catch (Exception e){
            e.printStackTrace(System.err);
            System.exit(-1);
        }
    }
    
    void solve() throws IOException{
        String s = readString();
        for (int length = s.length() - 1; length > 0; length--){
            for (int i = 0; i < s.length() - length; i++){
                if (s.lastIndexOf(s.substring(i, i + length)) > i){
                    out.print(length);
                    return;
                }
            }
        }
        out.print(0);
    }
}

