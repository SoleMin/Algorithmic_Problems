#include <stdio.h>
#include <math.h>

#define MAXN 100
#define MAXV 1000000
static int n, check[MAXN];
static double dot[MAXN][2], minval[MAXN], result;

void input()
{
	int i;
	
	scanf("%d", &n);
	for (i = 0; i < n; i++)
		scanf("%lf %lf", &dot[i][0], &dot[i][1]);
}

double dist(int a, int b)
{
	return sqrt(pow(dot[a][0] - dot[b][0], 2) + pow(dot[a][1] - dot[b][1], 2));
}

void solve()
{
	int i, j, a;
	result = 0;
	for (i = 0; i < n; i++)
		check[i] = 0;

	check[0] = 1;

	for (i = 0; i < n; i++)
		minval[i] = dist(0, i);

	for (i = 0; i < n; i++)
	{
		double min = MAXV;
		int index = 0;
		for (j = 0; j < n; j++)
		{
			if (check[j] == 1)
				continue;
			if (min > minval[j])
			{
				index = j;
				min = minval[j];
			}
		}
		check[index] = 1;


		for (j = 0; j < n; j++)
		{
			if (check[j] == 1)
				continue;
			if (minval[j] > dist(index, j))
				minval[j] = dist(index, j);
		}
	}

	for (i = 0; i < n; i++)
		result += minval[i];
}

int main(void)
{
	int i, t;
	scanf("%d", &t);
	for (i = 0; i < t; i++)
	{
		input();
		solve();
		if (i > 0)
			printf("\n");
		printf("%0.2lf\n", result);
	}
}