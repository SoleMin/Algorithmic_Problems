import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader reader;
    static StringTokenizer tokenizer;
    static PrintWriter writer;

    static int nextInt() throws NumberFormatException, IOException {
        return Integer.parseInt(nextToken());
    }

    static long nextLong() throws NumberFormatException, IOException {
        return Long.parseLong(nextToken());
    }

    static double nextDouble() throws NumberFormatException, IOException {
        return Double.parseDouble(nextToken());
    }

    static String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);
        pineapple();
        reader.close();
        writer.close();
    }

    static void pineapple() throws NumberFormatException, IOException {
        int n = nextInt();
        int a = nextInt();
        int b = nextInt();
        HashSet<Integer> al = new HashSet<Integer>();
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        HashSet<Integer> used = new HashSet<Integer>();
        int[] mas = new int[n];

        for (int i = 0; i < n; i++) {
            int t = nextInt();
            al.add(t);
            mas[i] = t;
            mp.put(t, i);
        }

        for (int st : al) {
            if (used.contains(st))
                continue;

            {
                int pr = st;
                int cc = -1;
                HashSet<Integer> u2 = new HashSet<Integer>();
                u2.add(pr);
                if (!u2.contains(a - pr) && al.contains(a - pr))
                    cc = a - pr;
                if (!u2.contains(a - pr) && al.contains(b - pr))
                    cc = b - pr;
                if (cc != -1) {
                    u2.add(cc);
                    boolean bGo = true;
                    while (bGo) {
                        bGo = false;
                        int nxt = -1;
                        if (!u2.contains(a - cc) && al.contains(a - cc))
                            nxt = a - cc;
                        if (!u2.contains(b - cc) && al.contains(b - cc))
                            nxt = b - cc;
                        if (nxt != -1) {
                            bGo = true;
                            u2.add(nxt);
                            cc = nxt;
                            pr = cc;
                        }
                    }
                    st = cc;
                }
            }

            LinkedList<Integer> ll = new LinkedList<Integer>();
            ll.add(st);
            while (!ll.isEmpty()) {
                int curr = ll.pollFirst();
                used.add(curr);
                int next1 = a - curr;
                if (al.contains(next1)) {
                    if (!used.contains(next1)) {
                        ll.addLast(next1);
                        if (ans[mp.get(curr)] == -1 && ans[mp.get(next1)] == -1) {
                            ans[mp.get(next1)] = 0;
                            ans[mp.get(curr)] = 0;
                        }
                    }
                }
                int next2 = b - curr;
                if (al.contains(next2)) {
                    if (!used.contains(next2)) {
                        ll.addLast(next2);
                        if (ans[mp.get(curr)] == -1 && ans[mp.get(next2)] == -1) {
                            ans[mp.get(next2)] = 1;
                            ans[mp.get(curr)] = 1;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (ans[i] == -1) {
                if (2 * mas[i] == a) {
                    ans[i] = 0;
                    continue;
                }
                if (2 * mas[i] == b) {
                    ans[i] = 1;
                    continue;
                }
                writer.println("NO");
                return;
            }
        }

        writer.println("YES");
        for (int i = 0; i < n; i++) {
            writer.print(ans[i] + " ");
        }
    }
    }