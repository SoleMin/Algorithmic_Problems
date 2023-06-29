import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    static StringTokenizer st;
    static PrintWriter out = new PrintWriter(System.out,true);
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static int nextInt() throws Exception {
        if(st == null || !st.hasMoreTokens()) st = new StringTokenizer(in.readLine());
        return Integer.parseInt(st.nextToken());
    }

    public static long nextLong() throws Exception {
        if(st == null || !st.hasMoreTokens()) st = new StringTokenizer(in.readLine());
        return Long.parseLong(st.nextToken());
    }

    public static void main(String[] args) throws Exception {
        HashSet<Integer> set = new HashSet<>();
        int n = nextInt();
        int k = nextInt();
        int[] m = new int[n];
        int[] d = new int[n];
        for(int i = 0;i < n;i++) m[i] = nextInt();
        int l = -1;
        int r = -1;
        for(int i = 0;i < n;i++) {
            set.add(m[i]);
            d[i] = set.size();
            if(d[i] == k) {
                r = i;
                break;
            }
        }
        if(r == -1) {
            out.println("-1 -1");
            return;
        }

        for(int i = r;i >= 0;i--) {
            set.remove(m[i]);
            if(set.size() == 0) {
                l = i;
                break;
            }
        }
        out.println((l+1)+" "+(r+1));
    }
}