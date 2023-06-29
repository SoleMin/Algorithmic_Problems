import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        long r,l;
          r = sc.nextLong();
          l = sc.nextLong();


            if ((r+2)>l) { System.out.print("-1"); return;}
            if ((r % 2) == 0)   {
              System.out.print(r);
                System.out.print(" ");
                System.out.print(r+1);
                System.out.print(" ");
                System.out.print(r+2);return; }
               if((r+3)<=l )
                {  System.out.print(r+1);
                System.out.print(" ");
                  System.out.print(r+2);
                System.out.print(" ");
                  System.out.print(r+3);return; }
             System.out.print("-1");


    }
}
