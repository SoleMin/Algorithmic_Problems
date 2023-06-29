#include <stdio.h>
#include <stdlib.h>
int sum = 0;
int cal(int n, int* s) {
	int a, b;
	
	
	if(n == 3) {
		for(int i = 0; i < n; i++){
			sum += s[i];
		}
		return sum;
	}
	else if (n < 3){
		sum += s[n-1];
		return sum;
	}
	else {
		a = (2 * s[0]) + s[n-2] + s[n-1];
		b = s[0] + (2 * s[1]) + s[n-1];
		if (a > b) 
			sum += b;
		else
			sum += a;
		
		cal(n-2, s);
	}
}

int sort(int *i, int *j) {
	if(*i > *j) return (1);
	if(*i < *j) return (-1);
	return(0);
}




void main() {
	int test_case;
	char blank[100];
	int per[100][1000];
	int i, j, k, num, s;
	
	scanf("%d", &test_case);
	gets(blank);
	for(i = 0; i < test_case; i++) {
		
		scanf("%d", &num);
		
		for(j = 0; j < num; j++) {
			scanf("%d", &per[i][j]);
		}
		
		qsort(per[i], num, sizeof(int), sort);
		
		s = cal(num, per[i]);
		printf("%d\n\n", s);
		sum = 0;
	}
}
