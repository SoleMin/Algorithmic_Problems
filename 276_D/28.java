import java.io.InputStreamReader;
import java.io.IOException;
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
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }
}

class TaskD {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        long LL = in.nextLong();
        long RR = in.nextLong();

        long L = LL;
        long R = RR;
        long ans = 0L;
        long X = Long.highestOneBit( R );
        while ( X > 0L && (L & X) == (R & X) ) X >>= 1;
        while ( X > 0L )
        {
            long a = L & X;
            long b = R & X;
            if ( (a ^ b) == X ) ans |= X;
            else
            {
                if ( b == 0L )
                {
                    if ( (R | X) <= RR )
                    {
                        R |= X;
                        ans |= X;
                    }
                    else if ( (L | X) <= RR )
                    {
                        L |= X;
                        ans |= X;
                    }
                }
                else
                {
                    if ( (L ^ X) >= LL )
                    {
                        L ^= X;
                        ans |= X;
                    }
                    else if ( (R ^ X) >= LL )
                    {
                        R ^= X;
                        ans |= X;
                    }
                }
            }
            X >>= 1;
        }
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

    public long nextLong()
    {
        return Long.parseLong(next());
    }
}
