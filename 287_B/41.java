import java.util.Scanner;

public class B{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        long n = input.nextLong();
        long k = input.nextLong();
        System.out.println(solve(n, k));
        input.close();
    }
    
    public static long solve(long n, long k){
        long dis = n - k;
        if(n == 1)
            return 0;
        if((((k - 2) * ((k - 2) + 1)) / 2) + 1 <= dis)
            return -1;
        if(k >= n)
            return 1;
        //
        long ans = 2;
        long now = (((k - 2) * ((k - 2) + 1)) / 2) + 1 + k;
        long dist = Math.abs(now - n);
        long delta = 1 + 8 * dist;
        double ret = (1 + Math.sqrt(delta)) / 2;
        //
        now = (((k - 2) * ((k - 2) + 1)) / 2) + 1 + k;
        dist = Math.abs(now - k);
        delta = 1 + 8 * dist;
        double nret = (1 + Math.sqrt(delta)) / 2;
        //
        double back = nret - ret;
        ans = (long) back;
        return ans + 2;
    }
}