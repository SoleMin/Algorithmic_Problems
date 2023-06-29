import javafx.util.Pair;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int chet = 0;
        for (int i = 0; i < n; i++) {
            arr[i]=scanner.nextInt();
            for (int j = 0; j < i; j++) {
                if (arr[j]>arr[i]) chet^=1;
            }
        }
        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            if ((((r-l+1)/2)&1)!=0){
                chet^=1;
            }
            if (chet==1){
                System.out.println("odd");
            }else{
                System.out.println("even");
            }
        }

    }


}