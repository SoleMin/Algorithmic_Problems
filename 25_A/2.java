import java.util.*;

public class A
{
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();   
        
        int odd = -1;
        int even = -1;
        int oc = 0;
        int ec = 0;
        
        for(int i=0;i < n;i++)
        {
            if(scan.nextInt() % 2 == 0)
            {
                ec++;
                even = i+1;
            }
            else
            {
                oc++;
                odd = i+1;
            }
        }
        
        if(ec == 1)
            System.out.println(even);
        else
            System.out.println(odd);
    }
}
