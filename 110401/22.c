#include <stdio.h>
#define MAX_N 500
int main() {
	int a[MAX_N];
	int num_cases, n;
	int left, right, i, j, pivot, temp, sum_dist;
	
	scanf("%d", &num_cases);
	while(num_cases-- > 0) {
		scanf("%d", &n);
		for(i = 0; i < n; i++)
			scanf("%d", &(a[i]));
		left = 0;
		right = n - 1;
		do {
			pivot = a[left];
			i = left;
			j = right;
			while(i <= j) {
				while(i <= right && a[i] <= pivot) // pivot 보다 큰 값 위치 -> i
					i++;
				while(j > left && a[j] >= pivot) // 작은 값 -> j
					j--;
				if(i < j) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
			a[left] = a[j];
			a[j] = pivot;
			if(j < n / 2)
				left = j + 1;
			else
				right = j - 1;
		} while(j != n / 2);
		
		sum_dist = 0;
		for(i = 0; i < j; i++)
			sum_dist += (pivot - a[i]);
		for(i = j+1; i < n; i++) 
			sum_dist += (a[i] - pivot);
		printf("%d\n", sum_dist);
	}
}
