#include <stdio.h>

int calculation() {
	int days;
	int num;
	int i, j;
	int count = 0;
	
	scanf("%d", &days);
	scanf("%d", &num);
	int num_count[num];
	int days_count[days];
	int array[num][days];

	for (i = 0; i < num; i++) {
		for (j = 0; j < days; j++) {
			array[i][j] = 0;
		}
	}
	
	for (i = 0; i < num; i++) {
		scanf("%d", &num_count[i]);
	}
	
	for (i = 1; i <= num; i++) {
		for (j = 1; j <= days; j++) {
			if(j % num_count[i-1] == 0) {
				array[i-1][j-1] = 1;
			}
		}
	}
	
	for(i = 0; i < days; i++)
		days_count[i] = 0;
	
	for(i = 0; i < num; i++) {
		for(j = 0; j < days; j++) {
			if(array[i][j] == 1) {
				days_count[j] = 1;
			}
			if(j%7==5 || j%7==6)
				days_count[j] = 0;
		}
	}
	
	for (i = 0; i < days; i++) {
		if(days_count[i] == 1)
			count++;
	}
	
	return count;
}


void main() {
	int n = 0;
	int a[100];
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		a[i] = calculation();
	}
	for (int j = 0; j < n; j++) {
		printf("%d\n", a[j]);
	}
}
