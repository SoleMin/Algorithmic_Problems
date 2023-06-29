import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
    private static int n;
    private static PrintWriter writer;
    private static int maxstep;
    
    private static void g(int src, int step) {
        if (step != 0 && n % src == 0) {
            writer.print("YES");
            writer.close();
            System.exit(0);
        }
        
        if (step == maxstep) return;
        
        int p = (int)Math.pow(10, step);
        
        g(src + 4 * p, step + 1);
        g(src + 7 * p, step + 1);
    }
    
    public static void main(String[] args) throws Exception {        
        //Scanner reader = new Scanner(new File("input.txt"));
        //PrintWriter writer = new PrintWriter("output.txt");
        Scanner reader = new Scanner(System.in);
        writer = new PrintWriter(System.out);
        
        n = reader.nextInt();
        maxstep = String.valueOf(n).length() + 1;
        
        g(0, 0);
        
        writer.print("NO");
        writer.close();
    }
}