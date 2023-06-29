import java.io.*;
import java.util.*;

public class Codeforces
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),m=Integer.parseInt(s[1]),i,j;
        boolean v[][]=new boolean[n][m]; char g[][]=new char[n][m];
        for(i=0;i<n;i++)
        g[i]=bu.readLine().toCharArray();
        for(i=0;i<n-2;i++)
        for(j=0;j<m-2;j++)
        if(possible(g,i,j))
        v[i][j]=v[i][j+1]=v[i][j+2]=v[i+1][j]=v[i+2][j]=v[i+2][j+1]=v[i+2][j+2]=v[i+1][j+2]=true;

        boolean ans=true;
        for(i=0;i<n;i++)
        for(j=0;j<m;j++)
        if(g[i][j]=='#' && !v[i][j]) ans=false;
        if(ans) sb.append("YES");
        else sb.append("NO");
        System.out.print(sb);
    }

    static boolean possible(char g[][],int i,int j)
    {
        int x,y;
        for(x=0;x<3;x++)
        for(y=0;y<3;y++)
        if(x==1 && y==1) continue;
        else if(g[i+x][j+y]=='.') return false;
        return true;
    }
}
