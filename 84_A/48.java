/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Saransh
 */
import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try
        {
            Parserdoubt pd=new Parserdoubt(System.in);
            //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int n=pd.nextInt();
            PrintWriter pw=new PrintWriter(System.out);
            pw.println((n*3)/2);
            pw.flush();
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