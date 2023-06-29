import java.util.*;
public class maestro{
    public static long inversions(long[] arr) {
        long x = 0;
        int n = arr.length;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    x++;
                    //temp++;
                }
                //if (temp%2==0) inv_a[i][j]=0;
                //else inv_a[i][j]=1;
            }
        }
        return x;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i=0;i<n;i++) arr[i] = sc.nextLong();
        long m = sc.nextLong();
        long x = inversions(arr)%2;
        for (int i=0;i<m;i++){
            int l = sc.nextInt()-1;
            int r = sc.nextInt()-1;
            if ((r-l+1)%4>1) x=(x+1)%2;
            if (x==1) System.out.println("odd");
            else System.out.println("even");
        }
        /*int inv=0;
        int temp=0;
        long[][] inv_a = new long[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                inv_a[i][j]=-1;
            }
        }
        for (int i=n-2;i>=0;i--){
            for (int j=i+1;j<n;j++){
                if (arr[i]<arr[j]){
                    inv++;
                    temp++;
                }
                if (temp%2==0) inv_a[i][j]=0;
                else inv_a[i][j]=1;
            }
            temp=0;
        }
        if (inv%2==0) inv=0;
        else inv=1;
        for (int i=0;i<m;i++){
            int l = sc.nextInt()-1;
            int r = sc.nextInt()-1;
            long[][] exp = new long[r-l+1][r-l+1];
            for (int k=0;k<exp.length;k++){
                for (int h=0;h<exp.length;h++){
                    exp[k][h]=-1;
                }
            }
            for (int j=l;j<=r;j++){

            }
        }*/
    }
}