import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int xs = sc.nextInt();
		int ys = sc.nextInt();
		int n = sc.nextInt();
		int[]x = new int[n], y = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		int[]single = new int[n];
		int[][]pair = new int[n][n];
		for (int i = 0; i < n; i++) {
			single[i] = 2*((x[i]-xs)*(x[i]-xs)+(y[i]-ys)*(y[i]-ys));
		}
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				pair[i][j] = (x[i]-xs)*(x[i]-xs)+(y[i]-ys)*(y[i]-ys)+(x[j]-xs)*(x[j]-xs)+(y[j]-ys)*(y[j]-ys)+(x[i]-x[j])*(x[i]-x[j])+(y[i]-y[j])*(y[i]-y[j]);
			}
		}
		int[]best = new int[1 << n], prev = new int[1 << n];
		for (int mask = 1; mask < (1 << n); mask++) {
			int i = 0;
			while ((mask & (1 << i))==0)
				i++;
			best[mask] = best[mask ^ (1 << i)]+single[i];
			prev[mask] = i+1;
			for (int j = i+1; j < n; j++) {
				if ((mask & (1 << j)) != 0) {
					int temp = best[mask ^ (1 << i) ^ (1 << j)]+pair[i][j];
					if (temp < best[mask]) {
						best[mask] = temp;
						prev[mask] = (i+1)*100+(j+1);
					}
				}
			}
		}
		System.out.println(best[(1 << n) - 1]);
		System.out.print("0 ");
		int cur = (1 << n) - 1;
		while (cur > 0) {
			int a = prev[cur]  % 100;
			int b = prev[cur] / 100;
			if (a > 0) {
				System.out.print(a+" ");
				cur ^= 1 << (a-1);
			}
			if (b > 0) {
				System.out.print(b+" ");
				cur ^= 1 << (b-1);
			}
			System.out.print(0+" ");
		}
	}
}