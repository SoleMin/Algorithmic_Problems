#include <stdio.h>

int main() {
	int times, cases, shape, value;
	int how[101][53];
	int before[53];
	int after[53];
	char input[100];
	int l;
	
	scanf("%d", &times);
	
	for (int i = 0; i < times; i++) {
		scanf("%d", &cases);
		for (int j = 1; j <= cases; j++)
			for (int k = 1; k <= 52; k++)
				scanf("%d", &how[j][k]);
		
		for (int j = 1; j <= 52; j++) {
			after[j] = j;
		}
	
		gets(input);
		while (gets(input) && input[0] != '\0') {
			sscanf(input, "%d", &l);
			for (int j  = 1; j <= 52; j++) {
				before[j] = after[j];
			}
			for (int j = 1; j <= 52; j++)
				after[j] = before[how[l][j]];
		}
		
	
		if (i > 0)
			putchar('\n');
		
		for (int j = 1; j <= 52; j++) {
			value = (after[j] - 1) % 13;
			shape = (after[j] - 1) / 13;
			switch(value) {
				case 9: printf("Jack"); break;
				case 10: printf("Queen"); break;
				case 11: printf("King"); break;
				case 12: printf("Ace"); break;
				default: printf("%d", value + 2); 
			}
			printf(" of ");
			switch(shape) {
				case 0: printf("Clubs\n"); break;
				case 1: printf("Diamonds\n"); break;
				case 2: printf("Hearts\n"); break;
				case 3: printf("Spades\n"); break;
			}
		}
		
	}
	return 0;
}
