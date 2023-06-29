import java.util.*;
import java.io.*;
public class Cf270a {
    public static void main(String[] args) throws IOException {
        InputStreamReader fin = new InputStreamReader(System.in);
        Scanner scr = new Scanner(fin);
        int n = scr.nextInt();
        int x = 0;
        int y = 0;
        if (n%2 == 0) {
            x = 4;
            y = n - x;
        } else {
            x = 9;
            y = n - x;
        }
        PrintWriter fout = new PrintWriter(System.out);
        fout.print(x+" "+y);
        fout.flush();
        fout.close();
    }
}