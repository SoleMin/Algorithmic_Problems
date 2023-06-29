#include <stdio.h>

int encode_card(char *card){
	int result;
	switch(card[0]){
		case 'T':
			result = 100; break;
		case 'J':
			result = 110; break;
		case 'Q':
			result = 120; break;
		case 'K':
			result = 130; break;
		case 'A':
			result = 140; break;
		default:
			result = (card[0] - '0')*10;
	}
	switch(card[1]){
		case 'C':
			result += 1; break;
		case 'D':
			result += 2; break;
		case 'H':
			result += 3; break;
		case 'S':
			result += 4; break;
	}
	return result;
}

long get_hand_value(int hand[5]){
	int max, temp;
	int value[5], suit[5];
	long result;
	for(int i=0; i<4; i++){
		max = i;
		for(int j=i+1; j<5; j++){
			if(hand[j] > hand[max])
				max = j;
		}
		temp = hand[i];
		hand[i] = hand[max];
		hand[max] = temp;
	}
	for(int i=0; i<5; i++){
		value[i] = hand[i]/10;
		suit[i] = hand[i]%10;
	}
	
	if(value[1]+1==value[0] && suit[1]==suit[0] && value[2]+2==value[0] && suit[2]==suit[0] && value[3]+3==value[0] && suit[3]==suit[0] && value[4]+4==value[0] && suit[4]==suit[0])
		result = (9 << 20) + (value[0] << 16);
	else if(value[1]==value[2] && value[2]==value[3] && (value[0]==value[1] || value[3]==value[4]))
		result = (8 << 20) + (value[2] << 16);
	else if(value[0]==value[1] && value[3]==value[4] && (value[2]==value[1] || value[2]==value[3]))
		result = (7 << 20) + (value[2] << 16);
	else if(suit[0]==suit[1] && suit[0]==suit[2] && suit[0]==suit[3] && suit[0]==suit[4])
		result = (6 << 20) + (value[0] << 16) + (value[1] << 12) + (value[2] << 8) + (value[3] << 4) + value[4];
	else if(value[1]+1==value[0] && value[2]+2==value[0] && value[3]+3==value[0] && value[4]+4==value[0])
		result = (5 << 20) + (value[0] << 16);
	else if((value[0]==value[1] && value[1]==value[2]) || (value[1]==value[2] && value[2]==value[3]) || (value[2]==value[3] && value[3]==value[4]))
		result = (4 << 20) + (value[2] << 16);
	else if(value[0]==value[1] && value[2]==value[3])
		result = (3 << 20) + (value[1] << 16) + (value[3] << 12) + (value[4] << 8);
	else if(value[0]==value[1] && value[3]==value[4])
		result = (3 << 20) + (value[1] << 16) + (value[3] << 12) + (value[2] << 8);
	else if(value[1]==value[2] && value[3]==value[4])
		result = (3 << 20) + (value[1] << 16) + (value[3] << 12) + (value[0] << 8);
	else if(value[0]==value[1])
		result = (2 << 20) + (value[0] << 16) + (value[2] << 12) + (value[3] << 8) + (value[4] << 4);
	else if(value[1]==value[2])
		result = (2 << 20) + (value[1] << 16) + (value[0] << 12) + (value[3] << 8) + (value[4] << 4);
	else if(value[2]==value[3])
		result = (2 << 20) + (value[2] << 16) + (value[0] << 12) + (value[1] << 8) + (value[4] << 4);
	else if(value[3]==value[4])
		result = (2 << 20) + (value[3] << 16) + (value[0] << 12) + (value[1] << 8) + (value[2] << 4);
	else
		result = (1 << 20) + (value[0] << 16) + (value[1] << 12) + (value[2] << 8) + (value[3] << 4) + value[4];
	
	return result;
}

int main() {
	char card[2];
	
	while(scanf("%s", card) == 1){
		int black[5], white[5];
		black[0] = encode_card(card);
		for(int i=1; i<5; i++){
			scanf("%s", card);
			black[i] = encode_card(card);
		}
		for(int i=0; i<5; i++){
			scanf("%s", card);
			white[i] = encode_card(card);
		}
		if(get_hand_value(black) > get_hand_value(white))
			printf("Black wins.\n");
		else if(get_hand_value(black) < get_hand_value(white))
			printf("White wins.\n");
		else
			printf("Tie.\n");
	}
	
	return 0;
}
