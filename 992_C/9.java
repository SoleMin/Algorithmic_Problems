import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dummy {
  private static long mod = 1000000007;
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String[] strs = reader.readLine().split(" ");
    long x = Long.parseLong(strs[0]);
    long k = Long.parseLong(strs[1]);
    long twoPK = modPow(2, k);
    long twoPK_1 = (twoPK * 2) % mod;
    long res = ((twoPK_1 * (x % mod)) % mod - (twoPK - 1) + mod) % mod;
    System.out.println(x == 0? x: res);
  }

  private static long modPow(long base, long pow) {
    long res = 1;
    while(pow != 0) {
      if((pow & 1) != 0) {
        res = (res % mod * base % mod)%mod;
      }
      base = (base % mod * base % mod) % mod;
      pow >>= 1;
    }
    return res;
  }
}
