
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class A {
    static int[] parent;

    public static int find(int x) {
        if (x == parent[x])
            return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) {
            parent[py] = px;
        }
    }

    public static void main(String[] args) throws Exception {
        int numCnt = (int) nextLong();
        long k = nextLong();
        parent = new int[numCnt];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        Long[] ar=new Long[numCnt];
        for (int i = 0; i < numCnt; i++) {
            ar[i] = nextLong();
        }
        Arrays.sort(ar);
        for (int i = 0; i < ar.length; i++) {
            long req = ar[i] * k;
            int l=0,h=ar.length,mid;
            while(l<h){
                mid=l+(h-l)/2;
                if(ar[mid]<req){
                    l=mid+1;
                }else{
                    h=mid;
                }
            }
            if(l<ar.length&&ar[l]==req){
                union(i,l);
            }
        }
        int[] count = new int[numCnt];
        for (int i = 0; i < parent.length; i++) {
            count[find(i)]++;
        }
        int res = 0;
        for (int i = 0; i < numCnt; i++) {
            res += (int) ((count[i] + 1) / 2.0);
        }
        System.out.println(res);
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(
            System.in));
    static StringTokenizer tokenizer = new StringTokenizer("");

    static long nextLong() throws Exception {
        return Long.parseLong(next());
    }

    static double nextDouble() throws Exception {
        return Double.parseDouble(next());
    }

    static String next() throws Exception {
        while (true) {
            if (tokenizer.hasMoreTokens()) {
                return tokenizer.nextToken();
            }
            String s = br.readLine();
            if (s == null) {
                return null;
            }
            tokenizer = new StringTokenizer(s);
        }
    }
}
