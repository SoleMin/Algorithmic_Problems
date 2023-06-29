import java.util.Scanner;
public class LuckyDivision{
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        if(a%4 == 0) System.out.println("YES");
        else if(a%7 == 0) System.out.println("YES");
        else if(a%47 == 0) System.out.println("YES");
        else if(a%74 == 0) System.out.println("YES");
        else if(a%447 == 0) System.out.println("YES");
        else if(a%474 == 0) System.out.println("YES");
        else if(a%477 == 0) System.out.println("YES");
        else if(a%747 == 0) System.out.println("YES");
        else if(a%774 == 0) System.out.println("YES");
        else System.out.println("NO");
    }
}