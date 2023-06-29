/**
 * Created by ankeet on 7/22/16.
 */
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C701 {

    static FastReader in = null;
    static PrintWriter out = null;

    public static void solve()
    {
        int n = in.nint();
        String pk = in.next();
        boolean[] occ = new boolean[52];
        for(int i=0; i<n; i++)
        {
            char c = pk.charAt(i);
            int val = Character.isUpperCase(c)?  (int)(c-'A') : (int)(c-'a'+26);
            occ[val] = true;
        }
        int[][] next = new int[n][52];
        for(int i=0; i<n; i++) for(int j=0; j<52; j++) next[i][j] = -1;

        for(int i= n-1; i>=0; i--) {

            char c = pk.charAt(i);
            int val = Character.isUpperCase(c)?  (int)(c-'A') : (int)(c-'a'+26);
            next[i][val] = i;
            if(i<n-1)
            for(int j=0; j<52; j++)
            {
                if(j!=val)
                {
                    next[i][j] = next[i+1][j];
                }
            }

        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++)
        {
            int maxd = 0;
            boolean endearly = false;
            for(int j=0; j<52; j++)
            {
                if(occ[j] && next[i][j] == -1)
                {
                    endearly = true;
                    break;
                }
                else if(occ[j])
                {
                    maxd = Math.max(maxd, next[i][j]-i+1);
                }
            }

            if(endearly) break;
            min = Math.min(min, maxd);
        }

        out.println(min);


    }

    public static void main(String[] args)
    {
        in = new FastReader(System.in);
        out = new PrintWriter(System.out);
        solve();
        out.flush();
        out.close();

    }

    static class FastReader {

        BufferedReader read;
        StringTokenizer tokenizer;

        public FastReader(InputStream in)
        {
            read = new BufferedReader(new InputStreamReader(in));
        }

        public String next()
        {
            while(tokenizer == null || !tokenizer.hasMoreTokens())
            {
                try{
                    tokenizer = new StringTokenizer(read.readLine());
                }catch(Exception e){
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nint()
        {
            return Integer.parseInt(next());
        }
        public long nlong()
        {
            return Long.parseLong(next());
        }
        public double ndouble()
        {
            return Double.parseDouble(next());
        }

        public int[] narr(int n)
        {
            int[] a = new int[n];
            for(int i=0; i<n; ++i)
            {
                a[i] = nint();
            }
            return a;
        }

        public long[] nlarr(int n)
        {
            long[] a = new long[n];
            for(int i=0; i<n; ++i)
            {
                a[i] = nlong();
            }
            return a;
        }
    }


}


