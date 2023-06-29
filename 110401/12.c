#include <stdio.h>
#define rMAX 500

int main(void) {
	int i=0, j, k, testcase;
	int arr1[rMAX] = { 0, };
	int arr2[rMAX];
	int vito, rel, left, right, temp, sum;

	scanf("%d", &testcase);

	for (k = 0; k < testcase; k++) {
		vito = 0;
		scanf("%d", &rel);
		for (i = 0; i < rel; i++) {
			scanf("%d", &arr1[i]);
		}
		left = 0;
		right = rel - 1;
		
		do {
			vito = arr1[left];
			i = left;
			j = right;
			while (i <= j) {
				while (i <= right && arr1[i] <= vito) {
					i++;
				}
				while (j > left&& arr1[j] >= vito) {
					j--;
				}
				if (i < j) {
					temp = arr1[i];
					arr1[i] = arr1[j];
					arr1[j] = temp;
				}
			}
			arr1[left] = arr1[j];
			arr1[j] = vito;
			if (j < rel / 2) {
				left = j + 1;
			}
			else {
				right = j - 1;
			}
		} while (j != rel / 2);
		sum = 0;

		for (i = 0; i < j; i++) {
			sum += (vito - arr1[i]);
		}
		for (i = j + 1; i < rel; i++) {
			sum += (arr1[i] - vito);
		}
		printf("%d\n", sum);
	}
}