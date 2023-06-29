
import java.io.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numcase = input.nextInt();
        for (int j = 0; j < numcase; j++) {
            int res = 0;
            int numday = input.nextInt();
            int numparty = input.nextInt();
            int[] h = new int[numparty];
            int[] dayarray = new int[numday];

            for (int i = 0; i < h.length; i++) {
                h[i] = input.nextInt();
                
            }

            for (int i = 1; i <= dayarray.length; i++) {
                if (i%7 == 6 || i%7 == 0) {
                    continue;
                } 
                for (int l = 0; l < h.length; l++) {
                    if (i%h[l] == 0 ) {
                        dayarray[i-1] = 10;
                    }
                }
            }
            for (int i = 0; i < dayarray.length; i++) {
                if (dayarray[i] == 10) {
                    res++;
                }
            }
            System.out.println(res);
        }
    }
}