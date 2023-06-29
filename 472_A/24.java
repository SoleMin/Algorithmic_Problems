/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author RezaM
 */
public class A {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        if (n % 2 == 0) {
            System.out.println(4 + " " + (n - 4));
        } else {
            System.out.println(9 + " " + (n - 9));
        }

    }

}
