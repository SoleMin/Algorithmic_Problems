
import java.io.*;
import java.util.*;
 
public class Kaudo {
    static Reader in =new Reader();
    static StringBuilder Sd=new StringBuilder();
    static long ans,res,lot,max;
    static List<Integer>gr[];
    static ArrayList<Integer> A=new ArrayList();
    static String ch[];
     public static void main(String [] args) {
        int n=in.nextInt(),a[]=new int [n],g=0;
        for(int i=0;i<n;i++){
        a[i]=in.nextInt();
        if(a[i]==1){System.out.println("1");return;}
        }
        ans=0;
        Arrays.sort(a);
        for(int i=0;i<n;i++){
            int x=a[i];
            if(x>0){ans++;
        for(int u=i;u<n;u++){
        if(a[u]%x==0){a[u]=0;}
        
        }}
        
        }
         System.out.println(ans);
     }
     static int gcd(int a,int b){
     if(b==0)return a;
     return gcd(b,a%b);
     }
   static class Reader 
    {  
        private InputStream mIs;private byte[] buf = new byte[1024];private int curChar,numChars;public Reader() { this(System.in); }public Reader(InputStream is) { mIs = is;} 
        public int read() {if (numChars == -1) throw new InputMismatchException();if (curChar >= numChars) {curChar = 0;try { numChars = mIs.read(buf);} catch (IOException e) { throw new InputMismatchException();}if (numChars <= 0) return -1; }return buf[curChar++];} 
        public int nextInt(){int c = read() ;while (isSpaceChar(c)) c = read();int sgn = 1;if (c == '-') { sgn = -1 ; c = read() ; }int res = 0;do{if (c < '0' || c > '9') throw new InputMismatchException();res *= 10 ; res += c - '0' ; c = read() ;}while(!isSpaceChar(c));return res * sgn;} 
        public boolean isSpaceChar(int c) { return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1; }
    }
    
}
