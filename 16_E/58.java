import java.util.Locale;
import java.util.Scanner;

public class E {
	public static void main(String[] args) {
		new E().run();
	}

	private void run() {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double[][] p = new double[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				p[i][j] = sc.nextDouble();
		}
		sc.close();
		double[] w = new double[1 << n];
		int max = (1 << n) - 1;
		w[max] = 1;
		for (int mask = max; mask > 0; mask--) {
			int count = 0;
			for (int i = 0; i < n; i++)
				if (((mask >> i) & 1) > 0)
					for (int j = i + 1; j < n; j++)
						if (((mask >> j) & 1) > 0) {
							count++;
						}
			if (count > 0)
				for (int i = 0; i < n; i++)
					if (((mask >> i) & 1) > 0)
						for (int j = i + 1; j < n; j++)
							if (((mask >> j) & 1) > 0) {
								w[mask ^ (1 << j)] += w[mask] * p[i][j] / count;
								w[mask ^ (1 << i)] += w[mask] * (1 - p[i][j])
										/ count;
							}
		}
		for (int i = 0; i < n; i++) {
			if (i != 0)
				System.out.print(' ');
			System.out.printf("%.6f", w[1 << i]);
		}
		System.out.println();
	}
}
