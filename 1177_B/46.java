import java.util.*;
import java.io.*;
public class A
{
      public static void main(String ar[]) throws Exception
      {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            long k=Long.parseLong(br.readLine());
            long l=1,h=1000000000000l;
            long p[]=new long[13];
            for(int i=1;i<=12;i++)
            {
                  long ll=9*i;
                  p[i]=ll*(long)Math.pow(10,i-1);
                  p[i]+=p[i-1];
            }
            while(h-l>1)
            {
                  long mid=(l+h)/2;
                  long num=(long)(Math.log(mid)/Math.log(10));
                  long l1=p[(int)num]+(num+1)*(mid-(long)Math.pow(10,num));
                  long l2=p[(int)num]+(num+1)*(mid-(long)Math.pow(10,num)+1);
                  if(k<=l1)
                   h=mid;
                  else if(k>l2)
                   l=mid;
                  else
                  { l=mid; h=mid; }
            }
            
            if(h-l==1)
            { 
                long num=(long)(Math.log(h)/Math.log(10));
                long l1=p[(int)num]+(num+1)*(h-(long)Math.pow(10,num));
                long l2=p[(int)num]+(num+1)*(h-(long)Math.pow(10,num)+1);
                if(k>l1 && k<=l2)
                { l=h; }
            }
            
            long n=(long)(Math.log(l)/Math.log(10));
            long u=p[(int)n]+(n+1)*(l-(long)Math.pow(10,n));
            k-=u;
            String ss=String.valueOf(l);
            //System.out.println(l+" "+k);
            System.out.println(ss.charAt((int)(k-1)));
      }
}