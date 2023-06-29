import java.io.*;
import java.util.*;

class Main {
	public static int solve(long x) {
		int cnt = 1;
		while (x > 1) {
			if (x % 2 == 0) {
				x /= 2;
			} else {
				x = 3 * x + 1;
			}
			cnt++;
		}
		return cnt;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		while (true) {
			String line = br.readLine();
			if (line == null) {
				break;
			}
			StringTokenizer st = new StringTokenizer(line);
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			out.append(x).append(' ').append(y).append(' ');
			if (x > y) {
				int tmp = x;
				x = y;
				y = tmp;
			}
			int ans = 0;
			for (int i = x; i <= y; i++) {
				ans = Math.max(ans, solve(i));
			}
			out.append(ans).append('\n');
		}
		
		System.out.print(out);
		br.close();
	}
}