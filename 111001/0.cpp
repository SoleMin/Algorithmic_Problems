#include <cstdio>
#include <cmath>
#include <cstring>
double xy[101][2];
double dist[101];
bool check[101];

double caldist(int a, int b)
{
	double result;
	result = sqrt(pow(xy[a][0] - xy[b][0], 2) + pow(xy[a][1] - xy[b][1], 2));
	return result;
}

void cal(int n)
{
	int i, j, cnt, before;
	double min, result, tmp;
	memset(check, 0, sizeof(check));

	cnt = 1;
	result = 0;
	check[0] = true;
	before = 0;

	for (i = 0; i <= 100; i++)
		dist[i] = 999999999;

	for (i = 1; i < n; i++)
	{	
		for (j = 0; j < n; j++) {
			if (check[j] || j == before)
				continue;
			tmp = caldist(before, j);
			if (tmp < dist[j])
				dist[j] = tmp;
		}
		check[before] = true;
		min = 999999999;

		for (j = 1; j < n; j++) {
			if (dist[j] < min && check[j] == false) {
				min = dist[j];
				before = j;
			}
		}
		result += min;
	}
	printf("%.2f\n\n", result);
}

int main()
{
	int T, t, n, i;

	scanf("%d", &T);
	while (T--)
	{
		scanf("%d", &n);
		for (i = 0; i < n; i++) {
			scanf("%lf %lf", &xy[i][0], &xy[i][1]);
		}

		cal(n);
	}
}