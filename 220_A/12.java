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
        for (int i=0; i<n; i++) arr[i] = in.nextInt();
        int[] arr2 = arr.clone();
        Arrays.sort(arr2);
        int diff = 0;
        for (int i=0; i<n; i++) {
            if (arr2[i]!=arr[i]) diff++;
        }
        if (diff<=2) System.out.println("YES");
        else System.out.println("NO"); 
    }

    Scanner in = new Scanner(System.in);
    StringBuilder buf = new StringBuilder();
    public static void main(String[] args) throws Exception { // {{{
        new A();
    } // }}}
    public static void debug(Object... arr) { // {{{
        System.err.println(Arrays.deepToString(arr));
    } // }}}
    public static class Scanner { // {{{
        BufferedReader br;
        String line;
        StringTokenizer st;
        public Scanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }
        public boolean hasNext() throws IOException {
            while ((st==null||!st.hasMoreTokens())&&(line=br.readLine())!=null)
                st = new StringTokenizer(line);
            return st.hasMoreTokens();
        }
        public String next() throws IOException {
            if (hasNext()) return st.nextToken();
            throw new NoSuchElementException();
        }
        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }
        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    } // }}}
}
