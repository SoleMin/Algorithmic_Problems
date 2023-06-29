import java.lang.*;
import java.math.*;
import java.util.*;
import java.io.*;

public class Main{
class Node implements Comparable<Node>{
    int l;
    int r;
    public Node(int l,int r){
        this.l=l;
        this.r=r;
    }
    public int compareTo(Node c){
        int t=Integer.compare(this.r,c.r);
        if(t!=0) return t;
        t=Integer.compare(this.l,c.l);
        return t;
    }
}
    void solve() {
        int n=ni();
        int a[]=new int[n+1];
        long pref[]=new long[n+1];
        for(int i=1;i<=n;i++){
            a[i]=ni();
            pref[i]=pref[i-1]+a[i];
        }
        PriorityQueue<Long> q=new PriorityQueue<>();
        for(int i=1;i<=n;i++){
            for(int j=i;j<=n;j++) q.offer(pref[j]-pref[i-1]);
        }
        int sz=1;
        while(!q.isEmpty()){
            long val=q.poll();
            if(!mp.containsKey(val)){
               mp.put(val,sz++);
            }
        }
        vec=new Node[sz][];
        int size[]=new int[sz];
        for(int i=1;i<=n;i++){
            for(int j=i;j<=n;j++) size[mp.get(pref[j]-pref[i-1])]++;
        }
        for(int i=1;i<sz;i++) vec[i]=new Node[size[i]];
        for(int i=1;i<=n;i++){
            for(int j=i;j<=n;j++) {
                int idx=mp.get(pref[j]-pref[i-1]);
                vec[idx][--size[idx]]=new Node(i,j);
            }
        }

        for(int i=1;i<sz;i++) Arrays.sort(vec[i]);
        for(int i=1;i<sz;i++){
            solve(vec[i]);
        }
        pw.println(ans.size());
        for(Node p : ans) pw.println(p.l+" "+p.r);


    }
    HashMap<Long,Integer> mp=new HashMap<>();
    Node vec[][];
    int cnt=0;
    ArrayList<Node> ans=new ArrayList<>();
    void solve(Node [] v){
        int n=v.length;
        if(n==0) return;
        int dp[]=new int[n+1];
        int prev[]=new int[n+1];
        int mx[]=new int[n+1];
        int mxid[]=new int[n+1];
        for(int i=1;i<=n;i++){
            Node p=v[i-1];
            dp[i]=dp[i-1];
            prev[i]=-1;
            int l=1,r=i-1;
            int idx=0;
            while(l<=r){
                int mid=(l+r)>>1;
                if(v[mid-1].r<p.l){
                    idx=mid;
                    l=mid+1;
                }else r=mid-1;
            }
            if(1+mx[idx]>dp[i]){
                dp[i]=1+mx[idx];
                prev[i]=mxid[idx];
            }
            mx[i]=mx[i-1];
            mxid[i]=mxid[i-1];
            if(dp[i]>mx[i]){
                mx[i]=dp[i];
                mxid[i]=i;
            }


        }
        if (dp[n] > cnt){
            cnt=dp[n];
            ans.clear();
            int id=n;
            while(id>0){
                if(dp[id]==dp[id-1]){
                    id--;
                    continue;
                }
                ans.add(new Node(v[id-1].l,v[id-1].r));
                id=prev[id];
            }
        }
    }
    long M = (long)1e9+7;
    InputStream is;
    PrintWriter pw;
    String INPUT = "";

    void run() throws Exception {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        pw = new PrintWriter(System.out);
        long s = System.currentTimeMillis();
        solve();
        pw.flush();
        if (!INPUT.isEmpty()) tr(System.currentTimeMillis() - s + "ms");

    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    private byte[] inbuf = new byte[1024];
    public int lenbuf = 0, ptrbuf = 0;

    private int readByte() {
        if (lenbuf == -1) throw new InputMismatchException();
        if (ptrbuf >= lenbuf) {
            ptrbuf = 0;
            try {
                lenbuf = is.read(inbuf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (lenbuf <= 0) return -1;
        }
        return inbuf[ptrbuf++];
    }

    private boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    private int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b)) ;
        return b;
    }

    private double nd() {
        return Double.parseDouble(ns());
    }

    private char nc() {
        return (char) skip();
    }

    private String ns() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private char[] ns(int n) {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while (p < n && !(isSpaceChar(b))) {
            buf[p++] = (char) b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }

    private char[][] nm(int n, int m) {
        char[][] map = new char[n][];
        for (int i = 0; i < n; i++) map[i] = ns(m);
        return map;
    }

    private int[] na(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = ni();
        return a;
    }

    private int ni() {
        int num = 0, b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private long nl() {
        long num = 0;
        int b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private boolean oj = System.getProperty("ONLINE_JUDGE") != null;

    private void tr(Object... o) {
        if (INPUT.length() > 0) System.out.println(Arrays.deepToString(o));
    }

}