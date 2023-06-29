import java.io.*;
import java.math.BigInteger;
import static java.math.BigInteger.*;


import java.util.*;

public class Solution{


    void solve()throws Exception
    {

        int n=nextInt();

        int[]a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=nextInt();
        int[]b=a.clone();
        Arrays.sort(b);
        int cnt=0;
        for(int i=0;i<n;i++)
            if(a[i]!=b[i])
                cnt++;
        if(cnt<=2)
            System.out.println("YES");
        else
            System.out.println("NO");






    }

    private boolean sorted(int[] a) {
        for(int i=0;i+1<a.length;i++)
            if(a[i]>a[i+1])
                return false;
        return true;
    }


    ////////////
    BufferedReader reader;
    PrintWriter writer;
    StringTokenizer stk;
    void run()throws Exception
    {

        reader=new BufferedReader(new InputStreamReader(System.in));
        // reader=new BufferedReader(new FileReader("input.txt"));
        stk=null;
        writer=new PrintWriter(new PrintWriter(System.out));
        //writer=new PrintWriter(new FileWriter("output.txt"));
        solve();
        reader.close();
        writer.close();
    }
    int nextInt()throws Exception
    {
        return Integer.parseInt(nextToken());
    }

    long nextLong()throws Exception
    {
        return Long.parseLong(nextToken());

    }
    double nextDouble()throws Exception
    {
        return Double.parseDouble(nextToken());


    }

    String nextString()throws Exception
    {
        return nextToken();
    }
    String nextLine()throws Exception
    {
        return reader.readLine();
    }
    String nextToken()throws Exception
    {
        if(stk==null || !stk.hasMoreTokens())
        {
            stk=new StringTokenizer(nextLine());
            return nextToken();

        }
        return stk.nextToken();
    }

    public static void main(String[]args) throws Exception
    {
        new Solution().run();
    }








}