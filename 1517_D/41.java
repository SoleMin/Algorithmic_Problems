import java.util.*;import java.io.*;import java.math.*;
public class Main
{
    static int[][] l,r,u,d;
    static int[][][]dist;
    static int inf=Integer.MAX_VALUE;
    static class Node{
        int x,y,len,dis;
        Node(int x,int y,int len,int dis){
            this.x=x;this.y=y;this.len=len;this.dis=dis;
        }
    }
    public static void process()throws IOException
    {
        int n=ni();
        int m=ni();
        int k=ni();
        dist=new int[n][m][k/2+1];
        l=new int[n][m];
        r=new int[n][m];
        for(int i=0;i<n;i++)
            for(int j=0;j<m-1;j++)
                l[i][j]=r[i][j+1]=ni();
        u=new int[n][m];
        d=new int[n][m];
        for(int i=0;i<n-1;i++)
            for(int j=0;j<m;j++)
                d[i][j]=u[i+1][j]=ni();
        if(k%2==1)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                    p("-1 ");
                pn("");
            }
            return;
        }
        k/=2;
        for(int kk=1;kk<=k;kk++)
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                dist[i][j][kk]=inf;
                if(i!=0)
                    dist[i][j][kk]=Math.min(dist[i][j][kk],dist[i-1][j][kk-1]+u[i][j]);
                if(i!=n-1)
                    dist[i][j][kk]=Math.min(dist[i][j][kk],dist[i+1][j][kk-1]+d[i][j]);
                if(j!=0)
                    dist[i][j][kk]=Math.min(dist[i][j][kk],dist[i][j-1][kk-1]+r[i][j]);
                if(j!=m-1)
                    dist[i][j][kk]=Math.min(dist[i][j][kk],dist[i][j+1][kk-1]+l[i][j]);
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
                p(2*dist[i][j][k]+" ");
            pn("");
        }

    }
    static AnotherReader sc;
    static PrintWriter out;
    public static void main(String[]args)throws IOException
    {
        boolean oj = System.getProperty("ONLINE_JUDGE") != null;
        if(oj){sc=new AnotherReader();out=new PrintWriter(System.out);}
        else{sc=new AnotherReader(100);out=new PrintWriter("output.txt");}
        int t=1;
       // t=ni();
        while(t-->0) {process();}
        out.flush();out.close();  
    }

    static void pn(Object o){out.println(o);}
    static void p(Object o){out.print(o);}
    static void pni(Object o){out.println(o);out.flush();}
    static int ni()throws IOException{return sc.nextInt();}
    static long nl()throws IOException{return sc.nextLong();}
    static double nd()throws IOException{return sc.nextDouble();}
    static String nln()throws IOException{return sc.nextLine();}
    static int[] nai(int N)throws IOException{int[]A=new int[N];for(int i=0;i!=N;i++){A[i]=ni();}return A;}
    static long[] nal(int N)throws IOException{long[]A=new long[N];for(int i=0;i!=N;i++){A[i]=nl();}return A;}
    static long gcd(long a, long b)throws IOException{return (b==0)?a:gcd(b,a%b);}
    static int gcd(int a, int b)throws IOException{return (b==0)?a:gcd(b,a%b);}
    static int bit(long n)throws IOException{return (n==0)?0:(1+bit(n&(n-1)));}

/////////////////////////////////////////////////////////////////////////////////////////////////////////

    static class AnotherReader{BufferedReader br; StringTokenizer st;
    AnotherReader()throws FileNotFoundException{
    br=new BufferedReader(new InputStreamReader(System.in));}
    AnotherReader(int a)throws FileNotFoundException{
    br = new BufferedReader(new FileReader("input.txt"));}
    String next()throws IOException{
    while (st == null || !st.hasMoreElements()) {try{
    st = new StringTokenizer(br.readLine());}
    catch (IOException  e){ e.printStackTrace(); }}
    return st.nextToken(); } int nextInt() throws IOException{
    return Integer.parseInt(next());}
    long nextLong() throws IOException
    {return Long.parseLong(next());}
    double nextDouble()throws IOException { return Double.parseDouble(next()); }
    String nextLine() throws IOException{ String str = ""; try{
    str = br.readLine();} catch (IOException e){
    e.printStackTrace();} return str;}}
   
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
}