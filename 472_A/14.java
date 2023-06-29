import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	private BufferedReader cin;
	private PrintWriter cout;
	private StringTokenizer strtok;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		final boolean CONTEST = true;
		if (CONTEST) {
			sol.cin = new BufferedReader(new InputStreamReader(System.in));
			sol.cout = new PrintWriter(System.out);

		} else {
			sol.cin = new BufferedReader(new FileReader("input.txt"));
			sol.cout = new PrintWriter("output.txt");
		}
		sol.solve();
		sol.cin.close();
		sol.cout.close();
	}

	private int nextInt() throws NumberFormatException, IOException {
		return Integer.parseInt(nextToken());
	}

	private String nextToken() throws IOException {
		while (strtok == null || !strtok.hasMoreTokens()) {
			strtok = new StringTokenizer(cin.readLine());
		}
		return strtok.nextToken();
	}

	private void solve() throws IOException {
		int n = nextInt();
		if (n % 2 == 0) {
			cout.println(n - 4 + " " + 4);
		} else {
			cout.println(n - 9 + " " + 9);
		}
	}

}
