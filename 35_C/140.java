import java.io.*;
import java.util.*;

public class FireAgain {

    public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		System.setOut(new PrintStream("output.txt"));
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		String s[] = r.readLine().split("\\s+");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		int k = Integer.parseInt(r.readLine());
		int[][] a = new int[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++)
				a[i][j] = Integer.MAX_VALUE;
		}
		assert k >= 1 && k < n * m;
		int max = 0;
		StringTokenizer st = new StringTokenizer(r.readLine());
		assert st.countTokens() == k;
		for(; k > 0; k--) {
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			assert x >= 1 && x <= n && y >= 1 && y <= n;

			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					int d = Math.abs(i - x) + Math.abs(j - y);
					if(a[i][j] > d)
						a[i][j] = d;
					if(k == 1 && a[i][j] > max)
						max = a[i][j];
				}
			}
		}

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(a[i][j] == max) {
					System.out.println((i + 1) + " " + (j + 1));
					return;
				}
			}
		}
    }

}
