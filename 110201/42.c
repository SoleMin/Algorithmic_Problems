#include <stdio.h>
#define abs(x) ((x)<0 ? (-(x)) : (x))

int main() {
	int res[3000] = {0,};
	int n, i, a, b, differ, jolly;
	char blank[100];
	while(scanf("%d", &n) == 1){
		jolly = 1;
		for(i=0; i<n; i++)
			res[i] = 0;
		scanf("%d", &a);
		for(i=1; i<n; i++){
			scanf("%d", &b);
			differ = abs(b-a);
			if(differ<=0 || differ>=n || res[differ]){
				jolly = 0;
				break;
			}
			res[differ] = 1;
			a = b;
		}
		gets(blank);
		printf(jolly ? "Jolly\n" : "Not jolly\n");
	}
	return 0;
}
