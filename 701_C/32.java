import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;


public class C {

	private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	private static PrintStream out = System.out;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(in.readLine());
		char[] s = in.readLine().toCharArray();
		HashSet<Character> all = new HashSet<Character>();
		for (char c : s)
			all.add(c);
		int totalCount = all.size();
		HashMap<Character, Integer> cnts = new HashMap<Character, Integer>();
		int ans = Integer.MAX_VALUE;
		int x = 0;
		for (int y = 0; y < n; ++y) {
			if (!cnts.containsKey(s[y]))
				cnts.put(s[y], 0);
			cnts.put(s[y], cnts.get(s[y]) + 1);
			if (cnts.size() < totalCount)
				continue;
			while (cnts.get(s[x]) > 1) {
				cnts.put(s[x], cnts.get(s[x]) - 1);
				++x;
			}
			ans = Math.min(ans, y - x + 1);
		}
		out.println(ans);
	}

}
