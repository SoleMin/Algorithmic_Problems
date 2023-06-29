
import java.util.Scanner;


public class composite {

  
    public static void main(String[] args) {
        int b;
        Scanner s3=new Scanner(System.in);
         b=s3.nextInt();
      
          if(b%2==0)
          {
              b=b-4;
              System.out.println(4+" "+b);
          }
          else
          {
              b=b-9;
              System.out.println(9+" "+b);
          }
      
    
}
}