#include <stdio.h>
#define MAX_N 3000
#define abs(x) ((x) < 0 ? (-(x)) : (x))
int main() {
	int present[MAX_N];
	int n, i, prev, curr, diff, jolly;
	char line[5000];
	
	while(scanf("%d", &n) == 1){
		jolly = 1;
		for(i = 1; i <= n; i++)
			present[i] = 0;
		
		scanf("%d", &prev);
		for(i = 1; i < n; i++){
			scanf("%d", &curr);
			diff = abs(curr - prev);
			if(diff <= 0 || diff >= n || present[diff]){
				jolly = 0;
				break;
			}
			present[diff] = 1;
			prev = curr;
		}
		
		gets(line);
		puts(jolly ? "Jolly" : "Not jolly");
	}
}
