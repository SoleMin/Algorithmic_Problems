import java.io.*;
import java.util.*;

public class Codeforces
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(bu.readLine());
        ArrayList<Integer> g[]=new ArrayList[n+1];
        int i;
        for(i=0;i<=n;i++) g[i]=new ArrayList<>();

        for(i=0;i<n-1;i++)
        {
            String s[]=bu.readLine().split(" ");
            int u=Integer.parseInt(s[0]),v=Integer.parseInt(s[1]);
            g[u].add(v);
            g[v].add(u);
        }
        g[1].add(1);
        ArrayList<Integer> al=new ArrayList<>();
        boolean vis[]=new boolean[n+1];
        int a[]=new int[n];
        String s[]=bu.readLine().split(" ");
        for(i=0;i<n;i++)
        a[i]=Integer.parseInt(s[i]);
        if(a[0]!=1) {System.out.print("No"); return;}

        i=1;
        vis[1]=true;
        al.add(1);
        boolean pos=true;
        while(!al.isEmpty())
        {
            ArrayList<Integer> nal=new ArrayList<>();
            for(int x:al)
            {
                int ch=g[x].size()-1,j;
                for(j=0;j<ch;j++)
                {
                    vis[a[i]]=true;
                    nal.add(a[i++]);
                }

                for(int y:g[x])
                if(!vis[y]) {pos=false; break;}
                if(!pos) break;
            }
            if(!pos) break;
            al=nal;
        }
        if(pos) sb.append("Yes\n");
        else sb.append("No\n");
        System.out.print(sb);
    }
}