import java.util.*;
import java.lang.*;

public class A {
    public static void main(String[] args) {
        // getting the inputs
        Scanner in = new Scanner(System.in);
        long l = in.nextLong();
        long r = in.nextLong();
        // printing the output
        new Solver().solve(l, r);
    }
}

class Solver {
    public void solve(long l, long r) {  
        if(r-l==1 || r-l==0) {
            System.out.println(-1);
            return;
        }
        if(r-l==2 && l%2!=0) {
            System.out.println(-1);
            return;
        }
        // long i;
        // long a = l, b = l+1, c = l+2;

        // while(a < r-2) {
        //     b = a+1;
        //     while(b < r-1) {
        //         c = b+1;
        //         while(c < r) {
        //             if(gcd(a,c) != 1 && gcd(a,b) == 1 && gcd(b,c) == 1) {
        //                 System.out.println(a + " " + b + " " + c);
        //                 return;
        //             }
        //             c++;
        //         }
        //         b++;
        //     }
        //     a++;
        // }
        if(l % 2 == 0) System.out.println(l + " " + (l+1) + " " + (l+2));
        else System.out.println((l+1) + " " + (l+2) + " " + (l+3));
    }
    
    // public long gcd(long a, long b) {
    //     if(a == b) return -1;
    //     long i;
    //     long ans = 1;
    //     for(i = 1; i < Math.max(a, b); i++) {
    //         if(a%i==0 && b%i==0) ans = i;
    //         if(ans > 1) return -1;
    //     }
    //     return ans;
    // }
}
