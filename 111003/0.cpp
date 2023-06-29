#include <cstdio>
#include <cstring>
int fire[100];
int W[501][501];
int dist[501][501];
int firedist[501];
int newdist[501];

void kruscal(int n)
{
	int i, j, k;

	for (i = 0; i <= n; i++)
		for (j = 0; j <= n; j++)
			dist[i][j] = W[i][j];

	for (k = 1; k <= n; k++)
	{
		for (i = 1; i <= n; i++)
		{
			for (j = 1; j <= n; j++)
			{
				if (dist[i][k] + dist[k][j] < dist[i][j]) {
					dist[i][j] = dist[i][k] + dist[k][j];
				}
			}
		}
	}
}

void cal(int F, int I)
{
	int i, j, fireindex, maxdist, tmp, result, finalfire;
	for (i = 0; i <= 500; i++)
		firedist[i] = 99999999;

	kruscal(I);

	for (i = 0; i < F; i++)
	{
		fireindex = fire[i];
		for (j = 1; j <= I; j++)
		{
			if (dist[j][fireindex] < firedist[j])
				firedist[j] = dist[j][fireindex];
		}
	}

	result = 99999999;

	for (i = 1; i <= I; i++)
	{// i => 소방서가 세워질 위치
		maxdist = 0;
		for (j = 1; j <= I; j++)
		{
			tmp = (firedist[j] < dist[i][j]) ? firedist[j] : dist[i][j];

			if (maxdist < tmp)
				maxdist = tmp;
		}
		if (maxdist < result) {
			result = maxdist;
			finalfire = i;
		}
	}
	printf("%d\n\n", finalfire);
}

int main()
{
	int T, I, n, F, j, a, b, c;

	scanf("%d", &T);

	while (T--)
	{
		memset(fire, 0, sizeof(fire));
		for (a = 0; a <= 500; a++)
			for (b = 0; b <= 500; b++)
				W[a][b] = dist[a][b] = 999999;

		scanf("%d %d", &F, &I);
		for (j = 0; j < F; j++) {
			scanf("%d", &a);
			fire[j] = a;
		}
		for (j = 0; j < I; j++) {
			scanf("%d %d %d", &a, &b, &c);
			W[a][b] = c;
			W[b][a] = c;
		}
		for (j = 1; j <= I; j++) {
			W[j][j] = 0;
		}
		//------------------------입력 완료

		cal(F, I);

	}
}