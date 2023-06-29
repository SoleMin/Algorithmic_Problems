import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    private static int MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        char[] arr = s.toCharArray();
        int k = Integer.parseInt(reader.readLine());
        if (k==0) {
            System.out.println(1);
            System.exit(0);
        }
        int[] operations = new int[1001];
        for (int i=2; i<=1000; i++) {
            int ones = 0;
            char[] a = Integer.toBinaryString(i).toCharArray();
            for (char elem:a) {
                if (elem=='1') ones++;
            }
            operations[i] = operations[ones] + 1;
        }
        int n = arr.length;
        if (n<=10 && Integer.parseInt(s, 2)<=1000) {
            int x = Integer.parseInt(s, 2);
            int res = 0;
            for (int i=0; i<=x; i++) {
                if (operations[i]==k) res++;
            }
            System.out.println(res);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i=1; i<=1000; i++) {
                if (operations[i]==k-1) list.add(i);
            }
            int[][] matr = new int[n+1][n+1];
            for (int i=0; i<=n; i++) {
                matr[i][0] = matr[i][i] = 1;
                if (i==0) continue;
                for (int j=1; j<=n; j++) {
                    matr[i][j] = (matr[i-1][j-1] + matr[i-1][j]) % MOD;
                }
            }
            int res = 0;
            for (int y=1; y<n; y++) {
                for (int x:list) {
                    if (x>y) break;
                    if (y==1 && x==1) continue;
                    res = (res + matr[y-1][x-1]) % MOD;
                }
            }
            int amount = 1;
            for (int i=1; i<n; i++) {
                if (arr[i]=='1') {
                    int y = n - i - 1;
                    for (int x:list) {
                        if (x-amount>y) break;
                        if (x-amount<0) continue;
                        res = (res + matr[y][x-amount]) % MOD;
                    }
                    amount++;
                }
            }
            if (list.contains(amount)) res = (res + 1) % MOD;
            System.out.println(res);
        }
    }
}