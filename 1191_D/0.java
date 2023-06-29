import java.io.*;
import java.util.*;
public class Main {
    public static void main(String args[])
    {
        long start=System.currentTimeMillis();
        FastReader input=new FastReader();
        PrintWriter out=new PrintWriter(System.out);
        int T=1;
        while(T-->0)
        {
            int n=input.nextInt();
            long sum=0;
            HashMap<Integer,Integer> map=new HashMap<>();
            for(int i=0;i<n;i++)
            {
                int a=input.nextInt();
                if(map.containsKey(a))
                {
                    map.put(a,map.get(a)+1);
                }
                else
                {
                    map.put(a,1);
                }
                sum+=(long)a;
            }
            long s=(long)n*(n-1)/2;
            if(map.size()==n)
            {
                sum-=s;
                if(sum%2==0)
                {
                    out.println("cslnb");
                }
                else
                {
                    out.println("sjfnb");
                }
            }
            else
            {
                Iterator it=map.entrySet().iterator();
                int c=0;
                int flag=0;
                int x=0;
                while(it.hasNext())
                {
                    Map.Entry e=(Map.Entry)it.next();
                    int r=(int)e.getValue();
                    if(r>2)
                    {
                        flag=1;
                        break;
                    }
                    else if(r==2)
                    {
                        x=(int)e.getKey();
                        c++;
                    }
                }
                if(c>1)
                {
                    flag=1;
                }
                if(flag==1)
                {
                    out.println("cslnb");
                }
                else
                {
                    if(x==0)
                    {
                        out.println("cslnb");
                    }
                    else if(map.containsKey(x-1))
                    {
                        out.println("cslnb");
                    }
                    else
                    {
                        sum--;
                        sum-=s;
                        if(sum%2==0)
                        {
                            out.println("sjfnb");
                        }
                        else
                        {
                            out.println("cslnb");
                        }
                    }
                }
            }
        }
        out.close();
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}