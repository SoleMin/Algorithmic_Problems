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
            int a[]=new int[n];
            for(int i=0;i<n;i++)
            {
                a[i]=input.nextInt();
            }
            HashMap<Integer,ArrayList<Pair>> map=new HashMap<>();
            for(int i=0;i<n;i++)
            {
                int sum=0;
                for(int j=i;j<n;j++)
                {
                    sum+=a[j];
                    if(map.containsKey(sum))
                    {
                        map.get(sum).add(new Pair(i,j));
                    }
                    else
                    {
                        map.put(sum,new ArrayList<>());
                        map.get(sum).add(new Pair(i,j));
                    }
                }
            }
            int max=Integer.MIN_VALUE;
            Iterator it=map.entrySet().iterator();
            ArrayList<Pair> setBlocks=new ArrayList<>();
            while(it.hasNext())
            {
                Map.Entry e=(Map.Entry)it.next();
                ArrayList<Pair> list=(ArrayList)e.getValue();
                Collections.sort(list, new Comparator<Pair>() {
                    @Override
                    public int compare(Pair o1, Pair o2) {
                        if(o1.l==o2.l)
                        {
                            return o1.r-o2.r;
                        }
                        else
                        {
                            return o1.l-o2.l;
                        }
                    }
                });
                Pair1 sufMin[]=new Pair1[list.size()];
                TreeSet<Pair> set=new TreeSet<>(new Comparator<Pair>() {
                    @Override
                    public int compare(Pair o1, Pair o2) {
                        if(o1.l==o2.l)
                        {
                            return o1.r-o2.r;
                        }
                        else
                        {
                            return o1.l-o2.l;
                        }
                    }
                });
                int min=Integer.MAX_VALUE;
                int index=-1;
                for(int j=list.size()-1;j>=0;j--)
                {
                    if(min>=list.get(j).r)
                    {
                        min=list.get(j).r;
                        index=j;
                    }
                    sufMin[j]=new Pair1(min,index);
                    set.add(new Pair(list.get(j).l,j));
                }
                int count=0;
                int j=0;
                ArrayList<Pair> blocks=new ArrayList<>();
                while(j<list.size())
                {
                    int m=sufMin[j].min;
                    int ind=sufMin[j].index;
                    blocks.add(list.get(ind));
                    count++;
                    Pair p=new Pair(m+1,0);
                    if(set.ceiling(p)==null)
                    {
                        break;
                    }
                    else
                    {
                        Pair p1=set.ceiling(p);
                        j=p1.r;
                    }
                }
                if(max<count)
                {
                    max=count;
                    setBlocks=blocks;
                }
            }
            out.println(max);
            for(int i=0;i<setBlocks.size();i++)
            {
                out.println((setBlocks.get(i).l+1)+" "+(setBlocks.get(i).r+1));
            }
        }
        out.close();
    }
    public static class Pair1
    {
        int min,index;
        Pair1(int min,int index)
        {
            this.min=min;
            this.index=index;
        }
    }
    public static class Pair
    {
        int l,r;
        Pair(int l,int r)
        {
            this.l=l;
            this.r=r;
        }
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
            String str="";
            try
            {
                str=br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}