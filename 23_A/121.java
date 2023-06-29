import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;



 

public class Main{
    private static Parser in;
    private static PrintWriter out;
    
    public static void main(String[] args){
        in = new Parser(System.in);
        out = new PrintWriter(System.out);
        
//        
//        char[] ccc = new char[1];
//        String ddd = "abcdef";
//        ddd.getChars(2, 3, ccc, 0);
//        
//        String sssss = new String(ccc);
//      
//        System.out.println(sssss);
//        
        String s = in.nextString(100);
        int len = 0;
        String ss = "";
        
       
        l:for (int i = 1; i<=s.length(); i++){
            for(int j = 0; j+i<=s.length();j++){
                char[] c = new char[i];
                char[] cc = new char[i];
                s.getChars(j, j+i, c, 0);
                String sss = new String(c);
                //System.out.println(sss);
                for(int k = j+1; k+i<=s.length();k++){
                     
                    s.getChars(k, k+i, cc, 0);
                    String ssss = new String(cc);
                    if(sss.equals(ssss)) {len = i; continue l;}
                }
            }
        }
        
        
        System.out.println(len);
       // out.flush();
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