import java.util.Scanner;
public class LuckyDivison 
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int inp = in.nextInt();
        if(inp%4==0||inp%7==0||inp%47==0||inp%74==0||inp%447==0||inp%474==0||inp%477==0||inp%747==0||inp%774==0||inp%777==0)
        {
          System.out.println("YES");  
        }
        else System.out.println("NO");
          
        
    }
}
