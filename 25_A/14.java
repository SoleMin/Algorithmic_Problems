import java.util.Scanner;
import static java.lang.Math.*;
import static java.lang.Integer.*;
import static java.lang.Long.*;
import static java.util.Arrays.*;

public class A {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int n = s.nextInt();
            int[] a = new int[n];
            int odd = 0;
            int even = 0;
            int po = -1;
            int ev = -1;
            for(int i=0;i<n;i++){
                a[i] = s.nextInt();
                if(a[i] % 2 == 0) {
                    even ++;
                    ev = i + 1;
                } else {
                    odd++;
                    po = i + 1;
                }
            }
            if(odd == 1) {
                System.out.println(po);
            }else{
                System.out.println(ev);
            }
        }
    }
}