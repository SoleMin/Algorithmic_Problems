
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author EndUser
 */
public class R455D2PC {

    public static void main(String[] args) {
        final int MAX = 5000;
        final int MODULO = 1000000007;

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        int pre = 0;
        int size = 0;

        int[] block = new int[MAX];
        for (int i = 0; i < n; i++) {
            String command = in.nextLine();
            if (command.startsWith("s")) {
                block[size++] = pre;
                pre = 0;
            } else {
                pre++;
            }
        }

        if (pre != 0) {
            System.out.println(0);
            return;
        }

        int[][] result = new int[2][MAX + 1];
        int currentMax = 0;
        int preIndex = 0;
        result[preIndex][0] = 1;
        for (int i = 1; i < size; i++) {
            int currentIndex = preIndex ^ 1;
            int j = block[i - 1];
            for (int k = currentMax; k >= 0; k--) {
                result[currentIndex][k + j] = (result[currentIndex][k + j + 1] + result[preIndex][k]) % MODULO;
            }
            for (int k = j - 1; k >= 0; k--) {
                result[currentIndex][k] = result[currentIndex][j];

            }
            currentMax += j;
            preIndex = currentIndex;
//            for (int k = 0; k <= currentMax; k++) {
//                System.out.print(result[preIndex][k] + " ");
//                
//            }
//            System.out.println("");
        }

        int sum = 0;
        for (int i = 0; i <= currentMax; i++) {
            sum = (sum + result[preIndex][i]) % MODULO;
        }
        
        System.out.println(sum);
    }
}
