/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package CodeForces3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class HexadecimalsTheorem {

    public void solve() {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        ArrayList<Long> a = new ArrayList<Long>();

        a.add(0l);
        a.add(1L);
        a.add(1L);

        int i = 1, j = 2;

        while ((a.get(i) + a.get(j)) <= n) {
            a.add((a.get(i) + a.get(j)));
            i++;
            j++;
        }

        if (a.contains(n)) {
            if (n == 0) {
                System.out.println("0 0 0");
            } else if (n == 1) {
                System.out.println("0 0 1");
            } else if (n == 2) {
                System.out.println("0 1 1");
            } else {
                System.out.println(a.get(j - 4) + " " + a.get(j - 3) + " " + a.get(j - 1));

            }

        } else {
            System.out.println("I'm too stupid to solve this problem");
        }


    }

    public static void main(String[] args) {
        new HexadecimalsTheorem().solve();
    }
}
