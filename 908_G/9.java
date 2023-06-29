import java.io.*;
import java.util.*;

public class cf908G {
	final static int MOD = 1_000_000_007;
	
	public static void main(String[] argv) {
		cf908G pro = new cf908G();
		
		InputStream fin = null;
		if (System.getProperty("ONLINE_JUDGE") == null) {
			try {
				fin = new FileInputStream("input.txt");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			fin = System.in;
		}
		pro.solve(new Scanner(fin), System.out);
	}
	
	private void solve(Scanner scanner, PrintStream out) {
		long ans = 0;
		String X = scanner.next();
		for (int x = 0; x < 9; x++) {
			ans = (ans + solve2(x, X)) % MOD;
		}
		out.println((ans % MOD + MOD) % MOD);
	}

	private long solve2(int x, String X) {
		int[][][] f = new int[X.length() + 1][X.length() + 1][2];
		f[0][0][1] = 1;
		
		int n = X.length();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= n; j++) {
				for (int u = 0; u < 2; u++) {
					int val = f[i][j][u];
					if (val == 0) continue;
					
					for (int num = 0; num < 10; num++) {
						int Xi = X.charAt(i) - '0';
						if (u == 1 && num > Xi) break;
						int _i = i + 1;
						int _j = num <= x ? j + 1 : j;
						int _u = u == 1 && num == Xi ? 1 : 0;
						
						f[_i][_j][_u] = (f[_i][_j][_u] + val) % MOD;
					}
				}
			}
		}
		
		long base = 1;
		long ret = 0;
		for (int i = n; i > 0; i--) {
			long t = 0;
			for (int j = 0; j < i; j++) {
				t = (t + f[n][j][0] + f[n][j][1]) % MOD;
			}
			
			ret = (ret + base * t) % MOD;
			
			base = (base * 10) % MOD;
		}
		return ret;
	}
	
}