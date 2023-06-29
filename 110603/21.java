
import java.util.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        BigInteger bigInt[] = new BigInteger[1001];
        bigInt[0] = BigInteger.valueOf(0);
        bigInt[1] = BigInteger.valueOf(2);
        bigInt[2] = BigInteger.valueOf(5);
        bigInt[3] = BigInteger.valueOf(13);
        
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int count = scanner.nextInt();

            for (int i = 4; i < bigInt.length; ++i) {
                bigInt[i] = bigInt[i-1].multiply(bigInt[1]);
                bigInt[i] = bigInt[i].add(bigInt[i - 2]);
                bigInt[i] = bigInt[i].add(bigInt[i - 3]);
            }
            System.out.println(bigInt[count]);
        }
    }
}
