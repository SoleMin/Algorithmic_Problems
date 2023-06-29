#include <stdio.h>
#include <math.h>
#include <stdlib.h>

void main() {
	
	int n = 0;
	int jolly, diff, aft, bef;
	int num[3000];	
	char line[5000];
	int count = 0;

	
	while(scanf("%d", &n) == 1) {
		jolly = 1;
		
		for(int i = 1; i <= n; i++) {
			num[i] = 0;
		}
		
		scanf("%d", &bef);
		for(int j = 1; j < n; j++) {
			scanf("%d", &aft);
			diff = abs(aft - bef);
			if(diff <= 0 || diff >= n || num[diff]) {
				jolly = 0;
				break;
			}
			num[diff] = 1;
			bef = aft;
		}
		
		gets(line);
		puts(jolly ? "Jolly" : "Not jolly");
		
		
	}

}
