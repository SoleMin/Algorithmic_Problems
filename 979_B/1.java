import java.io.*;
import java.util.*;

public class Codeforces
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(bu.readLine());
        String a=bu.readLine(),b=bu.readLine(),c=bu.readLine();
        int l=a.length();
        int a1=getmax(a,n),b1=getmax(b,n),c1=getmax(c,n);
        if(a1>b1 && a1>c1) sb.append("Kuro");
        else if(b1>a1 && b1>c1) sb.append("Shiro");
        else if(c1>a1 && c1>b1) sb.append("Katie");
        else sb.append("Draw");
        System.out.print(sb);
    }

    static int getmax(String s,int n)
    {
        int i,l=s.length(),c[]=new int[256];
        for(i=0;i<l;i++)
        c[s.charAt(i)]++;

        int max=0;
        for(i=0;i<256;i++)
        max=Math.max(c[i],max);
        //System.out.println(max);
        if(n>l-max)
        {
            if(max==l && n==1 && l!=1) max--;  //we cant have n only if all characters are equal and we must make 1 move
            else max=l;
        }
        else max+=n;
        //System.out.println(max);
        return max;
    }
}