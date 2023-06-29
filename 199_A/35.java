/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

/**
 *
 * @author dilshan
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = 1;
        int t = 0;
        int y = 2;
        int[] a = new int[100000];
        if(n==0){
            System.out.println(0+" "+0+" "+0);
        }
        else 
            if(n==1){
            System.out.println(0+" "+0+" "+1);
            }
            else 
                if(n==2){
                System.out.println(0+" "+1+" "+1);
                }
                else{
                    a[0] = 0;
                    a[1] = 1;
                    a[y] = a[y - 2] + a[y - 1];
                    while (a[y - 1] < n) {

                        a[y] = a[y - 2] + a[y - 1];
                        ++y;


                    }
                    System.out.println(a[y - 2] + " " + a[y - 4] + " " + a[y - 5]);
            }
        //System.out.println(y);
        


    }
}
