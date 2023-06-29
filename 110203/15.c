#include <stdio.h>

int main(void) {
	int cases, day, number, i, j, k;
	int h[100];
	int result;
	
	scanf("%d", &cases);
	for(i=0; i<cases; i++) {
		result=0;
		scanf("%d", &day);
		scanf("%d", &number);
		for(j=0; j<number; j++)
			scanf("%d", &h[j]);
		
		for(j=1; j<=day; j++) {
			if((j-1)%7 < 5)
				for(k=0; k<number; k++)
					if(j%h[k] == 0) {
						result++;
						break;
					}
		}
		printf("%d\n", result);
	}
}