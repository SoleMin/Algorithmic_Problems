#include <stdio.h>
#include <stdlib.h>

int main(void) {
	int testcase, days, p, count=0;
	int i, j, k;
	int *hartal;
	int *result;
	int **array;
	
	scanf("%d",&testcase);
	result = (int*)malloc(sizeof(int) * testcase);
	
	for(k = 0; k < testcase; k++) {
		i = 0;
		scanf("%d", &days);
		
		scanf("%d", &p);
		hartal = (int*)malloc(sizeof(int) * p);
		array = (int*)malloc(sizeof(int*) * (days + 1));
		
		for(i = 0; i < p; i++) {
			scanf("%d",&hartal[i]);
		}
		
		for(i = 0; i <= days; i++) {
			array[i] = (int*)malloc(sizeof(int) * p);
		}
		for(i = 0; i <= days; i++) {
			for(j = 0; j < p; j++) {
				array[i][j] = 0;
			}
		}
		
		for(i = 0; i < p; i++) {
			for(j = 1; j <= days; j++) {
				if(((j-1) % 7 < 5) && (j % hartal[i] == 0)) {
					array[j][i] = 1;
				}
			}
		}
		
		count = 0;
		for(i = 1; i <= days; i++) {
			for(j = 0; j < p; j++) {
				if(array[i][j] == 1) {
					count++;
					break;
				}
			}
		}
		result[k] = count;
}
	for(k = 0; k < testcase; k++) {
		printf("%d\n", result[k]);
	}
	
	for(i = 0; i < p; i++) {
		free(array[i]);
	}
	free(array);
	free(hartal);
	free(result);
	return 0;
}