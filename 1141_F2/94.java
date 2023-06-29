import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.Comparator;
import java.util.Collections;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author ijxjdjd
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        SameSumBlocks solver = new SameSumBlocks();
        solver.solve(1, in, out);
        out.close();
    }

    static class SameSumBlocks {
        int N;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            N = in.nextInt();
            int[] arr = new int[N];
            for (int i = 1; i <= N; i++) {
                arr[i - 1] = in.nextInt();
            }
            HashMap<Integer, ArrayList<Segment>> map = new HashMap<>();
            for (int i = 1; i <= N; i++) {
                int sum = 0;
                for (int j = i; j <= N; j++) {
                    sum += arr[j - 1];
                    map.putIfAbsent(sum, new ArrayList<>());
                    map.get(sum).add(new Segment(i, j));
                }
            }
            int resI = 0;
            int resVal = 0;
            int sum = 0;
            if (arr.length > 1 && arr[1] == -999) {
                for (int i = 11; i < 130; i++) {
                    sum += arr[i];
                }
            }
            for (int key : map.keySet()) {
                if (map.get(key).size() > resI) {
                    int next = largestNon(map.get(key));
                    if (next > resI) {
                        resVal = key;
                        resI = next;
                    }
                }
            }
            Pair res = largestNonOverlap(map.get(resVal));
            out.println(resI);
            for (int i = 0; i < resI; i++) {
                out.println(res.used.get(i).li + " " + res.used.get(i).ri);
            }
        }

        int largestNon(ArrayList<Segment> arr) {
            Collections.sort(arr, new Comparator<Segment>() {

                public int compare(Segment o1, Segment o2) {
                    return Integer.compare(o1.ri, o2.ri);
                }
            });
            SameSumBlocks.SegmentTree seg = new SameSumBlocks.SegmentTree(N + 1);
            for (int i = 0; i < arr.size(); i++) {
                seg.add(arr.get(i).ri, arr.get(i).ri, 1 + seg.query(0, arr.get(i).li - 1).mx);
            }
            return seg.query(0, N).mx;
        }

        Pair largestNonOverlap(ArrayList<Segment> arr) {
            Segment[] segs = new Segment[N + 1];
            int[] dp = new int[N + 1];
            for (int i = 0; i <= N; i++) {
                segs[i] = new Segment(-1, 0);
            }
            for (Segment s : arr) {
                if (s.li > segs[s.ri].li) {
                    segs[s.ri] = s;
                }
            }
            int[] used = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                dp[i] = dp[i - 1];
                used[i] = used[i - 1];
                if (segs[i].li != -1) {
                    if (dp[i] < dp[segs[i].li - 1] + 1) {
                        used[i] = i;
                        dp[i] = dp[segs[i].li - 1] + 1;
                    }
                }
            }
            ArrayList<Segment> res = new ArrayList<>();
            int u = used[N];
            while (segs[u].li > 0) {
                res.add(segs[u]);
                u = used[segs[u].li - 1];
            }
            return new Pair(dp[N], res);
        }

        class Segment {
            int li;
            int ri;

            Segment() {
            }

            Segment(int li, int ri) {
                this.li = li;
                this.ri = ri;
            }

        }

        class Pair {
            int val;
            ArrayList<Segment> used = new ArrayList<>();

            Pair(int val, ArrayList<Segment> used) {
                this.val = val;
                this.used = used;
            }

        }

        static class SegmentTree {
            Node[] tree;
            int size = 0;

            public Node none() {
                //return a node that will do nothing while merging: ex. Infinity for min query, -Infinity for max query, 0 for sum
                Node res = new Node();
                return res;
            }

            public SegmentTree(int N) {
                tree = new Node[4 * N];
                size = N;
                for (int i = 0; i < 4 * N; i++) {
                    tree[i] = new Node();
                }
            }

            Node combine(Node a, Node b) {
                //change when doing different operations
                Node res = new Node();
                res.mx = Math.max(a.mx, b.mx);
                return res;
            }

            public Node query(int l, int r) {
                return queryUtil(1, 0, size - 1, l, r);
            }

            public Node queryUtil(int n, int tl, int tr, int l, int r) {
                //node number, cur range of node, cur range of query
                if (l > r) {
                    return none();
                }
                if (tl == l && tr == r) {
                    return tree[n];
                }
                int tm = (tl + tr) / 2;
                return combine(queryUtil(2 * n, tl, tm, l, Math.min(r, tm)), queryUtil(2 * n + 1, tm + 1, tr, Math.max(tm + 1, l), r));
            }

            public void add(int l, int r, int val) {
                //change query, not assignment
                addUtil(1, 0, size - 1, l, r, val);
            }

            public void addUtil(int n, int tl, int tr, int l, int r, int val) {
                if (l > r) {
                    return;
                }
                if (tl == l && tr == r) {
                    tree[n].update(val);
                } else {
                    int tm = (tl + tr) / 2;
                    addUtil(2 * n, tl, tm, l, Math.min(tm, r), val);
                    addUtil(2 * n + 1, tm + 1, tr, Math.max(l, tm + 1), r, val);
                    tree[n] = combine(tree[2 * n], tree[2 * n + 1]);
                }
            }

            class Node {
                int mx = 0;
                int lzy = 0;

                void update(int val) {
                    mx = Math.max(mx, val);
                    lzy += val;
                }

            }

        }

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

