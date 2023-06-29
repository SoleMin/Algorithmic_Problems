import java.util.*;
import java.io.*;

public class C {
	public static void main(String[] args) throws Exception {
		final int fuck = 2001;

		Scanner in = new Scanner(new File("input.txt"));
		PrintWriter out = new PrintWriter(new File("output.txt"));
		int n = in.nextInt(), m = in.nextInt();
		int[] D = new int[ fuck*fuck ], Q = new int[ fuck*(fuck + 1) ],
			dx = new int[] { 1, -1, 0, 0},
			dy = new int[] { 0, 0, -1, 1};
		Arrays.fill(D, -1);
		int H = -1, T = 0;

		int k = in.nextInt(), ans = 0;
		for(int i = 0; i < k; ++i) {
			int x = in.nextInt(), y = in.nextInt();
			D[x * fuck + y] = 0;

			++H; H %= Q.length;
			ans = Q[H] = x * fuck + y;
		}
		
		while(H >= T) {
			int idx = Q[T++]; T %= Q.length;
			int x = idx / fuck, y = idx % fuck;
			for(int i = 0; i < 4; ++i) {
				int wtf = (dx[i] + x) * fuck + (dy[i] + y);
				if(dx[i] + x <= n && dx[i] + x >= 1 && dy[i] + y <= m && dy[i] + y >= 1 && D[wtf] == -1) {
					D[wtf] = D[idx] + 1;
					++H; H %= Q.length;
					Q[H] = wtf;

					if(D[wtf] >= D[ans])
						ans = wtf;
				}
			}
		}

		out.println((ans / fuck) + " " + (ans % fuck));
		out.close();
		in.close();
	}
}