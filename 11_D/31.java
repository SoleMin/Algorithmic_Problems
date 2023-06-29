import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
	InputStream fin = System.in;
	//fin = new FileInputStream("in.txt");
	Scanner cin = new Scanner(fin);

	int n = cin.nextInt();
	int m = cin.nextInt();
	int bound = 1 << n;
	boolean[][] mp = new boolean[n][n];
	long[][] dp = new long[bound][n];
	int used = 0;
	long ret = 0;
	for (int i = 0; i < n; i++) {
	    Arrays.fill(mp[i], false);
	}

	for (int i = 0; i < m; i++) {
	    int u = cin.nextInt() - 1;
	    int v = cin.nextInt() - 1;
	    mp[u][v] = mp[v][u] = true;
	}

	for (int k = 0; k < n; k++) {
	    for (int i = k; i < bound; i++) {
		Arrays.fill(dp[i], 0);
	    }
	    dp[1 << k][k] = 1;
	    for (int mask = 1 << k; mask < bound; mask++) {
		if ((mask & used) != 0)
		    continue;
		for (int i = k; i < n; i++) {
		    if (dp[mask][i] != 0) {
			if (mp[k][i] && bitcount(mask) > 2)
			    ret += dp[mask][i];
			for (int j = k; j < n; j++) {
			    if ((mask & (1 << j)) == 0 && mp[i][j]) {
				dp[mask ^ (1 << j)][j] += dp[mask][i];
			    }
			}
		    }
		}
	    }
	    used |= 1 << k;
	}

	System.out.println(ret / 2);

	fin.close();
	cin.close();
    }

    private static int bitcount(int mask) {
	// TODO Auto-generated method stub
	int ret = 0;
	while (mask > 0) {
	    ret += mask & 1;
	    mask >>= 1;
	}
	return ret;
    }
}