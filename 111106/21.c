#include <stdio.h>
#include <stdlib.h>
#define MAXL 100
static int n, carlength, carlengthsum, max, dynamic[MAXL * 100 + 1][2];
static int from[MAXL * 2 + 1][MAXL * 100 + 1][2], top, stack[MAXL * 2];
void solve(int carnum) {
	int i;
	for (i = n; i >= carlength; i--) {
		if (dynamic[i - carlength][0] != -1 &&
			carlengthsum - i + carlength <= n && dynamic[i][0] < carnum) {
			dynamic[i][0] = carnum;
			dynamic[i][1] = carlengthsum - i + carlength;
			from[carnum][i][0] = dynamic[i - carlength][0];
			from[carnum][i][1] = carlength;
			if (dynamic[max][0] < dynamic[i][0] || (dynamic[max][0] == dynamic[i][0] &&
				abs(max - dynamic[max][1]) > abs(i - dynamic[i][1])))
				max = i;
		}
	}
}
void output(int t)
{
	int i, j, k;
	k = top = 0;
	for (i = dynamic[max][0], j = max; i > 0;
		j -= from[i][k][1], i = from[i][k][0]) {
		stack[top++] = 1;
		for (k = i - 1; k > from[i][j][0]; k--)
			stack[top++] = 0;
		k = j;
	}
	if (t > 0)
		printf("\n");
	printf("%d\n", dynamic[max][0]);
}
void main()
{
	int i, j, t;
	scanf("%d", &t);
	for (i = 0; i < t; i++)
	{
		scanf("%d", &n);
		n *= 100;
		for (j = 0; j <= n; j++)
		{
			dynamic[j][0] = -1;
			dynamic[j][1] = 0;
		}
		dynamic[0][0] = 0;
		carlengthsum = 0;
		max = 0;
		for (j = 0; scanf("%d", &carlength),
			carlength != 0; j++)
		{
			if (carlengthsum <= 2 * n)
			{
				solve(j + 1);
				carlengthsum += carlength;
			}
		}
		output(i);
	}
}