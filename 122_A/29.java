import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int in = sc.nextInt();
        if(
                in%4==0||
                in%7==0||
                in%44==0||
                in%47==0||
                in%74==0||
                in%77==0||
                in%444==0||
                in%447==0||
                in%474==0||
                in%477==0||
                in%744==0||
                in%747==0||
                in%774==0||
                in%777==0
                
        )
            System.out.println("YES");
        else System.out.println("NO");

    }

}
