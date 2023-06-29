import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int K = s.nextInt();

        int[] primes = getPrimesFast(N);
        Set<Integer> ints = new HashSet<Integer>();
        for(int i=0;i<primes.length;i++) {
            ints.add(primes[i]);
        }

        for(int i=1;i<primes.length;i++) {
            ints.remove(primes[i] + primes[i-1]+1);
        }

        boolean res = primes.length - ints.size() >= K;
        System.out.print(res?"YES":"NO");
        
    }

    public static int[] getPrimesFast(int n) {
    if (n <= 1) {
      return new int[0];
    }
    boolean[] b = new boolean[n + 1];
    int m = n - 1;
    for (int i = 2; i * i <= n; i++) {
      if (!b[i]) {
        for (int j = i + i; j <= n; j += i) {
          if (!b[j]) {
            m--;
            b[j] = true;
          }
        }
      }
    }
    int[] primes = new int[m];
    int j = 0;
    for (int i = 2; i <= n; i++) {
      if (!b[i]) {
        primes[j++] = i;
      }
    }
    return primes;
  }
}
