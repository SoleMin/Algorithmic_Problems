/**
 *
 * @author Saransh
 */
import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;


public class Main
{
    static int senator_attr[][];
    static int senators;
    static double A;
    public static void main(String[] args)
    {
        try
        {
            Parserdoubt pd=new Parserdoubt(System.in);
            PrintWriter pw=new PrintWriter(System.out);
            senators=pd.nextInt();
            int candies=pd.nextInt();
            senator_attr=new int[senators][2];
            A=pd.nextInt();
            for(int i=0;i<senators;i++)
            {
                senator_attr[i][0]=pd.nextInt();
                senator_attr[i][1]=pd.nextInt();
            }
            max=-1;
            make(0,candies,new int[senators]);
            //print(maxer);
            System.out.printf("%.10f",max);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    static double max;
    static int maxer[];
    public static void get(int a[])
    {
        maxer=new int[senators];
        for(int i=0;i<maxer.length;i++)
            maxer[i]=a[i];
    }
    public static void make(int pos,int left,int arr[])
    {
        if(pos==senators-1)
        {
            arr[pos]=left;
            //print(arr);
            double f=calc(arr);
            if(f>max)
            {
                max=f;
              get(arr);
            }
            
            return;
        }
        if(left==0)
        {
            //print(arr);
            double f=calc(arr);
            if(f>max)
            {
                max=f;
                get(arr);
            }
            
            return;
        }
        for(int i=0;i<=left;i++)
        {
            arr[pos]=i;
            make(pos+1,left-i,arr);
            arr[pos]=0;
        }
    }
    public static double calc(int arr[])
    {
       // print(arr);
        int tmp[][]=new int[senators][2];
        for(int i=0;i<senators;i++)
        {
            tmp[i][0]=senator_attr[i][0];
            tmp[i][1]=Math.min(senator_attr[i][1]+arr[i]*10, 100);
           // System.out.println(tmp[i][0]+" "+tmp[i][1]);
        }
        //print(tmp[0]);
        return prob(tmp);
    }
    public static void print(int a[])
    {
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
        System.out.println();

    }
    public static double prob(int arr[][])
    {
        double probability=0.0;
        for(int i=0;i<(1<<senators);i++)
        {
            if(Integer.bitCount(i)>senators/2)
            {
                double add=1.0;
                int tmpi=i;
                for(int p=0;p<senators;p++)
                {
                    if(tmpi%2==1)
                    {
                        add*=arr[p][1]/100.0;
                    }
                    else
                    {
                        add*=(100-arr[p][1])/100.0;
                    }
                    tmpi/=2;
                }
                probability+=add;
                //System.out.println(i+" "+add);
            }
            else
            {
                double add=1.0;
                double B=0;
                int tmpi=i;
                for(int p=0;p<senators;p++)
                {
                    if(tmpi%2==1)
                    {
                        add*=arr[p][1]/100.0;
                    }
                    else
                    {
                        add*=(100-arr[p][1])/100.0;
                        B+=arr[p][0];
                    }
                    tmpi/=2;
                }
                add*=A/(A+B);
                probability+=add;
                //System.out.println(i+" "+add);
            }

        }
        return probability;
    }
}

class Skill implements Comparable<Skill>
{
    String name;
    int v;
    public Skill(String n,int val)
    {
        name=n;
        v=val;
    }
    public int compareTo(Skill k)
    {
        return -k.name.compareTo(name);
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