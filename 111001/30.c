#include <stdio.h>
#include <math.h>
#define _CRT_SECURE_NO_WARNINGS
#define MAXN 100
static int n, check[MAXN];
static double dot[MAXN][2], result;
void input(void) {
	int i;
	scanf("%d", &n);
	for (i = 0; i < n; i++) {
		scanf("%lf %lf", &dot[i][0], &dot[i][1]);
	}
}
double dist(int a, int b) {
	return sqrt(pow(dot[a][0] - dot[b][0], 2) +
		pow(dot[a][1] - dot[b][1], 2));
}
void solve(void) {
	int i, j, a, mina = 0, minj = 0;double min = 100000000.0;
	result = 0;
	for (i = 0; i < n; i++) {
		check[i] = 0;
	}
	check[0] = 1;

	for (i = 0; i < n - 1; i++) {//전체 엣지의 갯수?
		min = 1000000000;
		for (j = 0; j < n; j++) {
			if (check[j] == 0) continue;
			for (a = 0; a < n; a++) {
				if (check[a] == 1 || a == j)continue;
				if (min > dist(j, a)) {
					min = dist(j,a);
					minj = j;
					mina = a;
				}
			}
		}
		check[mina] = 1;
		result += min;
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
		if (i > 0)
			printf("\n");
		printf("%0.2lf\n", result);
	}
}