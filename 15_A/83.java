

import java.awt.Point;
import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class ProblemA_15 {
    
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
        new ProblemA_15().run();
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
        int n=readInt();
        int t=readInt();
        Point[] a=new Point[n];
        for (int i=0; i<n; i++){
            a[i]=new Point(readInt(), readInt());
        }
        int count=2;
        Arrays.sort(a, new Comparator<Point>(){

            @Override
            public int compare(Point p1, Point p2) {
                return p1.x-p2.x;
            }
            
        });
        for (int i=1; i<n; i++){
            double li=a[i-1].x+(double)a[i-1].y/2;
            double ri=a[i].x-(double)a[i].y/2;
            if (ri-li>t){
                count+=2;
            }
            if (ri-li==t){
                count++;
            }
        }
        out.print(count);
    }       
}

