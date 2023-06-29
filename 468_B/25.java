import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;


public class B {	
	BufferedReader reader;
    StringTokenizer tokenizer;
    PrintWriter out;
    
	public void solve() throws IOException {				
		int N = nextInt();
        int A = nextInt();
        int B = nextInt();

        int[] nsA = new int[N];
        int[] nsB = new int[N];
        char[] ans = new char[N];

        Arrays.fill(nsA, -1);
        Arrays.fill(nsB, -1);
        Arrays.fill(ans, 'C');

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] P = new int[N];
		for (int i = 0; i < N; i++) {
            P[i] = nextInt();
            map.put(P[i], i);
        }

        // if A == B
        if (A == B) {
            for (int i = 0; i < N; i++) {
                if (!map.containsKey(A - P[i])) {
                    out.println("NO"); return;
                }
            }

            out.println("YES");
            for (int i = 0; i < N; i++) {
                out.print(0 + " ");
            }
            out.println();
            return;
        }


        for (int i = 0; i < N; i++) {
            int oppA = A - P[i];
            int oppB = B - P[i];

            if (map.containsKey(oppA)) {
                nsA[i] = map.get(oppA);
            }

            if (map.containsKey(oppB)) {
                nsB[i] = map.get(oppB);
            }
        }

        for (int i = 0; i < N; i++) {
            if (nsA[i] == -1 && nsB[i] == -1) {
                out.println("NO");
                return;
            }
        }

        for (int i = 0; i < N; i++) {
            if (ans[i] != 'C') continue;

            if (nsA[i] == -1) {
                if (!go(i, 'B', ans, nsA, nsB) ){
                    out.println("NO"); return;
                }
            } else if (nsB[i] == -1) {
                if (!go(i, 'A', ans, nsA, nsB) ){
                    out.println("NO"); return;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (ans[i] != 'C') continue;

            if (nsA[i] == i || nsB[i] == i) {
                if (nsA[i] == i) {
                    if (!go(i, 'B', ans, nsA, nsB) ){
                        out.println("NO"); return;
                    }
                } else {
                    if (!go(i, 'A', ans, nsA, nsB) ){
                        out.println("NO"); return;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (ans[i] != 'C') continue;

            if (!go(i, 'A', ans, nsA, nsB) ){
                out.println("NO"); return;
            }
        }

        for (int i = 0; i < N; i++) {
            if (ans[i] == 'C') {
                out.println("NO");
                return;
            }
        }

        out.println("YES");
        for (int i = 0; i < N; i++) {
            out.print(ans[i] == 'A'? 0: 1);
            out.print(" ");
        }
        out.println();
	}

    public boolean go(int cur, char link, char[] ans, int[] nsA, int[] nsB) {
        while (ans[cur] == 'C') {
            int next = link == 'A'? nsA[cur]: nsB[cur];

            if (next == -1) return false;
            if (ans[next] != 'C') return false;
            ans[cur] = link;
            ans[next] = link;


            int nextNext = link == 'A'? nsB[next]: nsA[next];
            cur = nextNext;

            if (cur == -1) return true;

        }

        return true;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new B().run();
	}
	
	public void run() {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
            out = new PrintWriter(System.out);
            solve();
            reader.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

}
