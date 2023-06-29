import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class B{
    public static void main(String[] args) throws Exception{
        new B().run();
    }

    double ans = 0;
    int n, candy, A, half;

    void run() throws Exception{
        Scanner sc = new Scanner(System.in);
        //BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        // only sc.readLine() is available
        n = sc.nextInt();
        candy = sc.nextInt();
        A = sc.nextInt();
        half = n/2;
        //int[] level = new int[n];
        //int[] loyal = new int[n];
        S[] ss = new S[n];
        for(int i = 0; i < n; i++){
            ss[i] = new S(sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(ss);
        int need = 0;
        for(int i = n-1; i >= n-half-1; i--)
            need += (100-ss[i].loyal)/10;
        if(need <= candy){
            System.out.println(1.0);
            return;
        }
        tra(ss, 0, candy);
        /*
        while(candy > 0){
            int ind = 0;
            for(int i = 1; i < n; i++)
                if(ss[i].loyal < 100 && ss[ind].level < ss[i].level)
                    ind = i;
            ss[ind].loyal += 10;
            ss[ind].loyal = min(100, ss[ind].loyal);
            candy--;
        }
        */
        System.out.printf("%.10f\n", ans);
    }

    void tra(S[] ss, int pos, int rest){
        if(pos == n){
            double sum = 0;
            int lim = 1<<n;
            for(int m = 0; m < lim; m++){
                int app = Integer.bitCount(m);
                double p = 1;
                int B = 0;
                for(int i = 0; i < n; i++){
                    if(((m>>i) & 1) == 1){
                        p = p * ss[i].loyal / 100;
                    }else{
                        p = p * (100 - ss[i].loyal) / 100;
                        B += ss[i].level;
                    }
                }
                if(app > half)sum += p;
                else{
                    sum += p * A / (A+B);
                }
            }
            ans = max(ans, sum);
            return;
        }
        for(int i = 0; i <= rest; i++){
            int old = ss[pos].loyal;
            int nl = ss[pos].loyal + i * 10;
            if(nl > 100)break;
            ss[pos].loyal = nl;
            tra(ss, pos+1, rest-i);
            ss[pos].loyal = old;
        }
    }
}

class S implements Comparable<S>{
    int level, loyal;
    S(int a, int b){
        level = a;
        loyal = b;
    }
    public int compareTo(S s){
        return this.loyal - s.loyal;
    }
}
