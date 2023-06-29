import java.util.Scanner;
/**
 * Write a description of class lukno here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class lukno
{
    public static void main (String args[])
    {
        Scanner i= new Scanner(System.in);
        int n,p;
       
        n=i.nextInt(); int t=n;
       if(t%4==0||t%7==0||t%47==0||t%74==0||t%44==0||t%447==0||t%474==0||t%477==0)
               System.out.print("YES");
               else System.out.print("NO");

    
           


}
}
