import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;
public class C {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // Scanner scan = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        // int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        // int[] a = new int[n]; for(int i=0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());

        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        int mod = 1000000007;

        if(n == 0) {
          out.println(0);
          out.close(); System.exit(0);
        }
        n %= mod;

        long ans = exp(2, (int)((k+1) % (mod-1)), mod);
        ans = (1L*ans * n) % mod;
        ans = ans + mod + 1 - exp(2, (int)((k) % (mod-1)), mod);
        ans %= mod;
        out.println(ans);
        // int n = scan.nextInt();

        out.close(); System.exit(0);
    }
    public static int exp(int base, int e, int mod) {
      if(e == 0) return 1;
      if(e == 1) return base;
      int val = exp(base, e/2, mod);
      int ans = (int)(1L*val*val % mod);
      if(e % 2 == 1)
        ans = (int)(1L*ans*base % mod);
      return ans;
    }
}
