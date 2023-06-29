import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        var sc = new Scanner(System.in);
        var pw = new PrintWriter(System.out);
        
        int T = Integer.parseInt(sc.next());
        for(int t = 0; t < T; t++){
            int n = Integer.parseInt(sc.next());
            boolean ok = false;
            if(n%2 == 0){
                int a = n/2;
                int b = (int) Math.sqrt(a);
                if(b*b == a){
                    ok = true;
                }
            }
            if(n%4 == 0){
                int a = n/4;
                int b = (int) Math.sqrt(a);
                if(b*b == a){
                    ok = true;
                }
            }
            if(ok){
                pw.println("YES");
            }else{
                pw.println("NO");
            }
        }
        pw.flush();
    }
}