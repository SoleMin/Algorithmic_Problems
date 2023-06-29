import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;
import java.util.StringTokenizer;

public class TwoSets {
    static int n, a, b;
    static HashSet<Integer> arr = new HashSet<Integer>();
    static HashSet<Integer> visited = new HashSet<Integer>();
    static HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();

    static void dfs(int x, int parent, int len) {
        stack.push(x);
        visited.add(x);
        int children = 0;
        if (a - x > 0) {
            if (a - x != parent && arr.contains(a - x)) {
                dfs(a - x, x, len + 1);
                children++;
            }
        }
        if (b - x > 0) {
            if (b - x != parent && arr.contains(b - x)) {
                dfs(b - x, x, len + 1);
                children++;
            }
        }
        if (children == 0) {
            if (len % 2 == 1) {
                System.out.println("NO");
                System.exit(0);
            } else {
                while (!stack.isEmpty()) {
                    int first = stack.pop();
                    int second = stack.pop();
                    if (first == a - second) {
                        result.put(first, 0);
                        result.put(second, 0);
                    } else {
                        result.put(first, 1);
                        result.put(second, 1);
                    }

                }
            }
        }
    }

    static Stack<Integer> stack = new Stack<Integer>();

    public static void main(String[] args) {
        InputReader r = new InputReader(System.in);
        n = r.nextInt();
        a = r.nextInt();
        b = r.nextInt();
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = r.nextInt();
            arr.add(list[i]);
        }
        for (int x : arr) {
            if (!visited.contains(x)) {
                if (arr.contains(a - x) && arr.contains(b - x))
                    continue;
                if (arr.contains(a - x) || arr.contains(b - x)) {
                    dfs(x, -1, 1);
                } else {
                    System.out.println("NO");
                    System.exit(0);
                }
            }
        }
        PrintWriter out = new PrintWriter(System.out);
        out.println("YES");
        for (int i = 0; i < list.length; i++) {
            if (result.get(list[i]) == null)
                out.println(0);
            else
                out.println(result.get(list[i]));
        }
        out.close();

    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public InputReader(FileReader stream) {
            reader = new BufferedReader(stream);
            tokenizer = null;
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return null;
            }
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

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
