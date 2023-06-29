/*
Written by Kabir Kanha Arora
@kabirkanha
 */

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[2 * n];
        for (int i = 0; i < 2 * n; ++i)
            arr[i] = scanner.nextInt();
        int ans = 0;
        for (int i = 0; i < 2 * n; i += 2) {
            for (int j = i + 1; j < 2 * n; ++j) {
                if (arr[i] == arr[j]) {
                    int rpos = j;
                    while (rpos - i > 1) {
                        int temp = arr[rpos - 1];
                        arr[rpos - 1] = arr[rpos];
                        arr[rpos] = temp;
                        --rpos;
                        ++ans;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}

	 			    	  	     		  					