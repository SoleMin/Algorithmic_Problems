
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);

        int n,v;

        n=scan.nextInt();

        v=scan.nextInt();

        int[]dp=new int[n];

        if(v<n){

            dp[0]=v;

        }

        else{

            dp[0]=n-1;

        }

        for(int i=1;i<n;i++){

            if(v-1<n-i-1){

                dp[i]=dp[i-1]+i+1;

            }

            else{

                dp[i]=dp[i-1];

            }

        }

        System.out.println(dp[n-1]);

    }
}
