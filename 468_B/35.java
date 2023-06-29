import java.util.List;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Random;
import java.io.Reader;
import java.io.Writer;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Nipuna Samarasekara
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		FastScanner in = new FastScanner(inputStream);
		FastPrinter out = new FastPrinter(outputStream);
		TaskB solver = new TaskB();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskB {
    /////////////////////////////////////////////////////////////
    static nn[] B;
    static int n,a,b;
    public void solve(int testNumber, FastScanner in, FastPrinter out) {
     n=in.nextInt();a=in.nextInt();b=in.nextInt();
        int ccc=0;
        if (a==b)ccc=1;
     int[] A=in.readIntArray(n);
      B=new nn[n];
        for (int i = 0; i < n; i++) {
            B[i]=new nn(A[i],i);
        }
        ArrayUtils.shuffle(B);
        Arrays.sort(B);
        int chk=1;
        for (int i = 0; i < n; i++) {
            if (B[i].assign>=0)continue;
            int v=B[i].val;
            int cc=0;
            int pos1=Arrays.binarySearch(B,new nn(a-v,0));
            if (pos1>=0&&B[pos1].assign==-1)cc++;
           if (a!=b){
            int pos2=Arrays.binarySearch(B,new nn(b-v,0));
            if (pos2>=0&&B[pos2].assign==-1)cc++; }
            if (cc==0){
                chk=0;
                break;
            }
            if (cc==1){
            go(i);
            }
        }
        if (chk==0){
            out.println("NO");
            return;
        }
        int[] ans= new int[n];
        for (int i = 0; i < n; i++) {
            ans[B[i].pos]=B[i].assign;
        }
        out.println("YES");
        for (int i = 0; i < n; i++) {
          out.print(ans[i] + " ");
        }
        out.println();
        }
    static void go (int i){
        int v=B[i].val;
        int pos1=Arrays.binarySearch(B,new nn(a-v,0));
        if (pos1>=0&&B[pos1].assign==-1){
           B[i].assign=0;
           B[pos1].assign=0;
           int vv=B[pos1].val;
           int np=Arrays.binarySearch(B,new nn(b-vv,0));
           if (np>=0)go(np);

        }
        if (a!=b){
        int pos2=Arrays.binarySearch(B,new nn(b-v,0));
        if (pos2>=0&&B[pos2].assign==-1){
            B[i].assign=1;
            B[pos2].assign=1;
            int vv=B[pos2].val;
            int np=Arrays.binarySearch(B,new nn(a-vv,0));
            if (np>=0)go(np);
        } }

    }

}

class nn implements Comparable<nn> {
        int val,pos;

        public String toString() {
            return "nn{" +
                    "val=" + val +
                    ", pos=" + pos +
                    ", assign=" + assign +
                    ", ct=" + ct +
                    '}';
        }

        int assign=-1;
        int ct=0;
        nn(int val, int pos) {
            this.val = val;
            this.pos = pos;
        }

        public int compareTo(nn o) {
            return this.val-o.val;  //To change body of implemented methods use File | Settings | File Templates.
        }

}

class FastScanner extends BufferedReader {

    public FastScanner(InputStream is) {
        super(new InputStreamReader(is));
    }

    public int read() {
        try {
            int ret = super.read();
//            if (isEOF && ret < 0) {
//                throw new InputMismatchException();
//            }
//            isEOF = ret == -1;
            return ret;
        } catch (IOException e) {
            throw new InputMismatchException();
        }
    }

    static boolean isWhiteSpace(int c) {
        return c >= 0 && c <= 32;
    }

    public int nextInt() {
        int c = read();
        while (isWhiteSpace(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int ret = 0;
        while (c >= 0 && !isWhiteSpace(c)) {
            if (c < '0' || c > '9') {
                throw new NumberFormatException("digit expected " + (char) c
                        + " found");
            }
            ret = ret * 10 + c - '0';
            c = read();
        }
        return ret * sgn;
    }

    public String readLine() {
        try {
            return super.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    public int[] readIntArray(int n) {
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = nextInt();
        }
        return ret;
    }

}

class FastPrinter extends PrintWriter {

    public FastPrinter(OutputStream out) {
        super(out);
    }

    public FastPrinter(Writer out) {
        super(out);
    }


}

class ArrayUtils {


    static final long seed = System.nanoTime();

    static final Random rand = new Random(seed);


    public static <T> void shuffle(T[] a) {
        for (int i = 0; i < a.length; i++) {
            int j = rand.nextInt(i + 1);
            T t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
    }

}

