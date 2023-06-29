import java.io.*;
import java.util.*;

public class Codeforces
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),m=Integer.parseInt(s[1]),k=Integer.parseInt(s[2]);
        int i,j,max=n*m,in[][]=new int[n][m],x=0;
        if(k%2==1)  //not possible
        {
            for(i=0;i<n;i++)
            {
                for(j=0;j<m;j++) sb.append("-1 ");
                sb.append("\n");
            }
            System.out.print(sb);
            return;
        }

        for(i=0;i<n;i++)
        for(j=0;j<m;j++) in[i][j]=x++;

        ArrayList<Edge> g[]=new ArrayList[max];
        for(i=0;i<max;i++) g[i]=new ArrayList<>();
        for(i=0;i<n;i++)
        {
            s=bu.readLine().split(" ");
            for(j=0;j<m-1;j++)
            {
                int u=in[i][j],v=in[i][j+1],w=Integer.parseInt(s[j]);
                g[u].add(new Edge(v,w));
                g[v].add(new Edge(u,w));
            }
        }
        for(i=0;i<n-1;i++)
        {
            s=bu.readLine().split(" ");
            for(j=0;j<m;j++)
            {
                int u=in[i][j],v=in[i+1][j],w=Integer.parseInt(s[j]);
                g[u].add(new Edge(v,w));
                g[v].add(new Edge(u,w));
            }
        }

        k/=2;
        int dp[][]=new int[k][max];
        for(i=0;i<max;i++)
        {
            dp[0][i]=Integer.MAX_VALUE;
            for(Edge e:g[i])
            dp[0][i]=Math.min(dp[0][i],2*e.w);
        }

        for(i=1;i<k;i++)
        for(j=0;j<max;j++)
        {
            dp[i][j]=Integer.MAX_VALUE;
            for(Edge e:g[j])
            dp[i][j]=Math.min(dp[i][j],dp[i-1][e.v]+2*e.w);
        }

        for(i=0;i<n;i++)
        {
            for(j=0;j<m;j++)
            sb.append(dp[k-1][in[i][j]]+" ");
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static class Edge
    {
        int v,w,d;
        Edge(int a,int b)
        {
            v=a;
            w=b;
            d=0;
        }
    }
}