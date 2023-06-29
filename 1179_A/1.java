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
            int q=input.nextInt();
            Deque<Integer> dq=new LinkedList<>();
            int max=0;
            for(int i=0;i<n;i++)
            {
                int a=input.nextInt();
                dq.add(a);
                max=Math.max(max,a);
            }
            int arr[][]=new int[n+1][2];
            int x=1;
            while(true)
            {
                int a=dq.poll();
                int b=dq.poll();
                if(a==max)
                {
                    dq.addFirst(b);
                    dq.addFirst(a);
                    break;
                }
                else
                {
                    arr[x][0]=a;
                    arr[x][1]=b;
                    x++;
                    if(a<=b)
                    {
                        dq.addLast(a);
                        dq.addFirst(b);
                    }
                    else
                    {
                        dq.addLast(b);
                        dq.addFirst(a);
                    }
                }
            }
            int a[]=new int[n];
            int j=0;
            while(!dq.isEmpty())
            {
                a[j]=dq.poll();
                j++;
            }
            for(int i=0;i<q;i++)
            {
                long v=input.nextLong();
                if(v<x)
                {
                    out.println(arr[(int)v][0]+" "+arr[(int)v][1]);
                }
                else
                {
                    v-=x;
                    v++;
                    int index=(int)(v%(n-1));
                    if(index==0)
                    {
                        index=n-1;
                    }
                    out.println(max+" "+a[index]);
                }
            }
        }
        out.close();
    }
    public static void mergeSort(int a[][],int p,int r)
    {
        if(p<r)
        {
            int q=(p+r)/2;
            mergeSort(a,p,q);
            mergeSort(a,q+1,r);
            merge(a,p,q,r);
        }
    }
    public static void merge(int a[][],int p,int q,int r)
    {
        int n1=q-p+2;
        int L[][]=new int[n1][2];
        int n2=r-q+1;
        int R[][]=new int[n2][2];
        for(int i=p;i<=q;i++)
        {
            L[i-p]=a[i];
        }
        L[n1-1][0]=Integer.MAX_VALUE;
        for(int i=q+1;i<=r;i++)
        {
            R[i-q-1]=a[i];
        }
        R[n2-1][0]=Integer.MAX_VALUE;
        int x=0,y=0;
        for(int i=p;i<=r;i++)
        {
            if(L[x][0]<=R[y][0])
            {
                a[i]=L[x];
                x++;
            }
            else
            {
                a[i]=R[y];
                y++;
            }
        }
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