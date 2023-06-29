#include <stdio.h>
#define MAX_N 3000

int absolute(int n, int m);

int main() {
	int array[MAX_N];
	int n, check, prev, curr, diff;
	char line[1000];
	
	while(scanf("%d", &n) == 1) {
		check = 1;
		
		for(int i=1; i <= n; i++) 
			array[i] = 0;
		
		scanf("%d", &prev);
		for(int i=1; i < n; i++) {
			scanf("%d", &curr);
			diff = absolute(prev, curr);
			if(diff <= 0 || diff >= n || array[diff]) {
				check = 0;
				break;
			}
			array[diff] = 1;
			prev = curr;
		}
		gets(line);
		if(check)
			printf("Jolly\n");
		else
			printf("Not jolly\n");
	}
	return 0;
}

int absolute(int n, int m) {
	return n > m ? (n - m) : (m - n);
}
