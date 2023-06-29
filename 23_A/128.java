import java.util.*;
public class P023A {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String line = in.next();
        
        HashSet<String> hash = new HashSet<String>();
        
        int ans = 0;
        for (int len = line.length()-1; len > 0; --len)
        {
            for (int i = 0; i + len <= line.length(); ++i)
            {
                String sub = line.substring(i, i+len);
                if (hash.contains(sub))
                {
                    ans = Math.max(ans, sub.length());
                }
                
                hash.add(sub);
            }
        }
        
        System.out.println(ans);
    }
}
