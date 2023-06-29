import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author ocelopilli
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
        long k = in.nextLong();
        long[] a = new long[n];
        for (int i=0; i<n; i++) a[i] = in.nextInt();
        Arrays.sort( a );
        boolean[] ok = new boolean[ n ];
        Arrays.fill( ok, true );
        if (k > 1) for (int i=0; i<n; i++)
        {
            if ( ok[i] == false ) continue;
            int pos = Arrays.binarySearch( a, a[i]*k );
            if ( pos >= 0 )
            {
                //out.println( a[i]+" "+a[pos] );
                ok[ pos ] = false;
            }
        }
        int ans = 0;
        for (boolean x : ok) if ( x ) ans++;
        out.println( ans );
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

    public long nextLong()
    {
        return Long.parseLong(next());
    }
}
