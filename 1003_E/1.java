import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;
import static java.lang.System.out;

public class SolutionE extends Thread {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                                            InputStreamReader(in));
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
            return parseInt(next());
        }

        long nextLong() {
            return parseLong(next());
        }

        double nextDouble() {
            return parseDouble(next());
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

    static class Node {
        //standard attributes
        int index;
        int depth;
        boolean hasParent;

        public Node(int index, int depth, boolean hasParent) {
            this.index = index;
            this.depth = depth;
            this.hasParent = hasParent;
        }


        public void attachChildren(Node[] nodes, int k) {
            if (depth == 0) {
                return;
            }

            int amountChildren = hasParent ? (k - 1): (k - 2);
            for (int i = 0; i < amountChildren; i++) {
                if (nodePointer < nodes.length) {
                    Node child = new Node(nodePointer, depth - 1, true);
                    output.append(index + 1).append(" ").append(nodePointer + 1).append("\n");
                    nodes[nodePointer] = child;
                    nodePointer++;
                }
            }
        }
    }

    private static final FastReader scanner = new FastReader();
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        solve();
        out.close();
    }

    static int nodePointer = 0;
    static StringBuilder output = new StringBuilder();
    private static void solve() {
        int n = scanner.nextInt();
        int d = scanner.nextInt() + 1;
        int k = scanner.nextInt();

        if (d > n) {
            out.println("NO");
            return;
        }

        if (k == 1 && (d > 2 || n > 2)) {
            out.println("NO");
            return;
        }

        Node[] nodes = new Node[n];
        for (int i = 0; i < d; i++) {
            nodes[i] = new Node(i, Math.min(i, d - i - 1), false);
            nodePointer++;
            if (i > 0) {
                output.append(i+1).append(" ").append(i).append("\n");
            }
        }

        for (int i = 0; i < n; i++) {
            if (nodes[i] == null) {
                out.println("NO");
                return;
            } else if (nodePointer >= n) {
                break;
            }
            nodes[i].attachChildren(nodes, k);
        }

        if (nodePointer >= nodes.length) {
            out.println("YES");
            out.print(output);
        } else {
            out.println("NO");
        }

    }
}