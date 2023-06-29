import java.io.*;
import java.util.*;

public class ProblemF_2 {

    public static InputStream inputStream = System.in;

    public static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        Map<Integer, List<Pair<Integer, Integer>>> map = new HashMap<>();
        for (int i = n - 1; i >= 0; i--) {
            int x = 0;
            for (int j = i; j >= 0; j--) {
                x = x + list.get(j);
                if (!map.containsKey(x)) {
                    map.put(x, new ArrayList<>());
                }
                map.get(x).add(new Pair<>(j + 1, i + 1));
            }
        }

        List<Pair<Integer, Integer>> ans = new ArrayList<>();
        for (Map.Entry<Integer, List<Pair<Integer, Integer>>> entry : map.entrySet()) {
            List<Pair<Integer, Integer>> segments = entry.getValue();
            Collections.reverse(segments);
            List<Pair<Integer, Integer>> result = new ArrayList<>();
            result.add(segments.get(0));
            for (int i = 1; i < segments.size(); i++) {
                if (segments.get(i).first > result.get(result.size() - 1).second) {
                    result.add(segments.get(i));
                }
            }
            if (result.size() > ans.size()) {
                ans = result;
            }
        }

        out.println(ans.size());
        for (Pair<Integer, Integer> pair : ans) {
            out.println(pair.first + " " + pair.second);
        }



        out.flush();
    }

    private static class MyScanner {
        private BufferedReader bufferedReader;
        private StringTokenizer stringTokenizer;

        private MyScanner(InputStream inputStream) {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        }

        private String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }

        private int nextInt() {
            return Integer.parseInt(next());
        }

        private long nextLong() {
            return Long.parseLong(next());
        }

        private double nextDouble() {
            return Double.parseDouble(next());
        }

        private String nextLine() {
            String str = "";
            try {
                str = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    private static class Pair<F, S> {

        private F first;

        private S second;

        public Pair() {}

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }
}
