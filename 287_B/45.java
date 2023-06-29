import java.util.*;
import java.io.*;

public class Contest176B {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int k = sc.nextInt();
        
        if( ((long)k * (long)(k + 1))/2 - 1 - (k - 2) < n){
            System.out.println(-1);
            return;
        }
        
        if(n == 1) {
            System.out.println(0);
            return;
        }
        
        if(n <= k) {
            System.out.println(1);
            return;
            
        }
        
        int ans = rek(2, k, n, k);
        
        System.out.println(ans);
    }
    
    private static int rek(int s, int e, long n, int k){
        //System.out.println(s + " " + e );
        if(s == e){
            return k - s + 1;
        }
        if(s + 1 == e){
            if(sum(e, k) >= n) return k - e + 1;
            return k - s + 1;
        }

        int m = (s + e)/2;
        
        long ans = sum(m, k);
        
        if(ans == n) return k - m + 1;
        if(ans < n) return rek(s, m - 1, n, k);
        else return rek(m , e, n, k); 
        
        
    }
    private static long sum(int a, int b ){
        long sum1 = ((long)a * (long)(a - 1))/2;
        long sum2 = ((long)b * (long)(b + 1))/2;
        int numelement = b - a + 1;
        
        return sum2 - sum1 - (numelement - 1);
    }
    

    
}
