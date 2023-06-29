import java.util.Scanner;
import java.io.StreamTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author KNIGHT0X300
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputStreamReader in = new InputStreamReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskA {
    StreamTokenizer in;
    PrintWriter out;
    BufferedReader re;
    Scanner sc;
    public void solve (int testNumber, InputStreamReader in, PrintWriter out)  {

          this.in = new StreamTokenizer(new BufferedReader(in));
          this.re =  new BufferedReader(in);
          this.sc = new Scanner(in);
          this.out = out;
          try {
                      this.solve();
                  } catch (IOException e) {
                      e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                  }
          out.flush();

    }

         void solve() throws IOException
       {
        long a=sc.nextLong(),b=sc.nextLong();
           long ans=0,t;
          while(Math.min(a,b)!=1){
              if(a>b){
                  ans+=a/b;
                  a%=b;

              }
              else{
                  t=b;
                  b=a;
                  a=t;
                  long g=gcd(a,b);
                  a/=g;b/=g;
              }

          }
           ans+=Math.max(a,b);
           out.println(ans);

       }
     public static long gcd(long a, long b) {
       long c = 0;

     if(a<0)  a=-a;
       if(b<0)  b=-b;
       while (b>0) {
          c = a % b;
          a = b;
          b = c;
       }
       return a;
     }


         // do the sum

}

