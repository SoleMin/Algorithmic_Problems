import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	public static int gcd(int a , int b) {
		if (b == 0) return 0;
		else {
			return a / b + gcd (b , a % b);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int testCase = sc.nextInt();

		while (testCase-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			if (n < m) {
				int temp = n;
				n = m;
				m = temp;
			}	

			int ans = gcd (n , m);
			System.out.println(ans);
		}
	}
}