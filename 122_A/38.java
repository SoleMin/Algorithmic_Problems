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
        while(n!=0)
        {
            p=n%10;
            if(p!=4||p!=7)
           { if(t%7==0||t%4==0||t%47==0||t%74==0||t%447==0||t%477==0||t%474==0)
               System.out.print("YES");
               else System.out.print("NO");

            break;}
            else System.out.print("NO");
            
            n=(n/10);
            }
           


}
}