import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n,b = 0;
        n=in.nextInt();
        if (n%2==0) {
            b=n+n/2;
            System.out.println(b);
        }
    }
}

