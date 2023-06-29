import java.io.*;
import java.util.*;

public class Codeforces
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),r=Integer.parseInt(s[1]);
        double ans[]=new double[n];
        int i,x[]=new int[n],j;
        s=bu.readLine().split(" ");
        for(i=0;i<n;i++)
        {
            x[i]=Integer.parseInt(s[i]);
            ans[i]=r;
            for(j=0;j<i;j++)
            {
                int t=x[i]-x[j];
                if(t*t<=4*r*r) ans[i]=Math.max(ans[i],ans[j]+Math.sqrt(4*r*r-t*t));
            }
            sb.append(ans[i]+" ");
        }
        System.out.print(sb);
    }
}
