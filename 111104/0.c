#include <stdio.h>

int min(int a, int b){
	if(a>b)
		return b;
	else
		return a;
}
int max(int a, int b){
	if(a>b)
		return a;
	else 
		return b;
}
int main() {
	int weight,health;
	int turtle[5607][2];
	int n=0;
	int i,j;
	int temp;
	int dp[5607];
	int ans;
	while(scanf("%d %d", &weight,&health)==2){
		n++;
		turtle[n][0] = weight;
		turtle[n][1] = health;
	}
	for(i=1;i<=n;i++){
		for(j=1;j<=n;j++){
			if(turtle[i][1]<turtle[j][1]){
				temp = turtle[i][1];
				turtle[i][1] = turtle[j][1];
				turtle[j][1] = temp;
				temp = turtle[i][0];
				turtle[i][0] = turtle[j][0];
				turtle[j][0] = temp;
			}
			else if(turtle[i][1] == turtle[j][1] && turtle[i][0]<turtle[j][0]){
				temp = turtle[i][1];
				turtle[i][1] = turtle[j][1];
				turtle[j][1] = temp;
				temp = turtle[i][0];
				turtle[i][0] = turtle[j][0];
				turtle[j][0] = temp;
			}
		}
	}
	for(i=0;i<=n;i++){
		dp[i]=987654321;
	}
	dp[0] = 0;
	ans = 1;
	for(i = 0;i<=n;i++){
		for(j=n;j>=0;j--){
			if(dp[j-1]+turtle[i][0]<=turtle[i][1]){
				dp[j] = min(dp[j],dp[j-1]+turtle[i][0]);
			}
			if(dp[j]<987654321)
				ans = max(j,ans);
		}
	}
	/*for(i=0;i<=n;i++){
		printf("%d %d\n", turtle[i][0],turtle[i][1]);
	}*/
	printf("%d\n", ans-1);
}
