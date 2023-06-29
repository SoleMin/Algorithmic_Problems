import java.io.*;
import java.util.*;
import java.math.*;

public class Main
{
    public static void main(String args[])
    {
       Scanner scan=new Scanner(System.in);
       int n=scan.nextInt();
       System.out.println((n%4==0||n%7==0||n%47==0||n%74==0||n%447==0||n%474==0||n%477==0||n%744==0||n%747==0||n%774==0)?"YES":"NO");
    }
}