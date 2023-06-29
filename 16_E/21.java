import java.util.*;
public class Main {
public static void main(String [] args){
	Scanner in=new Scanner(System.in);
	int n=in.nextInt();
	double value[][]=new double[n][n];
	for(int i=0;i<n;i++)
		for(int j=0;j<n;j++)value[i][j]=in.nextDouble();
		double ans[]=new double[1<<n];
		int mask=(1<<n);
		ans[(1<<n)-1]=1.0;
		for(int i=mask-1;i>=0;i--){
		int cnt=Integer.bitCount(i);
		int pairs=cnt*(cnt-1)/2;
		for(int j=0;j<n;j++){
		if(((i>>j)&1)==0)continue;
		for(int k=j+1;k<n;k++){
		if(((i>>k)&1)==0)continue;
		ans[i^(1<<k)]+=ans[i]*value[j][k]/pairs;
		ans[i^(1<<j)]+=ans[i]*value[k][j]/pairs;
		}
		}
		}
		for(int i=0;i<n;i++)
			System.out.print(ans[1<<i]+" ");
		
}
}
    