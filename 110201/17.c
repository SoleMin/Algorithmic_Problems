#include <stdio.h>
#define MAX_N 3000
#define abs(x) ( (x) < 0 ? (-(x) ) : (x))

int arr1[MAX_N];
int arr2[MAX_N - 1];

int main(void) {
	int arr1[MAX_N];
	int arr2[MAX_N - 1];
	int n, i, j, tmp, token;
	
	while(scanf("%d", &n) == 1) {
		token = 0;
		for(i = 0; i < n; i++) { // 배열 arr[i]에 tmp 저장.
			scanf("%d", &tmp);
			arr1[i] = tmp;
		}
		
		if(n == 1) { // n == 1일 때, 무조건 참이므로 continue
			printf("Jolly\n");
			continue;
		}
		
		for(i = 1; i < n; i++) {
			tmp = abs(arr1[i] - arr1[i - 1]);
			arr2[i - 1] = tmp;
		}
		
		for(i = 0; i < n - 2; i++) {
			for(j = i + 1; j < n - 1; j++) {
				if(arr2[i] > arr2[j]) {
					tmp = arr2[i];
					arr2[i] = arr2[j];
					arr2[j] = tmp;
				}
			}
		}
		
		for(i = 0; i < n - 1; i++) {
			if(arr2[i] != i + 1) {
				printf("Not jolly\n");
				break;
			}
			token++;
		}
		if(token == n - 1)
			printf("Jolly\n");
	}
	return 0;
}