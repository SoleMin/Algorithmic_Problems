

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class B {

    
    public static void main(String[] args) throws Exception {
        Parserdoubt2333 s = new Parserdoubt2333(System.in);
        
        int n = s.nextInt();
        int k = s.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = s.nextInt();
            
        }
        
        TreeMap<Integer, Integer> tree = new TreeMap<Integer,Integer>();
        
        int left = 0;
        int right = 0;
        
        for (right = 0; right < a.length; right++) {
            if(tree.containsKey(a[right]))
                tree.put(a[right], tree.get(a[right]) + 1);
            else 
                tree.put(a[right],1);
            if(tree.size() == k)
                break;
        }
        
        if(tree.size() < k){
            System.out.println("-1 -1");
            return ;
        }
//      System.out.println(right);
        for (left = 0; left < a.length; left++) {
            int val = tree.get(a[left]);
            val--;
            if(val > 0)
                tree.put(a[left],val);
            if(val == 0)
                break;
            
        }
        left++;
        right++;
        System.out.println(left + " "+right);
    }

}



class Parserdoubt2333
{
   final private int BUFFER_SIZE = 1 << 18;
 
   private DataInputStream din;
   private byte[] buffer;
   private int bufferPointer, bytesRead;
 
   public Parserdoubt2333(InputStream in)
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