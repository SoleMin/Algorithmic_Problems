import java.util.*;
import java.io.*;
public class Main {
   
 
      static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(
                new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    }
                    else {
                        continue;
                    }
                }
                buf[cnt++] = (byte)c;
            }
            return new String(buf, 0, cnt);
        }
 
        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
 
            if (neg)
                return -ret;
            return ret;
        }
 
        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }
 
        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
 
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
 
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
 
            if (neg)
                return -ret;
            return ret;
        }
 
        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0,
                                 BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
 
        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
 
        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
     //System.out.println("YES");
//System.out.println("NO");
 
//int n=sc.nextInt();
//int a[]=new int[n];
//for(int i=0;i<n;i++)
//a[i]=sc.nextInt();
 
//int n=sc.nextInt();
//long a[]=new long[n];
//for(int i=0;i<n;i++)
//a[i]=sc.nextLong();
 
//System.out.println();
 
//String str=sc.next();
//long n=sc.nextLong();

  
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
      //  Reader sc=new Reader();
        PrintWriter out=new PrintWriter(System.out);
        int t = sc.nextInt();
		while(t-->0) {
		    int n=sc.nextInt();
		     ArrayList<Integer> al[]=new ArrayList[n+1];
		     
		    for(int i=0;i<=n;i++)
		    al[i]=new ArrayList<>();
		    
		    al[0].add(1);
		    
		    int y;
		    y=sc.nextInt();
		    boolean flag=true;
		    for(int i=1;i<=n-1;i++) {
		         int x=sc.nextInt();
		        int idx=al[i-1].size()-1;
		        if(x!=1) {
		            while(flag) {
		                int ans=x-1;
		                if(al[i-1].get(idx)==ans) {
		                    idx--;
		                   break;
		                }
		                idx--;
		            }
		        }
		        for(int j=0;j<=idx;j++) {
		            al[i].add(al[i-1].get(j));
		        }
		        al[i].add(x);
		    }
		    
		    for(int i=0;i<=n-1;i++) {
		        out.print(al[i].get(0));
		        for(int j=1;j<=al[i].size()-1;j++) {
		            out.print("."+al[i].get(j));
		        }
		        out.println();
		    }
	
        
  }
		  
		  out.flush();
		  out.close();
		 
		  
  
		  
        }
        
		
	
}
