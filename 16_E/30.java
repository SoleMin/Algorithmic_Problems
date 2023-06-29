import java.io.*;
import java.util.*;

public class CF16E {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		double[][] aa = new double[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				aa[i][j] = Double.parseDouble(st.nextToken());
		}
		double[][] pp = new double[1 << n][n];
		for (int k = 0; k < n; k++)
			pp[1 << k][k] = 1;
		for (int b = 1; b < 1 << n; b++) {
			int c = 0;
			for (int i = 0; i < n; i++) {
				if ((b & 1 << i) == 0)
					continue;
				c++;
				for (int j = i + 1; j < n; j++) {
					if ((b & 1 << j) == 0)
						continue;
					for (int k = 0; k < n; k++) {
						if ((b & 1 << k) == 0)
							continue;
						pp[b][k] += aa[i][j] * pp[b ^ 1 << j][k];
					 	pp[b][k] += aa[j][i] * pp[b ^ 1 << i][k];
					}
				}
			}
			if (c > 1) {
				double p = (double) c * (c - 1) / 2;
				for (int k = 0; k < n; k++)
					pp[b][k] /= p;
			}
		}
		StringBuilder sb = new StringBuilder();
		int b = (1 << n) - 1;
		for (int k = 0; k < n; k++)
			sb.append(pp[b][k]).append(k == n - 1 ? '\n' : ' ');
		System.out.print(sb);
	}
}
