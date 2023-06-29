import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class mainE {
    public static PrintWriter out = new PrintWriter(System.out);
    public static FastScanner enter = new FastScanner(System.in);
    public static void main(String[] args) throws IOException {
        int t=enter.nextInt();
        for (int i = 0; i < t; i++) {
            solve();
        }
        out.close();
    }
    public static int[][] arr=new int[13][2010];
    public static pair[] par= new pair[2010];
    private static void solve() throws IOException{
        int n=enter.nextInt();
        int m=enter.nextInt();
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                arr[i][j]=enter.nextInt();
            }
        }
        for (int i = 0; i <n ; i++) {
            for (int j = m; j <m+3 ; j++) {
                arr[i][j]=0;
            }
        }
        m=m+3;

        for (int i = 0; i <m ; i++) {
            int max=-1;
            for (int j = 0; j <n ; j++) {
                max=Math.max(arr[j][i], max);
            }
            par[i]=new pair(max,i);
        }
        Arrays.sort(par,0,m, pair::compareTo);

        int i0=par[0].st;
        int i1=par[1].st;
        int i2=par[2].st;
        int i3=par[3].st;
        int ans=-1;
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                for (int k = 0; k <n ; k++) {
                    for (int l = 0; l <n ; l++) {
                        int first=Math.max(Math.max(arr[i][i0],arr[j][i1]), Math.max(arr[k][i2],arr[l][i3]));
                        int second=Math.max(Math.max(arr[(i+1)%n][i0],arr[(j+1)%n][i1]), Math.max(arr[(k+1)%n][i2],arr[(l+1)%n][i3]));
                        int third=Math.max(Math.max(arr[(i+2)%n][i0],arr[(j+2)%n][i1]), Math.max(arr[(k+2)%n][i2],arr[(l+2)%n][i3]));
                        int fourth=Math.max(Math.max(arr[(i+3)%n][i0],arr[(j+3)%n][i1]), Math.max(arr[(k+3)%n][i2],arr[(l+3)%n][i3]));
                        if(n==1) {
                            second=0;
                            third=0;
                            fourth=0;
                        }
                        else if(n==2){
                            third=0;
                            fourth=0;
                        }
                        else if(n==3){
                            fourth=0;
                        }
                        ans=Math.max(ans, first+second+fourth+third);

                    }
                }
            }
        }
        System.out.println(ans);



    }

    static class pair implements Comparable<pair>{
        int max,st;

        public pair(int max, int st) {
            this.max = max;
            this.st = st;
        }

        @Override
        public int compareTo(pair o) {
            return -Integer.compare(max, o.max);
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer stok;

        FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        String next() throws IOException {
            while (stok == null || !stok.hasMoreTokens()) {
                String s = br.readLine();
                if (s == null) {
                    return null;
                }
                stok = new StringTokenizer(s);
            }
            return stok.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        char nextChar() throws IOException {
            return (char) (br.read());
        }

        String nextLine() throws IOException {
            return br.readLine();
        }
    }
}
