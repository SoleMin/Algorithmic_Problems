import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[] arr = br.readLine().toCharArray();
        int[][] count = new int[m][m];
        for (int i = 0; i < n - 1; i++) {
            count[arr[i] - 'a'][arr[i + 1] - 'a']++;
            count[arr[i + 1] - 'a'][arr[i] - 'a']++;
        }
        int[] memo = new int[1 << m];
        Arrays.fill(memo, (int) 1e9);
        memo[0] = 0;
        for (int msk = 0; msk < 1 << m; msk++) {
            for (int c = 0; c < m; c++) {
                if ((msk & 1 << c) != 0)
                    continue;
                int temp = 0;
                for (int i = 0; i < m; i++) {
                    if (i == c)
                        continue;
                    if ((msk & 1 << i) != 0) {
                        temp += count[c][i];
                    } else
                        temp -= count[c][i];
                }
                memo[msk | 1 << c] = Math.min(memo[msk | 1 << c], temp*Integer.bitCount(msk) + memo[msk]);
            }
        }
        System.out.println(memo[(1 << m) - 1]);
    }
}