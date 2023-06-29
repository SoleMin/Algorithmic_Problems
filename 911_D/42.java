
    //~~~~~~~~~~~~~~~~~~~~~~~@@@@@@@@@@@@@@@_____________K_____S_____J__________@@@@@@@@@@@@@@@@@@@@@@@@@@@@~~~~~~~~~~~~~~~~~~~~~~~~~~
    //Date:00/00/17
    //-------------


import java.util.*;
import java.io.*;

/*

    [[[[[[[[[[[[[[[      ]]]]]]]]]]]]]]]
    [::::::::::::::      ::::::::::::::]
    [::::::::::::::      ::::::::::::::]
    [::::::[[[[[[[:      :]]]]]]]::::::]
    [:::::[                      ]:::::]
    [:::::[                      ]:::::]
    [:::::[                      ]:::::]
    [:::::[                      ]:::::]
    [:::::[    CODE YOUR LIFE    ]:::::]
    [:::::[   Kripa Shankar jha  ]:::::]
    [:::::[                      ]:::::]
    [:::::[                      ]:::::]
    [:::::[                      ]:::::]
    [:::::[                      ]:::::]
    [::::::[[[[[[[:      :]]]]]]]::::::]
    [::::::::::::::      ::::::::::::::]
    [::::::::::::::      ::::::::::::::]
    [[[[[[[[[[[[[[[      ]]]]]]]]]]]]]]]
*/

public class prob3{
  

    static Parser sc=new Parser(System.in);
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
  
  static int p[]=new int[100005];
  public static void main(String[] args) throws IOException {
    // use ((((((( sc ............... for input

   
    int n=sc.nextInt();

    int arr[]=new int[n];

    for(int i=0;i<n;i++){
      arr[i]=sc.nextInt();
    }

    int swap=0;

    for(int i=0;i<n;i++){
      for(int j=0;j<i;j++){
        if(arr[i]<arr[j]){
           swap++; 
        }
      }
    }

    swap%=2;


    int m=sc.nextInt();

    for(int i=0;i<m;i++){

      int a=sc.nextInt(),b=sc.nextInt();
      swap+=((b-a)*((b-a)+1))/2;

      swap%=2;

      if(swap%2==0){System.out.println("even");}
      else{System.out.println("odd");}
    }


          
  }

   

public static void union(int a,int b){
        int i=find(a);
        int j=find(b);

        if(p[i]!=j){
          p[i]=j;
        }
      }


      public static int find(int a){

        while(p[a]!=a){
          a=p[a];
        }

        return a;
      }






  //___________________________Fast-Input_Output-------------------******************* 
  

  static class Parser {
        final private int BUFFER_SIZE = 1 << 20;  // 2^16, a good compromise for some problems
        private InputStream din;    // Underlying input stream
        private byte[] buffer;      // Self-maintained buffer
        private int bufferPointer;  // Current read position in the buffer
        private int bytesRead;      // Effective bytes in the buffer read from the input stream
        private SpaceCharFilter filter;
        public Parser(InputStream in) {
            din = in;
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;

        }

        /**
         * Read the next integer from the input stream.
         * @return The next integer.
         * @throws IOException
         */
        public int nextInt() throws IOException {
            int result = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
        while (c >= '0' && c <= '9') {
                result = result * 10 + c - '0';
                c = read();
            }
      if (neg) return -result;
              return result;
        }

        public int nextLong() throws IOException {
            int result = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
        while (c >= '0' && c <= '9') {
                result = result * 10 + c - '0';
                c = read();
            }
      if (neg) return -result;
              return result;
        }

        public String nextLine()throws IOException {
        int c = read();
        while (isSpaceChar(c))
          c = read();
        StringBuilder res = new StringBuilder();
        do {
          res.appendCodePoint(c);
          c = read();
        } while (!isEndOfLine(c)==true);
        return res.toString();
      }

      public boolean isSpaceChar(int c) {
        if (filter != null)
          return filter.isSpaceChar(c);
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
      }
   
      private boolean isEndOfLine(int c) {
        return c == '\n' || c == '\r' || c == -1;
      }
      public interface SpaceCharFilter {
        public boolean isSpaceChar(int ch);
      }


        /**
         * Read the next byte of data from the input stream.
         * @return the next byte of data, or -1 if the end of the stream is reached.
         * @throws IOException if an I/O error occurs.
         */
        public byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        /**
         * Read data from the input stream into the buffer
         * @throws IOException if an I/O error occurs.
         */
        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
    }
}