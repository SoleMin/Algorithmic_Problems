#include <stdio.h>
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
	int i, cnt;
	int test_case, person;
	int time[1000];
	int sum;
	scanf("%d\n", &test_case);
	while(test_case--){
		scanf("%d", &person);
		for(i = 0;i < person;i++)
			scanf("%d", &time[i]);
		quick(time, 0, person - 1);	
		if(person == 1) printf("%d\n", time[0]);
		else if(person == 2) printf("%d\n", time[1]);
		else {
			sum = 0;
			for(i = person - 1;i >= 2; i = i - 2){
				if(2 * time[0] + time[i] + time[i - 1] < time[0] + 2 * time[1] + time[i]) 
					sum += 2 * time[0] + time[i] + time[i - 1];
				else
					sum += time[0] + 2 * time[1] + time[i];
				
			}
			if(person % 2 == 0) sum += time[1];
			else sum -= time[0];
			printf("%d\n", sum);
		}
		printf("\n");
	}
	return 0;
}
