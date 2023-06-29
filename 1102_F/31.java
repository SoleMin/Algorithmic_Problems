import java.io.*;
import java.util.*;
public class EMatrix{
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskE solver = new TaskE();
        solver.solve(1, in, out);
        out.flush();out.close();
    }
        static class TaskE {
            final int max = (int)(1E9);
            int n , m;
            int a[][];
            int gm[];
            boolean visit[][]; int dp[][];
            boolean check(int d){
                if(n == 1){
                    for(int i = 0; i < m - 1; i++){
                        if(Math.abs(a[0][i] - a[0][i + 1]) < d)return false;
                    }
                    return true;
                }
                int nm[] = new int[n], pm[] = new int[n];
                for(int i = 0; i < n; i++){
                    boolean r;
                    for(int j = 0; j < n; j++){
                        if(j == i)continue;
                        r = true;
                        for(int k = 0; k < m; k++){
                            if(Math.abs(a[i][k] - a[j][k]) < d){
                                r = false; break;
                            }
                        }
                        if(r){
                            nm[i] |= (1 << j);
                        }
                        r = true;
                        for(int k = 0; k < m - 1; k++){
                            if(Math.abs(a[i][k + 1] - a[j][k]) < d){
                                r = false; break;
                            }
                        }
                        if(r){
                            pm[i] |= (1 << j);
                        }
                    }
                }
                // for(int i = 0; i < n; i++){
                //     System.out.println(nm[i] + " " + pm[i]);
                // }
                for(int i = 0; i < n; i++){
                    gm = new int[n];
                    gm[i] = nm[i];
                    for(int j = 0; j < n; j++){
                        if(j == i)continue;
                        if((nm[j] & (1 << i)) != 0){
                            gm[j] = nm[j] ^ (1 << i);
                        }else{
                            gm[j] = nm[j];
                        }
                    }
                    for(int j = 0; j < n; j++){
                        if(j == i)continue;
                        if((pm[i] >> j) % 2 == 1){
                            gm[j] |= (1 << i);
                        }
                    }
                    visit = new boolean[n][1 << n]; dp = new int[n][1 << n];
                    // for(int x = 0; x < n; x++)System.out.println(gm[x]);
                    if(dfs(i, i, (1 << i)) == n){
                        return true;
                    }
                }
                return false;
            }
            int dfs(int u, int r, int mask){
                // System.out.println(u + " " + r + " " + mask);
                if(u == r && mask == (1 << n) - 1)return 0;
                if(visit[u][mask])return dp[u][mask];
                visit[u][mask] = true;
                int val = 0;
                for(int i = 0; i < n; i++){
                    if((gm[u] >> i) % 2 == 1 && ((i == r && mask == (1 << n) - 1) || (mask >> i) % 2 != 1)){
                        val = Math.max(val, 1 + dfs(i, r, mask | (1 << i)));
                    }
                }
                // System.out.println(u + " " + mask + " " + val);
                return dp[u][mask] = val;
            }
           public void solve(int testNumber, InputReader in, PrintWriter out) {
            n = in.nextInt(); m = in.nextInt();
            a = new int[n][m];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    a[i][j] = in.nextInt();
                }
            }
            int l = 0, r = max, ans = 0;
            while(l <= r){
                int m = (l + r) >> 1;
                if(check(m)){
                    ans = m;
                    l = m + 1;
                }else{
                    r = m - 1;
                }
            }
            out.println(ans);
          }
//         pair ja[][];long w[];int from[],to[],c[];
//             void make(int n,int m,InputReader in){
//              ja=new pair[n+1][];w=new long[m];from=new int[m];to=new int[m];c=new int[n+1];
//              for(int i=0;i<m;i++){
//               int u=in.nextInt(),v=in.nextInt();long wt=in.nextLong();
//               c[u]++;c[v]++;from[i]=u;to[i]=v;w[i]=wt;
//              }
//              for(int i=1;i<=n;i++){
//               ja[i]=new pair[c[i]];c[i]=0;
//              }
//              for(int i=0;i<m;i++){
//               ja[from[i]][c[from[i]]++]=new pair(to[i],w[i]);
//               ja[to[i]][c[to[i]]++]=new pair(from[i],w[i]);
//              }
//             }
//        int[] radixSort(int[] f){ return radixSort(f, f.length); }
//    int[] radixSort(int[] f, int n)
//    {
//        int[] to = new int[n];
//        {
//            int[] b = new int[65537];
//            for(int i = 0;i < n;i++)b[1+(f[i]&0xffff)]++;
//            for(int i = 1;i <= 65536;i++)b[i]+=b[i-1];
//            for(int i = 0;i < n;i++)to[b[f[i]&0xffff]++] = f[i];
//            int[] d = f; f = to;to = d;
//        }
//        {
//            int[] b = new int[65537];
//            for(int i = 0;i < n;i++)b[1+(f[i]>>>16)]++;
//            for(int i = 1;i <= 65536;i++)b[i]+=b[i-1];
//            for(int i = 0;i < n;i++)to[b[f[i]>>>16]++] = f[i];
//            int[] d = f; f = to;to = d;
//        }
//        return f;
//    }
    }
    static class InputReader {
        BufferedReader br;
        StringTokenizer st;
        public InputReader(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
            st = null;
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return null;
                st = new StringTokenizer(s);
            }
            return st.nextToken();
        }

        boolean hasMoreTokens() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return false;
                st = new StringTokenizer(s);
            }
            return true;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
        public long nextLong() {
            return Long.parseLong(next());
        }
        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}