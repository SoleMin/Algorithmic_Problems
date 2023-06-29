import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A
{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;

    private void solve() throws IOException
    {
        int n = nextInt();
        int k = nextInt();
        int p[] = new int[n];
        int t[] = new int[n];
        for(int i = 0; i < n; i++)
        {
            p[i] = nextInt();
            t[i] = nextInt();
        }
        
        for(int i = 0; i < n; i++)
        {
            for(int j = i + 1; j < n; j++)
            {
                if(p[i] < p[j] || (p[i] == p[j] && t[i] > t[j]))
                {
                    int tmp = p[i];
                    p[i] = p[j];
                    p[j] = tmp;
                    tmp = t[i];
                    t[i] = t[j];
                    t[j] = tmp;
                }
            }
            
        }
        
        int pN = p[k - 1];
        int tN = t[k - 1];
        int counter = 0;
        for(int i = 0; i < n; i++)
        {
            if(p[i] == pN && t[i] == tN)
            {
                counter++;
            }
            
        }
        
        System.out.println(counter);
    }

    String nextToken() throws IOException
    {
        if (st == null || !st.hasMoreTokens())
        {
            st = new StringTokenizer(bf.readLine());
        }
        
        return st.nextToken();
    }

    int nextInt() throws IOException
    {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException
    {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException
    {
        return Double.parseDouble(nextToken());
    }

    public static void main(String args[]) throws IOException
    {
        new A().solve();
    }
    
}