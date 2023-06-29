import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        new A().solve();
    }
    
    public void solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        float[] left = new float[n];
        float[] right = new float[n];
        for (int i=0; i<n; ++i) {
            int c = sc.nextInt();
            int w = sc.nextInt();
            left[i] = (float) (c - (float) w * 1.0 / 2);
            right[i] = (float) (c + (float) w * 1.0 / 2);
        }
        for (int i=0; i<n; ++i)
            for (int j=i+1; j<n; ++j)
                if (left[j] < left[i]) {
                    float tmp = left[i];
                    left[i] = left[j];
                    left[j] = tmp;
                    tmp = right[i];
                    right[i] = right[j];
                    right[j] = tmp;
                }
        int res = 2;
        for (int i=1; i<n; ++i) {
            float dis = left[i] - right[i-1];
            if (Math.abs(dis - t) < 0.000001)
                res ++;
            if ((dis - t) > 0.000001)
                res += 2;
        }
        System.out.println(res);
    }
}
