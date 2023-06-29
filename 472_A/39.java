import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        
        int a = n/2;
        int b = (n/2) + (n%2);
        
        if ((a%2!=0 && a%3!=0) || (b%2!=0 && b%3!=0)) {
            a--;
            b++;
        }
        
        if ((a%2!=0 && a%3!=0) || (b%2!=0 && b%3!=0)) {
            a--;
            b++;
        }

        System.out.println(a + " " + b);
    }
}