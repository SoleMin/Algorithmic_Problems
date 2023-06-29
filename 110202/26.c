#include <stdio.h>
#include <stdlib.h>
#define get_value(x) ((x) / 10)
#define get_suit(x) ((x) % 10)

int find_same_int(int value[5]) { // 크기가 5인 정렬된 배열의 1쌍의 같은 숫자의 점수를 반환
	int result;
	for(int i = 0; i < 4; i++) 
		if(value[i] == value[i+1]) {
			result = value[i];
			break;
		}
	return result;
}

int encode_card(char *card) {
	int result;
	
	switch (card[0]) {
		case 'T' : result = 100; break;
		case 'J' : result = 110; break;
		case 'K' : result = 120; break;
		case 'Q' : result = 130; break;
		case 'A' : result = 140; break;
		default : result = (card[0] - '0') * 10; // 1~9면 10 20 30 ..으로 저장
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
	long result; 
	int value[5], suit[5];
	for(i = 0; i < 4; i++) {
		max = i;
		for(j = i+1; j < 5; j++)
			if(hand[j] > hand[max])
				max = j;
		temp = hand[i];
		hand[i] = hand[max];
		hand[max] = temp;
	}
	for(i = 0; i < 5; i++) {
		value[i] = get_value(hand[i]);
		suit[i] = get_suit(hand[i]);
	}
	
	if(value[1] + 1 == value[0] && suit[1] == suit[0]
		&& value[2] + 2 == value[0] && suit[2] == suit[0]
		&& value[3] + 3 == value[0] && suit[3] == suit[0]
		&& value[4] + 4 == value[0] && suit[4] == suit[0]) {
		result = (9 << 20) + (value[0] << 16);
	}
	else if(value[0] == value[1] && value[0] == value[2] && value[0] == value[3]
		|| value[0] == value[2] && value[0] == value[3] && value[0] == value[4]
		|| value[0] == value[1] && value[0] == value[3] && value[0] == value[4]
		|| value[0] == value[1] && value[0] == value[2] && value[0] == value[3]
		|| value[1] == value[2] && value[1] == value[3] && value[1] == value[4]) {
		result = (8 << 20) + (value[2] << 16);
	}
	else if(value[0] == value[1] && value[2] == value[3] && value[2] == value[4]
		|| value[0] == value[1] && value[0] == value[2] && value[3] == value[4]) {
		result = (7 << 20) + (value[2] << 16);
	}
	else if(suit[0] == suit[1] && suit[0] == suit[2] && suit[0] == suit[3] 
					&& suit[0] == suit[4]) {
		result = (6 << 20) + (value[0] << 16);
	}
	else if(value[1] + 1 == value[0] && value[2] + 2 == value[0] 
					&& value[3] + 3 == value[0] && value[4] + 4 == value[0]) {
		result = (5 << 20) + (value[0] << 16);
	}
	else if(value[0] == value[1] && value[0] == value[2] // 쓰리카드
		|| value[1] == value[2] && value[1] == value[3]
		|| value[2] == value[3] && value[2] == value[4]) {
		result = (4 << 20) + (value[2] << 16);
	}
	else if(value[0] == value[1] && value[2] == value[3]) {
		result = (3 << 20) + (find_same_int(value) << 16) + (value[4] << 12);
	}
	else if(value[1] == value[2] && value[3] == value[4]) {
		result = (3 << 20) + (find_same_int(value) << 16) + (value[0] << 12);
	}
	else if(value[0] == value[1] && value[3] == value[4]) {
		result = (3 << 20) + (find_same_int(value) << 16) + (value[2] << 12);
	}
	else if(value[0] == value[1]) {
		result = (2 << 20) + (find_same_int(value) << 16) + (value[2] << 12);
	}
	else if(value[1] == value[2]) {
		result = (2 << 20) + (find_same_int(value) << 16) + (value[0] << 12);
	}
	else if(value[2] == value[3]) {
		result = (2 << 20) + (find_same_int(value) << 16) + (value[0] << 12);
	} 
	else if(value[3] == value[4]) {
		result = (2 << 20) + (find_same_int(value) << 16) + (value[0] << 12);
	}
	else{
		result = 1 << 20;
		for(int i = 0; i < 5; i++)
			result += (value[i] << (20-4*(i+1)));
	}
	return result;
}

int main() {
	char white[5][2];
	char black[5][2];
	int white_hand[5];
	int black_hand[5];
	long white_result;
	long black_result;
	while(scanf("%s %s %s %s %s %s %s %s %s %s", &white[0], &white[1], &white[2], &white[3], &white[4] , &black[0], &black[1], &black[2], &black[3], &black[4]) == 10) {
		for(int i = 0; i < 5; i++) {
			white_hand[i] = encode_card(white[i]);
			black_hand[i] = encode_card(black[i]);
		}
		white_result = get_hand_value(white_hand);
		black_result = get_hand_value(black_hand);
		if(white_result > black_result) 
			printf("Black wins.\n");
		else if(white_result < black_result)
			printf("White wins.\n");
		else 
				printf("Tie.\n");
	}
	return 0;
}
