import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author kessido
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        DOlyaAndMagicalSquare solver = new DOlyaAndMagicalSquare();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class DOlyaAndMagicalSquare {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.NextInt();
            long k = in.NextLong();
            if (k == 0) {
                out.println("YES " + n);
                return;
            }
            long operationTillNow = 0, numberOfCubeOnTheSide = 1;
            ArrayList<CubeCount> cubes = new ArrayList<>();

            for (int i = n - 1; i >= 0; i--) {
                cubes.add(new CubeCount(i, (numberOfCubeOnTheSide - 1) * 2 * 2 + 1));
                operationTillNow = operationTillNow + 2 * numberOfCubeOnTheSide - 1;
                numberOfCubeOnTheSide *= 2;
                long operationLeft = k - operationTillNow;
                if (operationLeft == 0) {
                    out.println("YES " + i);
                    return;
                } else if (operationLeft < 0) {
                    out.println("NO");
                    return;
                }
                for (CubeCount c : cubes) {
                    if (!c.hasLessThen(operationLeft)) {
                        out.println("YES " + i);
                        return;
                    } else {
                        operationLeft = c.removeMeFrom(operationLeft);
                    }
                }
                if (operationLeft <= 0) {
                    out.println("YES " + i);
                    return;
                }
            }
            out.println("NO");
            return;
        }

        class CubeCount {
            int sideSizeLogScale;
            long repeats;

            public CubeCount(int sideSizeLogScale, long repeats) {
                this.repeats = repeats;
                this.sideSizeLogScale = sideSizeLogScale;
            }

            public boolean hasLessThen(long k) {
                return hasLessThen(k, sideSizeLogScale, repeats);
            }

            private boolean hasLessThen(long k, int sideLog, long repeats) {
                while (true) {
                    if (k <= 0) return false;
                    if (sideLog == 0) return true;
                    k -= repeats;
                    sideLog--;
                    repeats *= 4;
                }
            }

            public long removeMeFrom(long k) {
                return removeMeFrom(k, sideSizeLogScale, repeats);
            }

            private long removeMeFrom(long k, int sideLog, long repeats) {
                while (true) {
                    if (sideLog == 0) return k;
                    k -= repeats;
                    sideLog--;
                    repeats *= 4;
                }
            }

        }

    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine(), " \t\n\r\f,");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int NextInt() {
            return Integer.parseInt(next());
        }

        public long NextLong() {
            return Long.parseLong(next());
        }

    }
}

