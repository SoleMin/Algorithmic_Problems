

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long n=sc.nextLong();
        long m=sc.nextLong();
        long fact=1;
        long k=0;
        for (int i = 1; i <=n ; i++) {
            fact*=2;
            if (fact>m){
                k=i;
                break;
            }
        }
        if (k==0){
            System.out.println(m%fact);
        }else{
            System.out.println(m);
        }
    }
}
