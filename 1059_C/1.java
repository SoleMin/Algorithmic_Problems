import org.omg.CORBA.INTERNAL;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String args[])
    {
        FastReader input=new FastReader();
        PrintWriter out=new PrintWriter(System.out);
        int T=1;
        while(T-->0)
        {
            int n=input.nextInt();
            HashSet<Integer> set=new HashSet<>();
            for(int i=1;i<=n;i++)
            {
                set.add(i);
            }
            ArrayList<Integer> list=new ArrayList<>();
            int x=0;
            while(set.size()>3)
            {
                int v=(int)Math.pow(2,x);
                int i=1;
                while(true)
                {
                    if(!set.contains(v*i))
                    {
                        break;
                    }
                    else
                    {
                        list.add(v);
                        set.remove(v*i);
                    }
                    i+=2;
                }
                x++;
            }
            if(set.size()==3)
            {
                Iterator it=set.iterator();
                int max=0,min=Integer.MAX_VALUE;
                while(it.hasNext())
                {
                    int v=(int)it.next();
                    max=Math.max(max,v);
                    min=Math.min(min,v);
                }
                list.add(min);
                list.add(min);
                list.add(max);
            }
            else if(set.size()==2)
            {
                Iterator it=set.iterator();
                int max=0,min=Integer.MAX_VALUE;
                while(it.hasNext())
                {
                    int v=(int)it.next();
                    max=Math.max(max,v);
                    min=Math.min(min,v);
                }
                list.add(min);
                list.add(max);
            }
            else
            {
                Iterator it=set.iterator();
                int max=0,min=Integer.MAX_VALUE;
                while(it.hasNext())
                {
                    int v=(int)it.next();
                    max=Math.max(max,v);
                    min=Math.min(min,v);
                }
                list.add(max);
            }
            for(int i=0;i<list.size();i++)
            {
                out.print(list.get(i)+" ");
            }
        }
        out.close();
    }
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
        public FastReader()
        {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt()
        {
            return Integer.parseInt(next());
        }
        long nextLong()
        {
            return Long.parseLong(next());
        }
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}