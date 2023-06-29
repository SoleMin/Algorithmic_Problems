import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by IntelliJ IDEA.
 * User: piyushd
 * Date: Dec 5, 2010
 * Time: 4:09:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class HamstersTigers {
    private BufferedReader in;
    private PrintWriter out;
    private StringTokenizer st;

	int solve(String a, int k){
		int n = a.length(), ret = 0;
		int temp[] = new int[n];
		for(int i = 0; i < n; i++) temp[(n + i - k) % n] = (a.charAt(i) == 'T') ? 1: 0;
		int left = 0, right = n - 1;
		while(left < right){
			while(temp[left] == 0) left++;
			while(temp[right] == 1) right--;
			if(left < right){
				int t = temp[left];
				temp[left] = temp[right];
				temp[right] = t;
				ret++;
			}
		}
		return ret;
	}

    void solve() throws IOException {
		int n = nextInt();
		String a = next();
		int ans = Integer.MAX_VALUE;
		for(int fix = 0; fix < n; fix++){
			ans = Math.min(ans, solve(a, fix));
		}
		out.println(ans);
    }

    HamstersTigers() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        //in  = new BufferedReader(new InputStreamReader(new FileInputStream(new File("C://Users/piyushd/Desktop/codeforces/sample.txt"))));
        out = new PrintWriter(System.out);

        eat("");

        solve();

        in.close();
        out.close();
    }

    private void eat(String str) {
        st = new StringTokenizer(str);
    }

    String next() throws IOException {
        while (!st.hasMoreTokens()) {
            String line = in.readLine();
            if (line == null) {
                return null;
            }
            eat(line);
        }
        return st.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    public static void main(String[] args) throws IOException {
        new HamstersTigers();
    }
}
