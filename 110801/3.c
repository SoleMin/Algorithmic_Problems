#include <stdio.h>
#include <stdlib.h>
#define LENGTH 20

void bsort(int arr[], int n);
void set_arr1D(int arr[]);
void set_arr2D(int arr[][20]);


int main(void) {
	int n, k;
	int i, j;
	int row1[LENGTH], row2[LENGTH];
	int data1[LENGTH][LENGTH], data2[LENGTH][LENGTH];
	int result;
	
	while (scanf("%d %d", &n, &k) == 2) {
		if (n == 0 && k == 0)
			break;
		if (n == 1 || k == 0) {
			printf("1\n");
			continue;
		}
		set_arr1D(row1);
		set_arr1D(row2);

		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				if ((i + j) % 2)
					row1[(i + j) / 2]++;
				else
					row2[(i + j) / 2]++;
			}
		}
		bsort(row1, n - 1);
		bsort(row2, n);
		
		set_arr2D(data1);
		set_arr2D(data2);

		data1[0][0] = 1, data1[0][1] = row1[0];
		data2[0][0] = 1, data2[0][1] = row2[0];
		for (i = 1; i < n - 1; i++) {
			data1[i][0] = 1;
			for (j = 1; j <= row1[i]; j++) {
				data1[i][j] = data1[i - 1][j] + data1[i - 1][j - 1] * (row1[i] - (j - 1));
			}
		}

		for (i = 1; i < n; i++) {
			data2[i][0] = 1;
			for (j = 1; j <= row2[i]; j++) {
				data2[i][j] = data2[i - 1][j] + data2[i - 1][j - 1] * (row2[i] - (j - 1));
			}
		}
		result = 0;
		for (i = 0; i <= k; i++)
			result += data1[n - 2][i] * data2[n - 1][k - i];
		printf("%d\n", result);
	}

	return 0;
}

void bsort(int arr[], int n) {
	int tmp;
	int i, j;

	for (i = 0; i < n; i++) {
		for (j = 0; j < n - 1 - i; j++) {
			if (arr[j] > arr[j + 1]) {
				tmp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = tmp;
			}
		}
	}
}

void set_arr1D(int arr[]) {
	int i;
	for (i = 0; i < LENGTH; i++)
		arr[i] = 0;
}

void set_arr2D(int arr[][20]) {
	int i, j;
	for (i = 0; i < LENGTH; i++) {
		for (j = 0; j < LENGTH; j++) {
			arr[i][j] = 0;
		}
	}
}