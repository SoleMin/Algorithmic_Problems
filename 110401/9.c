#include <stdio.h>
#include <stdlib.h>
#include  <string.h>
#include <math.h>
#define MAX_BUF 100000
#define MAX_S   500



int main(void) {
	char line[MAX_BUF];
	char tmp[MAX_BUF];
	char* token;
	int cas;
	int r;
	int list[MAX_S] = { };
	int i, j;
	int min;
	int min_i;
	int total;
	int len;
	
	
	scanf("%d", &cas);
	fgets(line, MAX_BUF, stdin);
	while(cas--) {
		scanf("%d", &r);
		//printf("%d\n\n", r);
		for(i = 0; i < r; i++) {
			scanf("%d", list + i);
			//printf("list[%d] = %d\n", i, list[i]);
		} //printf("\n");
		
		for(i = 0; i < r; i++) {
			total = 0;
			for(j = 0; j < r; j++) {
				total += abs(list[i] - list[j]);
				//printf("%d ", total);
			}
			if(i == 0) {
				min = total;
				min_i = i;
				continue;
			}
			if(min > total) {
				min = total;
				min_i = i;
			}
		}
		printf("%d\n", min);
		
	}
	
	return 0;
}