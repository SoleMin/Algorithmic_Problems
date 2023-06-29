
import java.util.Arrays;
import java.util.Scanner;

public class CF_Chores {

    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int n = s.nextInt();
        int a = s.nextInt();
        int b = s.nextInt();
        
        long ar[] = new long[n];
        for (int i = 0; i < n; i++) {
            ar[i]=s.nextLong();
        }
        Arrays.sort(ar);
        
        long ret = 0;
//      System.out.println(Arrays.toString(ar));
        if(ar[b]==ar[b-1])
            System.out.println("0");
        else {
            ret = ar[b]-ar[b-1];
            System.out.println(ret);
        }
        
    }

}
