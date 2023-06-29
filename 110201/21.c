#include <stdio.h>
#define MAX 3000
#define abs(x)  ((x) < 0 ? (-(x)) : (x))
int main() {
	int i, j, n, exi, jolly;
	int present[MAX];
	int array[MAX];
	
	while(scanf("%d",&n)==1) {
		jolly=0;
		
		for(i=0; i<n; i++) {
			scanf("%d",&present[i]);
		}
		for(i=0; i<n; i++) {
			array[i]=0;
		}
		
		for(i=0; i<n-1; i++) {
			exi=abs(present[i] - present[i+1]);
			array[exi] = 1;
		}
		for(i=1; i<n; i++) {
			if(array[i] != 1){
				jolly=1;
				break;
			}
		}
		if(jolly==0) {
			printf("Jolly\n");
		}
		else {
			printf("Not jolly\n");
		}
	}
	return 0;
}
