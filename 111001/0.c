#include <stdio.h>
#include <math.h>
#define MAX 100

static int n, check[MAX];
static double dot[MAX][2], minval[MAX], result;

double dist(int a, int b) {
	return sqrt(pow(dot[a][0] - dot[b][0], 2) +
	pow(dot[a][1] - dot[b][1], 2));
}

void solve(void) {
	int i, j, a; 
	double tmp;
	result = 0;
	for (i = 0; i < n; i++) {
		check[i] = 0;
	}
	check[0] = 1;
	for (i = 1; i < n; i++) {
		minval[i] = dist(0, i);
	}
	for (i = 0; i < n-1; i++) {
		a = -1;
		tmp = 1000000.0;
		for(j = 0; j < n; j++)
		{
			if(minval[j] < tmp && check[j] == 0)
			{
				tmp = minval[j];
				a = j;
			}
		}
		
		if(a==-1) 
			break;

		result += tmp;
		check[a] = 1;
		for (j = 0; j < n; j++){
			if(minval[j] > dist(a, j) && check[j] == 0)
				minval[j] = dist(a, j);
		}
	}
}
int main() {
	int case_;
	scanf("%d",&case_);
	
	while(case_--)
	{
		scanf("%d",&n);
		for(int i=0;i<n;i++)
			scanf("%lf %lf",&dot[i][0],&dot[i][1]);
		solve();
		if (case_ >= 0)
			printf("\n");
		printf("%0.2lf\n", result);
	}
}
