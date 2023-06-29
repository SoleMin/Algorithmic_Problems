import java.io.*;
import java.util.*;

public class Solution{

    public static void main(String arg[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n,m,k;
        String str[]=br.readLine().split(" ");
        n=Long.parseLong(str[0]);
        m=Long.parseLong(str[1]);
        k=Long.parseLong(str[2]);
        long[] p = Arrays.stream(br.readLine().
                                split("\\s+")).mapToLong(Long::valueOf).toArray();
        long operations=0,start=0,sub=0,k2=k;
        while(start<p.length)
        {
            long i=0;
            while(start+i<p.length && p[(int)(start+i)]-sub<=k2)
                i++;
            start+=i;sub+=i;
            //System.out.print(start+" "+k2+"  || ");
            if(i==0)
            { 
                long x=p[(int)(start)]-sub;
                k2=((x- (x%k) )+ k);
                if(x%k == 0) 
                    k2-=k;
                continue;
            }
            operations++;
            
        }
        System.out.println(operations);

    }
}