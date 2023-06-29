#include <stdio.h>
#include <string.h>
#define MAX_N 3000
#define abs(x) (((x) < 0)? -(x):(x))

int main() {
	int n, i, pre, cur, dif, jolly;
	int diff[MAX_N];
	char line[1] = {'\0'};
	
	while(scanf("%d",&n) == 1) {
		jolly = 1;
		memset(diff,0,sizeof(int)*n);
		scanf("%d", &pre);
		for(i = 1; i < n; i++) {
			scanf("%d", &cur);
			dif = abs(cur - pre);
			if(dif <= 0 || dif >= n || diff[dif]) {
				jolly = 0;
				break;
			}
			diff[dif] = 1;
			pre = cur;
		}
		scanf("%*[^\n]",line);
		
		puts(jolly? "Jolly" : "Not jolly");
	}
	
}
