import java.util.Arrays;
import java.util.Scanner;

public class Twins {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] val = new int[n];
        for (int i=0; i<n; i++)
            val[i] = in.nextInt();
        Arrays.sort(val);
        int sum = 0, count = 0;
        for (int i=n-1; i>=0; i--)  {
            count++;
            sum += val[i];
            int his = 0;
            for (int j=0; j<i; j++) his += val[j];
            if (his < sum)  break;
        }
        System.out.println(count);
    }
}
