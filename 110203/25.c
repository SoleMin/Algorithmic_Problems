#include <stdio.h>
#include <stdbool.h>
int main() {
	int t, n, p;
	bool hartal;
	int main_count;
	int arr[100];
	scanf("%d", &t);
	for(int k = 0; k < t; k++) {
		main_count=0;
		scanf("%d", &n);
		scanf("%d", &p);
		for(int i = 0; i < p; i++)
			scanf("%d", &arr[i]);

		for(int i = 0; i < n; i++) {
			hartal = false;
			if((i+1)%7==6 || (i+1)%7==0) continue;
			for(int j = 0; j < p; j++) {
				if((i+1) % arr[j] == 0) {
					hartal = true;
				}
			}
			if(hartal) {
				main_count++;
			}
		}
		printf("%d\n", main_count);
	}
	return 0;
}
