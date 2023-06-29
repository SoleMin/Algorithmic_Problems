import java.util.*;
public class B138 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a[] = new int[100004];
        int b[] = new int[100004];
        int n, m, ans = 0, dau, cuoi=-1;
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i=0;i<100004;i++) a[i] = 0;
        for(int i=0;i<n;i++){
            b[i] = sc.nextInt();
            if(a[b[i]]==0){
                a[b[i]] = 1;
                ans++;
                if(ans==m){
                    cuoi = i+1;
                    break;
                }
            }
        }
        for(int i=cuoi-1;i>=00;i--){
            if(a[b[i]]==1){
                a[b[i]] = 0;
                ans--;
                if(ans==0){
                    System.out.println((i+1)+" "+cuoi);
                    System.exit(0);
                }
            }
        }
        System.out.println("-1 -1");
    }

}
