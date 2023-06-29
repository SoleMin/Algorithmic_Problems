// Created by Whiplash99
import java.io.*;
import java.util.*;
public class A
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        long N,K,tmp,ans=0;

        String s[]=br.readLine().trim().split(" ");
        N=Long.parseLong(s[0]);
        K=Long.parseLong(s[1]);

        long l=1,r=N,mid;

        while(l<=r)
        {
            mid=(l+r)/2;

            tmp=mid*(mid+1)/2;
            tmp-=N;
            tmp+=mid;

            if(tmp==K)
            {
                ans=N-mid;
                break;
            }
            else if(tmp>K)
                r=mid-1;
            else
                l=mid+1;
        }
        System.out.println(ans);
    }
}