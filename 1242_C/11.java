import java.util.*;
import java.io.*;

public class C599 {
    static ArrayList<Integer> [] adj;
    static long [] a; static int [] type;
    static Map<Long, Integer> map;
    static int [] vis;
    static HashSet<Integer> cy;
    static boolean [] good;
    static int [] dp;
    static HashSet<Integer> [] nodes;
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int k = sc.nextInt();
        int cur = 0;
        a = new long[75007]; long sum = 0;
        type = new int[75007];
        map = new HashMap<>();
        long [] typeSum = new long[k];
        for (int i = 0; i < k; i++) {
            int n = sc.nextInt(); long temp = sum;
            for (int j = 0; j < n; j++) {
                cur++;
                a[cur] = sc.nextLong();
                type[cur] = i;
                map.put(a[cur], cur);
                sum += a[cur];
            }
            typeSum[i] = sum - temp;
        }
        boolean notDiv = sum % k != 0;
        long need = sum / k;
        int n = cur;
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            long delta = need - typeSum[type[i]];
            long find = a[i] + delta;
            if (map.containsKey(find)) {
                if (type[map.get(find)] != type[i] || delta == 0) adj[i].add(map.get(find));
            }
        }
        vis = new int[n + 1];
        good = new boolean[1 << k];
        good[0] = true;
        nodes = new HashSet[1 << k];
        for (int i = 1; i <= n; i++) {
            if (vis[i] == 0) {
                cy = new HashSet<>();
                boolean b = dfs(i);
                int mask = 0;
                for (Integer node: cy) {
                    mask |= (1 << type[node]);
                }
                if (mask != 0) nodes[mask] = cy;
                good[mask] = true;
            }
        }
        dp = new int[1 << k];
        Arrays.fill(dp, -1);
        int possible = solve((1 << k) - 1);
        if (possible == 1 && !notDiv) {
            ArrayList<Integer> masks = dfs2((1 << k) - 1);

            long [] num = new long[k];
            int [] ret = new int[k];
            for (Integer mask: masks) {
                for (Integer node: nodes[mask]) {
                    num[type[node]] = a[node];
                    ret[type[adj[node].get(0)]] = type[node] + 1;
                }
            }
            boolean good = true; Set<Integer> soFar = new HashSet<>();
            for (int i = 0; i < ret.length; i++) {
                if (soFar.contains(ret[i])) good = false;
                soFar.add(ret[i]);
            }
            if (!good) {
                out.println("No");
                out.close();
                return;
            }
            out.println("Yes");
            for (int i = 0; i < k; i++) {
                out.println(num[i] + " " + ret[i]);
            }
        } else {
            out.println("No");
        }
        out.close();
    }

    static int solve(int mask) {
        if (dp[mask] != -1) return dp[mask];
        if (good[mask]) return dp[mask] = 1;
        int ret = 0;
        for (int i = (mask - 1) & mask; i > 0; i = (i - 1) & mask) {
            ret = solve(i) & solve(mask ^ i);
            if (ret == 1) break;
        }
        return dp[mask] = ret;
    }
    static ArrayList<Integer> dfs2(int mask) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (good[mask]) {
            ret.add(mask);
            return ret;
        }
        for (int i = (mask - 1) & mask; i > 0; i = (i - 1) & mask) {
            if (dp[i] == 1 && dp[mask ^ i] == 1) {
                ArrayList<Integer> one = dfs2(i);
                ArrayList<Integer> two = dfs2(mask ^ i);
                ret.addAll(one); ret.addAll(two);
                break;
            }
        }
        return ret;
    }

    static boolean dfs(int cur) {
        vis[cur] = 1; boolean ret = false;
        for (Integer next: adj[cur]) {
            if (vis[next] == 0) {
                boolean cycle = dfs(next);
                if (cycle) {
                    if (!cy.contains(cur)) {
                        cy.add(cur);
                        ret = true; break;
                    }
                }
            } else if (vis[next] == 1) {
                cy.add(next);
                cy.add(cur);
                if (next != cur) ret = true;
                break;
            }
        }
        vis[cur] = 2;
        return ret;
    }


    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }


    }

}