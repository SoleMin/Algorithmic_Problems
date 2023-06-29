import java.io.*;
public class Main
{
    static double arr[][];
    public static void main(String[] args)
    {
        try
        {
            Parserdoubt pd=new Parserdoubt(System.in);
            PrintWriter pw=new PrintWriter(System.out);
            int fishes=pd.nextInt();
            arr=new double[fishes][fishes];
            for(int i=0;i<fishes;i++)
                for(int j=0;j<fishes;j++)
                    arr[i][j]=Double.parseDouble(pd.nextString());
            double dp[]=new double[(1<<fishes)];
            dp[dp.length-1]=1.0;
            for(int c=dp.length-1;c>=0;c--)
            {
                
                if((c&(c-1))==0)
                    continue;
                for(int i=0;i<fishes;i++)
                    for(int j=i+1;j<fishes;j++)
                    {
                        if(((1<<i)&c)!=0&&((1<<j)&c)!=0)
                        {
                            dp[c&~(1<<j)]+=arr[i][j]*dp[c];
                            dp[c&~(1<<i)]+=arr[j][i]*dp[c];
                        }
                    }
            }
            double s=0.0;
            for(int i=0;i<fishes;i++)
                s+=dp[1<<i];
            for(int i=0;i<fishes;i++)
                dp[1<<i]/=s;
            int i=0;
            for(i=0;i<fishes-1;i++)
                pw.printf("%.6f ",dp[1<<i]);
            pw.printf("%.6f\n",dp[1<<i]);
            pw.close();
        }
        catch(Exception e)
        {}
    }
}
class Parserdoubt
    {
       final private int BUFFER_SIZE = 1 << 17;

       private DataInputStream din;
       private byte[] buffer;
       private int bufferPointer, bytesRead;

       public Parserdoubt(InputStream in)
       {
          din = new DataInputStream(in);
          buffer = new byte[BUFFER_SIZE];
          bufferPointer = bytesRead = 0;
       }
       public String nextString() throws Exception
       {
           StringBuffer sb=new StringBuffer("");
           byte c = read();
           while (c <= ' ') c = read();
           do
           {
               sb.append((char)c);
               c=read();
           }while(c>' ');
           return sb.toString();
       }
       public char nextChar() throws Exception
       {
           byte c=read();
           while(c<=' ') c= read();
           return (char)c;
       }
       public int nextInt() throws Exception
       {
          int ret = 0;
          byte c = read();
          while (c <= ' ') c = read();
          boolean neg = c == '-';
          if (neg) c = read();
          do
          {
              ret = ret * 10 + c - '0';
             c = read();
          } while (c > ' ');
          if (neg) return -ret;
          return ret;
       }
       public long nextLong() throws Exception
       {
          long ret = 0;
          byte c = read();
          while (c <= ' ') c = read();
          boolean neg = c == '-';
          if (neg) c = read();
          do
          {
              ret = ret * 10 + c - '0';
             c = read();
          } while (c > ' ');
          if (neg) return -ret;
          return ret;
       }
       private void fillBuffer() throws Exception
       {
          bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
          if (bytesRead == -1) buffer[0] = -1;
       }

       private byte read() throws Exception
       {
          if (bufferPointer == bytesRead) fillBuffer();
          return buffer[bufferPointer++];
       }
    }
