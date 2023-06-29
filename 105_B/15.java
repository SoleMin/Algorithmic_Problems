import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
public class B {

    public static void swap(int[] array, int a, int b) { // {{{
        int t = array[a];
        array[a] = array[b];
        array[b] = t;
    } // }}}

    int n, k, A;
    int[] b;
    int[] l;

    double ans;

    double cal() {
        double total = 0;
        for (int mask=0;mask<(1<<n);mask++) {
            int bit = Integer.bitCount(mask);
            double p = 1;
            for (int i=0;i<n;i++) {
                if ((mask&(1<<i))!=0)
                    p *= l[i]/10.0;
                else 
                    p *= 1.0-l[i]/10.0;
            }

            if (bit*2>n) 
                total += p;
            else {
                int B = 0;
                for (int i=0;i<n;i++) {
                    if ((mask&(1<<i))==0) {
                        B += b[i];
                    }
                }
                total += p*(A/(double)(A+B));
            }
        }
        return total;
    }

    void rec(int d, int remain) {
        ans = max(ans, cal());
        if (remain==0) return;
        for (int i=d;i<n;i++) {
            if (l[i]==10) continue;
            l[i]++;
            rec(i, remain-1);
            l[i]--;
        }
    }

    public B() throws Exception {
        n = in.nextInt();
        k = in.nextInt();
        A = in.nextInt();

        b = new int[n];
        l = new int[n];
        for (int i=0;i<n;i++) {
            b[i] = in.nextInt();
            l[i] = in.nextInt()/10;
        }

        ans = 0;
        rec(0, k);

        System.out.print(ans);
    }

    Scanner in = new Scanner(System.in);
    StringBuilder buf = new StringBuilder();
    public static void main(String[] args) throws Exception { // {{{
        new B();
    } // }}}
    public static void debug(Object... arr) { // {{{
        System.err.println(Arrays.deepToString(arr));
    } // }}}
}
