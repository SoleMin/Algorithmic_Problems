import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        //inputs
        long n = in.nextLong();
        if(n == 1)
            System.out.println(1);
        else if(n == 2)
            System.out.println(2);
            
        else if(n % 2 == 0){
            
            int cnt = nPrime(n);
            if(cnt == 1)
            System.out.println((n) * (n-1) * (n-3));
        else if(cnt > 1)
            System.out.println((n-1) * (n-2) * (n-3));
        }
        
        else
            System.out.println((n) * (n-1) * (n-2));
      }
    
    public static int nPrime(long n){
        int cnt=1;
        if(n % 3 == 0)
            cnt++;
        return cnt;
    }
    }
