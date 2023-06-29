import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class C {

	static int[] nm;
	static int ans = 0;
	static int rows, cols;
	static boolean[][] cae;
	static int[][] ca;

	public static void main(String[] args) throws IOException {
		nm = readIntArray();
		rows = Math.max(nm[0], nm[1]);
		cols = Math.min(nm[0], nm[1]);
		
		long s = System.currentTimeMillis();
		cae = new boolean[1000][50];
		ca = new int[1000][50];

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < cols; i++) {
			sb.append('1');
		}
		int startingState = Integer.parseInt(sb.toString(), 3);
		ans = solve(startingState, 0);

		System.out.println(nm[0]*nm[1] - ans);
//		System.out.println(System.currentTimeMillis() - s );
	}

	static int solve(int state, int row) {
		if (row == rows) {
			return 0;
		}
		if (cae[state][row]) {
			return ca[state][row];
		}

		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < Math.pow(3, cols); i++) {
			boolean isCover = covers(i, state);
			if (isCover && (row < rows - 1 || coversTotally(i, state))) {
				int p = placed(i);
				int s = solve(i, row + 1);
				ans = Math.min(ans, s + p);
			}
		}

		cae[state][row] = true;
		ca[state][row] = ans;

		return ans;
	}

	private static boolean coversTotally(int i, int state) {
			
		String bottom = decode(i);
		for (int j = 0; j < bottom.length(); j++) {
			if (bottom.charAt(j) == '0') {
				return false;
			}
		}
		return true;
	}

	private static boolean covers(int i, int state) {
		String top = decode(state);
		String bottom = decode(i);

		for (int j = 0; j < top.length(); j++) {
			if (top.charAt(j) == '0' && bottom.charAt(j) != '2') {
				return false;
			}
			if (top.charAt(j) == '2' && bottom.charAt(j) == '0') {
				return false;
			}
		}

		for (int j = 0; j < top.length(); j++) {
			if (bottom.charAt(j) == '1' && (top.charAt(j) != '2' && !(j > 0 && bottom.charAt(j-1) == '2') && !(j < top.length() - 1 && bottom.charAt(j+1) == '2'))) {
				return false;
			}
		}

		return true;
	}

	private static int placed(int i) {
		String s = decode(i);
		int cnt = 0;
		for (int j = 0; j < s.length(); j++) {
			if (s.charAt(j) == '2') {
				cnt++;
			}
		}

		return cnt;
	}

	private static String decode(int state) {		
		String tmp = Integer.toString(state, 3);
		if (tmp.length() < cols) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < cols - tmp.length(); i++) {
				sb.append('0');
			}		
			sb.append(tmp);
			return sb.toString();
		} else {
			return tmp;
		}		
	}

	static int countDispositionDivisors(int[] d) {
		HashSet<Integer> div = new HashSet<Integer>();
		for (int i = 1; i <= d.length; i++) {
			for (int j = 0; j < d.length; j++) {
				if ((j + 1) % i == 0 && d[j] % i == 0) {
					div.add(j + 1);
					break;
				}
			}
		}

		return div.size();
	}

	static InputStreamReader isr = new InputStreamReader(System.in);
	static BufferedReader br = new BufferedReader(isr);

	static int[] readIntArray() throws IOException {
		String[] v = br.readLine().split(" ");
		int[] ans = new int[v.length];

		for (int i = 0; i < ans.length; i++) {
			ans[i] = Integer.valueOf(v[i]);
		}

		return ans;
	}

	static long[] readLongArray() throws IOException {
		String[] v = br.readLine().split(" ");
		long[] ans = new long[v.length];

		for (int i = 0; i < ans.length; i++) {
			ans[i] = Long.valueOf(v[i]);
		}

		return ans;
	}

	static <T> void print(List<T> v) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < v.size(); i++) {
			if (sb.length() > 0) {
				sb.append(' ');
			}

			sb.append(v.get(i));
		}

		System.out.println(sb);
	}
}
