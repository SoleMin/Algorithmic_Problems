import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    static final double eps=1e-10;
    public static void main(String[] args) throws FileNotFoundException
    {
        new Main().solve();
    }
    public void solve() throws FileNotFoundException
    {
        Scanner cin=new Scanner(System.in);
        int n;
        n=cin.nextInt();
        String s;
        s=cin.next();
        int ans=Integer.MAX_VALUE;
        int h=0,t=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='H')
                h++;
            else if(s.charAt(i)=='T')
                t++;
        }
        ans=Math.min(ans,fun(s,'H',h));
        ans=Math.min(ans,fun(s,'T',t));
        System.out.println(ans);
    }
    public int fun(String s,char c,int num)
    {
        int ans=Integer.MAX_VALUE;
        int ret=num;
        for(int i=0;i<num;i++)
        {
            if(s.charAt(i)==c)
            {
                ret--;
            }
        }
        ans=ret;
        for(int i=0;i+num<s.length();i++)
        {
            if(s.charAt(i)!=c)
                ret--;
            if(s.charAt(i+num)!=c)
            {
                ret++;
            }
            ans=Math.min(ans, ret);
        }
        return ans;
    }
}
