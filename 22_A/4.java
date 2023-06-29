import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    private static Parser in;
    private static PrintWriter out;
    
    public static void main(String[] args) {
        in = new Parser(System.in);
        out = new PrintWriter(System.out);
        
        int n= in.nextInt();
        int min = 101;
        boolean b = false;
        int pmin = 101;
        int t= 0 ;
        for(int i=0; i<n; i++){
            t = in.nextInt();
            
            if (t<min){if(min != pmin)b=true; if(b) pmin = min;  min = t;  continue;}
            if (t>min && t<pmin){b=true; pmin = t;  continue;}
            if (t>min && !b){b=true; pmin = t;  continue;}
            //if (b){if(t<pmin){pmin = t; continue;}}
            //out.print(min);
            //out.print(pmin);
        }
        if (b) System.out.println(pmin); else System.out.println("NO");
        //out.flush();
    }
}


class Parser {
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;
 
    public Parser(InputStream in) {
            din = new DataInputStream(in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
    }
    public String nextString(int size) { 
        byte[] ch = new byte[size];
        int point = 0;
        try {
            byte c = read();
            while (c == ' ' || c == '\n' || c=='\r')
                c = read();
            while (c != ' ' && c != '\n' && c!='\r') {
                ch[point++] = c;
                c = read();
            }
        } catch (Exception e) {}
        return new String(ch,0,point);
        }
    public int nextInt() { 
    int ret = 0;
    boolean neg;
    try {
        byte c = read();
        while (c <= ' ')
            c = read();
        neg = c == '-';
        if (neg)
            c = read();
        do {
            ret = ret * 10 + c - '0';
            c = read();
        } while (c > ' ');
    
    if (neg) return -ret;
    } catch (Exception e) {}
    return ret;
    }
    public long nextLong() { 
        long ret = 0;
        boolean neg;
        try {
            byte c = read();
            while (c <= ' ')
                c = read();
            neg = c == '-';
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
                c = read();
            } while (c > ' ');
        
        if (neg) return -ret;
        } catch (Exception e) {}
        return ret;
        }
    private void fillBuffer() {
        try {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        } catch (Exception e) {}
        if (bytesRead == -1) buffer[0] = -1;
    }
 
    private byte read() {
        if (bufferPointer == bytesRead) fillBuffer();
        return buffer[bufferPointer++];
    }
}