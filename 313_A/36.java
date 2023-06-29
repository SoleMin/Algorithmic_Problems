import java.util.*;

public class Main{

    void solve(){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int n1 = n/10;
        int n2 = n/100*10 + n%10;

        int ans = n;
        ans = Math.max(ans, n1);
        ans = Math.max(ans, n2);
        System.out.println(ans);
    }

    public static void main(String[] args){
        new Main().solve();
    }
}
