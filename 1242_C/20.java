import javafx.util.Pair;

import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Main implements Runnable
{
    boolean multiple = false;
    long MOD;

    @SuppressWarnings({"Duplicates", "ConstantConditions"})
    void solve() throws Exception
    {
        int k = sc.nextInt();
        long tar = 0;
        long[][] arr = new long[k][];
        long[] sum = new long[k];
        HashMap<Long, Pair<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < k; i++)
        {
            int ni = sc.nextInt();
            arr[i] = new long[ni];
            for (int j = 0; j < ni; j++)
            {
                sum[i] += (arr[i][j] = sc.nextInt());
                map.put(arr[i][j], new Pair<>(i, j));
            }
            tar += sum[i];
        }
        if (tar % k != 0) { System.out.println("No"); return; }
        tar /= k;
        works = new HashMap<>();
        for (int i = 0; i < k; i++)
        {
            outer: for (int j = 0; j < arr[i].length; j++)
            {
                long val = arr[i][j];
                long want = tar - sum[i] + val;
                if (!map.containsKey(want)) continue;
//                ArrayList<pli> list = new ArrayList<>();
                int key = 1 << i;
                int next = map.get(want).getKey();
//                int prev = i;
                HashSet<Integer> seen = new HashSet<>();
                seen.add(i);
                while (true)
                {
                    if (seen.contains(next))
                    {
                        if (next == i && want == arr[i][j])
                            works.put(key, (((long) i) << 32) + ((long) j));
                        break;
                    }
//                    list.add(new pli(want, prev));
                    val = arr[next][map.get(want).getValue()];
                    want = tar - sum[next] + val;
                    if (!map.containsKey(want)) continue outer;
                    key |= 1 << next;
//                    prev = next;
                    seen.add(next);
                    next = map.get(want).getKey();
                }
            }
        }
//        dp.put(0, new ArrayList<>());
        dp = new long[1 << k];
        done = new boolean[1 << k];
        yes = new boolean[1 << k];
        yes[0] = done[0] = true;
        long ans = r((1 << k) - 1);
        long[] val = new long[k];
        int[] pos = new int[k];
        if (!yes[(1 << k) - 1]) System.out.println("No");
        else
        {
//            System.out.println(ans);
//            System.out.println(map);
            System.out.println("Yes");
            while (ans >> 32 != 0)
            {
                long p = works.get((int)(ans >> 32));
                int i = (int)(p >> 32), j = (int)(p & ((1L<<32)-1));
                long VAL = arr[i][j];
                long want = tar - sum[i] + VAL;
                int key = 1 << i;
                int next = map.get(want).getKey();
                int prev = i;
                while (true)
                {
                    if (next == i)
                    {
                        val[map.get(want).getKey()] = want;
                        pos[map.get(want).getKey()] = prev + 1;
                        if (want == arr[i][j])
                            works.put(key, (((long)i)<<32) + ((long)j));
                        break;
                    }
                    val[map.get(want).getKey()] = want;
                    pos[map.get(want).getKey()] = prev + 1;
                    VAL = arr[next][map.get(want).getValue()];
                    want = tar - sum[next] + VAL;
                    key |= 1 << next;
                    prev = next;
                    next = map.get(want).getKey();
                }

                ans = dp[(int)(ans & ((1L << 32)- 1))];
            }
            for (int i = 0; i < k; i++)
                System.out.println(val[i] + " " + pos[i]);
        }
    }

    HashMap<Integer, Long> works;
    long[] dp;
    boolean[] done, yes;

    long r(int mask)
    {
        if (done[mask]) return dp[mask];
        done[mask] = true;
        for (int s = mask; s != 0; s = (s-1) & mask)
            if (works.keySet().contains(s))
            {
                int tempMask = mask;
                for (int i = 0; i < 16; i++)
                    if ((s & (1 << i)) != 0)
                        tempMask ^= 1 << i;
                r(tempMask);
                if (yes[tempMask])
                {
                    yes[mask] = true;
                    return dp[mask] = (((long)s) << 32) + tempMask;
                }
            }
        return 0;
    }

    class pii { int f, s; pii(int k, int v) { f = k; s = v; } }
    class pli { long f; int s; pli(long k, int v) { f = k; s = v; } public String toString() { return "(" + f + ", " + s + ")"; } }
    StringBuilder ANS = new StringBuilder();
    void p(Object s) { ANS.append(s); } void p(double s) {ANS.append(s); } void p(long s) {ANS.append(s); } void p(char s) {ANS.append(s); }
    void pl(Object s) { ANS.append(s); ANS.append('\n'); } void pl(double s) { ANS.append(s); ANS.append('\n'); } void pl(long s) { ANS.append(s); ANS.append('\n'); } void pl(char s) { ANS.append(s); ANS.append('\n'); } void pl() { ANS.append(('\n')); }
    /*I/O, and other boilerplate*/ @Override public void run() { try { in = new BufferedReader(new InputStreamReader(System.in));out = new PrintWriter(System.out);sc = new FastScanner(in);if (multiple) { int q = sc.nextInt();for (int i = 0; i < q; i++) solve(); } else solve(); System.out.print(ANS); } catch (Throwable uncaught) { Main.uncaught = uncaught; } finally { out.close(); }} public static void main(String[] args) throws Throwable{ Thread thread = new Thread(null, new Main(), "", (1 << 26));thread.start();thread.join();if (Main.uncaught != null) {throw Main.uncaught;} } static Throwable uncaught; BufferedReader in; FastScanner sc; PrintWriter out; } class FastScanner { BufferedReader in; StringTokenizer st; public FastScanner(BufferedReader in) {this.in = in;}public String nextToken() throws Exception { while (st == null || !st.hasMoreTokens()) { st = new StringTokenizer(in.readLine()); }return st.nextToken(); }public int nextInt() throws Exception { return Integer.parseInt(nextToken()); }public long nextLong() throws Exception { return Long.parseLong(nextToken()); }public double nextDouble() throws Exception { return Double.parseDouble(nextToken()); }
}