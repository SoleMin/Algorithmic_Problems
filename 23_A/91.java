import java.util.*;

public class A
{
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        
        String str = scan.next();
        
        for(int i=str.length();i >= 1;i--)
        {
            for(int j=0;j + i <= str.length();j++)
            {
                String sub = str.substring(j, j+i);
                
                int index = str.indexOf(sub, j+1);
                
                
                if(index > -1)
                {
                    System.out.println(i);
                    return;
                }
                
            }
        }
        
        System.out.println(0);
    }
}
