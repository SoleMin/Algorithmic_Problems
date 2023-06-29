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
            String s1=input.next();
            String s2=input.next();
            String s3=input.next();
            char a=s1.charAt(1);
            char b=s2.charAt(1);
            char c=s3.charAt(1);
            int x=s1.charAt(0);
            int y=s2.charAt(0);
            int z=s3.charAt(0);
            if(a==b && b==c && x==y && y==z)
            {
                out.println(0);
            }
            else if(a==b && b==c)
            {
                int arr[]=new int[3];
                arr[0]=x;
                arr[1]=y;
                arr[2]=z;
                Arrays.sort(arr);
                if(arr[1]==arr[0]+1 && arr[2]==arr[1]+1)
                {
                    out.println(0);
                }
                else
                {
                    if(arr[0]==arr[1] || arr[1]==arr[2] || arr[0]==arr[2])
                    {
                        out.println(1);
                    }
                    else
                    {
                        if(arr[0]+1==arr[1] || arr[1]+1==arr[2] || arr[0]+1==arr[2])
                        {
                            out.println(1);
                        }
                        else if(arr[0]+2==arr[1] || arr[1]+2==arr[2] || arr[0]+2==arr[2])
                        {
                            out.println(1);
                        }
                        else
                        {
                            out.println(2);
                        }
                    }
                }
            }
            else
            {
                if(a==b && b!=c)
                {
                    if(Math.abs(x-y)<=2)
                    {
                        out.println(1);
                    }
                    else
                    {
                        out.println(2);
                    }
                }
                else if(b==c && a!=b)
                {
                    if(Math.abs(z-y)<=2)
                    {
                        out.println(1);
                    }
                    else
                    {
                        out.println(2);
                    }
                }
                else if(a==c && a!=b)
                {
                    if(Math.abs(x-z)<=2)
                    {
                        out.println(1);
                    }
                    else
                    {
                        out.println(2);
                    }
                }
                else
                {
                    out.println(2);
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