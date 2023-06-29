
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author madis
 */
public class Pjar {

    static int a[][];

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        PrintWriter out = new PrintWriter("output.txt");

        int N = in.nextInt();
        int M = in.nextInt();

        a = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                a[i][j] = Integer.MAX_VALUE;
            }
        }
        int k = in.nextInt();
        in.nextLine();
        for (int i = 0; i < k; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            a[x - 1][y - 1] = 1;
            burn(x - 1, y - 1);
        }
        int max = Integer.MIN_VALUE;
        int x = 0;
        int y = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(a[i][j]>max){
                    max = a[i][j];
                    x = i+1;
                    y = j+1;
                }
            }
        }
        out.printf("%d %d",x,y);
        out.close();
        in.close();
    }

    static void burn(int i, int j) {
        for(int k = 0;k<a.length;k++){
            for(int l=0;l<a[k].length;l++){
                if(a[k][l]>Math.abs(k-i) + Math.abs(l-j)){
                    a[k][l]=Math.abs(k-i) + Math.abs(l-j);
                }
            }
        }
    }
}
