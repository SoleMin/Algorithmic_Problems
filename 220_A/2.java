import java.util.*;
import java.io.*;

public class P220A
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        List<Integer> b = new ArrayList<Integer>(n);
        for (int i = 0; i < n; i++)
        {
            a[i] = sc.nextInt();
            b.add(a[i]);
        }
        Collections.sort(b);
        int c = 0;
        for (int i = 0; i < n; i++)
        {
            if (a[i] != b.get(i)) c++;
        }
        if (c == 0 || c == 2)
        {
            System.out.println("YES");
        }
        else
        {
            System.out.println("NO");
        }
    }
}
