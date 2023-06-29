import java.util.*;
import java.lang.*;

public class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int numSupply = sc.nextInt();
        int dev = sc.nextInt();
        int socket = sc.nextInt();
        int[] sockInSu = new int[numSupply];
        for (int i = 0; i< sockInSu.length; i++) {
            sockInSu[i] = sc.nextInt();
        }
        
        Arrays.sort(sockInSu);
        
        if (socket >= dev) {
            System.out.println(0);
        }else {
            int count = 0;
            for (int i = sockInSu.length-1; i >= 0; i--) {
                socket+= sockInSu[i]-1;
                count++;
                if (socket >= dev) {
                    System.out.println(count);
                    break;
                }
            }
            if (socket < dev)
                System.out.println(-1);
        }
    }
}