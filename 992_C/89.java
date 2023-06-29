import java.util.*;
public class algo93
{
    public static void main(String args[])
    {
        Scanner ex=new Scanner(System.in);
        long x=ex.nextLong();
        long k=ex.nextLong();
        long mod=1000000007;
        if(k==0)
        System.out.println((2*x)%mod);
        else if(x==0)
        System.out.println("0");
        else
        {
            long pow=power(2,k);
            long pow1=(2*pow)%mod;
            long ans=(pow1*(x%mod))-pow+1;
            if(ans<0)
            ans=ans+mod;
            ans=ans%mod;
            System.out.println(ans);
        }
    }
    public static long power(long x,long y)
    {
        if (y == 0)
        return 1;
        long mod=1000000007;
        long pow=power(x,y/2);
        pow=(pow*pow)%mod;
        if(y%2==0)
        return pow;
        else
        return ((x%mod)*pow)%mod;
    }
}