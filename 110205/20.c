#include <stdio.h>

#define CARDS 52
#define MAX 100

void main(void) {
	int shuffle[MAX + 1][CARDS];
	int deck[CARDS + 1], old_deck[CARDS + 1];
	char line[100];
	int num_c, num_s;
	int t,i,j,k,suit,value;
	
	scanf("%d", &num_c);
	
	for(t = 0; t < num_c; t++) {
		
		scanf("%d", &num_s);
		for(i = 1; i <= num_s; i++)
			for(j = 1; j <= CARDS; j++)
				scanf("%d", &shuffle[i][j]);
		for(i = 1; i <= CARDS; i++)
			deck[i] = i;
		
		gets(line);
		while(gets(line) && *line) {
			sscanf(line, "%d", &k);
			for(i = 1; i <= CARDS; i++)
				old_deck[i] = deck[i];
			for(i = 1; i <= CARDS; i++)
				deck[i] = old_deck[shuffle[k][i]];
		}
		
		if(t>0)
			putchar('\n');
		
		for(i = 1; i <= CARDS; i++) {
			value = (deck[i] - 1) % 13;
			suit = (deck[i] - 1) / 13;
			switch(value) {
				case 9 : printf("Jack"); break;
				case 10 : printf("Queen"); break;
				case 11 : printf("King"); break;
				case 12 : printf("Ace"); break;
				default: printf("%d", value + 2); break;
			}
			printf(" of ");
			switch(suit) {
				case 0 : puts("Clubs"); break;
				case 1 : puts("Diamonds"); break;
				case 2 : puts("Hearts"); break;
				case 3 : puts("Spades"); break;
			}
		}
	}
}