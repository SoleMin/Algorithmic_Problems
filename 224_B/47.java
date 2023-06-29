import java.util.*;
public class b {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), k = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++)
        data[i] = input.nextInt();
    int[] freq = new int[100001];
    int count = 0;
    for(int i = 0; i<n; i++)
    {
        if(freq[data[i]] == 0)
            count++;
        freq[data[i]]++;
    }
    if(count<k)
        System.out.println("-1 -1");
    
    else
    {
        int start = 0;
        for(int i = 0; i<n; i++)
        {
            //System.out.println(i + " " + count + " " + freq[data[i]]);
            if(count > k)
            {
                freq[data[i]]--;
                if(freq[data[i]] == 0)
                    count--;
            }
            else
            {
                if(freq[data[i]] > 1)
                {
                    freq[data[i]]--;
                }
                else
                {
                    start = i;
                    break;
                }
            }
        }
        int end = n-1;
        for(int i = n-1; i>=0; i--)
        {
            if(freq[data[i]] == 1)
            {
                end = i;
                break;
            }
            else
                freq[data[i]]--;

        }
        start++;
        end++;
        if(start<= end)
        System.out.println(start + " " + end);
        else
            System.out.println(-1 + " " + -1);
    }
}
}
