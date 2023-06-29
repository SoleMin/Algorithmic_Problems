/* package codechef; // don't place package name! */

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[m];
        int max = m/n;
        for (int i = 0; i < m; i++) {
            a[i] = sc.nextInt();
        }
        if (n > m)
        {
            System.out.println(0);
            return;
        }
        Map<Integer, Long> map = Arrays.stream(a)
                                    .boxed().collect(Collectors.groupingBy(Function.identity(),
                                    Collectors.counting()));
        int ans = 0;
        while (max > 0) {
            ans = 0;
            for (Map.Entry<Integer, Long> entry : map.entrySet()) {
                ans += entry.getValue()/max;
            }
            if (ans >= n) {
                break;
            }
            max--;
        }
        System.out.println(max);
	}
}

     			   			 	 	 					 					