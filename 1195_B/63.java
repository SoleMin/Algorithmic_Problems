import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Cf2 {

    static boolean ok(long n, long k, long eatten) {
        long moves = n-eatten;
        long ans = moves*(moves+1)/2;
        ans -= eatten;
        return ans <= k;
    }

    public static void main(String[] args) {
        FastReader in = new FastReader();
        long n = in.nextInt();
        long k = in.nextInt();
        long left = 0, right = n;
        while (left <= right) {
            long middle = (left+right)/2;
            if (ok(n, k, middle)) right = middle-1;
            else left=middle+1;
        }
        System.out.println(left);
    }

    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}
