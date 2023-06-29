import java.lang.Math;
import java.io.*;    
import java.util.*;
 
public class Main {
        
        static BufferedReader in;
        static PrintStream out;
        static StringTokenizer tok;
        
        @SuppressWarnings("empty-statement")
	public static void main(String[] args) throws NumberFormatException, IOException, Exception {
            in = new BufferedReader(new InputStreamReader(System.in));
            //in = new BufferedReader(new FileReader("metro.txt"));
            out = System.out;
            
            long mod = (long)1e9 + 7;
            int n = nextInt();
            long[][] dp = new long[n+1][n+1];
            Character[] line = new Character[n+1];
            line[0] = 'a';
            for (int i = 1; i <= n; i++) {
                line[i] = nextToken().charAt(0);
                if(line[i-1] == 'f')//for
                {
                    for (int j = 0; j < i; j++) {
                        dp[i][j+1] = dp[i-1][j];
                    }
                }
                else if(line[i-1] == 's')//simple
                {
                    long temp = 0;
                    for(int j = i; j >=0; j--)
                    {
                        temp = (temp + dp[i-1][j]) % mod;
                        dp[i][j] = temp;
                    }
                }
                else dp[i][0] = 1;
            }
            long total = 0;
            for(int j = 0; j <= n; j++)
                total = (total + dp[n][j]) % mod;
            out.println(total);
        }
        static String nextToken() throws IOException
        {
                String line = "";
                while(tok == null || !tok.hasMoreTokens()) {
                        if((line = in.readLine()) != null)
                                tok = new StringTokenizer(line);
                        else 
                                return null;
                }
                return tok.nextToken();
        }
        static int nextInt() throws NumberFormatException, IOException
        {
                return Integer.parseInt(nextToken());
        }
        static long nextLong() throws NumberFormatException, IOException
        {
                return Long.parseLong(nextToken());
        }

}