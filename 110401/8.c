#include <stdio.h>
#include <stdlib.h>
#include <math.h>
int main()
{
	int T, t, i, j, r ,mid, dist;
	int arr[501];

	scanf("%d", &T);

	for (t = 0; t < T; t++)
	{
		scanf("%d", &r);
		dist = 0;
		for (i = 0; i < r; i++)
			scanf("%d", &arr[i]);
		mid = r / 2;

		for (i = 0; i < r; i++)
		{
			dist += abs(arr[i] - arr[mid]);

		}
		printf("%d\n", dist);
	}
}