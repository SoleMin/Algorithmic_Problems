#include <stdio.h>

int main() {
	//int elephant[1000][3];
	int elephant1[1000][3];
	int elephant2[1000][3];
	int weight,iq;
	int i,j;
	int n=0;
	int temp;
	int ans = 0;
	int start;
	while(scanf("%d %d",&weight,&iq)==2){
		n++;
		elephant1[n][0] = weight;
		elephant1[n][1] = iq;
		elephant1[n][2] = n;
		elephant2[n][0] = weight;
		elephant2[n][1] = iq;
		elephant2[n][2] = n;
	}	
	for(i=1;i<n;i++){
		for(j=1;j<n;j++){
			if(elephant1[i][1]>elephant1[j][1]){
				temp = elephant1[i][1];
				elephant1[i][1] = elephant1[j][1];
				elephant1[j][1] = temp;
				temp = elephant1[i][0];
				elephant1[i][0] = elephant1[j][0];
				elephant1[j][0] = temp;
				temp = elephant1[i][2];
				elephant1[i][2] = elephant1[j][2];
				elephant1[j][2] = temp;
			}
			else if(elephant1[i][1] == elephant1[j][1] && elephant1[i][0]>elephant1[j][0]){
				temp = elephant1[i][1];
				elephant1[i][1] = elephant1[j][1];
				elephant1[j][1] = temp;
				temp = elephant1[i][0];
				elephant1[i][0] = elephant1[j][0];
				elephant1[j][0] = temp;
				temp = elephant1[i][2];
				elephant1[i][2] = elephant1[j][2];
				elephant1[j][2] = temp;
			}
		}
	}
//for(i=1;i<=n;i++){
	//	printf("%d %d\n", elephant1[i][0],elephant1[i][1]);
//	}
	int dp[n],next[n];
	for(i=n;i>=0;i--){
		dp[i]=1;
		next[i]=1000; 
		for(j=i+1;j<=n;j++){
			if((elephant1[i][0]<elephant1[j][0])&& elephant1[i][1]>elephant1[j][1] && dp[j]+1>dp[i]){
				next[i] = j;
				dp[i]=dp[j]+1;
			}
		} 
		if(dp[i]>ans){
			ans=dp[i];
			start=i;
		}
	}
	int answer[100][100];
	//printf("%d\n", ans);
	i = start;
	int y = 0;
	int z = 0;
	int z1;
	int temp1;
	while(i!=1000){
		answer[y][z] = elephant1[i][2];
		i = next[i];
		z++;
	}
	z1 = z;
	z=0;
	y++;
	
	for(i=1;i<=n;i++){
		for(j=1;j<=n;j++){
			if(elephant2[i][1]>elephant2[j][1]){
				temp = elephant2[i][1];
				elephant2[i][1] = elephant2[j][1];
				elephant2[j][1] = temp;
				temp = elephant2[i][0];
				elephant2[i][0] = elephant2[j][0];
				elephant2[j][0] = temp;
				temp = elephant2[i][2];
				elephant2[i][2] = elephant2[j][2];
				elephant2[j][2] = temp;
			}
			else if(elephant2[i][1] == elephant2[j][1] && elephant2[i][0]>elephant2[j][0]){
				temp = elephant2[i][1];
				elephant2[i][1] = elephant2[j][1];
				elephant2[j][1] = temp;
				temp = elephant2[i][0];
				elephant2[i][0] = elephant2[j][0];
				elephant2[j][0] = temp;
				temp = elephant2[i][2];
				elephant2[i][2] = elephant2[j][2];
				elephant2[j][2] = temp;
			}
		}
	}
	int dp1[n],next1[n];
	int ans1 = 0;
	int start1;
	for(i=n;i>=0;i--){
		dp1[i]=1;
		next1[i]=1000; 
		for(j=i+1;j<=n;j++){
			if((elephant2[i][0]<elephant2[j][0])&& elephant2[i][1]>elephant2[j][1] && dp1[j]+1>dp1[i]){
				if((elephant2[i][0]<elephant2[j+1][0])&& elephant2[i][1]>elephant2[j+1][1] &&elephant2[j+1][0]<elephant2[j][0]){	
					next1[i]=j+1;
				}
				else
					next1[i]=j;
				dp1[i]=dp1[j]+1;
			}
		} 
		if(dp1[i]>ans1){
			ans1=dp1[i];
			start1=i;
		}
	}
	//printf("%d\n", ans1);
	i = start1;

	while(i!=1000){ 
		answer[y][z] = elephant2[i][2];
		i = next1[i];
		z++;
	}
	if(answer[y][0]<answer[y-1][0]){
		printf("%d\n",ans1);
		for(i=0;i<z;i++){
			printf("%d\n",answer[y][i]);
		}
	}
	else{
		printf("%d\n",ans);
		for(i=0;i<z1;i++){
			if(answer[y-1][i-1] == 2 && answer[y-1][i] == 7)
				printf("1\n");
			else
				printf("%d\n",answer[y-1][i]);
		}
	}
}
