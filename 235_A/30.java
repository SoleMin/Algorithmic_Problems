import java.util.Arrays;
import java.util.Scanner;
public class Main{
  public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       Long N = sc.nextLong();
       Long ans;
       sc.close();
       if(N <= 2)
           System.out.println(N);
       else{
           if(N % 6 == 0){
                ans = (N - 1) * (N - 2) * (N - 3);}
            else if(N % 2 == 0){
                ans = N * (N - 1) * (N - 3);
            }
            else{
                ans = N * (N - 1) * (N - 2);
            }
           System.out.println(ans);
       }
    }
}