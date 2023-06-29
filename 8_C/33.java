import java.io.*;

public class CF8C {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int si = s.indexOf(' ', 0);
		int x = Integer.parseInt(s.substring(0, si));
		int y = Integer.parseInt(s.substring(si + 1));
		int n = Integer.parseInt(br.readLine());
		int[] xx = new int[n + 1];
		int[] yy = new int[n + 1];
		for (int i = 0; i < n; i++) {
			s = br.readLine();
			si = s.indexOf(' ', 0);
			xx[i] = Integer.parseInt(s.substring(0, si));
			yy[i] = Integer.parseInt(s.substring(si + 1));
		}
		xx[n] = x;
		yy[n] = y;
		int[][] dd = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++)
			for (int j = i + 1; j <= n; j++) {
				int dx = xx[i] - xx[j];
				int dy = yy[i] - yy[j];
				dd[i][j] = dx * dx + dy * dy;
			}
		int[] aa = new int[1 << n];
		int[] bb = new int[1 << n];
		for (int k = 1; k < 1 << n; k++) {
			int a = -1;
			for (int b = 0; b < n; b++)
				if ((k & 1 << b) > 0) {
					a = b;
					break;
				}
			int l = k ^ 1 << a;
			int d = dd[a][n] + dd[a][n];
			aa[k] = aa[l] + d;
			bb[k] = l;
			for (int b = a + 1; b < n; b++)
				if ((k & 1 << b) > 0) {
					l = k ^ 1 << a ^ 1 << b;
					d = dd[a][n] + dd[b][n] + dd[a][b];
					if (aa[l] + d < aa[k]) {
						aa[k] = aa[l] + d;
						bb[k] = l;
					}
				}
		}
		int k = (1 << n) - 1;
		System.out.println(aa[k]);
		StringBuilder sb = new StringBuilder();
		sb.append(0);
		while (k != 0) {
			int l = bb[k];
			int m = k ^ l;
			for (int b = 0; b < n; b++)
				if ((m & 1 << b) > 0)
					sb.append(' ').append(b + 1);
			sb.append(' ').append(0);
			k = l;
		}
		System.out.println(sb);
	}
}
