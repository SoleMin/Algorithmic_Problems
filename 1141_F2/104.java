import java.io.*;
import java.util.*;

public class CF1141F {
	static class V {
		int l, r, a;
		V(int l, int r, int a) {
			this.l = l; this.r = r; this.a = a;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] aa = new int[n + 1];
		for (int i = 1; i <= n; i++)
			aa[i] = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= n; i++)
			aa[i] += aa[i - 1];
		int m = n * (n + 1) / 2;
		V[] vv = new V[m];
		m = 0;
		for (int i = 1; i <= n; i++)
			for (int j = i; j <= n; j++)
				vv[m++] = new V(i, j, aa[j] - aa[i - 1]);
		Arrays.sort(vv, (u, v) -> u.a != v.a ? u.a - v.a : u.r - v.r);
		int[] ii_ = new int[m];
		int[] ii = new int[m];
		int k_ = 0;
		for (int i = 0, j; i < m; i = j) {
			j = i + 1;
			while (j < m && vv[j].a == vv[i].a)
				j++;
			int k = 0, r = 0;
			for (int h = i; h < j; h++)
				if (vv[h].l > r) {
					ii[k++] = h;
					r = vv[h].r;
				}
			if (k_ < k) {
				k_ = k;
				int[] tmp = ii_; ii_ = ii; ii = tmp;
			}
		}
		pw.println(k_);
		for (int h = 0; h < k_; h++) {
			int i = ii_[h];
			pw.println(vv[i].l + " " + vv[i].r);
		}
		pw.close();
	}
}
