import java.io.PrintWriter;
import java.util.Scanner;
  
public class Main {
    Scanner in;
    PrintWriter out;
      
    void solve() {
    	out.print("25");
    }

      
    void run() {

            in = new Scanner(System.in);
            out = new PrintWriter(System.out);      

            solve();

            out.close();
    }
  
    public static void main(String[] args) {
        new Main().run();
          
    }
}