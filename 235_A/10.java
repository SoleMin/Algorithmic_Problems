import java.util.Scanner;

public class A235 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        if (n == 1) {
            System.out.println(1);
            return;
        } else if (n == 2) {
            System.out.println(2);
            return;
        } else if (n == 3) {
            System.out.println(6);
            return;
        }

        if (n % 2 == 0) {
            if(n % 3 == 0) 
                System.out.println((n - 1) * (n - 2) * (n - 3));
            else
                System.out.println((n - 1) * n * (n - 3));
        } else {
            System.out.println(n * (n - 1) * (n - 2));
        }
    }
}
