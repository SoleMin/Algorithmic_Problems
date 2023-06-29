import java.util.*;

public class A
{
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        
        int n = scan.nextInt();
        
        int[] a = new int[n];
        
        for(int i=0;i < n;i++)
            a[i] = scan.nextInt();
            
        Arrays.sort(a);
        
        int min = a[0];
        
        for(int i=1;i < n;i++)
        {
            if(a[i] > min)
            {
                System.out.println(a[i]);
                return;
            }
        }
        
        System.out.println("NO");
    }
}
