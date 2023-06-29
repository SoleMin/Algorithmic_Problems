import java.util.Scanner;
public class Solution {
    public static void main(String [] args){
        Scanner stdin = new Scanner(System.in);
        long n = stdin.nextLong();
        if(n<3)	System.out.println(n);
        else {
            if(n%2==0){
                long a=0,b=0;
                if(n%3!=0)	a = (n*(n-1)*(n-3));    
                n--;
                b = (n*(n-1)*(n-2));
                System.out.println(Math.max(a, b));
            }
            else	System.out.println(n*(n-1)*(n-2));
        }
    }
}
 	 	 			   	 		 	 	 	 	 		