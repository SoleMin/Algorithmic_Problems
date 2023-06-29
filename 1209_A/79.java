import java.util.*;

public final class paint_and_numers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++) a[i] = in.nextInt();
        Arrays.sort(a);
        int count = 0;
        boolean[] c = new boolean[n];
        for(int i=0;i<n;i++) {
            if(c[i]==false) {
                c[i]=true;
                count++;
                for(int j=i+1;j<n;j++) {
                    if(a[j]%a[i]==0) {
                        c[j] = true;
                    }
                }
            }
        }
        System.out.println(count);
    }
}