
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;


public class P35C {
    int n, m;
    int [][]fire;
    public P35C() throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader("input.txt"));
        n = in.nextInt();
        m = in.nextInt();
        int k = in.nextInt();
        fire = new int[k][2];
        for (int i = 0; i < k; i++){
            fire[i][0] = in.nextInt();
            fire[i][1] = in.nextInt();
        }
        in.close();
        
        int []last = new int[2];
        int lastBurn = -1;
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                int burn = Integer.MAX_VALUE;
                for (int l = 0; l < k; l++){
                    int burnAux = dist(i, j, fire[l][0], fire[l][1]);
                    burn = Math.min(burn, burnAux);
                }
                if(burn >= lastBurn){
                    lastBurn = burn;
                    last[0] = i;
                    last[1] = j;
                    
            }
            }
        }
        

        PrintStream out = new java.io.PrintStream( "output.txt" );
        out.print(last[0] + " " + last[1]);
        out.close();
    }
    
     int dist(int x1, int y1, int x2, int y2){
         return Math.abs(x2 - x1) + Math.abs(y2 - y1);
     }
    
    public static void main (String []args) throws FileNotFoundException{
        new P35C();
    }
}
