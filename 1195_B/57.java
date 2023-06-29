
import java.util.Scanner;


public class CodeForces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int k = sc.nextInt();
        int ans = 0;
        long x = n;
        x = x*(x+1)/2;
        while (x!=k) {
            x-=n;
            n--;
            ans++;
            k++;
        }
        System.out.println(ans);
    }
}
