import java.util.*;

public class TaskF {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }

        int[] prefixSum = new int[n + 1];
        prefixSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + a[i];
        }

        Map<Integer, List<Segment>> sumToSegments = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                int sum = prefixSum[j] - prefixSum[i - 1];
                sumToSegments
                        .computeIfAbsent(sum, $ -> new ArrayList<>())
                        .add(Segment.make(i, j));
            }
        }

        List<Segment> bestSegments = null;
        for (int sum : sumToSegments.keySet()) {
            List<Segment> segments = sumToSegments.get(sum);
            int size = segments.size();

            int[] f = new int[size];
            int[] next = new int[size];
            boolean[] take = new boolean[size];

            f[size - 1] = 1;
            next[size - 1] = -1;
            take[size - 1] = true;
            int bestStartIndex = size - 1;

            for (int i = size - 2; i >= 0; i--) {
                int nextIndex;

                if (segments.get(i).q >= segments.get(size - 1).p) {
                    nextIndex = -1;
                } else {
                    int L = i + 1;
                    int R = size - 1;
                    while (L < R) {
                        int M = (L + R) / 2;
                        if (segments.get(i).q >= segments.get(M).p) { /* intersection */
                            L = M + 1;
                        } else {
                            R = M;
                        }
                    }
                    nextIndex = L;
                }

                f[i] = 1 + ((nextIndex == -1) ? 0 : f[nextIndex]);
                next[i] = nextIndex;
                take[i] = true;

                if (f[i + 1] > f[i]) {
                    take[i] = false;
                    f[i] = f[i + 1];
                    next[i] = i + 1;
                }

                if (bestStartIndex == -1 || f[i] > f[bestStartIndex]) {
                    bestStartIndex = i;
                }
            }

            // recover segment set
            List<Segment> maxForSum = new ArrayList<>();
            int index = bestStartIndex;
            do {
                if (take[index]) {
                    maxForSum.add(segments.get(index));
                }
                index = next[index];
            } while (index != -1);

            if (bestSegments == null || maxForSum.size() > bestSegments.size()) {
                bestSegments = maxForSum;
            }
        }

        System.out.println(bestSegments.size());
        for (Segment segment : bestSegments) {
            System.out.printf("%s %s%n", segment.p, segment.q);
        }

        in.close();
    }

    private static class Segment {
        public final int p;
        public final int q;

        private Segment(int p, int q) {
            this.p = p;
            this.q = q;
        }

        public static Segment make(int p, int q) {
            return new Segment(p, q);
        }
    }
}
