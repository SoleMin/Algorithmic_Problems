
/**
 * @author: Mehul Raheja
 */
import java.util.*;
import java.io.*;

public class p4 {

    /*
        Runtime = O()
     */
    static int N, M, K;
    static String s;
    static StringTokenizer st;
    static int[] d;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int[] x = {1,2,3,4,5,6,7,8,9,10};

        int N = Integer.parseInt(br.readLine());
        int[] d = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            d[i] = Integer.parseInt(st.nextToken());
        }
        boolean cur = ((inv(d)) % 2) == 1;
        // System.out.println(cur);
        int Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int dif = b - a + 1;
            if (dif / 2 % 2 == 1) {
                cur = !cur;
            }

            System.out.println((cur) ? "odd" : "even");
        }

//        for (int i = 0; i < 30; i++) {
//            int[] x = new int[i];
//            for (int j = 0; j < i; j++) {
//                x[j] = j + 1;
//            }
//            int[] y = new int[x.length];
//            for (int k = 0; k < x.length; k++) {
//                y[x.length - 1 - k] = x[k];
//            }
//
////            System.out.println(inv(x));
////            System.out.println(inv(y));
//            System.out.println(i + " " + ((inv(y) - inv(x))%2 == 1));
//        }
    }

    static class BIT {

        int[] tree;
        int N;

        public BIT(int N) {
            this.N = N;
            tree = new int[N + 1];
        }

        public BIT(int N, int[] d) {
            this.N = N;
            tree = new int[N + 1];
            for (int i = 1; i < d.length; i++) {
                update(i, d[i]);
            }
        }

        public int query(int K) {
            int sum = 0;
            for (int i = K; i > 0; i -= (i & -i)) {
                sum += tree[i];
            }
            return sum;
        }

        public void update(int K, int val) {
            for (int i = K; i <= N; i += (i & -i)) {
                tree[i] += val;
            }
        }
    }

    public static int[] toRel(int[] d) {
        pair[] p = new pair[d.length];
        for (int i = 0; i < d.length; i++) {
            p[i] = new pair(d[i], i + 1);
        }
        Arrays.sort(p);
        int[] fin = new int[d.length];
        for (int i = 0; i < d.length; i++) {
            fin[i] = p[i].b;
        }
        return fin;
    }

    public static int inv(int[] d) {
        int ans = 0;
        int N = d.length;
        int[] x = toRel(d);
        BIT b = new BIT(N + 1);

        for (int i = N - 1; i >= 0; i--) {
            ans += b.query(x[i]);
            b.update(x[i], 1);
        }

        return ans;
    }
}

class pair implements Comparable<pair> {

    int a, b;

    public pair(int _a, int _b) {
        this.a = _a;
        this.b = _b;
    }

    @Override
    public int compareTo(pair t) {
        return (a == t.a) ? b - t.b : a - t.a;
    }
}
