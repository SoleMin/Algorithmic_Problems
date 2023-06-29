#include <stdio.h>
#include <math.h>

#define MAXK 100

static int n, check[MAXK];
static double dot [MAXK][2], minval [MAXK], result;

void input(void)
{
	int i;
	
	scanf("%d", &n);
	for(i=0; i < n; i++)
	{
		scanf("%lf %lf", &dot[i][0], &dot[i][1]);
	}
}

double dist(int a, int b)
{
	return sqrt(pow(dot[a][0] - dot[b][0], 2) + pow(dot[a][1] - dot[b][1], 2));
}
void solve(void)
{
	int i, j, a;
	
	result = 0;
	for(i=0; i<n; i++)
	{
		check[i] = 0;
	}
	
	check[0] = 1;
	for(i = 1; i < n; i++)
	{
		minval[i] = dist(0, i);
	}
	
	for(i = 0; i < n-1; i++ )
	{
		a= -1;
		for(j=0; j<n; j++)
		{
			if(check[j]) continue;
			
			if(a == -1 ||minval[a] > minval[j])
				a = j;
		}
		
		result += minval[a];
		check[a] = 1;
		
		for(j=0; j<n; j++)
		{
			if(check[j]) continue;
			
			if(minval[j] > dist(a, j))
				minval[j] = dist(a, j);
		}
	}
}

void main(void)
{
	int i, t;
	scanf("%d", &t);
	for(i=0; i<t; i++)
	{
		input();
		
		solve();
		
		if(i > 0)
			printf("\n");
		printf("%0.2lf\n", result);
	}
}