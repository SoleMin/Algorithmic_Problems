import java.util.*;
import java.io.*;
import java.math.*;
public class Main1
{
    static class Reader 
    { 
        private InputStream mIs;private byte[] buf = new byte[1024];private int curChar,numChars;public Reader() { this(System.in); }public Reader(InputStream is) { mIs = is;} 
        public int read() {if (numChars == -1) throw new InputMismatchException();if (curChar >= numChars) {curChar = 0;try { numChars = mIs.read(buf);} catch (IOException e) { throw new InputMismatchException();}if (numChars <= 0) return -1; }return buf[curChar++];} 
        public String nextLine(){int c = read();while (isSpaceChar(c)) c = read();StringBuilder res = new StringBuilder();do {res.appendCodePoint(c);c = read();}while (!isEndOfLine(c));return res.toString() ;} 
        public String s(){int c = read();while (isSpaceChar(c)) c = read();StringBuilder res = new StringBuilder();do {res.appendCodePoint(c);c = read();}while (!isSpaceChar(c));return res.toString();} 
        public long l(){int c = read();while (isSpaceChar(c)) c = read();int sgn = 1;if (c == '-') { sgn = -1 ; c = read() ; }long res = 0; do{ if (c < '0' || c > '9') throw new InputMismatchException();res *= 10 ; res += c - '0' ; c = read();}while(!isSpaceChar(c));return res * sgn;} 
        public int i(){int c = read() ;while (isSpaceChar(c)) c = read();int sgn = 1;if (c == '-') { sgn = -1 ; c = read() ; }int res = 0;do{if (c < '0' || c > '9') throw new InputMismatchException();res *= 10 ; res += c - '0' ; c = read() ;}while(!isSpaceChar(c));return res * sgn;} 
        public double d() throws IOException {return Double.parseDouble(s()) ;}
        public boolean isSpaceChar(int c) { return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1; } 
        public boolean isEndOfLine(int c) { return c == '\n' || c == '\r' || c == -1; } 
    }
    
    
    ///////////////////////////////////////////////////////////////////////////////////////////
    //    RRRRRRRRR            AAA             HHH     HHH     IIIIIIIIIIIII   LLL           //
    //    RR    RRR           AAAAA            HHH     HHH      IIIIIIIIIII    LLL           //
    //    RR   RRR           AAAAAAA           HHH     HHH          III        LLL           //
    //    RR  RRR           AAA   AAA          HHHHHHHHHHH          III        LLL           //
    //    RRRRRR           AAA     AAA         HHHHHHHHHHH          III        LLL           //
    //    RR  RRR         AAAAAAAAAAAAA        HHH     HHH          III        LLL           //
    //    RR    RRR      AAA         AAA       HHH     HHH      IIIIIIIIIII    LLLLLLLLLLLL  //
    //    RR     RRR    AAA           AAA      HHH     HHH     IIIIIIIIIIIII   LLLLLLLLLLLL  //
    ///////////////////////////////////////////////////////////////////////////////////////////
    static class pair 
    {
       int x;
       int y;
       public pair (int k, int p) 
       {
           x = k;
           y = p;
       }
       @Override
       public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            pair pair = (pair) o;
            return x == pair.x && y == pair.y;
        }
    
       @Override
       public int hashCode() {
            return Objects.hash(x, y);
       }
    }
    public static void main(String[] args)throws IOException
    {
        /*PrintWriter out= new PrintWriter(new File("input.txt"));
        Reader sc=new Reader();*/
        Scanner sc = new Scanner(new File("input.txt"));
		PrintWriter out = new PrintWriter("output.txt");
        Queue<pair> q=new LinkedList<>();
        int n=sc.nextInt();
        int m=sc.nextInt();
        int t=sc.nextInt();
        int mark[][]=new int[n+2][m+2];
        while(t-->0)
        {
            int a=sc.nextInt();int b=sc.nextInt();
            mark[a][b]=1;
            q.add(new pair(a,b));
        }
        int ansx=1;int ansy=1;
        while(q.size()!=0)
        {
            pair p=q.remove();
            if(mark[Math.max(1,p.x-1)][p.y]==0)
            {
                q.add(new pair(Math.max(1,p.x-1),p.y));
                mark[Math.max(1,p.x-1)][p.y]=1;
                ansx=Math.max(1,p.x-1);
                ansy=p.y;
            }
            if(mark[Math.min(n,p.x+1)][p.y]==0)
            {
                q.add(new pair(Math.min(n,p.x+1),p.y));
                mark[Math.min(n,p.x+1)][p.y]=1;
                ansx=Math.min(n,p.x+1);
                ansy=p.y;
            }
            if(mark[p.x][Math.max(1,p.y-1)]==0)
            {
                q.add(new pair(p.x,Math.max(1,p.y-1)));
                mark[p.x][Math.max(1,p.y-1)]=1;
                ansx=p.x;
                ansy=Math.max(1,p.y-1);
            }
            if(mark[p.x][Math.min(m,p.y+1)]==0)
            {
                q.add(new pair(p.x,Math.min(m,p.y+1)));
                mark[p.x][Math.min(m,p.y+1)]=1;
                ansx=p.x;
                ansy=Math.min(m,p.y+1);
            }
        }
        out.println(ansx+" "+ansy);
        out.flush();
    }
}
    