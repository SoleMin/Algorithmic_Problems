
import java.util.Scanner;


public class composite {

  
    public static void main(String[] args) {
        
        Scanner s=new Scanner(System.in);
        int a=s.nextInt();
      
          if(a%2==0)
          {
              a=a-4;
              System.out.println(4+" "+a);
          }
          else
          {
              a=a-9;
              System.out.println(9+" "+a);
          }
      
    
}
}