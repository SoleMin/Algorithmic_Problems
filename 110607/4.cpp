#include <stdio.h>

int arr[10000000] = { 0, 1, };


int main()
{
	int n, sum, i, result;

	scanf("%d", &n);
	while (n != 0)
	{
		sum = 1;
		i = result = 2;
		while (i < n && sum < n)
		{
			arr[i] = 1 + arr[i - arr[arr[i-1]]];
			sum += arr[i];
			result = i;
			i++;
		}
		if (n == 1)
			printf("1\m");
		else
			printf("%d\n", result);

		scanf("%d", &n);
	}
}