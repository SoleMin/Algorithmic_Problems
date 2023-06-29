import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class CF224B {
    
    public static void main(String[] args) throws Exception {
        new CF224B().solve();
    }

    private void solve() throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        final int MAX_A = 100000;
        int[] freq = new int[MAX_A+1];
        int numDistinct = 0;
        int r = -1;
        for (int i = 0; i < n; i++) {
            int t = a[i];
            freq[t]++;
            if (freq[t] == 1) {
                numDistinct++;
            }
            if (numDistinct == k) {
                r = i;
                break;
            }
        }
        if (r == -1) {
            System.out.println("-1 -1");
            return;
        }
        int l;
        for (l = 0; l < r; l++) {
            int t = a[l];
            freq[t]--;
            if (freq[t] == 0) {
                break;
            }
        }
        System.out.println((l+1) + " " + (r+1));
    }

}
