#include <stdio.h>
#include <stdlib.h>

typedef struct {
	int value;
	char type;
} card;

char get_type(int i) {
	switch (i) {
		case 0: return 'C';
		case 1: return 'D';
		case 2: return 'H';
		case 3: return 'S';
	}
}

card* initialize_deck(void) {
	card* cards = malloc(sizeof(card) * 52);
	int count = 0;
	for (int i = 0; i < 4; i++)
		for (int j = 2; j <= 14; j++) {
			cards[count].value = j;
			cards[count].type = get_type(i);
			count++;
		}
	return cards;
}

void exchange(card* cards, card* shuffled) {
	for (int i = 0; i < 52; i++) {
		cards[i].value = shuffled[i].value;
		cards[i].type = shuffled[i].type;
	}
}

void print_value(int value) {
	switch (value) {
		case 11: printf("Jack"); return;
		case 12: printf("Queen"); return;
		case 13: printf("King"); return;
		case 14: printf("Ace"); return;
	}
}

void print_type(char type) {
	switch (type) {
		case 'C': printf("Clubs\n"); return;
		case 'D': printf("Diamonds\n"); return;
		case 'H': printf("Hearts\n"); return;
		case 'S': printf("Spades\n"); return;
	}
}

void printer(card* cards) {
	for (int i = 0; i < 52; i++) {
		if (cards[i].value < 11)
			printf("%d", cards[i].value);
		else
			print_value(cards[i].value);
		printf(" of ");
		print_type(cards[i].type);
	}
	printf("\n");
}

void shuffling(card* cards, int* arr) {
	card shuffled[52];
	for (int i = 0; i < 52; i++)
		shuffled[i] = cards[arr[i] - 1];
	exchange(cards, shuffled);
}

int main(void) {
	int test_case;
	scanf("%d", &test_case);
	while (test_case--) {
		card* cards = initialize_deck();
		int shuffle;
		scanf("%d", &shuffle);
		int** shuffle_way = malloc(sizeof(int*) * shuffle);
		for (int i = 0; i < shuffle; i++) {
			shuffle_way[i] = malloc(sizeof(int) * 52);
			for (int j = 0; j < 52; j++)
				scanf("%d", &shuffle_way[i][j]);
		}
		getchar();
		char token;
		while (scanf("%c", &token) != EOF && token != '\n') {
			shuffling(cards, shuffle_way[token - '0' - 1]);
			getchar();
		}
		printer(cards);
		free(cards);
		for (int i = 0; i < shuffle; i++)
			free(shuffle_way[i]);
		free(shuffle_way);
	}
}