
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
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
public class E35PD {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j]) {
                    count++;
                }
            }            
        }
        
        boolean isEven = (count % 2 == 0);
        
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            int l = in.nextInt();
            int r = in.nextInt();
            int size = (r - l) + 1;
            int numOfConn = (size - 1) * size / 2;
            if (numOfConn % 2 == 1) {
                isEven = !isEven;
            }
            if (isEven) {
                out.write("even");
                out.newLine();
            } else {
                out.write("odd");
                out.newLine();
            }
        }
        out.close();
    }
}
