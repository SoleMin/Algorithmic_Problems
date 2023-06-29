import java.util.*;

public class NewEmpty
{
    public static void main(String[] args)
    {
        Scanner blabla=new Scanner(System.in);
        long a,b,c=0,d;
        a=blabla.nextLong();
        b=blabla.nextLong();
        while (b!=0){
            c+=(a/b);
            a=a%b;
            d=a;
            a=b;
            b=d;
        }
        System.out.println(c);
    }
}