import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
 
public class Main {
	static int n, exp;
	static double arr[][],dp[], dies[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = new Integer(br.readLine());
		arr = new double[n][n];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Double.parseDouble(st.nextToken());
			}
		}
		exp = 1<<n;
		dp = new double[exp];
		dies = new double[n][exp];
		for (int all = 0; all < exp; all++) {
			dp[all] = -1;
			int countAlive = 0;
			for (int i = 0; i < n; i++) {
				if((all&(1<<i))!=0)
					countAlive++;
			}
			if(countAlive <2)continue;
			double x=1.0/(countAlive*(countAlive-1)/2.0);
			for(int i=0; i<n; i++){
				dies[i][all]=0;
				int mask=1<<i;
				if((mask&all)>0){
					for(int j=0; j<n; j++)
					{
						int mask2=1<<j;
						if((mask2&all)>0)
							dies[i][all]+=arr[j][i];
					}
					dies[i][all]*=x;
				}
			}
		}
		for(int myFish=0; myFish<n; myFish++){
			if(myFish>0)System.out.printf(" ");
			System.out.printf("%.6f",ff(1<<myFish));
		}
		System.out.println();	
 
	}
	static double ff(int state){
		if(state==exp-1)return 1;
		if(dp[state]!=-1)return dp[state];
		double ans=0;
		for(int i=0; i<n; i++)
		{
			int mask=1<<i;
			if((mask &state)==0)
			{
				ans+=dies[i][state+mask]*ff(state+mask);
			}
		}
		return dp[state]=ans;
	}
 
}