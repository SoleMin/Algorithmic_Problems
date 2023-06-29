/**
 * @author derrick20
 */
import java.io.*;
import java.util.*;

public class SameSumBlocks {
    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int N = sc.nextInt();
        int[] pre = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            pre[i] = pre[i - 1] + sc.nextInt();
        }
        var sumMap = new HashMap<Integer, ArrayList<Pair>>();
        for (int i = 1; i <= N; i++) {
            for (int j = i; j <= N; j++) {
                int sum = pre[j] - pre[i - 1];
                sumMap.computeIfAbsent(sum, val -> new ArrayList<>()).add(new Pair(i, j));
            }
        }
        var ans = new ArrayList<Pair>();
        for (var list : sumMap.values()) {
            Collections.sort(list, Comparator.comparingInt(p -> p.r));
            // greedily schedule the intervals
            int last = 0;
            var group = new ArrayList<Pair>();
            for (Pair p : list) {
                if (p.l > last) {
                    group.add(p);
                    last = p.r;
                }
            }
            if (group.size() > ans.size()) {
                ans = group;
            }
        }
        out.println(ans.size());
        for (Pair p : ans) {
            out.println(p);
        }
        out.close();
    }

    static class Pair {
        int l, r;
        public Pair(int ll, int rr) {
            l = ll; r = rr;
        }
        public String toString() {
            return l + " " + r;
        }
    }

    static class FastScanner {
        private int BS = 1<<16;
        private char NC = (char)0;
        private byte[] buf = new byte[BS];
        private int bId = 0, size = 0;
        private char c = NC;
        private double cnt = 1;
        private BufferedInputStream in;

        public FastScanner() {
            in = new BufferedInputStream(System.in, BS);
        }

        public FastScanner(String s) {
            try {
                in = new BufferedInputStream(new FileInputStream(new File(s)), BS);
            }
            catch (Exception e) {
                in = new BufferedInputStream(System.in, BS);
            }
        }

        private char getChar(){
            while(bId==size) {
                try {
                    size = in.read(buf);
                }catch(Exception e) {
                    return NC;
                }
                if(size==-1)return NC;
                bId=0;
            }
            return (char)buf[bId++];
        }

        public int nextInt() {
            return (int)nextLong();
        }

        public int[] nextInts(int N) {
            int[] res = new int[N];
            for (int i = 0; i < N; i++) {
                res[i] = (int) nextLong();
            }
            return res;
        }

        public long[] nextLongs(int N) {
            long[] res = new long[N];
            for (int i = 0; i < N; i++) {
                res[i] = nextLong();
            }
            return res;
        }

        public long nextLong() {
            cnt=1;
            boolean neg = false;
            if(c==NC)c=getChar();
            for(;(c<'0' || c>'9'); c = getChar()) {
                if(c=='-')neg=true;
            }
            long res = 0;
            for(; c>='0' && c <='9'; c=getChar()) {
                res = (res<<3)+(res<<1)+c-'0';
                cnt*=10;
            }
            return neg?-res:res;
        }

        public double nextDouble() {
            double cur = nextLong();
            return c!='.' ? cur:cur+nextLong()/cnt;
        }

        public String next() {
            StringBuilder res = new StringBuilder();
            while(c<=32)c=getChar();
            while(c>32) {
                res.append(c);
                c=getChar();
            }
            return res.toString();
        }

        public String nextLine() {
            StringBuilder res = new StringBuilder();
            while(c<=32)c=getChar();
            while(c!='\n') {
                res.append(c);
                c=getChar();
            }
            return res.toString();
        }

        public boolean hasNext() {
            if(c>32)return true;
            while(true) {
                c=getChar();
                if(c==NC)return false;
                else if(c>32)return true;
            }
        }
    }
}