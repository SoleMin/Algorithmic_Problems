#include <stdio.h>
int main() {
	char num[13][10] = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
	char shape[4][10] = {"Clubs", "Diamonds", "Hearts", "Spades"};
	int i, j, x, y, n, m, k;
	int set[101][53];
	int tmp[53];
	int card[53];
	int value, suit;
	char line[100];
	scanf("%d", &n);
	printf("\n");
	for(i = 0;i < n;i++){
		scanf("%d", &m);
		for(j = 1;j <= m;j++)
			for(x = 1;x <= 52;x++)
				scanf("%d", &set[j][x]);
		
		for(j = 1;j <= 52;j++) card[j] = j;

	gets(line);
		while(gets(line) && *line){
			sscanf(line, "%d", &k);
			for(j = 1;j <= 52;j++)
				tmp[j] = card[j];
			for(j = 1;j <= 52;j++)
				card[j] = tmp[set[k][j]];
		}
		printf("\n");		
		for(j = 1;j <= 52; j++){
			value = (card[j] - 1) % 13;
			suit = (card[j] - 1) / 13;
			printf("%s of %s\n", num[value], shape[suit]);
		}
	}
	return 0;
}
