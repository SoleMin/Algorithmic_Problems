#include <stdio.h>
#include <math.h>

int dp[1001][5001];
int check[5001];
int min(int a, int b){
	if(a<b)
		return a;
	else
		return b;
}
int DP(int s, int c) {
	if(dp[s][c] != 1000 && dp[s][c] != 987654321 /*&& /*dp[s][c] != 0*/)
		return dp[s][c];
	if(c < 3*s) { //젓가락이 손님들한테 줘야되는 양보다 적으면
		dp[s][c] = 987654321;
	} 
	else if(s == 0) { // 손님이 없으면
		dp[s][c] = 0;
	} 
	else {
		dp[s][c] = min(DP(s, c-1), DP(s-1, c-2)+check[c]);
		
	}
	return dp[s][c];
}

int main() {
	int num;
	int sn;
	int chop;
	int N[5001];
	//int dp[1001][5001];
	//int check[5001];
	int i,j;
	scanf("%d", &num);
	while(num!=0){
		scanf("%d %d", &sn, &chop);
		sn = sn+8; // 손님수에서 8명 추가
		for(i=chop;i>0;i--){
			scanf("%d",&N[i]);
		}
		/*for(i=0;i<chop;i++){
			printf("%d ",N[i]);
		}*/
		
		for(i=2;i<=chop;i++){
			check[i] = pow(N[i]-N[i-1],2); // (A-B)2
			//printf("%d ", check[i]);
		}
		//printf("\n");
		for(i=0;i<=sn;i++){
			for(j=0;j<=chop;j++){
				dp[i][j] = 1000;
			}
		}
		
		/*for(i=0;i<=sn;i++){
			for(j=0;j<=chop;j++){
				if(dp[i][j] != 1000){
					printf("%d ", dp[sn][chop]);
					break;
				}
			}
		}*/
		//DP(sn,chop);
		int answer = DP(sn,chop);
		printf("%d\n", answer);
		num--;
	}
}
