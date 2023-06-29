#include <stdio.h>
#define get_value(x) ((x) / 10)
#define get_suit(x) ((x) % 10)
#define n 5

int encord_card(char *card) {
	int result;
	
	switch (card[0]) {
		case 'T' : result = 100; break;
		case 'J' : result = 110; break;
		case 'Q' : result = 120; break;
		case 'K' : result = 130; break;
		case 'A' : result = 140; break;
		default :  result = (card[0] - '0') * 10;
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
	
	//카드 정렬
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
	}
	
	//스트레이트 플러쉬
	if(value[1] + 1 == 	value[0] && suit[1] == suit[0]
		&& value[2] + 2 == value[0] && suit[2] == suit[0]
		&& value[3] + 3 == value[0] && suit[3] == suit[0]
		&& value[4] + 4 == value[0] && suit[4] == suit[0])
		result = (9 << 20) + (value[0] << 16);
	
	//포카드
	else if(value[0] == value[1] && value[1] == value[2]
				 && value[2] == value[3] || value[1] == value[2]
				 && value[2] == value[3] && value[3] == value[4])
		result = (8 << 20) + (value[1] << 16);
	
	//풀 하우스
	else if(value[0] == value[1] && value[2] == value[3]
				 && value[3] == value[4] || value[0] == value[1]
				 && value[1] == value[2] && value[3] == value[4])
		result = (7 << 20) + (value[2] << 16);
	
	//플러쉬
	else if(suit[0] == suit[1] && suit[1] == suit[2]
				 && suit[2] == suit[3] && suit[3] == suit[4])
		result = (6 << 20) + (suit[0] << 16);
	
	//스트레이트
	else if(value[1] + 1 == value[0] && value[2] + 2 == value[0]
				 && value[3] + 3 == value[0] && value[4] + 4 == value[0])
		result = (5 << 20) + (value[0] << 16);
	
	//트리플
	else if(value[0] == value[1] && value[1] == value[2]
				 || value[1] == value[2] && value[2] == value[3]
				 || value[2] == value[3] && value[3] == value[4])
		result = (4 << 20) + (value[2] << 16);
		
	//투페어
	else if(value[0] == value[1] && value[2] == value[3]
				 || value[0] == value[1] && value[3] == value[4]
				 || value[1] == value[2] && value[3] == value[4])
		result = (3 << 20) + (value[1] << 16) + (value[3] << 12) + (value[0] << 8) + (value[2] << 4);
		
	//원페어
	else if(value[0] == value[1] || value[1] == value[2]
				 || value[2] == value[3] || value[3] == value[4])
		result = (2 << 20) + (value[0] << 16) + (value[1] << 12) + (value[2] << 8) + (value[3] << 4) + value[4];
		
	//탑
	else
		result = (1 << 20) + (value[0] << 16) + (value[1] << 12) + (value[2] << 8) + (value[3] << 4) + value[4];
	
	return result;
}

void main() {
	
	char card[n*2][10], *card1[n], *card2[n];
	int i_card1[n], i_card2[n];
	int i, c;
	char line[5000];
	
	while (scanf("%s", card[0]) == 1) {
		card1[0] = card[0];
		for (i = 1; i < n*2; i++) {
			scanf("%s", card[i]);
			if (i >= n)
				card2[i-n] = card[i];
			else 
				card1[i] = card[i];
		}
		
		
		
		for (i = 0; i < n; i++) {
			i_card1[i] = encord_card(card1[i]);
			i_card2[i] = encord_card(card2[i]);
		}
		
		if (get_hand_value(i_card1) > get_hand_value(i_card2)) {
			gets(line);
			printf("Black wins.\n");
		}
		else if (get_hand_value(i_card1) < get_hand_value(i_card2)) {
			gets(line);
			printf("White wins.\n");
		}
		else {
			gets(line);
			printf("Tie.\n");
		}
	}
}
