
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author scawn
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner (System.in);
        int n = cin.nextInt();
        long res = 2;
        long[] a = new long[4];
        a[0] = 0;
        a[1] = 1;
        a[2] = 1;
        a[3] = 2;
        if (n == 1){
            System.out.println("0 0 1");
            return;
        }
        if (n == 2){
            System.out.println("0 1 1");
            return;
        }
        if (n == 0){
            System.out.println("0 0 0");
            return;
        }
//        if (n == 1 || n == 2 || n == 0){
//            System.out.println("I'm too stupid to solve this problem");
//            return;
//        }
        if (n == 3){
            System.out.println("1 1 1");
            return;
        }
        do{
            a[3] = res;
            res = a[2] + a[3];
            if (res == n){
                System.out.println (a[0] + " " + a[1] + " " + a[3]);
                return;
            }
            a[0] = a[1];
            a[1] = a[2];
            a[2] = a[3];
            
        }while (true);
    }
}
