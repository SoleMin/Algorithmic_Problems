import java.util.*;
public class Solution{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int pairs = in.nextInt();
        while (pairs > 0){
            in.nextLine();
            int a = in.nextInt();
            int b = in.nextInt();
            int count = 0;
            while (a != 0 && b != 0){
                if (b >= a && a != 0){
                    count += b/a;
                    b = b%a;
                }
                if (a > b && b != 0){
                    count += a/b;
                    a = a%b;
                }
            }
            System.out.println(count);
            pairs--;
        }
    }

}