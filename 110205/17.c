#include <stdio.h>
#define CARD_AMOUNT 52
#define MAX_SHUFFLES 100

void main() {
	int shuffle[MAX_SHUFFLES+1][CARD_AMOUNT+1];
	int deck[CARD_AMOUNT+1], origin[CARD_AMOUNT+1];
	char line[100];
	int cases, shuffle_cnt, t, i, j, k, val, suit;
	scanf("%d", &cases);
	for(t=0; t<cases; t++){
		scanf("%d", &shuffle_cnt);
		for(i=1; i<=shuffle_cnt; i++){
			for(j=1; j<=CARD_AMOUNT; j++){
				scanf("%d", &shuffle[i][j]);
			}
		}
		for(i=1; i<=CARD_AMOUNT; i++){
			deck[i]=i;
		}
		gets(line);
		while(gets(line) && *line){
			sscanf(line, "%d", &k);
			for(i=1; i<=CARD_AMOUNT; i++){
				origin[i]=deck[i];
			}
			for(i=1; i<=CARD_AMOUNT; i++){
				deck[i]=origin[shuffle[k][i]];
			}
		}
		if(t>0){
			printf("\n");
		}
		for(i=1; i<=52; i++){
			val=deck[i]%13;
			suit=(deck[i]-1)/13;
			switch(val){
				case 10: printf("Jack"); break;
				case 11: printf("Queen"); break;
				case 12: printf("King"); break;
				case 0: printf("Ace"); break;
				default: printf("%d", val+1); break;
			}
			switch(suit){
				case 0: printf(" of Clubs\n"); break;
				case 1: printf(" of Diamonds\n"); break;
				case 2: printf(" of Hearts\n"); break;
				case 3: printf(" of Spades\n"); break;
			}
		}
	}
}