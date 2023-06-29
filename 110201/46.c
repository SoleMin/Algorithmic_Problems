#include <stdio.h>
#include <stdlib.h>

int main() {
	int input[3000];
	int n, m, jo, a, b;
	int line[3000];
	
	while(scanf("%d", &n) == 1) {
		jo = 1;
		for(int i = 1; i <= n; i++)
			input[i] = 0;
		scanf("%d", &a);
		for(int i = 1; i < n; i++) {
			scanf("%d", &b);
			if(abs(b - a) <= 0 || abs(b - a) >= n || input[abs(b - a)]) {
				jo = 0;
				break;
			}
			input[abs(b - a)] = 1;
			a = b;
		}
		gets(line);
		if(jo == 1)
			printf("Jolly\n");
		else if(jo == 0)
			printf("Not jolly\n");
	}
}
