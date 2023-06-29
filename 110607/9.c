#include <stdio.h>
int main() {
	int n, i, num[100000];
	
	while(scanf("%d", &n), n != 0) {
		num[0] = 1;
		num[1] = 2;
		int count = 3, a = 2, sum = 3;
		if(n >= 4) {
			for(i = 3; i < 100000; i++) {
				num[i - 1] = a;
				sum = sum + a;
				if(sum >= n) break;
				if(i == count) {
					a++;
					count = count + num[a - 1];
				}
			}
			printf("%d\n", i);
		}
		else if(n == 2 || n == 3)
			printf("2\n");
		else
			printf("1\n");
	}
		
	return 0;
}
