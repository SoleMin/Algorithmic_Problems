import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import static java.lang.Math.*;

public class main implements Runnable{

    static ArrayList <Integer> adj[];
    static int co=0,f=0;

    static void Check2(int n){
        adj=new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            adj[i]=new ArrayList<>();
        }

    }
    static void add(int i,int j){

        adj[i].add(j);
        adj[j].add(i);
    }
    public static void main(String[] args)  {
        new Thread(null, new main(), "Check2", 1<<26).start();// to increse stack size in java
    }
    static long mod=(long)(1e9+7);
    public void run() {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        //Scanner in=new Scanner(System.in);

        InputReader in = new InputReader(System.in);
        PrintWriter w = new PrintWriter(System.out);



       long n=in.nextLong();
        long s=in.nextLong();
        
        long l=1;
        long r=(long)(n);
       long ans=-1;
        while(l<=r){
            
            long mid=(l+r)/2;
            if(ch(mid,s)){
                ans=mid;
                r=mid-1;
            }
            else
            {
                l=mid+1;
            }
            
        }
        if(ans==-1)w.println(0);
        else
            w.println(n-ans+1);
        w.close();
    }
        public boolean ch(long a,long s){
            
            long p=0;
            long val=a;
            while(val>0){
                p=p+val%10;
                val=val/10;
            }
            if(a-p>=s)return true;
            return false;
            
        }
    public boolean rec(int a,int b,int x,int y,int c,int d,int co){

        if(a>x|b>y)return false;

        if(a<-100000||b<-100000||co>100000)return false;

        if(a==x&&b==y)return true;



        return (rec(a+c,b+d,x,y,c,d,co+1)||rec(a+c,b-d,x,y,c,d,co+1)||rec(a-c,b+d,x,y,c,d,co+1)||rec(a-c,b-d,x,y,c,d,co+1));



    }



    static  int gcd(int a,int b){

        if(b==0)return a;
        return gcd(b,a%b);
    }
    static  void dfs(int i,int v[],int val,int b[]){


        if(v[i]==1)return ;

        v[i]=1;
        b[i]=val;

        Iterator <Integer> it=adj[i].iterator();
        while(it.hasNext()){
            int q=it.next();
            dfs(q,v,val,b);
        }





    }

    static  void sev(int a[],int n){

        for(int i=2;i<=n;i++)a[i]=i;
        for(int i=2;i<=n;i++){

            if(a[i]!=0){
                for(int j=2*i;j<=n;){

                    a[j]=0;
                    j=j+i;
                }
            }

        }

    }

    static class pair implements Comparable<pair> {

        int x,y;
        pair(int c,int d){
            x=c;
            y=d;
        }

        public int compareTo(pair o){

            return (this.x-o.x);   //sort in incrementing order w.r.t to c
        }



    }

    static class node{

        int y;
        int val;

        node(int a,int b){

            y=a;
            val=b;

        }


    }
    static  void rec(String s,int a,int b,int n){

        if(b==n){
            System.out.println(s);
            return ;
        }
        String p=s;
        if(a>b){
            s=p+")" ;
            rec(s,a,b+1,n);
        }
        if(a<n){
            s=p+"(";
            rec(s,a+1,b,n);
        }




    }

    static class InputReader
    {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream)
        {
            this.stream = stream;
        }

        public int read()
        {
            if (numChars==-1)
                throw new InputMismatchException();

            if (curChar >= numChars)
            {
                curChar = 0;
                try
                {
                    numChars = stream.read(buf);
                }
                catch (IOException e)
                {
                    throw new InputMismatchException();
                }

                if(numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public String nextLine()
        {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
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
        public int nextInt()
        {
            int c = read();

            while(isSpaceChar(c))
                c = read();

            int sgn = 1;

            if (c == '-')
            {
                sgn = -1;
                c = read();
            }

            int res = 0;
            do
            {
                if(c<'0'||c>'9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));

            return res * sgn;
        }

        public long nextLong()
        {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-')
            {
                sgn = -1;
                c = read();
            }
            long res = 0;

            do
            {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
            return res * sgn;
        }

        public double nextDouble()
        {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-')
            {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.')
            {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.')
            {
                c = read();
                double m = 1;
                while (!isSpaceChar(c))
                {
                    if (c == 'e' || c == 'E')
                        return res * Math.pow(10, nextInt());
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        public String readString()
        {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do
            {
                res.appendCodePoint(c);
                c = read();
            }
            while (!isSpaceChar(c));

            return res.toString();
        }

        public boolean isSpaceChar(int c)
        {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next()
        {
            return readString();
        }

        public interface SpaceCharFilter
        {
            public boolean isSpaceChar(int ch);
        }
    }







}