
import java.util.*;
public class init {
static class p{
	int i;
	int c;
	public p(int i,int c) {
		this.i=i;this.c=c;
		// TODO Auto-generated constructor stub
	}
}
static int mod=1000000007;
	public static void main(String[] args) {
	
		// TODO Auto-generated method stub
Scanner s=new Scanner(System.in);
int n=s.nextInt();
int a[]=new int[n];
for(int i=0;i<n;i++) {
	char c=s.next().charAt(0);
	if(c=='f')
		a[i]=1;
		
}
int dp[][]=new int[n+1][n+1];
for(int i=0;i<=n;i++) {
	for(int j=0;j<=n;j++)
		dp[i][j]=-1;
}
System.out.println(ans(dp,1,0,a,n));
	}
	public static int ans(int dp[][],int i,int j,int a[],int n) {
		if(i==n) {
			
			return 1;
		}
		if(dp[i][j]!=-1) {
			return dp[i][j];
		}
		if(a[i-1]==1) {
			int x=ans(dp,i+1,j+1,a,n);
			if(x!=-1)
				dp[i][j]=x%mod;
		}
		else {
			int x=-1;
			if(j!=0)
			x=ans(dp,i,j-1,a,n);
			int y=ans(dp,i+1,j,a,n);
			if(x!=-1)
				dp[i][j]=x%mod;
			if(y!=-1) {
				if(dp[i][j]==-1)
					dp[i][j]=y%mod;
				else
				dp[i][j]+=y%mod;}
		}
		return dp[i][j];
	}
}
