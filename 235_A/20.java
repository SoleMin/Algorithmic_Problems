import java.util.Scanner;
public class test5{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
            long x=in.nextLong();
            if(x>=3){
                if(x%2!=0)
                    System.out.println(x*(x-1)*(x-2));
                else if(x%3==0)
                    System.out.println((x-3)*(x-1)*(x-2));
                else 
                    System.out.println(x*(x-1)*(x-3));
            }
            else System.out.println(x);
    }
}