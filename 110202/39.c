# include <stdio.h>
# define get_value(x) ((x) / 10)
# define get_suit(x) ((x) % 10)
# define MAX_INPUT (30)


int encode_card(char* card) {	// 카드를 숫자로 인코딩, 방법이 섹시하다.
	int result;
	
	switch (card[0]) {
		case 'T' : result = 100; break;
		case 'J' : result = 110; break;
		case 'Q' : result = 120; break;
		case 'K' : result = 130; break;
		case 'A' : result = 140; break;
		default: result = (card[0] - '0') * 10;
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
	
	/*손 패 정렬*/
	for (i = 0; i < 4; i++){
		max = i;
		for (j = i + 1; j < 5; j++){
			if (hand[j] > hand[max]){
				max = j;
			}
		}
		temp = hand[i];
		hand[i] = hand[max];
		hand[max] = temp;
	}
	/*손 패 정렬*/
	
	/*값과 문양 담아두기*/
	for (i = 0; i < 5; i++){
		value[i] = get_value(hand[i]);
		suit[i] = get_suit(hand[i]);
	}
	/*값과 문양 담아두기*/
	
	/***result의 저장 방식***/
	/*
	result에는 손 패에 따라서 어떠한 정수 값들이 들어가게 된다.
	
	포커에 대해서 생각해보자.
	포커는 우선 적으로 족보를 가지고 싸움을 겨루고, 그 다음에는 문양, 그 후에는 하이 카드로 승부를 본다.
	하지만 문제에 조건에서는 족보와, 하이카드를 고려하는 식으로 되어있다.
	
	그렇기에 원래는 더 세분화 되어야 할 과정들을 조금은 줄일 수 있다.
	
	그렇기의 값의 저장 방식은 이러하다.
	
	만족하는 족보에 따라서 등급에 해당 하는 value를 넣어준다.
	그 후에 하이카드에 대한 value를 넣어준다.
	
	Integer는 4비트를 차지한다. 그리고 손패는 5개이다.
	그렇기에 우리는 이와 같은 순서로 비트에 값을 저장한다.
	
	족보(4비트)+카드1(4비트)+카드2(4비트)+카드3(4비트)+카드4(4비트)+카드5(4비트)
	
	그리고 우리는 카드를 높은 순대로 내림차순 정리하였으므로 카드에 대한 값들은 높은 순으로 기입하면 된다.
	총 24비트의 값을 반환하여 손패의 가치를 계산하는 것이다.
	
	족보는 특수 족보가 없는 포커이므로 하이카드~스트레이트 플러시 까지 총 9단계다.
	*/
	
	
	/*스트레이트 + 플러시(5장이 연속된 숫자 + 5장이 같은 문양*/
	if (value[1] + 1 == value[0] && suit[1] == suit[0] &&
	    value[2] + 2 == value[0] && suit[2] == suit[0] &&
	    value[3] + 3 == value[0] && suit[3] == suit[3] &&
		value[4] + 4 == value[0] && suit[4] == suit[4]) {
		
		result = (9 << 20) + (value[0] << 16);
	}
	/*스트레이트 플러시*/
	
	/*포카드(4장이 숫자가 같음)*/
	else if (value[0] == value[3] || value[1] == value[4]) {	//카드가 정렬 되어 있음을 기억하자
		result = (8 << 20) + (value[0] << 16);
	}
	/*포카드*/
	
	/*풀 하우스(숫자가 같은 카드 2장 + 숫자가 같은 카드 3장)*/
	else if (value[0] == value[2] && value[3] == value[4]) {
		result = (7 << 20) + (value[0] << 16);
	}
	// 하이카드는 3장 쪽 카드로 판단한다. 풀 하우스는 2개의 경우가 나오니 둘 다 처리해준다.
	else if (value[0] == value[1] && value[2] == value[4]) {
		result = (7 << 20) + (value[2] << 16);
	}
	/*풀 하우스*/
	
	/*플러시 (5장의 문양이 같음)*/
	else if (suit[1] == suit[0] && suit[2] == suit[0] &&
			 suit[3] == suit[0] && suit[4] == suit[0]) {
		result = (6 << 20) + (value[0] << 16) + (value[1] << 12) + (value[2] << 8) + (value[3] << 4) + value[4];
	}
	/*플러시*/
	
	/*스트레이트(5장이 연속된 숫자)*/
	else if (value[1] + 1 == value[0] && value[2] + 2 == value[0] &&
			 value[3] + 3 == value[0] && value[4] + 4 == value[0]) {
		result = (5 << 20) + (value[0] << 16);
	}
	/*스트레이트*/
	
	/*트리플(숫자 같은 카드 3장)*/
	else if (value[0] == value[2] || value[1] == value[3] || value[2] == value[4]) {
		result = (4 << 20) + (value[2] << 16);
	}
	/*트리플*/
	
	/*투페어(숫자 같은 카드 2장 2쌍)*/
	else if (value[0] == value[1] && value[2] == value[3]) {
		result = (3 << 20) + (value[0] << 16) + (value[2] << 12) + (value[4] << 8);
	}
	else if (value[0] == value[1] && value[3] && value[4]) {
		result = (3 << 20) + (value[0] << 16) + (value[3] << 12) + (value[2] << 8);
	}
	else if (value[1] == value[2] && value[3] == value[4]) {
		result = (3 << 20) + (value[1] << 16) + (value[3] << 12) + (value[0] << 8);
	}
	/*투페어*/
	
	/*원페어(숫자 같은 카드 2장 1쌍)*/
	else if (value[0] == value[1]) {
		result = (2 << 20) + (value[0] << 16) + (value[2] << 12) + (value[3] << 8) + (value[4] << 4);
	}
	else if (value[1] == value[2]) {
		result = (2 << 20) + (value[1] << 16) + (value[0] << 12) + (value[3] << 8) + (value[4] << 4);
	}
	else if (value[2] == value[3]) {
		result = (2 << 20) + (value[2] << 16) + (value[0] << 12) + (value[1] << 8) + (value[4] << 4);
	}
	else if (value[3] == value[4]) {
		result = (2 << 20) + (value[3] << 16) + (value[0] << 12) + (value[1] << 8) + (value[2] << 4);
	}
	/*원페어*/
	
	/*탑(족보 없음)*/
	else {
		result = (1 << 20) + (value[0] << 16) + (value[1] << 12) + (value[2] << 8) + (value[3] << 4) + value[4];
	}
	/*탑*/
}

int main() {
	
	char input[MAX_INPUT];
	
	int black_hand[5] = {0, };
	int white_hand[5] = {0, };
	
	long black_hand_value = 0;
	long white_hand_value = 0;
	
	int input_index = 0;
	int hand_index = 0;
	
	while(gets(input) != NULL){	
		
		input_index = 0;
		
		for(hand_index = 0; hand_index < 5; hand_index++) {
			if(input[input_index] == ' '){
				input_index++;
			}
			
			black_hand[hand_index] = encode_card(input + input_index);
			white_hand[hand_index] = encode_card(input + input_index + 15);
			
			input_index += 2;
		}
		
		black_hand_value = get_hand_value(black_hand);
		white_hand_value = get_hand_value(white_hand);
		
		//printf("black => %d\n", black_hand_value);
		//printf("white => %d\n", white_hand_value);
		
		if (black_hand_value > white_hand_value) {
			printf("Black wins.\n");
		}
		else if (black_hand_value < white_hand_value) {
			printf("White wins.\n");
		}
		else {
			printf("Tie.\n");
		}
	} // EOW
	
	
	return 0;
}
