import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		ArrayList<BigInteger> fibs = new ArrayList<BigInteger>();
		fibs.add(BigInteger.ONE);
		fibs.add(BigInteger.TWO);
		BigInteger limit = BigInteger.valueOf(10).pow(100);
		for (int i = 2;; i++) {
			fibs.add(fibs.get(i - 1).add(fibs.get(i - 2)));
			if (fibs.get(i).compareTo(limit) == 1)
				break;
		}

		String line;
		while ((line = br.readLine()) != null) {
			StringTokenizer token = new StringTokenizer(line);
			BigInteger a = new BigInteger(token.nextToken());
			BigInteger b = new BigInteger(token.nextToken());
			if (a.compareTo(BigInteger.ZERO) == 0 && b.compareTo(BigInteger.ZERO) == 0)
				break;
			int index = 0;
			while (fibs.get(index).compareTo(a) == -1)
				index++;
			int count = 0;
			while (fibs.get(index).compareTo(b) != 1) {
				count++;
				index++;
			}
			sb.append(count + "\n");
		}
		System.out.print(sb);
	}
}