import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner Console = new Scanner(System.in);
        
        long N = Console.nextLong();
        long D = Console.nextLong();
        System.out.println(solve(N,D));
    }
    
    public static long solve(long N, long D){
        if (N == 0) return 0;
        if (N == D-1) return D;
        if (N >= D) return N/D + solve(N%D, D);
        return D/N + solve(D%N, N);
    }
}