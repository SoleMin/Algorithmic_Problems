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
            String s[]=bu.readLine().split(" ");
            HashMap<Integer,Integer> hm=new HashMap<>();
            ArrayList<Integer> sides=new ArrayList<>();
            int i,x;
            for(i=0;i<n;i++)
            {
                x=Integer.parseInt(s[i]);
                hm.put(x,hm.getOrDefault(x,0)+1);
            }
            for(int y:hm.keySet())
            if(hm.get(y)>1)
            {
                sides.add(y);
                if(hm.get(y)>3) sides.add(y);
            }
            Collections.sort(sides);
            double min=Integer.MAX_VALUE; int minp=1;
            for(i=1;i<sides.size();i++)
            {
                int l=sides.get(i),r=sides.get(i-1);
                double v=1.0*l/r+1.0*r/l;
                if(v<min)
                {
                    min=v;
                    minp=i;
                }
            }
            int a1=sides.get(minp),a2=sides.get(minp-1);
            sb.append(a1+" "+a1+" "+a2+" "+a2+"\n");
        }
        System.out.print(sb);
    }
}
