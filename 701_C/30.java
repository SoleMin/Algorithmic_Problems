import com.sun.org.apache.xml.internal.utils.StringComparable;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
//     Test.testing();
        ConsoleIO io = new ConsoleIO();
        new Main(io).solve();
        io.close();
    }

    ConsoleIO io;

    Main(ConsoleIO io) {
        this.io = io;
    }

    ArrayList<ArrayList<Integer>> gr;
    boolean[] visit;

    class Edge {
        public Edge(int u, int v, int c) {
            this.u = u;
            this.v = v;
            this.c = c;
        }

        public int u;
        public int v;
        public int c;
    }

    long MOD = 1_000_000_007;
    int N, M, K;
    double[][] map;

    public void solve() {
        String s = io.readLine();
        N = Integer.parseInt(s);
        char[] a = io.readLine().toCharArray();
        int[] look = new int[256];
        Arrays.fill(look, 10000);
        int k = 0;
        for (int i = 0; i < a.length; i++) {
            if (look[a[i]] == 10000) {
                look[a[i]] = k;
                k++;
            }
        }
        int res = N;
        long need = (1L << k) - 1;
        long mask = 0;
        int head = 0;
        int tail = 0;
        int[] c = new int[k];
        while (head < a.length) {
            while (head < a.length && mask != need) {
                int v = look[a[head]];
                if (c[v] == 0)
                    mask |= (1L << v);
                c[v]++;
                head++;
            }
            while (tail < head && mask == need) {
                res = Math.min(res, head - tail);

                int v = look[a[tail]];
                c[v]--;
                if (c[v] == 0)
                    mask ^= (1L << v);


                tail++;
            }
        }
        io.writeLine(res + "");
    }


    long gcd(long a, long b) {
        if (a < b) return gcd(b, a);
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}

class ConsoleIO {
    BufferedReader br;
    PrintWriter out;
    public ConsoleIO(){br = new BufferedReader(new InputStreamReader(System.in));out = new PrintWriter(System.out);}
    public void flush(){this.out.flush();}
    public void close(){this.out.close();}
    public void writeLine(String s) {this.out.println(s);}
    public void writeInt(int a) {this.out.print(a);this.out.print(' ');}
    public void writeWord(String s){
        this.out.print(s);
    }
    public int read(char[] buf, int len){try {return br.read(buf,0,len);}catch (Exception ex){ return -1; }}
    public String readLine() {try {return br.readLine();}catch (Exception ex){ return "";}}
    public long readLong() {
        return Long.parseLong(this.readLine());
    }
    public long[] readLongArray() {
        String[]n=this.readLine().trim().split("\\s+");long[]r=new long[n.length];
        for(int i=0;i<n.length;i++)r[i]=Long.parseLong(n[i]);
        return r;
    }
    public int[] readIntArray() {
        String[]n=this.readLine().trim().split("\\s+");int[]r=new int[n.length];
        for(int i=0;i<n.length;i++)r[i]=Integer.parseInt(n[i]);
        return r;
    }
    public int[] readIntArray(int n) {
        int[] res = new int[n];
        char[] all = this.readLine().toCharArray();
        int cur = 0;boolean have = false;
        int k = 0;
        boolean neg = false;
        for(int i = 0;i<all.length;i++){
            if(all[i]>='0' && all[i]<='9'){
                cur = cur*10+all[i]-'0';
                have = true;
            }else if(all[i]=='-') {
                neg = true;
            }
            else if(have){
                res[k++] = neg?-cur:cur;
                cur = 0;
                have = false;
                neg = false;
            }
        }
        if(have)res[k++] = neg?-cur:cur;
        return res;
    }
    public int readInt() {
        try {
            int r = 0;
            boolean start = false;
            boolean neg = false;
            while (true) {
                int c = br.read();
                if (c >= '0' && c <= '9') {
                    r = r * 10 + c - '0';
                    start = true;
                } else if (!start && c == '-') {
                    start = true;
                    neg = true;
                } else if (start || c == -1) return neg ? -r : r;
            }
        } catch (Exception ex) {
            return -1;
        }
    }
    public void writeIntArray(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {if (i > 0) sb.append(' ');sb.append(a[i]);}
        this.writeLine(sb.toString());
    }
}
class Pair {
    public Pair(int a, int b) {this.a = a;this.b = b;}
    public int a;
    public int b;
}
class Tri {
    public Tri(int a, int b, int c) {this.a = a;this.b = b;this.c = c;}
    public int a;
    public int b;
    public int c;
}
class PairLL {
    public PairLL(long a, long b) {this.a = a;this.b = b;}
    public long a;
    public long b;
}



