#include <stdio.h>
#include <stdlib.h>

void main() {
	
	int test;
	int i, j, k, m, num, count;
	char line[100];
	int* home;
	
	scanf("%d", &test);
	gets(line);
	
	for(i = 0; i < test; i++) {
		scanf("%d", &count);
		home = (int *)malloc(sizeof(int) * count);
		for(j = 0; j < count; j++) 
			scanf("%d", &home[j]);
		int min, temp, result = 0;
		for(k = 0; k < count; k++) {
			for(m = 0; m < count; m++) {
				min = home[m];
				if(min > home[m+1]) {
					temp = min;
					min = home[m+1];
					home[m] = temp;
				}
			}
		}
		num = count / 2;
		for(k = 0; k < count; k++)
			result += abs(home[k] - home[num]);
		printf("%d\n", result);
		free(home);
	}
}
