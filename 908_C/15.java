/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import java.util.*;

/**
 *
 * @author kamranmaharov
 */
public class Main {

    
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] line = in.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int r = Integer.parseInt(line[1]);
        
        line = in.readLine().split(" ");
        int[] x = new int[n+1];
        double[] y = new double[n+1];
        
        for (int i=1; i<=n; ++i) {
            x[i] = Integer.parseInt(line[i-1]);
            double maxy = -1.0;
            for (int j=1; j<i; ++j) {
                double x2 = x[i];
                double x1 = x[j];
                double y1 = y[j];
                
                double a = 1;
                double b = -2 * y1;
                double c = x1 * x1 + x2 * x2 - 2 * x1 * x2 + y1 * y1 - 4.0 * r * r;
                
                double D = b * b - 4 * a * c;
                //System.out.println(i + " " + j + " " + D);
                if (D >= 0) {
                    double y2 = (-b + Math.sqrt(D)) / (2 * a);
                    maxy = Math.max(maxy, y2);
                }
            }
            if (maxy < 0) {
                maxy = r;
            }
            y[i] = maxy;
            if (i>1) {System.out.print(" ");}
            System.out.printf("%.13f", y[i]);
        }
        System.out.println();
    }
}
