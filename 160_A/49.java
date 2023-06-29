import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class nA {

    Scanner in;
    PrintWriter out;

    void solve() {
        int n = in.nextInt();
        int a[] = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            sum+=a[i];
        }
        Arrays.sort(a);
        int nowsum = 0;
        int kol = 0;
        for(int i = n - 1; i >= 0; i--){
            if(nowsum <= sum / 2){
                nowsum+=a[i];
                kol++;
            }else{
                break;
            }
        }
        out.println(kol);
    }

    void run() {
        in = new Scanner(System.in);
        out = new PrintWriter(System.out);
        try {
            solve();
        } finally {
            out.close();
        }
    }

    public static void main(String[] args) {
        new nA().run();
    }
}
