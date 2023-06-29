import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long A = in.nextLong();
        long B = in.nextLong();
        System.out.println(f(A,B));
    }
    static long f(long A, long B) {
        if(A==0) return 0;
        if(A < B) return f(B,A);
        else {
            long k = A/B;
            return k+f(A-B*k, B);
        }
    }
}
