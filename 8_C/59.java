import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class C {

	public static void main(String[] args) {
		//long t = System.currentTimeMillis();
		new C().run();
		//System.out.println(System.currentTimeMillis() - t);
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		int sx = sc.nextInt();
		int sy = sc.nextInt();
		int n = sc.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt(); 
		}
		sc.close();
		int[] w = new int[n * n];
		int[] pMask = new int[n * n];
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int ind = i * n + j;
				if (i == j) {
					w[ind] = 2 * dist(sx, sy, x[i], y[i]);
					pMask[ind] = 1 << i;
				} else {
					w[ind] = dist(sx, sy, x[i], y[i]) + dist(x[i], y[i], x[j], y[j]) + dist(x[j], y[j], sx, sy);
					pMask[ind] = 1 << i | 1 << j;
				}
			}
		}
		int max = 1 << n;
		int[] p = new int[max];
		int[] dist = new int[max];
		Arrays.fill(dist, Integer.MAX_VALUE / 2);
		dist[0] = 0;
		int[] available = new int[n * n];
		for (int mask = 0; mask < max; mask++) {
			int ac = 0;
			for (int i = 0; i < n; i++) {
				if (((mask >> i) & 1) == 0) {
					available[ac++] = i;
				}
			}
			int s = 0;
			//for (int i = 0; i < ac; i++) {
				for (int j = s; j < ac; j++) {
					int a = available[s];
					int b = available[j];
					int ind = a * n + b;
					int nextMask = mask | pMask[ind];
					int newD = dist[mask] + w[ind];
					if (newD < dist[nextMask]) {
						dist[nextMask] = newD;
						//p[nextMask] = a * n + b;
						p[nextMask] = ind;
					}
				}
			//}
		}
		System.out.println(dist[max - 1]);
		ArrayList<Integer> steps = new ArrayList<Integer>();
		int mask = max - 1;
		while (mask > 0) {
			int msk = p[mask];
			steps.add(msk);
			int a = msk / n;
			int b = msk % n;
			if (a == b) {
				mask ^= 1 << a;
			} else {
				mask ^= 1 << a;
				mask ^= 1 << b;
			}
		}
		System.out.print(0);
		for (int i = steps.size() - 1; i >= 0; i--) {
			int msk = steps.get(i);
			int a = msk / n;
			int b = msk % n;
			if (a == b) {
				System.out.printf(" %d 0", a + 1);
			} else {
				System.out.printf(" %d %d 0", a + 1, b + 1);
			}
		}
		System.out.println();
	}

	private int dist(int x1, int y1, int x2, int y2) {
		return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
	}

}
