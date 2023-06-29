import java.io.*;
import java.util.*;

public class Main {
	static Scanner in;
	static PrintWriter out;
//	static StreamTokenizer in; static int next() throws Exception {in.nextToken(); return (int) in.nval;}

	public static void main(String[] args) throws Exception {
		in = new Scanner(System.in);
		out = new PrintWriter(System.out);
//		in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

		String s = in.next();
		int n = s.length();

		int max = 0;
		for (int i = 1; i < n; i++) {
			String[] subs = new String[n - i + 1];
			for (int j = 0; j + i <= n; j++) subs[j] = s.substring(j, j + i);
			Arrays.sort(subs);
			boolean flag = false;
			for (int j = 0; j < n - i; j++)
				if (subs[j].equals(subs[j + 1])) flag = true;
			if (flag) max = Math.max(max, i);
		}

		out.println(max);

		out.close();
	}
}