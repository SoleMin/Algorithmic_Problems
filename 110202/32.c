#include <stdio.h>
#define get_value(x) ((x) / 10)
#define get_suit(x) ((x) % 10)

int encode_card(char *card){
	int result;
	
	switch (card[0]) {
		case 'T': result = 100; break;
		case 'J': result = 110; break;
		case 'Q': result = 120; break;
		case 'K': result = 130; break;
		case 'A': result = 140; break;
		default: result = (card[0] - '0') * 10;
	}
	switch (card[1]) {
		case 'H': result += 1; break;
		case 'D': result += 2; break;
		case 'S': result += 3; break;
		case 'C': result += 4; break;
	}
	return result;
}

long get_hand_value(int hand[5]) {
	int i, j, max, temp;
	int value[5], suit[5];
	long result;
	for(i = 0; i < 4; i++) {
		max = i;
		for (j = i + 1; j < 5; j++)
			if (hand[j] > hand[max])
				max = j;
		temp = hand[i];
		hand[i] = hand[max];
		hand[max] = temp;
	}
	
	for ( i = 0; i < 5; i++) {
		value[i] = get_value(hand[i]);
		suit[i] = get_suit(hand[i]);
	}
	// 스트레이트 플러시
	if (value[1] + 1 == value[0] && suit[1] == suit[0] && value[2] + 2 == value[0] && suit[2] == suit[0] && value[3] + 3 == value[0] && suit[3] == suit[0] && value[4] + 4 == value[0] && suit[4] == suit[0])
		result = (9 << 20) + (value[0] << 16);
	
	// 포카드 정렬된 상태이므로 1~4번째 카드 값 동일, 2~5번째 카드 값 동일한지 확인
	else if ((value[0] == value[1] && value[1] == value[2] && value[2] == value[3]) || (value[1] == value[2] && value[2] == value[3] && value[3] == value[4]))
		result = (8 << 20) + (value[2] << 16);
	
	// 풀 하우스 1~3번째 카드 값 동일 / 4~5번째 카드값 동일.
	else if (value[0] == value[1] && value[1] == value[2] && value[3] == value[4])
		result = (7 << 20) + (value[0] << 16);
	// 풀 하우스 1~2번째 카드 값 동일/ 3~5번째 카드값 동일.
	else if (value[0] == value[1] && value[2] == value[3] && value[3] == value[4])
		result = (7 << 20) + (value[2] << 16);
	
	// 플러시
	else if (suit[0] == suit[1] && suit[1] == suit[2] && suit[2] == suit[3] && suit[3] == suit[4])
		result = (6 << 20) + (value[0] << 16);
	
	// 스트레이트
	else if (value[1]+1 == value[0] && value[2] + 2 == value[0] && value[3] + 3 == value[0] && value[4] + 4 == value[0])
		result = (5 << 20) + (value[0] << 16);
	
	// 쓰리 카드 1~3번째 카드값 동일 or 2~4번째 카드값 동일 or 3~5번째 카드값 동일
	else if (value[0] == value[1] && value[1] == value[2])
		result = (4 << 20) + (value[0] << 16);
	else if (value[1] == value[2] && value[2] == value[3])
		result = (4 << 20) + (value[1] << 16);
	else if (value[2] == value[3] && value[3] == value[4])
		result = (4 << 20) + (value[2] << 16);
	
	// 투 페어 1-2번째 카드 동일 & 4-5번째 카드 동일
	else if (value[0] == value[1] && value[3] == value[4])
		result = (3 << 20) + (value[0] << 16) + (value[3] << 12);
	
	// 원 페어 1-2번째카드값동일 or 2-3번째카드값동일 or 3-4번째카드값동일 or 4-5번째카드값동일
	else if (value[0] == value[1])
		result = (2 << 20) + (value[0] << 16) + (value[2] << 12) + (value[3] << 8) + (value[4] << 4);
	else if (value[1] == value[2])
		result = (2 << 20) + (value[1] << 16) + (value[0] << 12) + (value[3] << 8) + (value[4] << 4);
	else if (value[2] == value[3])
		result = (2 << 20) + (value[2] << 16) + (value[0] << 12) + (value[1] << 8) + (value[4] << 4);
	else if (value[3] == value[4])
		result = (2 << 20) + (value[3] << 16) + (value[0] << 12) + (value[1] << 8) + (value[2] << 4);
	
	// 하이 카드
	else
		result = (1 << 20) + (value[0] << 16) + (value[1] << 12) + (value[2] << 8) + (value[3] << 4) + (value[4]);

	return result;
}

int main(){
	char handBW[50]; // 검정과 하양 패를 다 받는 문자열.
	char temp[2];  //카드 한장 저장하는 임시 변수.
	long handV[2]; 
	int hand[2][5]; // 문자열 카드를 숫자로 저장.
	int idx; // 문자열에서 카드를 읽기 위한 변수.
	
	while(fgets(handBW,sizeof(handBW), stdin) != NULL) {
		idx = 0;
		
			for( int i = 0; i < 2; i++){
				for(int j = 0; j < 5; j++){
					while (handBW[idx] == ' ')
						idx++;
					sscanf(handBW + idx, "%s", &temp); // 문자열에서 해당 카드만 추출한다.
					hand[i][j] = encode_card(temp); //정수로 카드 변환.
					idx += 2; 
				}
			}
			
		
		for (int i = 0; i < 2; i++){
			handV[i] = get_hand_value(hand[i]);
		}
		
		if (handV[0] > handV[1])
			printf("Black wins.\n");
		else if (handV[0] < handV[1])
			printf("White wins.\n");
		else
			printf("Tie.\n");
	}
	return 0;
}
	
