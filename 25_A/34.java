import java.util.Scanner;

/**
 *
 * @author Ronak
 */
public class Main {

    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner in=new Scanner(System.in);
         int n=in.nextInt();
         
        if(n>=3&&n<=100)
        {
        int num[]=new int[n];
        for(int i=0;i<n;i++)
        {
            num[i]=in.nextInt();
        }
        int even=0,odd=0,ceven=0,codd=0;
        for(int i=0;i<n;i++)
        {
            if(num[i]%2==0)
            {
                even++;
                ceven=i+1;
                
            }
            else
            {
                odd++;
                codd=i+1;
            }
        }
        if(odd==1)
        {
            System.out.println(""+codd);
        }
        else
        {
            System.out.println(""+ceven);
        }
        }
    }

}
