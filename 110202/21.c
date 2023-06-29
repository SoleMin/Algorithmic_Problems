#include <stdio.h>
#define get_value(x) ((x) / 10)
#define get_suit(x) ((x) % 10)

int encode_card(char *card) {
	int result;
	
	switch (card[0]) {
	case 'T' : result = 100; break;
	case 'J' : result = 110; break;
	case 'Q' : result = 120; break;
	case 'K' : result = 130; break;
	case 'A' : result = 140; break;
	default : result = (card[0] - '0') * 10;
	}
	
	switch (card[1]) {
	case 'H' : result += 1; break;
	case 'D' : result += 2; break;
	case 'S' : result += 3; break;
	case 'C' : result += 4; break;
	}
	
	return result;
}

long get_hand_value(int hand[5]) {
	int i, j, max, temp;
	int value[5], suit[5];
	long result;
	for (i = 0; i < 4; i++) {
		max = i;
		for (j = i + 1; j < 5; j++)
			if (hand[j] > hand[max])
				max = j;
		temp = hand[i];
		hand[i] = hand[max];
		hand[max] = temp;
	}
	
	for (i = 0; i < 5; i++) {
		value[i] = get_value(hand[i]);
		suit[i] = get_suit(hand[i]);
		//printf("%d ", value[i]);
		//printf("%d ", suit[i]);
	}
	
	
	/*straight flush */
	if (value[1] + 1 == value[0] && suit[1] == suit[0]
			&& value[2] + 2 == value[0] && suit[2] == suit[0]
			&& value[3] + 3 == value[0] && suit[3] == suit[0]
			&& value[4] + 4 == value[0] && suit[4] == suit[0])
		result = (9 << 20) + (value[0] << 16);
	
	/*four of a kind */
	else if ((value[1] == value[0] && value[2] == value[0]
					 && value[3] == value[0]) ||
					 (value[2] == value[1] && value[3] == value[1]
					 && value[4] == value[1]))
		result = (8 << 20) + (value[2] << 16);
	
	/*full house */
	else if ((value[1] == value[0] && value[2] == value[0]
					 && value[4] == value[3]) ||
					(value[1] == value[0] && value[3] == value[2]
					 && value[4] == value[2]))
		result = (7 << 20) + (value[2] << 16);
	
	/*flush */
	else if (suit[1] == suit[0] && suit[2] == suit[0]
					&& suit[3] == suit[0] && suit[4] == suit[0])
		result = (6 << 20) + (value[0] << 16);
	
	/*straight */
	else if (value[1] + 1 == value[0] && value[2] + 2 == value[0]
					&& value[3] + 3 == value[0] && value[4] + 4 == value[0])
		result = (5 << 20) + (value[0] << 16);
	
	/*three of a kind */
	else if ((value[1] == value[0] && value[2] == value[0])
					|| (value[2] == value[1] && value[3] == value[1])
					|| (value[3] == value[2] && value[4] == value[2]))
		result = (4 << 20) + (value[2] << 16);
	
	/*two pair */
	else if (value[1] == value[0] && value[3] == value[2])
		result = (3 << 20) + (value[0] << 16)
							+ (value[2] << 12) + (value[4] << 8);
	
	else if (value[1] == value[0] && value[4] == value[3])
		result = (3 << 20) + (value[0] << 16)
							+ (value[3] << 12) + (value[2] << 8);
	
	else if (value[2] == value[1] && value[4] == value[3])
		result = (3 << 20) + (value[1] << 16)
							+ (value[3] << 12) + (value[0] << 8);
	
	/*one pair */
	else if (value[1] == value[0])
		result = (2 << 20) + (value[0] << 16) + (value[2] << 12)
							 + (value[3] << 8) + (value[4] << 4);
	
	else if (value[2] == value[1])
		result = (2 << 20) + (value[1] << 16) + (value[0] << 12)
							 + (value[3] << 8) + (value[4] << 4);
	
	else if (value[3] == value[2])
		result = (2 << 20) + (value[2] << 16) + (value[0] << 12)
							 + (value[1] << 8) + (value[4] << 4);
	
	else if (value[4] == value[3])
		result = (2 << 20) + (value[3] << 16) + (value[0] << 12)
							 + (value[1] << 8) + (value[2] << 4);
	
	/*high card */
	else
		result = (value[0] << 16) + (value[1] << 12)
							 + (value[2] << 8) + (value[3] << 4)
							 + (value[4]);
	
	return result;
	
}

int main (void)
{
	
	int value[5];
	char temp[2];
	long blackResult, whiteResult;
	
	while (~scanf("%s", temp)) {
		
		value[0] = encode_card(temp);
		
		for (int j = 1; j < 5; j++) {
			scanf("%s", temp);
			value[j] = encode_card(temp);
			//printf("%d ", value[j]);
		}
		blackResult = get_hand_value(value);
		
		
		
		for (int j = 0; j < 5; j++) {
			scanf("%s", temp);
			value[j] = encode_card(temp);
			//printf("%d ", value[j]);
		}
		whiteResult = get_hand_value(value);
		
		
		if (blackResult > whiteResult)
			printf("Black wins.\n");
		else if (blackResult < whiteResult)
			printf("White wins.\n");
		else
			printf("Tie.\n");
	}
}