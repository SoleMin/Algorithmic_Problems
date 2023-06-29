import java.io.*;
import java.util.*;

public class Codeforces
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int i,n=Integer.parseInt(bu.readLine());
        if(n<6) sb.append("-1\n");
        else
        {
            int used=2;
            for(i=0;i<n-3;i++,used++)
            sb.append("1 "+used+"\n");
            for(i=0;i<2;i++,used++)
            sb.append("2 "+used+"\n");
        }
        for(i=2;i<=n;i++)
        sb.append("1 "+i+"\n");
        System.out.print(sb);
    }
}
