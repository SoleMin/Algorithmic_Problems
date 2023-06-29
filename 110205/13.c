#include <stdio.h>

int main(void) {
	int casesnum;
	int sufflesnum;
	int suffles[101][53];
	int card[53];
	int new_card[53];
	char line[1000];
	int i, j, k, t, value, suit;
	
	scanf("%d", &casesnum);
	
	for(k=0; k<casesnum; k++) {
		
		scanf("%d", &sufflesnum);
		for(i=1; i<=sufflesnum; i++) {
			for(j=1; j<=52; j++)
				scanf("%d", &suffles[i][j]);
		}
	
		for(i=1; i<=52; i++)
			new_card[i] = i;
	
		gets(line);
		while(gets(line) && *line) {
			sscanf(line, "%d", &t);
			for(i=1; i<=52; i++)
				card[i] = new_card[i];
			for(i=1; i<=52; i++)
				new_card[i] = card[suffles[t][i]];
		}
		
		if(k>0)
			printf("\n");
		
		for(i=1; i<=52; i++) {
			value = (new_card[i]-1) % 13;
			switch(value) {
				case 9 : printf("Jack"); break;
				case 10 : printf("Queen"); break;
				case 11 : printf("King"); break;
				case 12 : printf("Ace"); break;
				default : printf("%d", value+2); break;
			}
			
			printf(" of ");
		
			suit = (new_card[i]-1) / 13;
			switch(suit) {
				case 0 : printf("Clubs\n"); break;
				case 1 : printf("Diamonds\n"); break;
				case 2 : printf("Hearts\n"); break;
				case 3 : printf("Spades\n"); break;
			}	
	}
	}
}
