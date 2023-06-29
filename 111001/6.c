#include <stdio.h>
#include <math.h>
#define MAXN 100
#define Inf 999999
static int n, check[MAXN];
static double dot[MAXN][2], minval[MAXN], result;

void input(void) 
{
	int i;
	scanf("%d", &n);
	for (i = 0; i < n; i++) 
	{
		scanf("%lf %lf", &dot[i][0], &dot[i][1]);
	}
}
double dist(int a, int b) 
{
	return sqrt(pow(dot[a][0] - dot[b][0], 2) + pow(dot[a][1] - dot[b][1], 2)); //피타고라스의 정리 a제곱 + b제곱 = c제곱
}

void solve(void) 
{
	int i, j, a;
	result = 0;

	for (i = 1; i < n; i++) 
	{
		minval[i] = dist(0, i); //0번째 노드를 기준으로 최소거리를 먼저 측정함.
	}
	for (i = 0; i < n - 1; i++) 
	{
		int min = Inf;
		for(j=1; j<n; j++)
		{
			if(0 <= minval[j]  &&  minval[j] < min)
			{
				min = minval[j];
				a = j;
			}
		}
		result = result + minval[a];
		minval[a] = -1;
		for(j=1; j<n; j++)
		{
			if(dist(j,a) < minval[j]) //새로포함한 정점을포함하여 , 최소거리를다시 측정함.
			{
				minval[j] = dist(j,a);
			}
		}
	}
}

void main(void)
{
	int i, t;
	scanf("%d", &t);
	for (i = 0; i < t; i++)
	{
		input();
		solve();
		/*if (i > 0)
			printf("\n");*/
		printf("%0.2lf\n\n", result);
	}
}