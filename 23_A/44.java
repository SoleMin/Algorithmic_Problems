import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.TreeSet;
import java.util.StringTokenizer;
import java.util.AbstractCollection;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Zyflair Griffane
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		PandaScanner in = new PandaScanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		A solver = new A();
		solver.solve(1, in, out);
		out.close();
	}
}

class A {
    public void solve(int testNumber, PandaScanner in, PrintWriter out) {
        String s = in.next();
        String[] ss = Substring.allSubstrings(s);
        int res = 0;
        for (String sss: ss) {
            if (sss.length() <= res) continue;
            if (Substring.occurences(s, sss).length > 1) {
                res = sss.length();
            }
        }
        out.println(res);
    }
}

class PandaScanner {
    public BufferedReader br;
    public StringTokenizer st;
    public InputStream in;

    public PandaScanner(InputStream in) {
        br = new BufferedReader(new InputStreamReader(this.in = in));
    }

    public String nextLine() {
        try {
            return br.readLine();
        }
        catch (Exception e) {
            return null;
        }
    }

    public String next() {
        if (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(nextLine().trim());
            return next();
        }
        return st.nextToken();
    }

    }

class Substring {

    public static String[] allSubstrings(String s) {
        TreeSet<String> substrings = new TreeSet<String>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                substrings.add(s.substring(i, j));
            }
        }
        return substrings.toArray(new String[0]);
    }

    public static int[] occurences(String s, String target) {
        int n = s.length();
        ArrayList<Integer> res = new ArrayList<Integer>();
        int idx = s.indexOf(target);
        while (idx != -1) {
            res.add(idx);
            if (idx == n - 1) break;
            idx = s.indexOf(target, idx + 1);
        }
        n = res.size();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }
}

