import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[] h = new int[n];
        for (int i = 0; i < n; i++)
            h[i] = sc.nextInt();

        Arrays.sort(h);
        
        pw.print(h[b]-h[b-1]);
        pw.close();
    }

}
