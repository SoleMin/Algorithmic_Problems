//package com.company;
import java.io.*;

//@author Maurice Saldivar
public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);
        double totalTime = 0;
        int A = 0, V = 0, L = 0, D = 0, W = 0;
        String tokens[];
        tokens = br.readLine().split("\\s+");
        A = Integer.parseInt(tokens[0]);
        V = Integer.parseInt(tokens[1]);
        tokens = br.readLine().split("\\s+");
        L = Integer.parseInt(tokens[0]);
        D = Integer.parseInt(tokens[1]);
        W = Integer.parseInt(tokens[2]);

        if (V >= W) {
            if (W * W >= 2 * A * D) {

                double x = Math.sqrt(2*A*D);    // The max speed when passing the traffic light
                totalTime = x / A;

                if ((V * V - x * x) >= 2 * A * (L - D)) {

                    totalTime += (-2 * x + Math.sqrt(4 * x * x + 8 * A * (L - D))) / (2 * A);
                }
                else {

                    totalTime += (V - x) / (1.0 * A) + (L - D - (V * V - x * x) / (2.0 * A)) / V;
                }
            } else {

                if (2 * V * V - W * W   <= 2 * A * D) {

                    totalTime = V   / (1.0*A) + (V - W)  / (1.0 * A) + (D - (2 * V * V - W * W ) /(2.0 * A)) / V ;
                } else {

                    double x = Math.sqrt((2 * A * D + W * W ) /2.0);
                    totalTime = x / A + ( x - W ) / A;
                }

                if ((V * V - W * W )  >= 2 * A  *(L - D))

                    totalTime += (-2 * W + Math.sqrt(4 * W * W + 8 * A * (L - D))) / (2 * A);
                else

                    totalTime += (V - W) /(1.0 * A) + (L - D - (V * V - W * W ) /(2.0 * A))/V ;
            }
        } else {


            if (V * V >= 2 * A * L)

                totalTime = Math.sqrt(L * 2.0 / A);
            else

                totalTime = V   / (1.0 * A) + (L - V * V / (2.0 * A)) / V ;
        }

        pr.printf("%.10f", totalTime);
        pr.flush();

    }
}
