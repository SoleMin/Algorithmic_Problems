#include <stdio.h>
#define MAX 100
#define CARD 52
int main (void) {

	int n,k;
	char blank;
	int shuffle_ways=0,i,j;
	int shuffle[MAX][CARD+1];
	int set[CARD+1];
	int pre_set[CARD+1];
	int shuffle_select;
	int num,design;
	char line[100];
	
	scanf("%d",&n);
	
	for(k=0;k<n;k++){
		
		/*초기 카드*/
		for(i=1;i<=CARD;i++){
			set[i] = i;
		}
		
		/*섞는 방법 입력*/
		scanf("%d",&shuffle_ways);
		
		for(i=0;i<shuffle_ways;i++){
			for(j=1;j<=CARD;j++){
				scanf("%d", &shuffle[i][j]); 
			}
		}
		
		/*카드 섞기*/
		gets(line);
		while(gets(line) && *line){
			sscanf(line, "%d", &shuffle_select);
	
			for(i=1;i<=CARD;i++){
				pre_set[i] = set[i];	
				
			}
			
			for(i=1;i<=CARD;i++){
				set[i] = pre_set[shuffle[shuffle_select -1][i]];
			
			}

		}
		
		/*결과 출력*/
		for(i=1;i<=CARD;i++){
			design = (set[i]-1)/13;
			num = set[i]%13;
			
			switch(num){
				case 0 : printf("Ace");break;
				case 1 : printf("2");break;
				case 2 : printf("3");break;
				case 3 : printf("4");break;
				case 4 : printf("5");break;
				case 5 : printf("6");break;
				case 6 : printf("7");break;
				case 7 : printf("8");break;
				case 8 : printf("9");break;
				case 9 : printf("10");break;
				case 10 : printf("Jack");break;
				case 11 : printf("Queen");break;
				case 12 : printf("King");break;
			}
			
			printf(" of ");
	
			switch(design){
				case 0 : printf("Clubs\n");break;
				case 1 : printf("Diamonds\n");break;
				case 2 : printf("Hearts\n");break;
				case 3 : printf("Spades\n");break;
			}
		}
		printf("\n");
		
	}
	
	return 0;
}
