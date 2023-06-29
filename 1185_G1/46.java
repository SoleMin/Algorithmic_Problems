import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class G_PlaylistForPolycarp {

	static final int mod = 1000000007;

	static int dp[][];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] dat = br.readLine().split(" ");

		int n = Integer.parseInt(dat[0]);
		int T = Integer.parseInt(dat[1]);

		int[] st = new int[n];
		byte[] sg = new byte[n];

		dp = new int[1 << (n + 1)][4];

		for (int j = 0; j < 1 << (n + 1); j++) {
			for (int k = 0; k < 4; k++) {
				dp[j][k] = -1;
			}
		}

		for (int i = 0; i < n; i++) {
			dat = br.readLine().split(" ");
			st[i] = Integer.parseInt(dat[0]);
			sg[i] = Byte.parseByte(dat[1]);
		}

		short visited = 0;

		int count = recur(0, visited, st, sg, T, 0);

		bw.write(count + "\n");

		bw.close();

	}

	private static int recur(int time, short visited, int[] st, byte[] sg, int T, int last) {

		int count = 0;

		if (dp[visited][last] != -1) {
			return dp[visited][last];
		}

		for (int i = 0; i < st.length; i++) {

			if ((visited & (1 << i)) == 0 && sg[i] != last) {

				if (time + st[i] == T) {
					count += 1;
				} else if (time + st[i] < T) {
					short visitedc = (short) (visited | (1 << i));
					count += recur(time + st[i], visitedc, st, sg, T, sg[i]);
					if (count > mod) {
						count = count % mod;
					}
				}

			}

		}

		return dp[visited][last] = count % mod;
	}

}
