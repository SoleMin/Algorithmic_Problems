import java.io.*;
import java.util.*;
import java.math.*;


public class Solution
{
    public static void main(String[] args) throws IOException
    {
        new Solution().run();
    }
    StreamTokenizer in; 
    Scanner ins;
    PrintWriter out;
    
    int nextInt() throws IOException
    {
        in.nextToken();      
        return (int)in.nval;
    }
   

    void run() throws IOException
    {

        if(System.getProperty("ONLINE_JUDGE")!=null)
        {
            in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
            ins = new Scanner(System.in);
            out = new PrintWriter(System.out);
        }
        else
        {           
            in = new StreamTokenizer(new BufferedReader(new FileReader("input.txt")));             
            ins = new Scanner(new FileReader("input.txt"));
            out = new PrintWriter(new FileWriter("output.txt"));
        }
        int n = nextInt(),a = nextInt(),b = nextInt();
        b--;
        int [] A = new int[n];
        for(int i = 0; i < n ;i++)
        {
            A[i] = nextInt();
        }
        Arrays.sort(A);
        if(A[b] == A[b+1])
            out.print(0);
        else
            out.print(A[b+1]- A[b]);
        out.close();
    }
    
    
    class Team implements Comparable
    {
        public int p,t;
        public int compareTo(Object obj)
        {
            Team a = (Team) obj;
            if(p>a.p || p==a.p && t<a.t)                          
                return -1;
            else                
                if(p==a.p && t==a.t)
                    return 0;
                else
                    return 1;
        }
        
    }
}