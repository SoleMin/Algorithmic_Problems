import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt(), k = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++)
        data[i] = input.nextInt();
    Arrays.sort(data);
    m -= k;
    int at = n-1;
    int count = 0;
    while(at>=0 && m>0)
    {
        count++;
        m++;
        m -= data[at];
        at--;
    }
    if(m>0)
        System.out.println(-1);
    else
        System.out.println(count);
}
}
