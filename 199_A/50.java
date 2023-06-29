import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: vaibhav mittal
 * Date: 23/6/12
 * Time: 1:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        long n = in.nextLong();
        out.println(0 + " " + 0 + " " + n);

        in.close();
        out.close();
    }
}
