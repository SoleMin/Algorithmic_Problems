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
            int m[]=new int[n];
            long sum=0;
            ArrayList<Integer> list=new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                m[i]=input.nextInt();
                list.add(m[i]+1);
                sum+=m[i];
            }
            int max=0;
            for(int i=0;i<n;i++)
            {
                int v=list.get(i);
                max=Math.max(max,v);
                list.set(i,max);
            }
            for(int i=n-2;i>=0;i--)
            {
                if(list.get(i+1)-list.get(i)>1)
                {
                    list.set(i,list.get(i+1)-1);
                }
            }
            long s1=0;
            for(int i=0;i<list.size();i++)
            {
                s1+=list.get(i);
            }
            out.println(s1-sum-n);
        }
        out.close();
    }
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
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