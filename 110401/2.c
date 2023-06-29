#include <stdio.h>
#define Max 500
void Swap(int arr[], int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
}
int Partition(int arr[], int left, int right) {
    int pivot = arr[left]; 
    int low = left + 1;
    int high = right;

    while (low <= high) {
        while (low <= right && pivot >= arr[low]) {
            low++; 
        }
        while (high >= (left + 1) && pivot <= arr[high]) {
            high--;
        }
        if (low <= high) {
            Swap(arr, low, high);
        }
    }
    Swap(arr, left, high); 
    return high; 
}
void quick(int arr[], int left, int right) {
    if (left <= right) {
        int pivot = Partition(arr, left, right);
        quick(arr, left, pivot - 1);
        quick(arr, pivot + 1, right);
    }
}
int main() {
	int test_case, n;
	int adr[Max];
	int i, j;
	int mid, tmp1, tmp2, sum;
	scanf("%d",&test_case);
	while(test_case--){
		scanf("%d", &n);
		for(i = 0;i < n;i++)
			scanf("%d", &adr[i]);
		quick(adr, 0, n - 1);
		
		mid = n/2;
		sum = 0;
		for(i = 0;i < mid;i++)
			sum += (adr[mid] - adr[i]);
		for(i = mid + 1; i < n;i++)
			sum += (adr[i] - adr[mid]);
		printf("%d\n", sum);
	
	}
	
	return 0;
}
