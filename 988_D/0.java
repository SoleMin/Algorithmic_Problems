import java.io.*;
import java.util.*;

public class Codeforces
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(bu.readLine());
        int i;
        String s[]=bu.readLine().split(" ");
        Long a[]=new Long[n];
        HashMap<Long,Integer> hm=new HashMap<>();
        for(i=0;i<n;i++)
        {
            a[i]=Long.parseLong(s[i]);
            hm.put(a[i],1);
        }
        Arrays.sort(a);

        long p2[]=new long[32];
        p2[0]=1;
        for(i=1;i<32;i++) p2[i]=p2[i-1]*2;

        ArrayList<Long> ans=new ArrayList<>();
        for(i=0;i<31;i++)
        {
            int j;
            for(j=0;j<n;j++)
            {
                ArrayList<Long> tem=new ArrayList<>();
                tem.add(a[j]);
                if(hm.get(a[j]+p2[i])!=null) tem.add(a[j]+p2[i]);
                long cr=a[j]+p2[i];
                if(hm.get(cr+p2[i])!=null) tem.add(cr+p2[i]);
                if(tem.size()>ans.size())
                {
                    ans=new ArrayList<>();
                    for(long x:tem) ans.add(x);
                }
            }
        }
        sb.append(ans.size()+"\n");
        for(long x: ans) sb.append(x+" ");
        System.out.print(sb);
    }
}
