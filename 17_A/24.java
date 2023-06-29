import java.util.Arrays;
import java.util.Scanner;


public class A {

	public static void main(String[] args) {
		new A().run();
	}

	private void run() {
		Scanner sc =new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		sc.close();
		boolean[] isp = new boolean[n + 1];
		Arrays.fill(isp, true);
		isp[1] = false;
		int[] primes = new int[n];
		int pc = 0;
		for (int i = 2; i <= n; i++) {
			if (isp[i]) {
				primes[pc++] = i;
				for (int j = i * i; j <= n; j+= i) {
					isp[j] = false;
				}
			}
		}
		int res = 0;
		for (int i = 0; i < pc; i++) {
			for (int j = 1; j < i; j++)				
					if (primes[i] == primes[j] + primes[j - 1] + 1)
						res++;
		}
		System.out.println(res >= k ? "YES" : "NO");
	}

}
