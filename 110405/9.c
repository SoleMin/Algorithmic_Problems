#include <stdio.h>
int result[1000];
double val[1000];
void swap(int arr[][2], int n, int b)
{
	int tmp;
	double dtmp;
	tmp = arr[n][0];
	arr[n][0] = arr[b][0];
	arr[b][0] = tmp;

	tmp = arr[n][1];
	arr[n][1] = arr[b][1];
	arr[b][1] = tmp;
}
int main()
{
	int t, T, i, j, n, min;
	int arr[1000][2];

	scanf("%d", &T);

	for (t = 0; t < T; t++)
	{
		scanf("%d", &n);

		for (i = 0; i < n; i++)
		{
			scanf("%d %d", &arr[i][0], &arr[i][1]);
		}

		for (i = 0; i < n; i++)
			result[i] = i;
		for (i = 0; i < n; i++)
			val[i] = arr[i][0] / (double)arr[i][1];
		min = 0;
		for (i = 0; i < n; i++)
		{
			for (j = 0; j < n; j++)
			{
				if (val[min] > val[j])
					min = j;
			}
			val[min] = 10000;
			result[i] = min;
			swap(arr, i, min);
		}

		for (i = 0; i < n; i++)
			printf("%d ", result[i] + 1);
		printf("\n\n");
	}
}