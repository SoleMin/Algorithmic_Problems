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
            TreeMap<Long,Integer> map=new TreeMap<>();
            for(int i=0;i<n;i++)
            {
                long l=input.nextLong();
                long r=input.nextLong();
                if(map.containsKey(l))
                {
                    map.put(l,map.get(l)+1);
                }
                else
                {
                    map.put(l,1);
                }
                if(map.containsKey(r+1))
                {
                    map.put(r+1,map.get(r+1)-1);
                }
                else
                {
                    map.put(r+1,-1);
                }
            }
            ArrayList<ArrayList<Long>> list=new ArrayList<>();
            Iterator it=map.entrySet().iterator();
            while(it.hasNext())
            {
                Map.Entry e=(Map.Entry)it.next();
                long v=(long)e.getKey();
                long r=(int)e.getValue();
                ArrayList<Long> l=new ArrayList<>();
                l.add(v);
                l.add(r);
                list.add(l);
            }
            for(int i=0;i<list.size();i++)
            {
                if(i!=0)
                {
                    list.get(i).set(1,list.get(i-1).get(1)+list.get(i).get(1));
                }
            }

            long arr[]=new long[n+1];
            for(int i=0;i<list.size()-1;i++)
            {
                long v=list.get(i+1).get(0)-1-list.get(i).get(0)+1;
                long c=list.get(i).get(1);
                arr[(int)c]+=v;
            }
            for(int i=1;i<=n;i++)
            {
                out.print(arr[i]+" ");
            }
            out.println();
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