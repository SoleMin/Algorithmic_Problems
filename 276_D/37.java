import java.util.*;

public class D {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long L = sc.nextLong();
		long R = sc.nextLong();
		long res = Math.max(2 * Long.highestOneBit(L ^ R) - 1, 0);
		System.out.println(res);
	}
}
