
import java.util.Scanner;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next(),c;
        int n = s.length(),a,b;
        
        for(int sz = n ; sz >= 1 ; sz--) {
            for(int i = 0 ; i+sz <= n ; i++) {
                c = s.substring(i, i+sz);
                a = s.indexOf(c,0);
                if(a < 0) continue;
                b = s.indexOf(c,a+1);
                if(b < 0) continue;
                System.out.println(sz);
                return;
                
            } // for j
        } // for i
        System.out.println(0);

    }

}