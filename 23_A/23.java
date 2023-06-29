import java.util.Scanner;

/**
 * @author Alexander Grigoryev
 *         Created on 01.08.11
 */
public
class Main
{
    static Scanner in = new Scanner(System.in);

    public static
    void main(String[] args)
    {
        String s = in.nextLine();
        int k, ans = 0;

        for(int i = 0; i < s.length(); i++)
            for(int j = i + 1; j < s.length(); j++)
            {
                for(k = 0; j + k < s.length(); k++)
                {
                    if(s.charAt(i + k) != s.charAt(j + k)) break;
                }
                if(ans < k) ans = k;
            }
        System.out.println(ans);
    }
}