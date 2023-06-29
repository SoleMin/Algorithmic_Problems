import java.io.*;

public class IQTest
{
    public static void main(String[] args)
    {
        try
        {
            BufferedReader in = new BufferedReader(
                new InputStreamReader(System.in));
            String str = in.readLine();
            int n = Integer.parseInt(str);
            int odd = -1, even = -1, odds = 0, evens = 0;
            //while (n-- > 0)
            //{
                str = in.readLine();
                String[] numbers = str.split(" ");
                int index = 1;
                for (String number: numbers)
                {
                    int i = Integer.parseInt(number);
                    if (i % 2 == 0)
                    {
                        ++evens;
                        if (even == -1)
                            even = index;
                    }
                    else
                    {
                        ++odds;
                        if (odd == -1)
                            odd = index;
                    }
                    ++index;
                }
            //}
            
            System.out.println((evens > odds ? odd : even));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}