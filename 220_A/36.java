import java.util.Arrays;
import java.util.Scanner;

public class test1
{

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[]=new int[n];
        int b[]=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=in.nextInt();
            b[i]=a[i];
        }
        Arrays.sort(b);
        int count=0;
        for(int i=0;i<n;i++)
            if(a[i]!=b[i])
                count++;
        if(count<=2)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
    
 
}