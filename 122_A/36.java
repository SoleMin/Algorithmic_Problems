import java.util.*;
public class x
{
    public static void main(String args[])
    {
        Scanner obj=new Scanner(System.in);
        int n;
        String d="0";
        n=obj.nextInt();
        if(n%4==0 || n%7==0 || n%47==0 || n%74==0 || n%447==0 || n%474==0 || n%747==0)
        d="YES";
        else if(n%444==0 || n%477==0 || n%744==0 || n%774==0 || n%777==0)
        d="YES";
        else
        d="NO";
        System.out.print(d);
    }
}