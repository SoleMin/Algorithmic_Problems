import java.util.Scanner;

public class Main 
{   
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int one, two;
        if(n%2 == 0)
        {
            one = two = n/2;
            if(one%2 != 0 && two%2 != 0)
            {
                one--;
                two++;
            }
        }
        else
        {
            one = n - 9;
            two = 9;
        }
        
        System.out.println(one+" "+two);
        
    }
}
