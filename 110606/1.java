import java.util.Scanner;
import java.math.BigInteger;

public class Main {

		public static void main(String[] args) {

				Scanner scanner = new Scanner(System.in);

				BigInteger[] many = new BigInteger[10001];
				many[0] = BigInteger.ZERO;
				BigInteger mul = new BigInteger("1");

				int count = 1;
				int i=1;
				while (i <= 10000) {
						for (int j = count; j > 0; j--){
							if(i>10000)
								break;
							many[i] = many[i - 1].add(mul);
							i++;
						}
						count++;
						BigInteger two = new BigInteger("2");
						mul = mul.multiply(two);
				}

				while (scanner.hasNextInt()) {
					System.out.println(many[scanner.nextInt()]);
				}
		}

}