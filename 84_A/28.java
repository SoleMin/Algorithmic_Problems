import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 13.05.11
 * Time: 23:21
 * To change this template use File | Settings | File Templates.
 */
public class ToyArmies {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        System.out.print(String.format("%d",(long)(n*1.5)));
    }
}
