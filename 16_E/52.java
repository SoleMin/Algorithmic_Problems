import java.io.*;
import java.util.*;
import static java.util.Arrays.*;

public class E implements Runnable
{
    public static void main(String[] args) throws IOException
    {
        new Thread(null, new E(), "", 1 << 20).start();
    }   
    
    BufferedReader input;
    PrintWriter out;
    String file = "input";
    
    public void run()
    {
        try
        {
            //input = new BufferedReader(new FileReader(file + ".in"));
            input = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(new BufferedOutputStream(System.out));
            solve();
            
            out.close();    
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    void solve() throws IOException
    {
        int n = Integer.parseInt(input.readLine());
        double[][] p = new double[n][n];
        for(int i = 0; i < n; i++)
        {
            StringTokenizer st = new StringTokenizer(input.readLine());
            for(int j = 0; j < n; j++) 
            {
                p[i][j] = Double.parseDouble(st.nextToken());
            }
        }
        double[] dp = new double[1 << n];
        int mask = (1 << n) - 1;
        dp[mask] = 1;
        for(int w = mask; w > 0; w--)
        {
            int count = 0;
            for(int i = 0; i < n; i++)
                for(int j = i + 1; j < n; j++)
                    if((w >> i & 1) != 0 && (w >> j & 1) != 0) count++;
            
            if(count == 0) continue;
            for(int i = 0; i < n; i++)
                for(int j = i + 1; j < n; j++)
                    if((w >> i & 1) != 0 && (w >> j & 1) != 0)
                    {
                        dp[w ^ (1 << i)] += 1.0 / count * p[j][i] * dp[w];
                        dp[w ^ (1 << j)] += 1.0 / count * p[i][j] * dp[w];
                    }
        }
        for(int i = 0; i < n; i++)
            System.out.print(dp[1 << i] + " ");
            
    }
}