#include <stdio.h>
#include <stdlib.h>
#define MAX_N 500

int intcompare (int *i, int *j){
	if(*i >*j) return 1;
	if(*i <*j) return -1;
	return 0;
}


int main(void) {
	
	int num_cases, n,i,j;
	int bito;
	int min=0;
	
	
	scanf("%d", &num_cases);
	while(num_cases -->0){
		scanf("%d", &n);
		int house[MAX_N]={0};
		int distance[MAX_N]={0};
		for(i=0;i<n;i++)
			scanf("%d", &house[i]);
	
		qsort((char *)house, n, sizeof(int), intcompare);

		for(i=0;i<n;i++){
			bito = house[i];
			for(j=0;j<n;j++){
				distance[i]+= abs(bito - house[j]);	
			}
		}

		min=distance[0];
		for(i=1;i<n;i++){
			if(min>distance[i]){
				min = distance[i];
			}
		}
	
		printf("%d\n",min);

	}
	
	return 0;
}
