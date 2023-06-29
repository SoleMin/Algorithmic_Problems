import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author c0der
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }
}

class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[ n ];
        for (int i=0; i<n; i++) a[i] = in.nextInt();

        if ( m <= k ) out.println( 0 );
        else
        {
            m -= k - 1;
            Arrays.sort( a );
            int ans = 0;
            for (int i=n-1; i>=0; i--)
            {
                ans++;
                //out.println(m+" "+a[i]);
                m -= a[ i ];
                if ( m <= 0 ) break;
                m++;
            }
            if ( m > 0 ) out.println( -1 );
            else out.println( ans );
        }
    }
}

class InputReader {
    BufferedReader br;
    StringTokenizer st;

    public InputReader(InputStream in)
    {
        br = new BufferedReader(new InputStreamReader(in));
        st = null;
    }

    public String next()
    {
        while (st==null || !st.hasMoreTokens())
        {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return st.nextToken();
    }

    public int nextInt()
    {
        return Integer.parseInt(next());
    }
}
