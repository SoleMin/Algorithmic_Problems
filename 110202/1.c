#include <stdio.h>
#define get_value(x) ((x) / 10)
#define get_suit(x) ((x) % 10)

int encode_card(char *card){
	int result;
	
	switch (card[0]){
		case 'T': result = 100; break;
		case 'J': result = 110; break;
		case 'Q': result = 120; break;
		case 'K': result = 130; break;
		case 'A': result = 140; break;
		default: result = (card[0] - '0') * 10;
	}
	switch (card[1]){
		case 'H': result += 1; break;
		case 'D': result += 2; break;
		case 'S': result += 3; break;
		case 'C': result += 4; break;
	}
	return result;
}

long get_hand_value(int hand[5]){
	int i, j, max, temp;
	int value[5], suit[5];
	long result;
	for(i = 0; i < 4; i++){
		max = i;
		for(j = i+1; j < 5; j++){
			if(hand[j] > hand[max])
				max = j;
		}
		temp = hand[i];
		hand[i] = hand[max];
		hand[max] = temp;
	}
	for(i = 0; i < 5; i++){
		value[i] = get_value(hand[i]);
		suit[i] = get_suit(hand[i]);
	}
	
	/* straight flush */
	if(value[1] + 1 == value[0] && suit[1] == suit[0]
			&& value[2] + 2 == value[0] && suit[2] == suit[0]
			&& value[3] + 3 == value[0] && suit[3] == suit[0]
			&& value[4] + 4 == value[0] && suit[4] == suit[0])
		result = (9 << 20) + (value[0] << 16);
	/* four card */
	else if(value[0] == value[3] || value[1] == value[4])
		result = (8 << 20) + (value[2] << 16);
	/* full house */
	else if(value[0] == value[2] && value[3] == value[4])
		result = (7 << 20) + (value[0] << 16);
	else if(value[0] == value[1] && value[2] == value[4])
		result = (7 << 20) + (value[2] << 16);
	/* flush */
	else if(suit[1] == suit[0] && suit[2] == suit[0] && suit[3] == suit[0] && suit[4] == suit[0])
		result = (6 << 20) + (value[0] << 16) + (value[1] << 15) + (value[2] << 14) + (value[3] << 13) + (value[4] << 12);
	/* straight */
	else if(value[1] + 1 == value[0]
			&& value[2] + 2 == value[0]
			&& value[3] + 3 == value[0]
			&& value[4] + 4 == value[0])
		result = (5 << 20) + (value[0] << 16);
	/* three card */
	else if(value[0] == value[2]
			|| value[1] == value[3]
			|| value[2] == value[4])
		result = (4 << 20) + (value[2] << 16);
	/* two pair */
	else if(value[0] == value[1] && value[2] == value[3])
		result = (3 << 20) + (value[0] << 16) + (value[2] << 15) + (value[4] << 14);
	else if(value[0] == value[1] && value[3] == value[4])
		result = (3 << 20) + (value[0] << 16) + (value[3] << 15) + (value[2] << 14);
	else if(value[1] == value[2] && value[3] == value[4])
		result = (3 << 20) + (value[1] << 16) + (value[3] << 15) + (value[0] << 14);
	/* one pair */
	else if(value[0] == value[1])
		result = (2 << 20) + (value[0] << 16) + (value[2] << 15) + (value[3] << 14) + (value[4] << 13);
	else if(value[1] == value[2])
		result = (2 << 20) + (value[1] << 16) + (value[0] << 15) + (value[3] << 14) + (value[4] << 13);
	else if(value[2] == value[3])
		result = (2 << 20) + (value[2] << 16) + (value[0] << 15) + (value[1] << 14) + (value[4] << 13);
	else if(value[3] == value[4])
		result = (2 << 20) + (value[3] << 16) + (value[0] << 15) + (value[1] << 14) + (value[2] << 13);
	/* high card */
	else
		result = (1 << 20) + (value[0] << 16) + (value[1] << 15) + (value[2] << 14) + (value[3] << 13) + (value[4] << 12);
	
	return result;
}

int main() {
	char line[1024];
	char* ptr;
	int black[5], white[5];
	long white_hand, black_hand;
	int i;
	
	while (fgets(line, 1024, stdin) != NULL) {
		ptr = line;
		for(i = 0; i < 5; i++){
			black[i] = encode_card(ptr);
			ptr = ptr + 3;
		}
		for(i = 0; i < 5; i++){
			white[i] = encode_card(ptr);
			ptr = ptr + 3;
		}
		white_hand = get_hand_value(white);
		black_hand = get_hand_value(black);
		if(white_hand > black_hand)
			printf("White wins.\n");
		else if(white_hand < black_hand)
			printf("Black wins.\n");
		else if(white_hand == black_hand)
			printf("Tie.\n");
	}
	return 0;
	
}
