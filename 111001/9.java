
import java.util.*;

class Main {
    static Scanner sc = new Scanner(System.in);
    static final int MAXN = 100;
	  static final int init = 99999;
    static int n;
    static boolean [] check;
    static double [][] dot;
    static double [] minval;
    static double result;
    public static void input(){
        int i;
        n = sc.nextInt();
        dot = new double[n][2];
        check = new boolean [n];
        for ( i = 0; i < n; i++){
            dot[i][0] = sc.nextDouble();
            dot[i][1] = sc.nextDouble();
        }
    }
    public static double dist(int a, int b){
        return Math.sqrt(Math.pow(dot[a][0] - dot[b][0], 2) + Math.pow(dot[a][1] - dot[b][1], 2));
    }
    public static void solve(){
        minval = new double[MAXN];
        int i, j, a;
        result = 0;
        for (i = 0; i < n; i++)
            check[i] = false;
        check[0] = true;
        for (i = 1; i < n; i++)
            minval[i] = dist(0, i);
        for (i = 0; i < n-1; i++){
            a = init;
            for (j = 0; j < n; j++)
            {
                if (check[j] == false && (a == init ||minval[a] > minval[j]))
                    a = j;
            }
            result += minval[a];
            check[a] = true;

            for (j  = 0; j < n; j++)
            {
                if (minval[j] > dist(a, j) && check[j] == false)
                    minval[j] = dist(a, j);
            }
        }

    }
    public static void main(String[] args) {
        int i, t;
        t = sc.nextInt();
        for ( i = 0; i < t; i++){
            input();
            solve();
            if (i > 0)
                System.out.println();
            System.out.printf("%.2f\n", result);
        }
    }
}