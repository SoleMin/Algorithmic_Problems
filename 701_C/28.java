import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class C {
	public static void main(String[] args) throws IOException {
		File inputFile = new File("entradaC");
		if (inputFile.exists())
			System.setIn(new FileInputStream(inputFile));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		String line = "";
		while ((line = in.readLine()) != null) {
			int n = Integer.parseInt(line);
			char[] p = in.readLine().toCharArray();
			HashMap<Character, Integer> dif = new HashMap<>();
			for (int i = 0; i < p.length; i++)
				dif.put(p[i], 0);
			int ndif = dif.size();
			int head = 0, tail = 0, cnt = 0, ans = Integer.MAX_VALUE, cur;
			while (head < n) {
				cur = dif.get(p[head]);
				if (cur == 0)
					cnt++;
				dif.put(p[head], cur + 1);
				head++;
				if (cnt == ndif)
					ans = Math.min(ans, head - tail);
				while (tail < head && cnt == ndif) {
					cur = dif.get(p[tail]);
					if (cur == 1)
						cnt--;
					dif.put(p[tail], cur - 1);
					tail++;
					if (cnt == ndif)
						ans = Math.min(ans, head - tail);
				}
			}
			if (ndif == 1)
				ans = 1;
			out.append(ans + "\n");

		}
		System.out.print(out);
	}

	static int[] readInts(String line) {
		StringTokenizer st = new StringTokenizer(line.trim());
		int a[] = new int[st.countTokens()], index = 0;
		while (st.hasMoreTokens())
			a[index++] = Integer.parseInt(st.nextToken());
		return a;
	}

	static long[] readLongs(String line) {
		StringTokenizer st = new StringTokenizer(line.trim());
		long a[] = new long[st.countTokens()];
		int index = 0;
		while (st.hasMoreTokens())
			a[index++] = Long.parseLong(st.nextToken());
		return a;
	}

	static double[] readDoubles(String line) {
		StringTokenizer st = new StringTokenizer(line.trim());
		double a[] = new double[st.countTokens()];
		int index = 0;
		while (st.hasMoreTokens())
			a[index++] = Double.parseDouble(st.nextToken());
		return a;
	}
}
