#include <stdio.h>
#define MAX_N 500

int main(void) {
	int cases, n;
	int add[MAX_N] = { 0, }, sum[MAX_N] = { 0, };
	int left, right, i, j, pivot, temp, count=0;

	scanf("%d", &cases);
	while (cases != 0) {
		scanf("%d", &n);
		for (i = 0; i < n; i++)
			scanf("%d", &(add[i]));

		left = 0;
		right = n - 1;

		do {
			pivot = add[left];
			i = left;
			j = right;
			while (i <= j) {
				while (i <= right && add[i] <= pivot)
					i++;
				while (j > left && add[j] >= pivot)
					j--;
				if (i < j) {
					temp = add[i];
					add[i] = add[j];
					add[j] = temp;
				}
			}
			add[left] = add[i];
			add[j] = pivot;
			if (j < n / 2)
				left = j + 1;
			else
				right = j - 1;
		} while (j != n / 2);
		
		for (i = 0; i < j; i++)
			sum[count] += (pivot - add[i]);
		for (i = j + 1; i < n; i++)
			sum[count] += (add[i] - pivot);
		count++;
		cases--;
	}
	for(i=0; i<count; i++)
		printf("%d\n", sum[i]);
}