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
        var ansMap = new HashMap<Integer, ArrayDeque<Pair>>();
        for (int j = 1; j <= N; j++) {
            pre[j] = pre[j - 1] + sc.nextInt();
            for (int i = j; i >= 1; i--) {
                int sum = pre[j] - pre[i - 1];
                /**
                 we can actually perform the greedy scheduling as we read in the information!
                 Because we are sweeping with an increasing right pointer, the moment a sum is
                 found with this right endpoint, we can greedily place it into the schedule
                 for a given sum "bucket", (if it's disjoint. Otherwise, we would be replacing
                 one OR MORE previous intervals, which would only decrease or keep the same size,
                 while reducing our future accessibility for adding intervals!)
                 */
                if (!ansMap.containsKey(sum) || ansMap.get(sum).getLast().r < i) {
                    var dq = ansMap.computeIfAbsent(sum, val -> new ArrayDeque<>());
                    dq.add(new Pair(i, j, sum));
                }
            }
        }
        var ans = new ArrayDeque<Pair>();
        for (var group : ansMap.values()) {
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
        int l, r, sum;
        public Pair(int ll, int rr, int ss) {
            l = ll; r = rr; sum = ss;
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