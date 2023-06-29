import java.io.*;
import java.math.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		List<BigInteger> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		sb.append(1);
		for (int i = 0; i < 100; i++) {
			sb.append(0);
		}
		BigInteger x = new BigInteger(sb.toString());
		list.add(BigInteger.ONE);
		list.add(BigInteger.valueOf(2));
		while (list.get(list.size() - 1).compareTo(x) < 0) {
			list.add(list.get(list.size() - 2).add(list.get(list.size() - 1)));
		}
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			BigInteger a = new BigInteger(st.nextToken());
			BigInteger b = new BigInteger(st.nextToken());
			if (a.equals(BigInteger.ZERO) && b.equals(BigInteger.ZERO)) {
				break;
			}
			int cnt = 0;
			for (BigInteger y : list) {
				if (a.compareTo(y) <= 0 && y.compareTo(b) <= 0) {
					cnt++;
				}
			}
			out.append(cnt).append('\n');
		}
		
		System.out.print(out);
		
		br.close();
	}
}