import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
public class A {

    public A() throws Exception {
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++) 
            arr[i] = in.nextInt();

        if (n==1&&arr[0]==1) {
            System.out.println(2); 
            return;
        } 

        Arrays.sort(arr);
        if (arr[n-1]==1)
            arr[n-2] = 2;
        buf.append(1);
        for (int i=0;i<n-1;i++) 
            buf.append(' ').append(arr[i]);
        buf.append('\n');
        System.out.print(buf);
    }

    Scanner in = new Scanner(System.in);
    StringBuilder buf = new StringBuilder();
    public static void main(String[] args) throws Exception { // {{{
        new A();
    } // }}}
    public static void debug(Object... arr) { // {{{
        System.err.println(Arrays.deepToString(arr));
    } // }}}
}
