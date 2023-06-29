import java.io.*;
import java.util.*;

public class Codeforces
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine());
            int cur[]=new int[n],i,cr=-1;
            for(i=0;i<n;i++)
            {
                int j,d=Integer.parseInt(bu.readLine()),f=-1;
                for(j=cr;j>=0;j--)
                if(cur[j]==d-1) {f=j; break;}

                if(f==-1)
                {
                    cr++;
                    f=cr;
                }
                cur[f]=d;
                cr=f;
                for(j=f+1;j<n;j++) cur[j]=0;
                sb.append(cur[0]);
                for(j=1;j<n;j++)
                if(cur[j]==0) break;
                else sb.append("."+cur[j]);
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}
