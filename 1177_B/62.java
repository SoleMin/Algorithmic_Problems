
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class A {
    void solve(){
        long k = readLong();

       long x = 9;
       long y = 1;
       while(k > x * y){
           k -= x * y;
           x *= 10;
           y++;
       }


       long w = k / y + (k % y == 0 ? 0 : 1);
       long e = (k % y - 1 % y + y) % y;

       long num = x/9 + w - 1;
       String s = Long.toString(num);
       out.print(s.charAt((int) e) - '0');
    }

    public static void main(String[] args) {
        new A().run();
    }

    void run(){
        init();
        solve();
        out.close();
    }

    BufferedReader in;
    PrintWriter out;

    StringTokenizer tok = new StringTokenizer("");

    void init(){
        in = new BufferedReader(new InputStreamReader(System.in));
        out  = new PrintWriter(System.out);
    }

    String readLine(){
        try{
            return in.readLine();
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
    String readString(){
        while(!tok.hasMoreTokens()){
            String nextLine = readLine();
            if(nextLine == null) return null;
            tok = new StringTokenizer(nextLine);
        }
        return tok.nextToken();
    }

    int readInt(){
        return Integer.parseInt(readString());
    }

    long readLong(){
        return Long.parseLong(readString());
    }

    double readDouble(){
        return Double.parseDouble(readString());
    }
}
