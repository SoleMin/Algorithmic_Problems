import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main implements Runnable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Thread(new Main()).start();
	}

	public void run() {
		Locale.setDefault(Locale.US);
		try {
			run1();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	int nextInt(StreamTokenizer st) throws IOException {
		st.nextToken();
		return (int) st.nval;
	}

	private List<Integer> kmp(String x, String a) {
		String s = a + "$" + x;
		int[] oppa = new int[s.length()];
		oppa[0] = 0;
		int tmp = 0;
		List<Integer> res = new ArrayList<Integer>();
		for (int i = 1; i < s.length(); i++) {
			while (tmp != 0 && s.charAt(tmp) != s.charAt(i)) {
				// System.out.println(i + " " + tmp);
				tmp = oppa[tmp - 1];
			}
			if (s.charAt(tmp) == s.charAt(i))
				tmp++;
			oppa[i] = tmp;
			if (tmp == a.length()) {
				res.add(i - a.length() - a.length());
			}
		}
		return res;
	}

	double nextDouble(StreamTokenizer st) throws IOException {
		st.nextToken();
		return st.nval;
	}

	String nextLine(StreamTokenizer st) throws IOException {
		st.nextToken();
		return st.sval;
	}

	int cnt = 0;
	int[] col;

	void unite(int a, int b) {
		if (cnt % 2 == 0)
			col[getCol(a)] = getCol(b);
		else
			col[getCol(b)] = getCol(a);
		cnt++;
	}

	int getCol(int a) {
		return a == col[a] ? a : (col[a] = getCol(col[a]));
	}

	public void run1() throws IOException {
//		 Scanner sc = new Scanner(new FileReader("input.txt"));
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		// BufferedReader br = new BufferedReader(new
		// InputStreamReader(System.in));
		// PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));
		String s= sc.next();
		int res = 0;
		int n = s.length();
		for(int i = 0; i < n; i++)
			for(int j = i + 1; j < n; j++) {
				int k = 0;
				while(j + k < n && s.charAt(i + k) == s.charAt(j + k))
					k++;
					res = Math.max(res, k);
			}
		System.out.println(res);
	}
}