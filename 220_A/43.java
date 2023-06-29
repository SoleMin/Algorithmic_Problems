import java.io.IOException;
import java.util.Arrays;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Random;
import java.util.NoSuchElementException;
import java.util.TreeSet;
import java.util.Collection;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        MyScanner in = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }
}

class TaskA {
    public void solve(int testNumber, MyScanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] as = new int[n];
        for (int i = 0; i < n; i++) as[i] = in.nextInt();
        int[] sorted = as.clone();
        ArrayUtils.sort(sorted);
        int diff = 0;
        for (int i = 0; i < n; i++)if(as[i]!=sorted[i])diff++;
        if(diff<=2)out.println("YES");
        else out.println("NO");
    }
}

class MyScanner {
    private final InputStream in;
    public MyScanner(InputStream in){
        this.in = in;
    }

    public int nextInt(){
        try{
            int c=in.read();
            if(c==-1) return c;
            while(c!='-'&&(c<'0'||'9'<c)){
                c=in.read();
                if(c==-1) return c;
            }
            if(c=='-') return -nextInt();
            int res=0;
            do{
                res*=10;
                res+=c-'0';
                c=in.read();
            }while('0'<=c&&c<='9');
            return res;
        }catch(Exception e){
            return -1;
        }
    }


    }

class ArrayUtils {

    public static void swap(int[] is, int i, int j) {
        int t = is[i];
        is[i] = is[j];
        is[j] = t;
    }

    public static void shuffle(int[] S) {
        Random rnd = r == null ? (r = new Random()) : r;
        shuffle(S, rnd);
    }

    private static Random r;
    private static void shuffle(int[] S, Random rnd) {
        for (int i = S.length; i > 1; i--)
            swap(S, i - 1, rnd.nextInt(i));
    }


    public static void sort(int[] a) {
        shuffle(a);
        Arrays.sort(a);
    }
}
