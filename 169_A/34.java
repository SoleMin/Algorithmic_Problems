import java.util.Arrays;
import java.util.Scanner;

public class problemA {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[] hs = new int[n];
        for(int i = 0; i < n; i++){
            hs[i] = sc.nextInt();
        }
        Arrays.sort(hs);
        System.out.println(hs[b]-hs[b-1]);
    }
}