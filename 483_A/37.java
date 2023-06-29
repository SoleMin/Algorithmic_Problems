import java.util.*;

public class Counterexample483A
{
    public static void main(String[] args) 
    {
        // Set up scanner
        Scanner sc = new Scanner(System.in); 
        // System.out.println("Enter l");
        long l = sc.nextLong();
        // System.out.println("Enter r");
        long r = sc.nextLong();
        
        if (l==r || l+1 == r)
        {
            System.out.println(-1);
            return;
        }
        if (l+2 == r && l%2 == 1)
        {
            System.out.println(-1);
            return;
        }
        if (l%2 == 0)
        {
            System.out.println(l + " " + (l+1) + " " + (l+2));
            return;
        }
        System.out.println((l+1) + " " + (l+2) + " " + (l+3));
    }
}
            
            
        
        