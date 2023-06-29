#include <stdio.h>
#include <stdlib.h>
#define MAX 5001
#define MIN(a, b) (((a) < (b)) ? (a) : (b))

int stick[1001][MAX];
int st_len[MAX];

int k,n;
int dp(int x,int y)
{
	int a,b;

	if(stick[x][y] != -1)
		return stick[x][y];
	if(x==0)
		return 0;
	if(n<=y)
		return 1000000001;
	if(n-y<3*x)
		return 1000000000;
	
	a = (st_len[y] - st_len[y+1]);
	a *= a;
	a += dp(x-1,y+2);
	b = dp(x,y+1);
	if(a<b)
		stick[x][y] = a;
	else
		stick[x][y] = b;
	
	return stick[x][y];
}



int main() {
	char input[100];
	int cases;
	int result;
	scanf("%d", &cases);
	while(cases--)
	{
		scanf("%d %d",&k,&n);
		for(int i=0;i<n;i++)
			scanf("%d",st_len+i);
		k+=8;
		for(int i=0;i<=k+1;i++)
			for(int j=0;j<=n+1;j++)
				stick[i][j] = -1;
		result = dp(k,0);
		printf("%d\n",result);
	}
	
	return 0;
}
