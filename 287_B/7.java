import java.io.PrintWriter;
import java.util.Scanner;

public class Problem2 implements Runnable {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);

        long n = scanner.nextLong();
        long k = scanner.nextLong();

        long count = 1;


        if (n == 1) {
            writer.println(0);
            writer.close();
            return;
        }

        if (k >= n) {
            writer.println(1);
            writer.close();
            return;
        }

        long answer = 0;

        while (k > 1) {
            if (k > 2000) {
                if (count + k <= n) {
                    if (count + (k - 1 + k - 1000) * 500 <= n) {
                        count += (k - 1 + k - 1000) * 500;
                        k -= 1000;
                        answer += 1000;
                    }
                }
            }
            if ((count + k - 1) <= n) {
                    count += (k - 1);
                    answer++;

            }

            if (count + k - 100000000000000000l > n) {
                k -= 99999999999999999l;
            }
            if (count + k - 10000000000000000l > n) {
                k -= 9999999999999999l;
            }
            if (count + k - 1000000000000000l > n) {
                k -= 999999999999999l;
            }
            if (count + k - 100000000000000l > n) {
                k -= 99999999999999l;
            }
            if (count + k - 10000000000000l > n) {
                k -= 9999999999999l;
            }
            if (count + k - 1000000000000l > n) {
                k -= 999999999999l;
            }
            if (count + k - 100000000000l > n) {
                k -= 99999999999l;
            }
            if (count + k - 10000000000l > n) {
                k -= 9999999999l;
            }
            if (count + k - 1000000000l > n) {
                k -= 999999999l;
            }
            if (count + k - 100000000l > n) {
                k -= 99999999l;
            }
            if (count + k - 10000000l > n) {
                k -= 9999999l;
            }
            if (count + k - 1000000l > n) {
                k -= 999999l;
            }
            if (count + k - 100000l > n) {
                k -= 99999l;
            }
            if (count + k - 10000l > n) {
                k -= 9999l;
            }
            if (count + k - 1000l > n) {
                k -= 999l;
            }
            if (count + k - 100l > n) {
                k -= 99l;
            }


            if (n - count + 1 < k) {
                k = n - count + 1;
            } else {
                k--;
            }

        }


        if (count == n) {
            writer.println(answer);
        } else {
            writer.println(-1);
        }
        writer.close();
    }
    public static void main(String[] args) {
        new Problem2().run();
    }
}
