import java.util.Scanner;

public class N1_CF_199A {
    public static void main(String[] args) {
    int n = new Scanner(System.in).nextInt();
    if( n == 0)
    {
        System.out.println(0);
        System.out.println(0);
        System.out.println(0);
        return;
    }
    int i = 0 , j = 1;
    while(true)
    {
        int t = i + j;
        if( t == n)
        break;
        i = j;
        j = t;
    }
    System.out.println(i);
    System.out.println(j);
    System.out.println(0);
    }
}
