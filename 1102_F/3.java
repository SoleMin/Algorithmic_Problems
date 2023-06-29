import java.io.*;
import java.util.*;
import java.lang.*;


public class Main implements Runnable {
    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars==-1)
                throw new InputMismatchException();

            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                }
                catch (IOException e) {
                    throw new InputMismatchException();
                }

                if(numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
        public int nextInt() {
            int c = read();

            while(isSpaceChar(c))
                c = read();

            int sgn = 1;

            if (c == '-') {
                sgn = -1;
                c = read();
            }

            int res = 0;
            do {
                if(c<'0'||c>'9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));

            return res * sgn;
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;

            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
            return res * sgn;
        }

        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E')
                        return res * Math.pow(10, nextInt());
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            }
            while (!isSpaceChar(c));

            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
    public static void main(String args[]) throws Exception {
        new Thread(null, new Main(),"Main",1<<26).start();
    }

    static long gcd(long a,long b){ if(b==0)return a;return gcd(b,a%b); }
    static long modPow(long a,long p,long m){ if(a==1)return 1;long ans=1;while (p>0){ if(p%2==1)ans=(ans*a)%m;a=(a*a)%m;p>>=1; }return ans; }
    static long modInv(long a,long m){return modPow(a,m-2,m);}
    static long sol_x,sol_y,gcd_a_b;
    static void extendedEuclid(long a,long b){ if(b==0){gcd_a_b=a;sol_x=1;sol_y=0; } else{ extendedEuclid(b,a%b);long temp = sol_x;sol_x=sol_y;sol_y = temp - (a/b)*sol_y; } }
    static class Bhavansort{ Random random;Bhavansort(int a[]){ randomArray(a); sort(a);}Bhavansort(long a[]){ randomArray(a); sort(a);}static int[] sort(int a[]){ Arrays.sort(a);return a;}static long[] sort(long a[]){ Arrays.sort(a);return a; }void randomArray(long a[]){ int n=a.length;for(int i=0;i<n;i++){ int p=random.nextInt(n)%n;long tm=a[i];a[i]=a[p];a[p]=tm; } }void randomArray(int a[]){ int n=a.length;for(int i=0;i<n;i++){ int p=random.nextInt(n)%n;int tm=a[i];a[i]=a[p];a[p]=tm; } }}



    public void run() {
        InputReader sc = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n=sc.nextInt();
        int m=sc.nextInt();
        int a[][]=new int[n][m];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                a[i][j]=sc.nextInt();
            }
        }

        int cost[][]=new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n ; j++) {
                cost[i][j]=Integer.MAX_VALUE;
                for (int k = 0; k <m ; k++) {
                    cost[i][j]=Math.min(cost[i][j],Math.abs(a[i][k]-a[j][k]));
                }
            }
        }

        int costRight[][]=new int[n][n];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                costRight[i][j]=Integer.MAX_VALUE;
                for (int k = 0; k <m-1 ; k++) {
                    costRight[i][j]=Math.min(Math.abs(a[i][k+1]-a[j][k]),costRight[i][j]);
                }
            }
        }

        /*for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                out.print(cost[i][j]+" ");
            }
            out.println();
        }
        out.println();

        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                out.print(costRight[i][j]+" ");
            }
            out.println();
        }*/

        if(n==1){
            int ans=Integer.MAX_VALUE;
            for (int i = 0; i <m-1 ; i++) {
                ans=Math.min(ans,Math.abs(a[0][i]-a[0][i+1]));
            }
            out.println(ans);
            out.close();
            return;
        }

        Long dp[][][]=new Long[n+1][n+1][1<<n];
        long max=0;
        for (int i = 0; i <n ; i++) {
           // out.println(f(i,i,1<<i,dp,n,cost,costRight));
            max=Math.max(max,f(i,i,1<<i,dp,n,cost,costRight));
        }

        out.println(max);
        out.close();
    }

    long f(int start,int end,int mask,Long dp[][][],int n,int cost[][],int costRight[][]){
        if(dp[start][end][mask]!=null)return dp[start][end][mask];
        long ans=Integer.MIN_VALUE;
        for (int i = 0; i <n ; i++) {
            if((mask&(1<<i))==0){
                int newMask=mask|(1<<i);
                if((1<<n)-1!=(mask|(1<<i))){
                    ans = Math.max(ans, Math.min(cost[end][i], f(start, i, newMask, dp, n, cost, costRight)));
                }
                else{
                    ans=Math.max(ans,Math.min(cost[end][i],costRight[start][i]));
                }
            }
        }
        return dp[start][end][mask]=ans;
    }

}