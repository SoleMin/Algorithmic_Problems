import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
	
	public Main() {
		super();
	}
	
	public static void main(String... args) {
		Main main = new Main();
		main.start();
	}
	
	public void start() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		double a[][] = new double[n][n];
		for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) a[i][j] = Double.parseDouble(in.next());
		
		int nn = 1 << n;
		double p[] = new double[nn];
		Arrays.fill(p, -1.0);
        p[nn - 1] = 1.0;

		DecimalFormat f = new DecimalFormat();
		f.applyPattern("0.000000");
		for (int i = 0; i < n; i++) {
			if (i != 0) System.out.print(" ");
			System.out.print(f.format(this.probability(a, p, 1 << i)));
		}
	}
	
	private double probability(double a[][], double p[], int i) {
        if (p[i] >= 0.0) return p[i];
        double ans = 0;
        int count = Integer.bitCount(i);
        int n = a.length;
        for (int j = 0; j < n; j++) {
            int jj = 1 << j;
            if ((jj & i) == 0) {
                double d = this.probability(a, p, jj | i);
                double dPair = 2.0 / (double)((count + 1) * count);
                double s = 0;
                for (int l = 0; l < n; l++) {
                    int ll = 1 << l;
                    if ((ll & i) != 0) s += a[l][j];
                }
                ans += d * dPair * s;
            }
        }
        p[i] = ans;
        return p[i];
    }


	
}