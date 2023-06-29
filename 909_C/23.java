import java.util.Scanner;
public class maestro{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long mod = (long)Math.pow(10,9)+7;
        long[][] arr = new long[N][N];
        arr[0][0]=1;
        for (int i=1;i<N;i++){
            char c = sc.next().charAt(0);
            if (c=='f'){
                for (int j=1;j<N;j++) arr[i][j] = arr[i - 1][j - 1];
            }
            else {
                long sum=0;
                for (int j=N-1;j>=0;j--){
                    sum=(sum+arr[i-1][j])%mod;
                    arr[i][j] = sum;
                }
            }
        }
        long ans=0;
        for (int i=0;i<N;i++) ans=(ans+arr[N-1][i])%mod;
        System.out.println(ans);
    }
}