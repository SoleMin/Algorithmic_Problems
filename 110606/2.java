import java.io.*;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger[] hanoi = new BigInteger[10001];
		BigInteger[] hanoi4 = new BigInteger[10001];
		hanoi[0] = BigInteger.ZERO;
		hanoi[1] = BigInteger.ONE;
		hanoi4[0] = BigInteger.ZERO;
		hanoi4[1] = BigInteger.ONE;
		for (int i = 2; i <= 10000; i++) {
			hanoi[i] = hanoi[i-1].add(hanoi[i-1].add(BigInteger.ONE));
		}
		for (int i = 2; i <= 10000; i++) {
			hanoi4[i] = hanoi4[i-1].add(hanoi4[i-1].add(BigInteger.ONE));
			for (int j = i - 2; j > 0; j--) {
				BigInteger temp = hanoi4[j].add(hanoi4[j].add(hanoi[i-j]));
				if (hanoi4[i].compareTo(temp) < 1)
					break;
				hanoi4[i] = temp;
			}
		}
		String line;
		while ((line = br.readLine()) != null) {
			int n = Integer.parseInt(line);
			System.out.println(hanoi4[n]);
		}
	}
}