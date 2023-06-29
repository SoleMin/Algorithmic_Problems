import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(final String[] args) throws IOException {
        try(Scanner scan = new Scanner(System.in);
            PrintWriter print = new PrintWriter(System.out)) {
            final int n = scan.nextInt();
            final int m = scan.nextInt();
            final Pair<Integer, Integer>[] arcs = new Pair[m];
            for(int k = 0; k < m; ++k) {
                int i = scan.nextInt();
                int j = scan.nextInt();
                --i; --j;
                arcs[k] = new Pair(i, j);
            }
            print.println(calcMinNumStepsToCenterPermGraph(new DirectedGraph(n, arcs)));
        }
    }

    public static int calcMinNumStepsToCenterPermGraph(final DirectedGraph graph) {
        int result = Integer.MAX_VALUE;
        for(DirectedGraph.Vertex center : graph.vertices) {
            int num = 2 * graph.vertices.length - 1 - graph.getOutcomingArcs(center).size() -
                    graph.getIncomingArcs(center).size() + (graph.containsArc(center, center) ? 1 : 0);
            final int n = graph.vertices.length - 1;
            final List<Pair<Integer, Integer>> edges = CollectionFactory.createArrayList();
            for(DirectedGraph.Arc arc : graph.arcs) {
                if(!center.equals(arc.from) && !(center.equals(arc.to))) {
                    int i = arc.from.index;
                    int j = arc.to.index;
                    if(i > center.index) {
                        --i;
                    }
                    if(j > center.index) {
                        --j;
                    }
                    edges.add(new Pair(i, j));
                }
            }
            final int matching = GraphUtils.calcNumMatchingBipartite(n, n, edges);
            num += edges.size() - matching;
            num += n - matching;
            result = Math.min(result, num);
        }
        return result;
    }

    public static class GraphUtils {
        public static int calcNumMatchingBipartite(final int n, final int m, final List<Pair<Integer, Integer>> edges) {
            final MatchingBipartiteSolver solver = new MatchingBipartiteSolver(n, m, edges);
            return solver.solve();
        }

        private static class MatchingBipartiteSolver {
            private final int n;
            private final int m;
            private final List<Integer>[] edges;
            private final Integer[] match;
            private final boolean[] visited;

            public MatchingBipartiteSolver (final int n, final int m, final List<Pair<Integer, Integer>> edges) {
                this.n = n;
                this.m = m;
                this.edges = new List[n];
                for(int i = 0; i < n; ++i) {
                    this.edges[i] = CollectionFactory.createArrayList();
                }
                for(final Pair<Integer, Integer> edge: edges) {
                    this.edges[edge.first].add(edge.second);
                }
                match = new Integer[n + m];
                visited = new boolean[n + m];
            }

            public int solve() {
                int result = 0;
                for(;;) {
                    Arrays.fill(visited, false);
                    int gain = 0;
                    for(int i = 0; i < n; ++i) {
                        if(match[i] == null && !visited[i] && tryMatch(i)) {
                            ++gain;
                        }
                    }
                    if(gain > 0) {
                        result += gain;
                    } else {
                        break;
                    }
                }
                return result;
            }

            private boolean tryMatch(final int i) {
                visited[i] = true;
                for(int j : edges[i]) {
                    if(!visited[j + n]) {
                        visited[j + n] = true;
                        final Integer k = match[j + n];
                        if(k == null || (!visited[k] && tryMatch(k))) {
                            match[j + n] = i;
                            match[i] = j + n;
                            return true;
                        }
                    }
                }
                return false;
            }
        }
    }

    public static class DirectedGraph {
        public static class Vertex {
            public final int index;

            public Vertex(int index) {
                this.index = index;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                Vertex vertex = (Vertex) o;

                if (index != vertex.index) return false;

                return true;
            }

            @Override
            public int hashCode() {
                return index;
            }
        }

        public static class Arc {
            public final Vertex from;
            public final Vertex to;

            public Arc(Vertex from, Vertex to) {
                this.from = from;
                this.to = to;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                Arc arc = (Arc) o;

                if (!from.equals(arc.from)) return false;
                if (!to.equals(arc.to)) return false;

                return true;
            }

            @Override
            public int hashCode() {
                int result = from.hashCode();
                result = 31 * result + to.hashCode();
                return result;
            }
        }

        final public Vertex[] vertices;
        final public Arc[] arcs;

        public DirectedGraph(final int n, final Pair<Integer, Integer>[] arcs) {
            vertices = new Vertex[n];
            this.arcs = new Arc[arcs.length];
            for(int i = 0; i < n; ++i) {
                vertices[i] = new Vertex(i);
            }
            for(int i = 0; i < arcs.length; ++i) {
                this.arcs[i] = new Arc(vertices[arcs[i].first], vertices[arcs[i].second]);
            }
        }

        public List<Arc> getOutcomingArcs(final Vertex v) {
            final List<Arc> result = CollectionFactory.createArrayList();
            for(Arc arc : arcs) {
                if(arc.from.equals(v)) {
                    result.add(arc);
                }
            }
            return result;
        }

        public List<Arc> getIncomingArcs(final Vertex v) {
            final List<Arc> result = CollectionFactory.createArrayList();
            for(Arc arc : arcs) {
                if(arc.to.equals(v)) {
                    result.add(arc);
                }
            }
            return result;
        }

        public boolean containsArc(final Vertex from, final Vertex to) {
            for(Arc arc : arcs) {
                if(arc.from.equals(from) && arc.to.equals(to)) {
                    return true;
                }
            }
            return false;
        }
    }


    public static class MatrixIntMod {
        final int mod;
        final int[][] data;

        public MatrixIntMod(final int n, final int m, final int mod) {
            this.mod = mod;
            this.data = new int[n][m];
            for(int i = 0; i < n; ++i) {
                Arrays.fill(data[i], 0);
            }
        }

        public MatrixIntMod(final int[][] data, final int mod) {
            this(data.length, data[0].length, mod);
            for(int i = 0; i < data.length; ++i) {
                for(int j = 0; j < data[i].length; ++j) {
                    this.data[i][j] = ModNumberUtils.norm(mod, data[i][j]);
                }
            }
        }

        public MatrixIntMod(final int[] data, final int mod) {
            this(data.length, 1, mod);
            for(int i = 0; i < data.length; ++i) {
                this.data[i][0] = ModNumberUtils.norm(mod, data[i]);
            }
        }

        public int[] all() {
            int n = data.length;
            int m = data[0].length;
            final int[] res = new int[n * m];
            int k = 0;
            for(int i = 0; i < n; ++i) {
                for(int j = 0; j < m; ++j) {
                    res[k++] = data[i][j];
                }
            }
            return res;
        }

        public MatrixIntMod mult(final MatrixIntMod val) {
            if(data[0].length != val.data.length) throw new RuntimeException("dimensions for mult are wrong");
            final int n = data.length;
            final int m = data[0].length;
            final int l = val.data[0].length;
            final MatrixIntMod res = new MatrixIntMod(n, l, mod);
            for(int i = 0; i < n; ++i) {
                for(int j = 0; j < l; ++j) {
                    for(int k = 0; k < m; ++k) {
                        res.data[i][j] = ModNumberUtils.add(mod, res.data[i][j],
                                ModNumberUtils.mult(mod, data[i][k], val.data[k][j]));
                    }
                }
            }
            return res;
        }

        public int[] mult(final int[] ar) {
            return mult(new MatrixIntMod(ar, mod)).all();
        }

        public MatrixIntMod power(final long t) {
            if(t == 0) return eye(data.length, mod);
            MatrixIntMod res = power(t >> 1);
            res = res.mult(res);
            if((t & 1) == 1) {
                res = res.mult(this);
            }
            return res;
        }

        public static MatrixIntMod eye(final int n, final int mod) {
            final MatrixIntMod res = new MatrixIntMod(n, n, mod);
            if(mod > 1) {
                for(int i = 0; i < n; ++i) {
                    res.data[i][i] = 1;
                }
            }
            return res;
        }
    }

    public static class ModNumberUtils {
        public static int add(int mod, int a, int b) {
            a += b;
            if(a >= mod) {
                a -= mod;
            }
            return a;
        }

        public static int norm(int mod, int a) {
            a %= mod;
            if(a < 0) {
                a += mod;
            }
            return a;
        }

        public static int mult(int mod, int a, int b) {
            return (int)((long)a * b % mod);
        }
    }

    public static class Pair<X, Y>{
        public X first;
        public Y second;

        public Pair(final X first, final Y second) {
            this.first = first;
            this.second = second;
        }
    }


    public static class NumberUtils {
        public static interface Factorizer {
            List<Integer> factorize(int number);
        }

        /**
         * thread safe Factorizer
         */
        public static Factorizer createSmallNumberFactorizer(final int upperBound) {
            return new SmallNumberFactorizer(upperBound);
        }

        /**
         * thread safe
         */
        private static class SmallNumberFactorizer implements Factorizer {
            private int[] divisors;
            private final int upperBound;
            private boolean prepared = false;

            /**
             * lazy
             * time complexity O(n * log(n) * log(log(n))
             * memory complexity O(n)
             */
            public SmallNumberFactorizer(final int upperBound) {
                this.upperBound = upperBound;
            }

            private synchronized void prepare() {
                divisors = new int[upperBound];
                Arrays.fill(divisors, 0);
                for(int i = 2; i * i < upperBound; ++i) {
                    if(divisors[i] == 0) {
                        for(int j = i * i; j < upperBound; j += i) {
                            if(divisors[j] == 0) {
                                divisors[j] = i;
                            }
                        }
                    }
                }
                prepared = true;
            }

            /**
             * complexity O(result)
             */
            public List<Integer> factorize(int number) {
                synchronized (this) {
                    if(!prepared) {
                        prepare();
                    }
                }
                final List<Integer> result = CollectionFactory.createArrayList();
                if(number < 2) return result;
                if(number >= upperBound) throw new RuntimeException("number should be less than upper bound");
                while(divisors[number] > 0) {
                    result.add(divisors[number]);
                    number /= divisors[number];
                }
                result.add(number);
                return result;
            }
        }
    }

    public static class CollectionFactory {
        public static<T> List<T> createArrayList() {
            return new ArrayList<>();
        }

        public static<T> List<T> createArrayList(final int capacity) {
            return new ArrayList<>(capacity);
        }
    }

    public static class CollectionUtils {
        public static<T> List<T> unique(final List<T> list) {
            final List<T> result = CollectionFactory.createArrayList();
            T p = null;
            for(T elem : list) {
                if(!elem.equals(p)) {
                    result.add(elem);
                    p = elem;
                }
            }
            return result;
        }

        public static<T extends Comparable<T>> T max(final List<T> list, final T lowerBound) {
            T result = lowerBound;
            for(T elem : list) {
                if(elem.compareTo(result) > 0) {
                    result = elem;
                }
            }
            return result;
        }
    }

}
