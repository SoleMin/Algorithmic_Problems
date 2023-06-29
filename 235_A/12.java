import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        long num=in.nextLong();
        long lcm=1;
        if(num==2){
            System.out.println(2);
            System.exit(0);
        }//End if
        else if(num%2==0&&num%3!=0)
            lcm=(num)*(num-1)*(num-3);
        else if(num%2==0&&num%3==0)
            lcm=(num-1)*(num-2)*(num-3);
        else if(num%2!=0&&num>2)
            lcm=num*(num-1)*(num-2);
        System.out.println(lcm);
    }//End main()
}//End class
