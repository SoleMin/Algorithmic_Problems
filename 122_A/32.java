import java.util.Scanner;

public class HelloWorld
{
    public static void main (String args [])
    {
        Scanner read = new Scanner(System.in);
        int n = read.nextInt();
        int n1 = n; boolean q = true;
        while (n1 > 0)
        {
            if (n % n1 == 0)
            {
                if (check(n1))
                {
                    System.out.print("YES");
                    q = false;
                    break;
                }   
            }
            n1--;
        }
        if (q) System.out.print("NO");
        
    }
    public static boolean check (int n)
    {
        int n1 = n;
        while (n1 != 0)
        {
            if (n1 % 10 != 4 && n1 % 10 != 7) return false;
            n1 /= 10;
        }
        return true;
    }

}

