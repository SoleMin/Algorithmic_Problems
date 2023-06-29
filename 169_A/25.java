import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    //<editor-fold desc="input parse" defaultstate="collapsed">

    private static StringTokenizer st;
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static long nextLong() {
        return Long.parseLong(st.nextToken());
    }

    private static int nextInt() {
        return Integer.parseInt(st.nextToken());
    }

    private static double nextDouble() {
        return Double.parseDouble(st.nextToken());
    }

    private static short nextShort() {
        return Short.parseShort(st.nextToken());
    }

    private static byte nextByte() {
        return Byte.parseByte(st.nextToken());
    }

    private static void initTokenizer() throws Exception {
        st = new StringTokenizer(reader.readLine());
    }

    //</editor-fold>

    public static void main(String[] args) throws Exception {
        initTokenizer();

        int n = nextInt();
        int a = nextInt();
        int b = nextInt();

        int[] h = new int[n];

        initTokenizer();

        for (int i = 0; i < n; i++) {
            h[i] = nextInt();
        }

        Arrays.sort(h);

        System.out.print(h[b] - h[b - 1]);
    }
}