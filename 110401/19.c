#include <stdio.h>
#include <stdlib.h>

int compare(const void* a, const void* b) {
	return *(int*)a - *(int*)b;
}

int main() {
	int test_case;
	scanf("%d", &test_case);
	while (test_case--) {
		int num;
		scanf("%d", &num);
		int* arr = malloc(sizeof(int) * num);
		for (int i = 0; i < num; i++)
			scanf("%d", &arr[i]);
		qsort(arr, num, sizeof(int), compare);
		int median = arr[num / 2];
		int sum = 0;
		for (int i = 0; i < num; i++)
			if (median >= arr[i])
				sum += median - arr[i];
			else
				sum += arr[i] - median;
		printf("%d\n", sum);
	}
}
