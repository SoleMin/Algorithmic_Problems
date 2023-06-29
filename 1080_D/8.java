import java.math.*;
import java.text.*;
import java.util.*;
public class Main {

    public static void main(String args[]) {
        Scanner sca = new Scanner(System.in);
        long k,n;
        long ans;
        long[] pw = new long[33];
        pw[1]=4;
        pw[0]=1;
        for(int i=2;i<=31;i++)
            pw[i]=pw[i-1]<<2;
        int t;
        t = sca.nextInt();
        for(int cas=1;cas<=t;cas++) {
            n = sca.nextLong();
            k = sca.nextLong();
            ans = n;
            long last, path = 1;
            for (int i = 0; ; i++) {
                if ((pw[i + 1] - 1) / 3 > k) {
                    ans -= i;
                    last = k - (pw[i] - 1) / 3;
                    break;
                }
                path *= 2;
            }
            long sp = path * 2 - 1;
            if (ans < 0 || (ans == 0 && last > 0)) {
                System.out.println("NO");
                continue;
            }
            BigInteger sq = BigInteger.valueOf(path).multiply(BigInteger.valueOf(path)).subtract(BigInteger.valueOf(sp));
            if (ans == 1 && sq.compareTo(BigInteger.valueOf(last))==-1 && last < sp) {
                System.out.println("NO");
                continue;
            } else if (ans == 1 && last >= sp) {
                ans--;
            }
            System.out.println("YES "+ans);
        }

    }
}