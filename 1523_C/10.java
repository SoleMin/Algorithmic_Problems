import java.io.*;
import java.util.*;

public class C {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static FastReader s = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    private static int[] rai(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        return arr;
    }

    private static int[][] rai(int n, int m) {
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.nextInt();
            }
        }
        return arr;
    }

    private static long[] ral(int n) {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextLong();
        }
        return arr;
    }

    private static long[][] ral(int n, int m) {
        long[][] arr = new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.nextLong();
            }
        }
        return arr;
    }

    private static int ri() {
        return s.nextInt();
    }

    private static long rl() {
        return s.nextLong();
    }

    private static String rs() {
        return s.next();
    }

    static long gcd(long a,long b)
    {
        if(b==0)
        {
            return a;
        }
        return gcd(b,a%b);
    }

    static int gcd(int a,int b)
    {
        if(b==0)
        {
            return a;
        }
        return gcd(b,a%b);
    }

    static boolean isPrime(int n) {
        //check if n is a multiple of 2
        if (n % 2 == 0) return false;
        //if not, then just check the odds
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
    static int MOD=1000000007;

    static long mpow(long base,long pow)
    {
        long res=1;
        while(pow>0)
        {
            if(pow%2==1)
            {
                res=(res*base)%MOD;
            }
            pow>>=1;
            base=(base*base)%MOD;
        }
        return res;
    }

    public static void main(String[] args) {
        StringBuilder ans = new StringBuilder();
        int t = ri();
//        int t = 1;
        while (t-- > 0)
        {
            int n=ri();
            int[] arr=rai(n);

            List<Integer> list = new ArrayList<>();
            for(int i:arr)
            {
                if(i==1)
                {
                    list.add(i);
                }
                else
                {
                    int ind = list.size()-1;
                    while(list.size()>0 && list.get(ind)+1!=i )
                    {
                        list.remove(list.size()-1);
                        ind=list.size()-1;
                    }
                    if(list.size()>0)
                    {
                        list.remove(list.size()-1);
                    }
                    list.add(i);
                }

                for(int j=0;j<list.size()-1;j++)
                {
                    ans.append(list.get(j)).append(".");
                }
                ans.append(list.get(list.size()-1)).append("\n");
            }
        }
        out.print(ans.toString());
        out.flush();
    }



}