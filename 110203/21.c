#include <stdio.h>

void main(void){
	
	int try;
	int day;
	int party;
	int i, j;
	int partynum[100];
	int freeday[100];
	scanf("%d", &try);
	
	while(try != 0){
		int count = 0;
		scanf("%d", &day);
		int freeday[day];
		
		scanf("%d", &party);
		int partynum[party];
		
		for(i = 1; i <= day; i++){
			freeday[i] = 0;
		}
		
		for(i = 1; i <= party; i ++){
			scanf("%d", &partynum[i]);
		}
	
		for(i = 1; i <= day; i++){
			for(j = 1; j <= party; j++){
				if(i % partynum[j] == 0)
					freeday[i] = 1;
			}
		}
		
		for(i = 1; i <= day; i++){
			if(i % 7 == 6 || i % 7 == 0)
				freeday[i] = 0;
		}
		
		for(i = 1; i <= day; i++){
			if(freeday[i] == 1)
				count++;
		}
		
		printf("%d\n", count);
		try--;
	}
}