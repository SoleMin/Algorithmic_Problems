#include <stdio.h>

#define NUM_CARDS 52
#define MAX_SHUFFLES 100

int main() {
	
	int shuffle[MAX_SHUFFLES + 1][NUM_CARDS + 1];
	int deck[NUM_CARDS+1], old_deck[NUM_CARDS+1];
	char line[100];
	int num_cases, num_shuffles;
	int t, i , j ,k , suit, value;
	
	scanf("%d", &num_cases);
	for( t=0; t < num_cases; t++){
		scanf("%d", &num_shuffles);
		for(i = 1; i <= num_shuffles;i++)
			for(j = 1; j<= NUM_CARDS; j++)
				scanf("%d", &shuffle[i][j]);
		
		for(i = 1; i <=NUM_CARDS; i++)
			deck[i] = i;
		
		gets(line);
		while(gets(line) && *line){
			sscanf(line, "%d", &k);
			for(i = 1 ; i <= NUM_CARDS ; i++)
				old_deck[i] = deck[i];
			for(i = 1 ; i <= NUM_CARDS ; i++)
				deck[i] = old_deck[shuffle[k][i]];
		}
		if(t > 0)
			putchar('\n');
		
		for(i=1; i <= 52; i++){
			value = (deck[i] -1 ) % 13;
			suit = (deck[i] - 1) / 13;
			switch(value){
				case 9: printf("Jack"); break;
				case 10: printf("Queen"); break;
				case 11: printf("King"); break;
				case 12: printf("Ace"); break;
				default: printf("%d", value + 2); break;
			}
			switch(suit){
				case 0: puts(" of Clubs"); break;
				case 1: puts(" of Diamonds"); break;
				case 2: puts(" of Hearts"); break;
				case 3: puts(" of Spades"); break;
			}
		}
	}
}
