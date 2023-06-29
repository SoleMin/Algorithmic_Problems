import java.util.*;
import static java.lang.System.*;

public class D276 {
    Scanner sc = new Scanner(in);


    public void run() {
        long l=sc.nextLong(),r=sc.nextLong();

        long tes=l^r;

        int d=0;
        while(tes!=0){
            tes/=2;
            d++;
        }
        ln((1L<<d)-1);
    }


    public static void main(String[] _) {
        new D276().run();
    }

    public static void pr(Object o) {
        out.print(o);
    }
    public static void ln(Object o) {
        out.println(o);
    }
    public static void ln() {
        out.println();
    }
}