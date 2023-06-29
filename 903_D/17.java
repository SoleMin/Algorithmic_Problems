/*
 * PDPM IIITDM Jabalpur
 * Asutosh Rana
 */

import java.util.*;
import java.io.*;
import java.math.*;

public class Main
{
    long MOD = 1000000007;
    InputReader in;BufferedReader br;PrintWriter out;
    public static void main (String[] args) throws java.lang.Exception
    {
        Main solver = new Main();
        solver.in = new InputReader(System.in);
        solver.br = new BufferedReader(new InputStreamReader(System.in));
        solver.out = new PrintWriter(System.out);
        solver.solve();
        solver.out.flush();
        solver.out.close();
    }

    public void solve(){
        
        int tc = 1;//in.readInt();
        
        for(int cas=1;cas<=tc;cas++){
            int N = in.readInt();
            int[] A = new int[N];
            in.readInt(A);
            
            HashMap<Integer, Integer> H = new HashMap<>();
            long sum = A[0], count = 1;
            BigInteger B = BigInteger.ZERO;
            H.put(A[0], 1);
            for(int i=1;i<N;i++){
                // res = res + (count*A[i] - sum);
                B = B.add(BigInteger.valueOf(count*A[i]-sum));
                if(!H.containsKey(A[i]))
                    H.put(A[i], 0);
                H.put(A[i], H.get(A[i])+1);

                if(H.containsKey(A[i]-1)){
                    int k = H.get(A[i]-1);
                    // res = res + (k*(A[i]-1) - k*A[i]);
                    B = B.add(BigInteger.valueOf((k*(A[i]-1) - k*A[i])));
                }
                if(H.containsKey(A[i]+1)){
                    int k = H.get(A[i]+1);
                    B = B.add(BigInteger.valueOf((k*(A[i]+1) - k*A[i])));
                    // res = res + (k*(A[i]+1) - k*A[i]);
                }
                // out.println(res);
                sum+=A[i];count++;
            }
            // out.println("-1");
            out.println(B);


        }

    }
    
}
 
class InputReader{
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;

    public InputReader(InputStream stream){this.stream = stream;}
    public int read(){
        if (numChars==-1) throw new InputMismatchException();
        if (curChar >= numChars){
            curChar = 0;
            try {numChars = stream.read(buf);}
            catch (IOException e){throw new InputMismatchException();}
            if(numChars <= 0) return -1;
        }
        return buf[curChar++];
    }

    public int readInt(){
        int c = read();
        while(isSpaceChar(c)) c = read();
        int sgn = 1;
        if (c == '-') {sgn = -1;c = read();}
        int res = 0;
        do {
            if(c<'0'||c>'9') throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        }
        while (!isSpaceChar(c)); return res * sgn;
    }

    public void readInt(int[] A){
        for(int i=0;i<A.length;i++)
            A[i] = readInt();
    }

    public long readLong() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        }
        while (!isSpaceChar(c));
        return res * sgn;
    }

    public void readLong(long[] A){
        for(int i=0;i<A.length;i++)
            A[i] = readLong();
    }

    public double readDouble() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        double res = 0;
        while (!isSpaceChar(c) && c != '.') {
            if (c == 'e' || c == 'E')
                return res * Math.pow(10, readInt());
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        }
        if (c == '.') {
            c = read();
            double m = 1;
            while (!isSpaceChar(c)) {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, readInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                m /= 10;
                res += (c - '0') * m;
                c = read();
            }
        }
        return res * sgn;
    }

    public char[] readCharA(){
        return readString().toCharArray();
    }

    public String readString() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    public boolean isSpaceChar(int c) {
        if (filter != null)
            return filter.isSpaceChar(c);
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public String next() {
        return readString();
    }

    public interface SpaceCharFilter {
        public boolean isSpaceChar(int ch);
    }

}