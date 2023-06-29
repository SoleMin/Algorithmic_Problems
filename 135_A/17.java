import java.util.Arrays;
import java.util.Scanner;

public class C {

    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        sc.nextLine();
        int[] x = new int[n];
        
        int max=0, pos=-1;
        for(int i=0; i<n; i++) {
            x[i]=sc.nextInt();
            if (max<x[i]) {
                max=x[i];
                pos=i;
            }
        }
        x[pos] = (max==1) ? 2 : 1;
        
        Arrays.sort(x);

        for(int i=0; i<n; i++) 
            System.out.print(x[i]+" ");
    }
    
}