//package global14;

import java.util.Scanner;

public class B {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        while(t > 0){
            t --;
            int n = in.nextInt();
            if(n % 2 != 0){
                System.out.println("NO");
                continue;
            }
            int a = n / 2;
            int x = (int)Math.sqrt(a);
            if(x * x == a || (x + 1) * (x + 1) == a){
                System.out.println("YES");
                continue;
            }
            a = n / 4;
            if(n % 4 != 0){
                System.out.println("NO");
                continue;
            }
            x = (int)Math.sqrt(a);
            if(x * x == a || (x + 1) * (x + 1) == a){
                System.out.println("YES");
                continue;
            }
            System.out.println("NO");



        }


    }
}
