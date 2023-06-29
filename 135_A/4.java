import javax.sound.sampled.Line;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.io.*;
import java.math.BigInteger;
import static java.math.BigInteger.*;
import java.util.*;
public class A{


    void solve()throws Exception
    {
      int n=nextInt();
      int[]a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=nextInt();
        Arrays.sort(a);
        int[]res=new int[n];
        for(int i=0;i<n;i++)
        {
            if(i==0)
                res[i]=1;
            else
                res[i]=a[i-1];
        }
        if(a[n-1]==1)
            res[n-1]=2;
        for(int i=0;i<n;i++)
        {
            if(i==n-1)
                writer.println(res[i]);
            else
                writer.print(res[i]+" ");

        }


    }
     ////////////
    BufferedReader reader;
    PrintWriter writer;
    StringTokenizer stk;
    void run()throws Exception
    {
        reader=new BufferedReader(new InputStreamReader(System.in));
        stk=null;
        writer=new PrintWriter(new PrintWriter(System.out));
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
        new A().run();
    }



}