import java.util.*;
public class c {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    long a = input.nextLong(), b = input.nextLong();
    System.out.println(gcd(a, b));
}
static long gcd(long a, long b)
{
    if(b==1) return a;
    if(a==1) return b;
    if(a>b) return a/b + gcd(b, a%b);
    return b/a + gcd(a, b%a);
}
}
