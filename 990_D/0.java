import java.io.*;
import java.util.*;
 
 
public class Main{

	public static Reader sc = new Reader();
	//public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static void invert(int[][] sol) {
		int n = sol.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) continue;
				sol[i][j] = 1-sol[i][j];
			}
		}
	}
   public static void main(String[] args) throws IOException{
	
	int n = sc.nextInt();
	int a = sc.nextInt();
	int b = sc.nextInt();
	if (n == 2 && a==b) {
		 out.println("NO");
	}
	else if (n == 3 && a == 1 && b == 1) out.println("NO");
	else if ((a == 1 || b == 1)) {
		out.println("YES");
		// flip if b == 1
		int[][] sol = new int[n][n];
		// okay so we just can make B connected components lol
		// or A connected components
		int count = Integer.max(a, b);
		
		for (int i = count-1; i < n-1; i++) {
			// link together i, i+1, i+2, etc;
			sol[i][i+1] = 1;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sol[i][j] = sol[j][i] = Integer.max(sol[i][j], sol[j][i]);
			}
		}
		
		invert(sol);
		
		
		if (b == 1) {
			invert(sol);
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				out.print(sol[i][j]);
			}
			out.println();
		}
	}
	else out.println("NO");
	
	out.close();
   }
   static long ceil(long a, long b) {
		return (a+b-1)/b;
	}
  
   static long powMod(long base, long exp, long mod) {
	   if (base == 0 || base == 1) return base;
	   if (exp == 0) return 1;
	   if (exp == 1) return base % mod;
	   long R = powMod(base, exp/2, mod) % mod;
	   R *= R;
	   R %= mod;
	   if ((exp & 1) == 1) {
		   return base * R % mod;
	   }
	   else return R % mod;
   }
   
   static long pow(long base, long exp) {
	   if (base == 0 || base == 1) return base;
	   if (exp == 0) return 1;
	   if (exp == 1) return base;
	   long R = pow(base, exp/2);
	   if ((exp & 1) == 1) {
		   return R * R * base;
	   }
	   else return R * R;
   }
   

 
   static class Reader 
   { 
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
           din = new DataInputStream(new FileInputStream(file_name)); 
           buffer = new byte[BUFFER_SIZE]; 
           bufferPointer = bytesRead = 0; 
       } 

       public String readLine() throws IOException 
       { 
           byte[] buf = new byte[64]; // line length 
           int cnt = 0, c;
           while ((c = read()) != -1) 
           { 
               if (c == '\n') 
               {
            	   break;
               }
               buf[cnt++] = (byte) c; 
           } 
           return new String(buf, 0, Integer.max(cnt-1, 0)); 
       } 

       public int nextInt() throws IOException 
       { 
           int ret = 0; 
           byte c = read(); 
           while (c <= ' ') 
               c = read(); 
           boolean neg = (c == '-'); 
           if (neg) 
               c = read(); 
           do
           { 
               ret = ret * 10 + c - '0'; 
           }  while ((c = read()) >= '0' && c <= '9'); 

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
           } 
           while ((c = read()) >= '0' && c <= '9'); 
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
           } 
           while ((c = read()) >= '0' && c <= '9'); 

           if (c == '.') 
           { 
               while ((c = read()) >= '0' && c <= '9') 
               { 
                   ret += (c - '0') / (div *= 10); 
               } 
           } 

           if (neg) 
               return -ret; 
           return ret; 
       } 

       private void fillBuffer() throws IOException 
       { 
           bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
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

	public static PrintWriter out = new PrintWriter (new BufferedOutputStream(System.out));
}











