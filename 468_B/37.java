import java.util.ArrayList;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.io.BufferedReader;
import java.util.List;
import java.util.Map;
import java.math.BigInteger;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author shu_mj @ http://shu-mj.com
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		Scanner in = new Scanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskB solver = new TaskB();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskB {
    Scanner in;
    PrintWriter out;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        this.in = in;
        this.out = out;
        run();
    }

    void run() {
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int[] is = in.nextIntArray(n);
        Map<Integer, Integer> id = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            id.put(is[i], i);
        }
        SCC.V[] vs = new SCC.V[n * 2];
        for (int i = 0; i < vs.length; i++) vs[i] = new SCC.V();
        for (int i = 0; i < n; i++) {
            if (id.containsKey(a - is[i])) {
                int j = id.get(a - is[i]);
                vs[i].add(vs[j]);
                vs[j + n].add(vs[i + n]);
            } else {
                vs[i].add(vs[i + n]);
            }
            if (id.containsKey(b - is[i])) {
                int j = id.get(b - is[i]);
                vs[i + n].add(vs[j + n]);
                vs[j].add(vs[i]);
            } else {
                vs[i + n].add(vs[i]);
            }
        }
        SCC.scc(vs);
        for (int i = 0; i < n; i++) {
            if (vs[i].comp == vs[i + n].comp) {
                out.println("NO");
                return ;
            }
        }
        out.println("YES");
        for (int i = 0; i < n; i++) {
            if (vs[i].comp > vs[i + n].comp) {
                out.print("0 ");
            } else {
                out.print("1 ");
            }
        }
        out.println();
    }
}

class Scanner {
    BufferedReader br;
    StringTokenizer st;

    public Scanner(InputStream in) {
        br = new BufferedReader(new InputStreamReader(in));
        eat("");
    }

    private void eat(String s) {
        st = new StringTokenizer(s);
    }

    public String nextLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    public boolean hasNext() {
        while (!st.hasMoreTokens()) {
            String s = nextLine();
            if (s == null)
                return false;
            eat(s);
        }
        return true;
    }

    public String next() {
        hasNext();
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public int[] nextIntArray(int n) {
        int[] is = new int[n];
        for (int i = 0; i < n; i++) {
            is[i] = nextInt();
        }
        return is;
    }

}

class SCC {

    public static int n;
    public static V[] us;

    public static int scc(V[] vs) {
        n = vs.length;
        us = new V[n];
        for (V v : vs) if (!v.visit) dfs(v);
        for (V v : vs) v.visit = false;
        for (V u : us) if (!u.visit) dfsRev(u, n++);
        return n;
    }

    public static void dfs(V v) {
        v.visit = true;
        for (V u : v.fs) if (!u.visit) dfs(u);
        us[--n] = v;
    }

    public static void dfsRev(V v, int k) {
        v.visit = true;
        for (V u : v.rs) if (!u.visit) dfsRev(u, k);
        v.comp = k;
    }

    public static class V {
        public boolean visit;
        public int comp;
        public List<V> fs = new ArrayList<V>();
        public List<V> rs = new ArrayList<V>();

        public void add(V u) {
            fs.add(u);
            u.rs.add(this);
        }
    }
}

