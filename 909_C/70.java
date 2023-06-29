import java.util.*;

public class GFG {
    static int count=0;
    
	public static void main (String[] args) {
		Scanner ob=new Scanner(System.in);
		int n;
		long MOD=(long)(1e9+7);
		int f=0,s=0;
		n=ob.nextInt();
		long dp[][]=new long[n+2][n+2];
		dp[0][1]=1;
		char ch='s';
		char p;
		for(int i=1;i<=n;i++)
		{
		    p=ch;
		    ch=ob.next().charAt(0);
		    if(p=='f')
		    {
		        for(int j=1;j<=n;j++)
		        dp[i][j+1]=dp[i-1][j];
		    }
		    else
		    {
		        for(int j=n;j>0;j--)
		        {
		            dp[i][j]=(dp[i][j+1]+dp[i-1][j])%MOD;
		        }
		    }
		}
		
		long ans=0;
		
		for(int i=1;i<=n;i++)
		{
		    ans=(ans+dp[n][i])%MOD;
		}
		System.out.println(ans);
	}
}