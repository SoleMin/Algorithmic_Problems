import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] a = new int[10000];
    static int[][] dynamic = new int[5500][1100];
    static int k, n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int tc = Integer.parseInt(input);
        for(int t = 0; t < tc; t++) {
            input = br.readLine();
            String[] str = input.split(" ");
            k = Integer.parseInt(str[0]);
            n = Integer.parseInt(str[1]);
            input = br.readLine();
            str = input.split(" ");
            for(int i = n; i >= 1; i--) {
                a[i] = Integer.parseInt(str[n - i]);
            }

            for(int i = 0; i <= n; i++) {
                for(int j = 0; j <= n; j++) {
                    dynamic[i][j] = Integer.MAX_VALUE;
                    if(j == 0)
                        dynamic[i][0] = 0;
                }
            }

            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= k + 8; j++) {
                    dynamic[i][j] = dynamic[i - 1][j];
                    if(i >= j * 3) {
                        dynamic[i][j] = Math.min(dynamic[i][j], dynamic[i - 2][j - 1] + (a[i] - a[i - 1]) * (a[i] - a[i - 1]));
                    }
                }
            }
            System.out.println(dynamic[n][k + 8]);
        }
    }
}
