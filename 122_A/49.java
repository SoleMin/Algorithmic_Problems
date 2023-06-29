import java.util.*;

public class MainClass {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[] = {4,7,47,74,447,474,477,744,747,774};
        int i=0, x = in.nextInt();
        while (i<arr.length)
        if (x%arr[i++] == 0)
        {
             System.out.print("YES");
             return;
        }
        System.out.print("NO");
    }
}
