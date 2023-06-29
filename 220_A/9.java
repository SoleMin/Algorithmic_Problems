
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;


public class Main{

    public static void main(String[] args) throws Exception {
        Parserdoubt12 s = new Parserdoubt12(System.in);
        
        int n = s.nextInt();
        
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        
        int copy[] = a.clone();
        Arrays.sort(a);
        int count = 0;
        for (int i = 0; i < copy.length; i++) {
            if(a[i] != copy[i]) count++;
        }
        if(count <= 2) System.out.println("YES");
        else System.out.println("NO");
    }
    
    
}


class Parserdoubt12
{
   final private int BUFFER_SIZE = 1 << 17;
 
   private DataInputStream din;
   private byte[] buffer;
   private int bufferPointer, bytesRead;
 
   public Parserdoubt12(InputStream in)
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