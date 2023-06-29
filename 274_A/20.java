

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;



public class div168C {

public static void main(String[] args) throws Exception{
        
    div168C a=new div168C();
        Parserdoubt pd=a.new Parserdoubt(System.in);
        StringBuffer sb = new StringBuffer();
        
        ArrayList<Integer> arr=new ArrayList<Integer>();
        int max=0;
        int n=pd.nextInt();
        int k=pd.nextInt();
        for(int i=0;i<n;i++){
            arr.add(pd.nextInt());
            max=Math.max(max, arr.get(i));
        }
        Collections.sort(arr);
    
        int count=0;
        int[] mat=new int[n+1];
        for(int i=n-1;i>=0;i--){
            if(mat[i]!=1){
                int x=arr.get(i);
                if(x%k==0){
                int ans=Collections.binarySearch(arr, x/k);
                
            //  System.out.println("index "+ans);
                
                if(ans>=0&&arr.get(ans)==(x/k)){
                    count++;
                    mat[ans]=1;
                }
                else{
                    count++;
                }
                }
                else{
                    count++;
                }
            }
        }
        /*for(int i=0;i<arr.size();i++){
            System.out.print(arr.get(i)+" ");
        }
        System.out.println();
        */
        if(n==1)
            count=1;
        System.out.println(count);
        
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

    
    
}
