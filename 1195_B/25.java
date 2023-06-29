


import java.util.*;

public class Temppp {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long k = sc.nextLong();
       
        long ans = (long) ((java.lang.Math.sqrt((9+(8*(n+k))))-3)/2);
        System.out.println(n-ans);
        
    }
    
}
