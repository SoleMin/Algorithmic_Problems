/* Idea: read the instruction, be careful about array bound */

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

typedef enum {high, one, two, three, straight, flush, full, four, straight_flush} hand;
typedef struct {
	int value;
	char type;
} card;

void set_hand(char* str, card* black, card* white);
int get_value(char c);
hand evaluate_hand(card* cards, int* score);
int compare(const void* a, const void* b);

int main(void) {
	char str[30];
	card black[5];
	card white[5];
	while (fgets(str, 30, stdin) != NULL) {
		getchar();
		set_hand(str, black, white);
		qsort(black, 5, sizeof(card), compare);
		qsort(white, 5, sizeof(card), compare);
		int black_score;
		int white_score;
		hand black_hand = evaluate_hand(black, &black_score);
		hand white_hand = evaluate_hand(white, &white_score);
		if (black_hand > white_hand) {
			printf("Black wins.\n");
			continue;
		}
		if (black_hand < white_hand) {
			printf("White wins.\n");
			continue;
		}
		bool tied = true;
		for (int i = 0; i < 5; i++) {
			if (black[i].value > white[i].value) {
				printf("Black wins.\n");
				tied = false;
				break;
			}
			else if (black[i].value < white[i].value) {
				printf("White wins.\n");
				tied = false;
				break;
			}
		}
		if (tied)
			printf("Tie.\n");
	}
}

int compare(const void* a, const void* b) {
	return ((card*)b)->value - ((card*)a)->value;
}

void set_hand(char* str, card* black, card* white) {
	char* black_pointer = str;
	char* white_pointer = str + 15;
	for (int i = 0; i < 5; i++, black_pointer++, white_pointer++) {
		black[i].value = get_value(*black_pointer++);
		black[i].type = *black_pointer++;
		white[i].value = get_value(*white_pointer++);
		white[i].type = *white_pointer++;
	}
}

int get_value(char c) {
	if ('2' <= c && c <= '9')
		return c - '0';
	switch (c) {
		case 'T': return 10;
		case 'J': return 11;
		case 'Q': return 12;
		case 'K': return 13;
		case 'A': return 14;
	}
}

hand evaluate_hand(card* cards, int* score) {
	bool is_straight_flush = true;
	char type = cards[0].type;
	int base = cards[0].value;
	for (int i = 1; i < 5; i++)
		if (type != cards[i].type || base - i != cards[i].value) {
			is_straight_flush = false;
			break;
	 	}
	if (is_straight_flush) {
		*score = base;
		return straight_flush;
	}
	
	for (int i = 0; i < 2; i++) {
		int count = 1;
		for (int j = i + 1; j < 5; j++)
			if (cards[i].value == cards[j].value)
				count++;
		if (count >= 4) {
			*score = cards[i].value;
			return four;
		}
	}
	
	for (int i = 0; i < 3; i++) {
		int count = 1;
		for (int j = i + 1; j < i + 3; j++)
			if (cards[i].value == cards[j].value)
				count++;
		if (count == 3 && cards[(i + 3) % 5].value == cards[(i + 4) % 5].value) {
			*score = cards[i].value;
			return full;
		}
	}
	
	bool is_flush = true;
	int max = cards[0].value;
	for (int i = 1; i < 5; i++) {
		if (cards[0].type != cards[i].type) {
			is_flush = false;
			break;
		}
		if (max < cards[i].value)
			max = cards[i].value;
	}
	if (is_flush) {
		*score = max;
		return flush;
	}
	
	bool gay = false;
	for (int i = 1; i < 5; i++) {
		if (cards[0].value - i != cards[i].value)
			gay = true;
	}
	if (!gay) {
		*score = cards[0].value;
		return straight;
	}
	
	for (int i = 0; i < 3; i++) {
		int count = 1;
		for (int j = i + 1; j < i + 3; j++)
			if (cards[j].value == cards[i].value)
				count++;
		if (count == 3) {
			*score = cards[i].value;
			return three;
		}
	}
	
	for (int i = 0; i < 4; i++) {
		int count = 0;
		int max;
		if (cards[i].value == cards[i + 1].value) {
			count++;
			if (count == 1)
				max = cards[i].value;
		}
		if (count == 2) {
			*score = max;
			return two;
		}
	}
	
	for (int i = 0; i < 4; i++) {
		if (cards[i].value == cards[i + 1].value) {
			*score = cards[i].value;
			return one;
		}
	}
	
	*score = cards[0].value;
	return high;
}