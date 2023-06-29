#include <stdio.h>
#define N 31
#define M 64

static int row1[N] = {0,1,1,3,3,5,5,7,7,9,9,11,11,13,13,15,15,17,17,19,19,21,21,23,23,25,25,27,27,29};
static int row2[N] = {0,0,2,2,4,4,6,6,8,8,10,10,12,12,14,14,16,16,18,18,20,20,22,22,24,24,26,26,28,28};
static long long b[N][M] = {0}, w[N][M] = {0};

int pre(){
	
	for(int i=0;i<N;++i)
	{
		b[i][0] = 1;
		w[i][0] = 1;
	}
	for(int i=1;i<N;++i)
		for(int j=1;j<M;++j)
		{
			b[i][j] = b[i-1][j] + b[i-1][j-1] * (row1[i]-(j-1));
			if(i>1)
				w[i][j] = w[i-1][j] + w[i-1][j-1] * (row2[i]-(j-1));
		}
	return 0;
}
int main() {
	int n,k;
	long long result=0;
	// n x n 체스판 k 비숍 개수
	pre();
	while(scanf("%d %d",&n,&k))
	{
		result =0;
		if(n==0 && k==0)
			break;
		if(k==0 || n==1) {
			printf("1\n");
			continue;
		}
		for(int i=0;i<=k;++i)
			result += (b[n][i] * w[n][k-i]);
		
		printf("%lld\n",result);
		
	}
}
