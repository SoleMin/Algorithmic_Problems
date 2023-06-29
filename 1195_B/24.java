
import java.util.*;
import java.io.*;

public class submitting {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		StringTokenizer st = new StringTokenizer(sc.nextLine());
		long n = Integer.parseInt(st.nextToken());
		long k = Integer.parseInt(st.nextToken());
		long put = n / 2;
		long lower = 0;
		long upper = n;
		while (put * (put + 1) / 2 - (n - put) != k) {
			if (put * (put + 1) / 2 - (n - put) > k) {
				upper = put - 1;
				put = (lower + upper) / 2;
			} else {
				lower = put + 1;
				put = (lower + upper) / 2;
			}
		}
		System.out.println(n - put);

		sc.close();
	}
}