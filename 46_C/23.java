import java.io.*;
import java.util.*;

public class Main {
	private static boolean _READ_FROM_FILE = System.getProperty("ONLINE_JUDGE") == null;
	private static Scanner in;
	private static void core() {
		int n = in.nextInt();
		ArrayList<Character> all = new ArrayList<Character>();
		for (char ch : in.next().toCharArray()) {
			all.add(ch);
		}
		
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int now = calc(all);
			res = Math.min(res, now);
			all.add(all.get(0));
			all.remove(0);
		}
		System.out.println(res);
	}
	private static int calc(ArrayList<Character> all) {
		int nh = 0;
		for (char ch: all) {
			if (ch == 'H')
				++nh;
		}
		int r1 = 0;
		for (int i = 0; i < nh; i++) {
			if (all.get(i) != 'H')
				++r1;
		}
		
		int nt = all.size() - nh;
		int r2 = 0;
		for (int i = 0; i < nt; i++) {
			if (all.get(i) != 'T')
				++r2;
		}
		return Math.min(r1, r2);
	}
	static void debug(Object...os) {
		System.out.println(Arrays.deepToString(os));
	}
	public static void main(String[] args) throws FileNotFoundException {
		if (_READ_FROM_FILE)
			System.setIn(new FileInputStream("in.in"));
		in = new Scanner(System.in);
		core();
	}
}
