import java.util.*;
import java.io.*;

public class e {
	private void main() {
		Scanner stdin = new Scanner(System.in);
		PrintStream stdout = System.out;
		int n = stdin.nextInt();
		double[][] p = new double[n][n];
		double[][] ans = new double[1<<n][n];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				p[i][j] = stdin.nextDouble();
		double[] dieChance = new double[n];
		ArrayList<Integer> sel = new ArrayList<Integer>();
		for(int i = 0; i < (1<<n); i++) {
			sel.clear();
			for(int k = 0; k < n; k++) {
				if((i & (1<<k)) != 0)
					sel.add(k);
			}
			if(sel.size() == 1) {
				ans[i][sel.get(0)] = 0;
				continue;
			}
			for(int j : sel)
				dieChance[j] = 0;
			for(int j : sel)
				for(int k : sel)
					dieChance[k] += p[j][k];
			for(int j : sel)
				dieChance[j] /= sel.size()*(sel.size()-1)/2;
			for(int j : sel) {
				ans[i][j] = dieChance[j];
				for(int k : sel)
					ans[i][j] += dieChance[k] * ans[i-(1<<k)][j];
			}
		}
		for(double d : ans[(1<<n)-1])
			stdout.format("%f ", 1-d);
		stdout.println();
	}
	public static void main(String[] args) {
		new e().main();
	}
}
