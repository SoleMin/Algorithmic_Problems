import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author beginner1010
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskE solver = new TaskE();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskE {
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean[] dp;
        boolean[] vis;
        boxPair[] ans;

        int two(int bit) {
            return 1 << bit;
        }

        boolean contain(int mask, int bit) {
            return ((two(bit) & mask) > 0);
        }

        int get(long val) {
            if (val > Integer.MAX_VALUE || val < Integer.MIN_VALUE) return -1;
            int key = (int) val;
            if (map.containsKey(key) == false) return -1;
            return map.get(key);
        }

        boolean rec(int mask, boolean[] hasCycle) {
            if (hasCycle[mask]) return true;
            if (vis[mask] == true) return dp[mask];
            vis[mask] = true;
            for (int i = mask & (mask - 1); i > 0; i = mask & (i - 1)) {
                if (rec(i, hasCycle) && rec(i ^ mask, hasCycle)) {
                    return dp[mask] = true;
                }
            }
            return dp[mask] = false;
        }

        void findPath(int mask, boolean[] hasCycle, ArrayList<boxPair>[] maskPath) {
            if (hasCycle[mask]) {
                for (boxPair b : maskPath[mask]) {
                    ans[get(b.addTo)] = b;
                }
                return;
            }
            for (int i = mask & (mask - 1); i > 0; i = mask & (i - 1)) {
                if (rec(i, hasCycle) && rec(i ^ mask, hasCycle)) {
                    findPath(i, hasCycle, maskPath);
                    findPath(i ^ mask, hasCycle, maskPath);
                    return;
                }
            }
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int k = in.nextInt();
            int[][] a = new int[k][];
            int[] n = new int[k];
            long[] sum = new long[k];

            long S = 0;
            for (int i = 0; i < k; i++) {
                n[i] = in.nextInt();
                a[i] = new int[n[i]];
                for (int j = 0; j < n[i]; j++) {
                    a[i][j] = in.nextInt();
                    sum[i] += a[i][j];
                    map.put(a[i][j], i);
                }
                S += sum[i];
            }
            if (S % k != 0) out.println("No");
            else {
                ArrayList<boxPair>[] maskPath = new ArrayList[two(k)];
                boolean[] hasCycle = new boolean[two(k)];
                for (int i = 0; i < two(k); i++) {
                    maskPath[i] = new ArrayList<>();
                }
                long balance = S / k;
                for (int i = 0; i < k; i++) {
                    for (int j = 0; j < n[i]; j++) {
                        long remove = a[i][j];
                        int curID = i;
                        int curMask = 0;
                        ArrayList<boxPair> curPath = new ArrayList<>();
                        while (true) {
                            curMask |= two(curID);
                            remove = (balance - (sum[curID] - remove));
                            int nxtID = get(remove);
                            curPath.add(new boxPair(curID, (int) remove));
                            if (nxtID == i && remove == a[i][j]) {
                                if (hasCycle[curMask] == false) {
                                    hasCycle[curMask] = true;
                                    maskPath[curMask] = curPath;
                                }
                                break;
                            }
                            if (nxtID == -1 || contain(curMask, nxtID)) break;
                            curID = nxtID;
                        }
                    }
                }
                vis = new boolean[two(k)];
                dp = new boolean[two(k)];
                if (rec(two(k) - 1, hasCycle) == false) out.println("No");
                else {
                    ans = new boxPair[k];
                    findPath(two(k) - 1, hasCycle, maskPath);
                    out.println("Yes");
                    for (int i = 0; i < k; i++) {
                        out.println(ans[i].addTo + " " + (ans[i].boxID + 1));
                    }
                }
            }
        }

        class boxPair {
            int boxID;
            int addTo;

            boxPair(int _boxID, int _addTo) {
                this.boxID = _boxID;
                this.addTo = _addTo;
            }

        }

    }

    static class InputReader {
        InputStream is;
        private byte[] inbuf = new byte[1024];
        private int lenbuf = 0;
        private int ptrbuf = 0;
        static final int[] ints = new int[128];

        public InputReader(InputStream is) {
            for (int i = '0'; i <= '9'; i++) ints[i] = i - '0';
            this.is = is;
        }

        public int readByte() {
            if (lenbuf == -1) throw new InputMismatchException();
            if (ptrbuf >= lenbuf) {
                ptrbuf = 0;
                try {
                    lenbuf = is.read(inbuf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (lenbuf <= 0) return -1;
            }
            return inbuf[ptrbuf++];
        }

        public int nextInt() {
            int num = 0, b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }

            while (true) {
                if (b >= '0' && b <= '9') {
                    num = (num << 3) + (num << 1) + ints[b];
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

    }
}

