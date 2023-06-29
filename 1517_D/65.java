import java.util.*;
import java.io.*;

public class Main {
    static FastScanner sc = new FastScanner(System.in);
    static PrintWriter pw = new PrintWriter(System.out);
    static StringBuilder sb = new StringBuilder();
    static long mod = (long) 1e9 + 7;
    public static void main(String[] args) throws Exception {
        solve();
        pw.flush();
    }
    
    static ArrayList<ArrayList<ArrayList<int[]>>> kruscal = new ArrayList<>();
    static long ans = Integer.MAX_VALUE;
    static int[][][] map;
    public static void solve() {
        int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
        for(int i = 0; i < n; i++){
            kruscal.add(new ArrayList<>());
            for(int j = 0; j < m; j++){
                kruscal.get(i).add(new ArrayList<>());
            }
        }
        map = new int[n][m][k+1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m-1; j++){
                //int now = (int)(Math.random()*1000000)*2;
                int now = sc.nextInt();
                kruscal.get(i).get(j).add(new int[]{now,i,j+1});
                kruscal.get(i).get(j+1).add(new int[]{now,i,j});
            }
        }
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < m; j++){
                //int now = (int)(Math.random()*1000000)*2;
                int now = sc.nextInt();
                kruscal.get(i).get(j).add(new int[]{now,i+1,j});
                kruscal.get(i+1).get(j).add(new int[]{now,i,j});
            }
        }
        if(k % 2 != 0){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    sb.append(-1).append(" ");
                }
                pw.println(sb.toString().trim());
                sb.setLength(0);
            }
            return;
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                Arrays.fill(map[i][j],Integer.MAX_VALUE/2);
                map[i][j][k/2] = 0;
            }
        }
        for(int kk = k/2; kk > 0; kk--){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    for(int[] next : kruscal.get(i).get(j)){
                        int d = next[0], i2 = next[1], j2 = next[2];
                        map[i2][j2][kk-1] = Math.min(map[i2][j2][kk-1],map[i][j][kk]+d);
                    }
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                sb.append(map[i][j][0]*2).append(" ");
            }
            pw.println(sb.toString().trim());
            sb.setLength(0);
        }
    }
    
    static void dfs(Stack<Integer> st, int y, int x, int cnt, long total){
        if(st.size() == cnt){
            ans = Math.min(total,ans);
        }
        for(int[] next : kruscal.get(y).get(x)){
            int d = next[0], i = next[1], j = next[2];
            if(Math.abs(i-y)+Math.abs(j-x)-st.size() < 0){
                continue;
            }
            Stack<Integer> stk = (Stack<Integer>)st.clone();
            stk.push(d);
            dfs(stk,i,j,cnt,total + d);
        }
        int rem = cnt - st.size();
        long tmp = 0;
        int c = 0;
        while(st.size() > 0){
            tmp += st.pop();
            c++;
            if(rem % c == 0){
                ans = Math.min(ans,total + tmp * (rem/c));
            }
        }
    }
    
    static class ArrayComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a1, int[] a2) {
            for (int i = 0; i < a1.length; i++) {
                if (a1[i] < a2[i]) {
                    return -1;
                } else if (a1[i] > a2[i]) {
                    return 1;
                }
            }
            if (a1.length < a2.length) {
                return -1;
            } else if (a1.length > a2.length) {
                return 1;
            } else {
                return 0;
            }
        }
    }
    
    private static String ArraysToString(int[] arr){
        String s = Arrays.toString(arr);
        s = s.replaceAll(",","");
        s = s.substring(1,s.length()-1);
        return s;
    }

    static class GeekInteger {
        public static void save_sort(int[] array) {
            shuffle(array);
            Arrays.sort(array);
        }

        public static int[] shuffle(int[] array) {
            int n = array.length;
            Random random = new Random();
            for (int i = 0, j; i < n; i++) {
                j = i + random.nextInt(n - i);
                int randomElement = array[j];
                array[j] = array[i];
                array[i] = randomElement;
            }
            return array;
        }

        public static void save_sort(long[] array) {
            shuffle(array);
            Arrays.sort(array);
        }

        public static long[] shuffle(long[] array) {
            int n = array.length;
            Random random = new Random();
            for (int i = 0, j; i < n; i++) {
                j = i + random.nextInt(n - i);
                long randomElement = array[j];
                array[j] = array[i];
                array[i] = randomElement;
            }
            return array;
        }

    }
}

class DSU {
    private int n;
    private int[] parentOrSize;
    private java.util.ArrayList<java.util.ArrayList<Integer>> map;

    public DSU(int n) {
        this.n = n;
        this.map = new java.util.ArrayList<java.util.ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            this.map.add(new java.util.ArrayList<Integer>());
            this.map.get(i).add(i);
        }
        this.parentOrSize = new int[n];
        java.util.Arrays.fill(parentOrSize, -1);
    }

    int merge(int a, int b) {
        if (!(0 <= a && a < n))
            throw new IndexOutOfBoundsException("a=" + a);
        if (!(0 <= b && b < n))
            throw new IndexOutOfBoundsException("b=" + b);

        int x = leader(a);
        int y = leader(b);
        if (x == y)
            return x;
        if (-parentOrSize[x] < -parentOrSize[y]) {
            int tmp = x;
            x = y;
            y = tmp;
        }
        parentOrSize[x] += parentOrSize[y];
        parentOrSize[y] = x;
        this.map.get(x).addAll(this.map.get(y));
        return x;
    }

    boolean same(int a, int b) {
        if (!(0 <= a && a < n))
            throw new IndexOutOfBoundsException("a=" + a);
        if (!(0 <= b && b < n))
            throw new IndexOutOfBoundsException("b=" + b);
        return leader(a) == leader(b);
    }

    int leader(int a) {
        if (parentOrSize[a] < 0) {
            return a;
        } else {
            parentOrSize[a] = leader(parentOrSize[a]);
            return parentOrSize[a];
        }
    }

    int size(int a) {
        if (!(0 <= a && a < n))
            throw new IndexOutOfBoundsException("" + a);
        return -parentOrSize[leader(a)];
    }

    java.util.ArrayList<java.util.ArrayList<Integer>> groups() {
        int[] leaderBuf = new int[n];
        int[] groupSize = new int[n];
        for (int i = 0; i < n; i++) {
            leaderBuf[i] = leader(i);
            groupSize[leaderBuf[i]]++;
        }
        java.util.ArrayList<java.util.ArrayList<Integer>> result = new java.util.ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            result.add(new java.util.ArrayList<>(groupSize[i]));
        }
        for (int i = 0; i < n; i++) {
            result.get(leaderBuf[i]).add(i);
        }
        result.removeIf(java.util.ArrayList::isEmpty);
        return result;
    }

    java.util.ArrayList<Integer> getArray(int n) {
        return this.map.get(n);
    }
}

class FastScanner {
    private BufferedReader reader = null;
    private StringTokenizer tokenizer = null;

    public FastScanner(InputStream in) {
        reader = new BufferedReader(new InputStreamReader(in));
        tokenizer = null;
    }

    public FastScanner(FileReader in) {
        reader = new BufferedReader(in);
        tokenizer = null;
    }

    public String next() {
        if (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public String nextLine() {
        if (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken("\n");
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public String[] nextArray(int n) {
        String[] a = new String[n];
        for (int i = 0; i < n; i++)
            a[i] = next();
        return a;
    }

    public int[] nextIntArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = nextInt();
        return a;
    }

    public long[] nextLongArray(int n) {
        long[] a = new long[n];
        for (int i = 0; i < n; i++)
            a[i] = nextLong();
        return a;
    }
}
