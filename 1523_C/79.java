/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
    /*static long power(long a,long b,long m)
    {
        if(b==0)
        return 1;
        if((b&1)==0)
        return power((a*a)%m,b/2,m);
        else
        return (a*power((a*a)%m,b/2,m))%m;
    }*/
    /*
    static int gcd(int a,int b)
    {
        if(b==0)
        return a;
        else
        return gcd(b,a%b);
    }
    */
    public static void main (String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        PrintWriter p=new PrintWriter(System.out);
        while(t-->0)
        {
            //StringTokenizer st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(br.readLine());
            String a[]=new String[n];
            for(int i=0;i<n;i++)
            {
                a[i]=br.readLine();
            }
            String pre="1";
            for(int i=1;i<n;i++)
            {
                if(a[i].equals("1"))
                {
                    a[i]=pre+".1";
                    pre=a[i];
                    continue;
                }
                int li=pre.lastIndexOf('.');
                while(li!=-1 && Integer.parseInt(pre.substring(li+1))+1!=Integer.parseInt(a[i]))
                {
                    pre=pre.substring(0,li);
                    li=pre.lastIndexOf('.');
                }
                //li=pre.lastIndexOf('.');
                if(li!=-1)
                a[i]=pre.substring(0,li+1)+a[i];
                pre=a[i];
            }
            for(int i=0;i<n;i++)
            {
                p.println(a[i]);
            }
            p.flush();
        }
	}
}
