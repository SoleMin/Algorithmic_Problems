import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;


public class A {

    /**
     * @param args
     */
    public static void main(String[] args) {
        HomeWorks hw = new HomeWorks();
        hw.sol();
        hw.print();
    }

}

class HomeWorks {
    HomeWorks(){
        Scanner scr = new Scanner(System.in);
        
        n = scr.nextInt();
        a = scr.nextInt();
        b = scr.nextInt();
        h = new int[n];
        
        for (int i = 0; i < n; i++){
            h[i] = scr.nextInt();
        }
        scr.close();
    }
    
    void sol() {
        Arrays.sort(h);
        int Vasya = h[b-1];
        int Petya = h[b]; 
        
        ans = Petya - Vasya;
        if (ans < 0){
            ans = 0;
        }
        
    }
    
    void print(){
        PrintWriter pw = new PrintWriter(System.out);
        pw.println(ans);
        pw.flush();
        pw.close();
    }
    
    int ans;
    
    int[] h;
    
    int n;
    int a;
    int b;
}
