import java.util.Scanner;

public class Main {
    
    final static long Mod = 1000000009;
    static long n, m, k, t, l, u, ans;
    static Scanner cin = new Scanner(System.in); 
    
    static long multi_mod(long base, long cur) {
        long res = 1;
        while(cur > 0) {
            if(cur % 2 == 1) res = (res * base) % Mod;
            cur >>= 1;
            base = (base * base) % Mod;
        }
        return res;
    }
    
    public static void main(String[] args) {
        n = cin.nextLong(); m = cin.nextLong(); k = cin.nextLong();
        l = (k - 1)*(n / k) + n % k;
        if(m <= l) {
            System.out.println(m);
        }
        else {
            t = n / k;
            u = m - l;
            ans = (0 + (t - u) * (k - 1) + n % k) % Mod;
            ans = (ans + ((k)*((multi_mod(2, u + 1) - 2 + Mod) % Mod)) % Mod) % Mod;
            System.out.println(ans);
        }
    }
}
