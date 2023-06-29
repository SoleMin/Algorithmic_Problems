import java.io.*;
import java.util.*;
import java.math.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		BigInteger [] cnt = new BigInteger[1000 + 1];
		
		cnt[0] = BigInteger.ZERO;
		cnt[1] = BigInteger.TWO;
		cnt[2] = BigInteger.valueOf(5);
		cnt[3] = BigInteger.valueOf(13);
		
		for (int i = 4; i <= 1000; i++) {
			cnt[i] = cnt[i-1].multiply(BigInteger.TWO);
			cnt[i] = cnt[i].add(cnt[i -2]);
			cnt[i] = cnt[i].add(cnt[i -3]);
		}
		
		while(sc.hasNextInt()) {
			int n = sc.nextInt();
			System.out.println(cnt[n]);
		}
	}
}