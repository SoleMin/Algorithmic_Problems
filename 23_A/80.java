import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
        new Solution().calc();
    }

    void calc()
    {
        Scanner cin = new Scanner(System.in);
        String s = cin.next();
        int ret = 0;
        for (int i = 0; i < s.length(); i++)
        {
            for (int j = i + 1; j < s.length(); j++)
            {
                for (int k = 0; j + k < s.length(); k++)
                {
                    if (s.charAt(i + k) != s.charAt(j + k)) break;
                    ret = Math.max(k + 1, ret);
                }
            }
        }
        System.out.println(ret);
    }
}
