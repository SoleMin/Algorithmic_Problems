import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;


public class Task16e {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double[][] prob = new double[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				prob[i][j] = sc.nextDouble();
			}
		}
		double[] var = new double[1 << n];
		boolean[] was = new boolean[1 << n];
		Arrays.fill(var, 0.0);
		Arrays.fill(was, false);
		was[0] = true;
		var[(1 << n) - 1] = 1.0;
		Set<Integer> cr = new HashSet<Integer>();
		Set<Integer> nx = new HashSet<Integer>();
		nx.add((1 << n) - 1);
		boolean[] fish = new boolean[n];
		for (int cnt = 0; cnt < n -1; cnt++) {
			cr.clear();
			cr.addAll(nx);
			nx.clear();
			for (Iterator<Integer> iterator = cr.iterator(); iterator.hasNext();) {
				int curr = iterator.next();
				for (int i = 0; i < n; i++) {
					fish[i] = ((1 << i) & curr) != 0;
				}
				int fishn = 0;
				for (int i = 0; i < n; i++) {
					if (fish[i]) fishn++;
				}
				if (fishn == 1) continue;
				
				for (int i = 0; i < n; i++) {
					if (!fish[i]) continue;
					for (int j = i + 1; j < n; j++) {
						if (!fish[j]) continue;
						int woi = curr & ~(1 << i);
						int woj = curr & ~(1 << j);
						var[woi] += var[curr] * prob[j][i];
						var[woj] += var[curr] * prob[i][j];
						nx.add(woi);
						nx.add(woj);
					}
				}
			}
		}
		double sum = 0.0;
		for (int i = 0; i < n; i++) {
			sum += var[1 << i];
		}
		for (int i = 0; i < n; i++) {
			System.out.printf("%.6f ", var[1 << i] / sum);
		}
	}

}
