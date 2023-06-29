import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Main {
	public static BufferedReader in;
	public static PrintWriter out;

	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);

		boolean showLineError = true;
		if (showLineError) {
			solve();
			out.close();
		} else {
			try {
				solve();
			} catch (Exception e) {
			} finally {
				out.close();
			}
		}

	}

	static void debug(Object... os) {
		out.println(Arrays.deepToString(os));
	}

	private static void solve() throws IOException {
		String[] line = nss();
		int n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);

		boolean[][] matrix = new boolean[n][n];
		for (int i = 0; i < m; i++) {
			line = nss();
			int u = Integer.parseInt(line[0]) - 1;
			int v = Integer.parseInt(line[1]) - 1;
			matrix[u][v] = matrix[v][u] = true;
		}
		long[][] dp = new long[1<<n][n];
		for(int i=0;i<n;i++)
			dp[1<<i][i]=1;
		long ret=0;
		for(int mask =0;mask< 1<<n;mask++){
			for(int last =0;last<n;last++)
				if((mask & (1<<last))!=0){
					int first=-1;
					for(first=0;first<n;first++)
						if((mask & (1<<first))!=0)
							break;
					for(int add =first;add<n;add++)
						if((mask & (1<<add))==0 && matrix[last][add])
							dp[mask+ (1<<add)][add]+=dp[mask][last];
							
					if(Long.bitCount(mask)>2 && matrix[first][last])	
						ret+=dp[mask][last];
				}
		}
		out.println(ret/2L);

	}

	private static String[] nss() throws IOException {
		return in.readLine().split(" ");
	}

	private static int ni() throws NumberFormatException, IOException {
		return Integer.parseInt(in.readLine());
	}
}