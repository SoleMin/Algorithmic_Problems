#include <stdio.h>
#include <math.h>
int main() {
	int sequence[3000];
	int n, i, jolly, x, y, result;
	char line[5000];
	
	while(scanf("%d", &n) == 1){
		jolly = 1;
		for(i = 1;i <= n;i++) sequence[i] = 0;
		scanf("%d", &x);
		for(i = 1; i < n; i++){
			scanf("%d", &y);
			result = abs(x - y);
			if(result >= n || result <= 0 || sequence[result]){
				jolly = 0;
				break;
			}
			sequence[result] = 1;
			x = y;
		}
		
		gets(line);
		puts(jolly ? "Jolly" : "Not jolly");
	}
	return 0;
}
