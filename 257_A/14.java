import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int n = s.nextInt();
        int m = s.nextInt();
        int k = s.nextInt();
        
        int a[] = new int [n];
        for (int i = 0; i < a.length; i++) {
            a[i] = s.nextInt();
        }
        int ans = 0;
        
        while(k < m){
            k--;
            int max = -1;
            int ix = -1;
            for (int i = 0; i < a.length; i++) {
                if(a[i] > max){
                    max = a[i];
                    ix = i;
                }
            }
            if(ix == -1){
                System.out.println("-1");
                return ;
            }
            k += a[ix];
            a[ix] = -1;
            ans++;
        }
        System.out.println(ans);
    }

}
