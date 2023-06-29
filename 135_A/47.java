import java.util.Arrays;
import java.util.Scanner;


public class A {
    static final Scanner sc = new Scanner(System.in);
    
    void run() {
        int n = sc.nextInt();
        int[] xs = new int[n];
        for(int i = 0; i < n; i++) {
            xs[i] = sc.nextInt();
        }
        Arrays.sort(xs);
        xs[n-1] = xs[n-1] == 1 ? 2 : 1;
        Arrays.sort(xs);
        for(int i = 0; i < n; i++)
            System.out.print(xs[i] + " ");
    }
    
    public static void main(String[] args) {
        new A().run();
    }
}
