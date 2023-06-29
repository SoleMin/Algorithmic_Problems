
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a = input.nextInt();
        int b = input.nextInt();
        int x[] = new int[n];
        for (int i=0; i<n; i++) x[i]=input.nextInt();
        Arrays.sort(x);
        int y[] = new int[n];
        for (int i=0; i<n; i++) y[i]=x[n-i-1];
        System.out.println(y[a-1]-y[a]);
    }
}
