import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
    
    public static void main(String[] args) throws Exception {
        int n = nextInt();
        
        int[] mas = new int[n];
        
        for(int i = 0; i<n; i++) {
            mas[i] = nextInt();
        }
        
        Arrays.sort(mas);
        
        if(mas[n-1] == 1) {
            for(int i = 0; i<n-1; i++) {
                out.print(1 + " ");
            }
            out.println(2);
            out.flush();
            exit();
        }
        
        out.print("1 ");
        
        for(int i = 0; i<n-1; i++) {
            out.print(mas[i] + " ");
        }
        
        out.println();
        out.flush();
    }
    
    /////////////////////////////////////////////////////////////////
    // IO
    /////////////////////////////////////////////////////////////////
    private static StreamTokenizer in;
    private static PrintWriter out;
    private static BufferedReader inB;
    
    private static boolean FILE=false;
    
    private static int nextInt() throws Exception{
        in.nextToken();
        return (int)in.nval;
    }
    
    private static String nextString() throws Exception{
        in.nextToken();
        return in.sval;
    }
    
    static{
        try {
            out = new PrintWriter(FILE ? (new FileOutputStream("output.txt")) : System.out);
            inB = new BufferedReader(new InputStreamReader(FILE ? new FileInputStream("input.txt") : System.in));
        } catch(Exception e) {e.printStackTrace();}
        in = new StreamTokenizer(inB);
    }
    /////////////////////////////////////////////////////////////////
    
    /////////////////////////////////////////////////////////////////
    // pre - written
    /////////////////////////////////////////////////////////////////
    private static void println(Object o) throws Exception {
        out.println(o);
        out.flush();
    }
    private static void exit(Object o) throws Exception {
        println(o);
        exit();
    }
    private static void exit() {
        System.exit(0);
    }
    private static final int  INF = Integer.MAX_VALUE;
    private static final int MINF = Integer.MIN_VALUE;
    //////////////////////////////////////////////////////////////////
}
