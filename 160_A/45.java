import java.util.Arrays;
import java.util.Scanner;


public class Round111ProbA {

    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int[]a = new int[n];
        int s =0;
        for(int i =0 ; i < n;i++)
        {
            a[i] = in.nextInt();
            s += a[i];
        }
        Arrays.sort(a);
        int x =0;
        int c =0;
        for(int i =n-1 ; i >-1;i-- )
        {
            x +=a[i];
            s -= a[i];
            c++;
            if(x > s)break;
        }
        System.out.println(c);
    }
    
}
