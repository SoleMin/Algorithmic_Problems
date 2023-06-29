#include <stdio.h>
#define MAXN 3650
#define MAXP 100
int main() {
	int numT, numN, numP, closing, i, j, k;
	int h[MAXP];
	int res[MAXN];
	
	scanf("%d", &numT);
	for(i = 0; i < numT; i++){
		closing = 0;
		for(j = 0; j < MAXP; j++){
			h[j]=0;
		}
		for(j=0; j < MAXN; j++)
			res[j]=0;
		scanf("%d", &numN);
		scanf("%d", &numP);
		for(j = 0; j < numP; j++){
			scanf("%d", &h[j]);
		}
		for(j = 0; j < numP; j++){
			for(k = 0; k < numN; k++){
				if(k % h[j] == (h[j]-1))
					res[k]++;
			}
		}
		for(j = 0; j < numN; j++){
			if(j % 7 >= 5 )
				res[j] = 0;
		}
		for(j = 0; j < numN; j++){
			if(res[j] > 0)
				closing++;
		}
		printf("%d\n", closing);
	}
}
