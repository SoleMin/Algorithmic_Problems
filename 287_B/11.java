import java.io.PrintWriter;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		doIt();
	}

	static void doIt() {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		long n = sc.nextLong();
		long k = sc.nextLong();
		long msum = (k - 1) * k / 2 + 1;
		long u = k;
		long l = 0;
		long m = (u + l) / 2;
		while(l < u){
			m = (u + l) / 2 + (u + l) % 2;
			long sum = (m - 1) * m / 2;
			if(n <= msum - sum) l = m;
			else u = m - 1;
		}
		m = (u + l) / 2 + (u + l) % 2;
		if(msum - (m - 1) * m / 2 < n) System.out.println(-1);
		else System.out.println(k - m);
	}
}
