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
            long n=input.nextLong();
            int m=input.nextInt();
            long k=input.nextLong();
            long p[]=new long[(int)m];
            for(int i=0;i<m;i++)
            {
                p[i]=input.nextLong();
            }
            long sum=0;
            int i=0;
            int count=0;
            while(i<m)
            {
                HashSet<Long> set=new HashSet<>();
                int ind=-1;
                for(int j=i;j<m;j++)
                {
                    long x=p[j]-sum;
                    long y=0;
                    if(x%k==0)
                    {
                        y=x/k;
                    }
                    else
                    {
                        y=x/k;
                        y++;
                    }
                    set.add(y);
                    if(set.size()>1)
                    {
                        ind=j;
                        break;
                    }
                }
                count++;
                if(ind==-1)
                {
                    break;
                }
                sum+=ind-i;
                i=ind;
            }
            out.println(count);
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