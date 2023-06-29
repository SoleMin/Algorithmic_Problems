#include <stdio.h>
#define MAX_N 2650
#define MAX_P 100

void main(){
	int num_case, n, p ,i , j, k, lost;
	int h[MAX_P];
	
	scanf("%d", &num_case);
	for( i = 0; i < num_case; i++){
		scanf("%d", &n);
		scanf("%d", &p);
		for(j = 0; j < p; j++)
			scanf("%d", &h[j]);
		lost = 0;
		for( j = 1; j <= n; j++)
			if( (j - 1) % 7 < 5 )
				for(k = 0; k < p; k++)
					if(j % h[k] == 0){
						lost++;
						break;
					}
		printf("%d\n", lost);
	}
	
}