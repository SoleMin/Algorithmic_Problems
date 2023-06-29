import java.util.Arrays;
import java.util.Scanner;


public class SecondOrderStatistics {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int[] v = new int[n];
        for(int i=0;i<n;i++){
            v[i] = in.nextInt();
        }
        
        Arrays.sort(v);
        int i=0 ;
        for(;i<n && v[0] == v[i];i++);
        System.out.println(i==n? "NO" : v[i]);
    }
}
