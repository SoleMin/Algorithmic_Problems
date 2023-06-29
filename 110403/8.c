#include <stdio.h>
#include <stdlib.h>

int burn_the_bridge(int* arr, int n) {//배열은 정렬된 상태로 0, 1이 가장 빠르다.
	if (n <= 2)
		return arr[n - 1];
	if (n == 3)
		return arr[n - 1] + arr[0] + arr[1];
	int r1 = arr[1] + arr[0] + arr[n - 1] + arr[1];
	int r2 = arr[n - 1] + arr[0] + arr[n - 2] + arr[0];
	int result = r1 > r2 ? r2 : r1;
	return result + burn_the_bridge(arr, n - 2);
	
	/*
	int result = arr[1] + arr[0]; //같이 갔다가 최속이 돌아옴
	if (arr[1] == arr[n - 2]) //차속이랑 차느리미랑 같으면
		result += arr[n - 1] + arr[0];
	else
		result += arr[n - 1] + arr[1]; //느린 애들 보내고 차속이 돌아옴
	return result + burn_the_bridge(arr, n - 2);	
	*/
}

int compare(const void* a, const void* b) {
	return *(int*)a - *(int*)b;
}

int main() {
	int test_case;
	scanf("%d", &test_case);
	
	while (test_case--) {
		int n;
		scanf("%d", &n);
		int* arr = malloc(sizeof(int) * n);
		for (int i = 0; i < n; i++)
			scanf("%d", &arr[i]);
		qsort(arr, n, sizeof(int), compare);
		int sum = 0;
		sum = burn_the_bridge(arr, n);
		printf("%d\n\n", sum);
		free(arr);
	}
	
	return 0;
}