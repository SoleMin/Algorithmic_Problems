import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        if (n%2==0) {
            System.out.println(4+" "+(n-4));
        } else {
            System.out.println(9+" "+(n-9));
        }

        in.close();
        out.close();
    }
}
