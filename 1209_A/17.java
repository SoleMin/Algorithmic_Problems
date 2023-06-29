import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.next());
        int[] a = new int[N];
        int[] flag = new int[N];
        int ans = 0;
        for (int i=0;i<N;i++) {
            a[i] = Integer.parseInt(sc.next());
        }
        Arrays.sort(a);
        for (int i=0;i<N;i++) {
            int used = 0;
            for (int j=0;j<N;j++) {
                if (flag[j]==1) {
                    continue;
                } else {
                    if (a[j]%a[i]==0) {
                        used=1;
                        flag[j]=1;
                    }
                }
            }
            if (used==1) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}