import java.io.InputStreamReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Nipuna Samarasekara
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		FastScanner in = new FastScanner(inputStream);
		FastPrinter out = new FastPrinter(outputStream);
		TaskB solver = new TaskB();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskB {
    /////////////////////////////////////////////////////////////
 long n,x,y,c;
    public void solve(int testNumber, FastScanner in, FastPrinter out) {
     n=in.nextLong();
 x=in.nextLong();
y=in.nextLong();
c=in.nextLong();
  long td=-1,tup=2*(n-1);
     while(Math.abs(td-tup)>1){
      long mid=(td+tup)/2;
       if(chk(mid))tup=mid;
         else td=mid;
     }
        out.println(tup);

    }

    private boolean chk(long t) {
     long ct=-3;
        long d=x,w=y;
        if(w>d){
            long tt=w;
            w=d;d=tt;
        }

        if(t>=d+w-2) ct+=d*w;
        else if(t<w&&t<d) {
          //  long k=w;
            ct+=(t+1)*(t+2)/2;
        }
        else if(t>=w&&t<d) {
           // long k=w;
            ct+=w*(w+1)/2;
            long k=t-(w-1);
            ct+=k*w;
        }
        else if(t>=w&&t>=d) {
            // long k=w;

            ct+=w*d;
            long k=w-2-(t-d);
            ct-=k*(k+1)/2;
        }
        ////
        w=x;d=n+1-y;
        if(w>d){
            long tt=w;
            w=d;d=tt;
        }

        if(t>=d+w-2) ct+=d*w;
        else if(t<w&&t<d) {
            //  long k=w;
            ct+=(t+1)*(t+2)/2;
        }
        else if(t>=w&&t<d) {
            // long k=w;
            ct+=w*(w+1)/2;
            long k=t-(w-1);
            ct+=k*w;
        }
        else if(t>=w&&t>=d) {
            // long k=w;

            ct+=w*d;
            long k=w-2-(t-d);
            ct-=k*(k+1)/2;
        }

        w=n+1-x;d=y;
        if(w>d){
            long tt=w;
            w=d;d=tt;
        }

        if(t>=d+w-2) ct+=d*w;
        else if(t<w&&t<d) {
            //  long k=w;
            ct+=(t+1)*(t+2)/2;
        }
        else if(t>=w&&t<d) {
            // long k=w;
            ct+=w*(w+1)/2;
            long k=t-(w-1);
            ct+=k*w;
        }
        else if(t>=w&&t>=d) {
            // long k=w;

            ct+=w*d;
            long k=w-2-(t-d);
            ct-=k*(k+1)/2;
        }
        w=n+1-x;d=n+1-y;
        if(w>d){
            long tt=w;
            w=d;d=tt;
        }

        if(t>=d+w-2) ct+=d*w;
        else if(t<w&&t<d) {
            //  long k=w;
            ct+=(t+1)*(t+2)/2;
        }
        else if(t>=w&&t<d) {
            // long k=w;
            ct+=w*(w+1)/2;
            long k=t-(w-1);
            ct+=k*w;
        }
        else if(t>=w&&t>=d) {
            // long k=w;

            ct+=w*d;
            long k=w-2-(t-d);
            ct-=k*(k+1)/2;
        }
        ct-=Math.min(t,x-1);
        ct-=Math.min(t,y-1);
        ct-=Math.min(t,n-x);
        ct-=Math.min(t,n-y);
       // System.out.println(t+" "+ct);
        if(ct>=c)return true;
        else
        return false;
    }

}

class FastScanner extends BufferedReader {

    public FastScanner(InputStream is) {
        super(new InputStreamReader(is));
    }

    public int read() {
        try {
            int ret = super.read();
//            if (isEOF && ret < 0) {
//                throw new InputMismatchException();
//            }
//            isEOF = ret == -1;
            return ret;
        } catch (IOException e) {
            throw new InputMismatchException();
        }
    }

    public String next() {
        StringBuilder sb = new StringBuilder();
        int c = read();
        while (isWhiteSpace(c)) {
            c = read();
        }
        if (c < 0) {
            return null;
        }
        while (c >= 0 && !isWhiteSpace(c)) {
            sb.appendCodePoint(c);
            c = read();
        }
        return sb.toString();
    }

    static boolean isWhiteSpace(int c) {
        return c >= 0 && c <= 32;
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public String readLine() {
        try {
            return super.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    }

class FastPrinter extends PrintWriter {

    public FastPrinter(OutputStream out) {
        super(out);
    }

    public FastPrinter(Writer out) {
        super(out);
    }


}

