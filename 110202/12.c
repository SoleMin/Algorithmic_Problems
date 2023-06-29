#include <stdio.h>
#define get_value(x) ((x) / 10)
#define get_suit(x) ((x) % 10)

int encode_card(char *card);
long get_hand_value(int hand[5]);

int main() {
	int i;
	char input[2];
	int b_hand[5], w_hand[5];
	long b_result, w_result;
	
	while(scanf("%s",input) == 1){
		
		b_hand[0] = encode_card(input);
		
	for(i=1;i<5;i++){
		scanf("%s",input);
		b_hand[i] = encode_card(input);
	}
	for(i=0;i<5;i++){
		scanf("%s",input);
		w_hand[i] = encode_card(input);
	}
	
	b_result = get_hand_value(b_hand);
	w_result = get_hand_value(w_hand);

	if(b_result > w_result)
		printf("Black wins.\n");
		
	else if(w_result > b_result)
		printf("White wins.\n");

	else
			printf("Tie.\n");
		
	}
	
	return 0;
}

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
	
	for (i=0; i<4; i++){
		max = i;
		for(j = i + 1; j < 5; j++)
			if (hand[j] > hand[max])
				max = j;
		temp = hand[i];
		hand[i] = hand[max];
		hand[max] = temp;
	} //hand[i]를 크기순 정렬
	
	for (i = 0; i < 5; i++){
		value[i] = get_value(hand[i]);
		suit[i] = get_suit(hand[i]);
	}
	 
	/* straight flush */
	if (value[1] + 1 == value[0] && suit[1] == suit[0]
			&& value[2] + 2 == value[0] && suit[2] == suit[0]
			&& value[3] + 3 == value[0] && suit[3] == suit[0]
			&& value[4] + 4 == value[0] && suit[4] == suit[0])
		result = (9 << 20) + (value[0] << 16);
		
	
	// four card x
	else if (value[0] == value[3] 
					 || value[1] == value[4] 
					  )
		result = (8 << 20) + (value[2] << 16);
	
	// full house x
	else if (value[0] == value[2]
					&& value[3] == value[4]
					)
		result = (7 << 20) + (value[0] << 16);
		
	else if (value[4] == value[3]
						&& value[4] == value[2]
						&& value[1] == value[0])
		result = (7 << 20) + (value[2] << 16);
	
	//flush 하이카드 value[0] >> 20 하면 6 나오는걸 if 로 줌
	else if (suit[0] == suit[1]
					&& suit[0] == suit[2]
					&& suit[0] == suit[3]
					&& suit[0] == suit[4])
		result = (6 << 20) + (value[0] << 16) + (value[1] << 12) + (value[2] << 8) + (value[3] << 4) + value[4];//하이카드 적용 result를 리턴하는거니까 하이카드 적용하는 케이스는 result 값을 특이하게 하면 될거같음
	
	//straight
	else if (value[0] == value[1] + 1 
					&& value[1] == value[2] + 1
					&& value[2] == value[3] + 1
					&& value[3] == value[4] + 1)
		result = (5 << 20) + (value[0] << 16);
	
	//three card
	else if (
		(value[0] == value[2])
		||
		(value[1] == value[3])
		||
		(value[2] == value[4])
					)
		result = (4 << 20) + (value[2] << 16);
	
	// two pare 특수케이스
	else if (value[0] == value[1] && value[2] == value[3])
		result = (3 << 20) + (value[1] << 16) + (value[3] << 12) + (value[4] << 8);
	else if (value[0] == value[1] && value[3] == value[4])
		result = (3 << 20) + (value[1] << 16) + (value[3] << 12) + (value[2] << 8);
	else if (value[1] == value[2] && value[3] == value[4])
		result = (3 << 20) + (value[1] << 16) + (value[3] << 12) + (value[0] << 8);
		
	//one pare 하이 카드
	else if(value[0] == value[1])
		result = (2 << 20) + (value[0] << 16) + (value[2] << 12) + (value[3] << 8) + (value[4] << 4);
	
	else if(value[1] == value[2])
		result = (2 << 20) + (value[1] << 16) + (value[0] << 12) + (value[3] << 8) + (value[4] << 4);
	
	else if(value[2] == value[3])
		result = (2 << 20) + (value[2] << 16) + (value[0] << 12) + (value[1] << 8) + (value[4] << 4);
	
	else if(value[3] == value[4])
		result = (2 << 20) + (value[3] << 16) + (value[0] << 12) + (value[1] << 8) + (value[2] << 4) ;
	
	else
		result = (1 << 20) + (value[0] << 16) + (value[1] << 12) + (value[2] << 8) + (value[3] << 4) + value[4];
	
	return result;
	
}















