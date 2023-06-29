#include <stdio.h>
#include <string.h>

int encode_card(char *card){
	int result;
	
	switch(card[0]){
		case 'T': result = 100; break;
		case 'J': result = 110; break;
		case 'Q': result = 120; break;
		case 'K': result = 130; break;
		case 'A': result = 140; break;
		default: result = (card[0] - '0')*10;
	}
	switch(card[1]){
		case 'H': result +=1; break;
		case 'D': result +=2; break;
		case 'S': result +=3; break;
		case 'C': result +=4; break;
	}
	return result;
}
//2 6 7 4 3
void sort(int hand[5]){
	
	int i, j, temp;
	for(i = 0; i < 5; i++){
		for(j =0; j< 4; j++)
			if(hand[j] <hand[j+1]){
				temp = hand[j];
				hand[j] = hand[j+1];
				hand[j+1] = temp;
			}
		
	}
}
long get_hand_value(int hand[5]){
	int i;
	int value[5], suit[5];
	long result =0;
	
	sort(hand); // 정렬, 14 13 12 11 10 이런식으로 저장
	
	
	for(i = 0; i < 5; i++){
		value[i] = ((hand[i])/10); // 숫자(2~ A) , 저장값은 2,3,4... 11,12,13,14
		suit[i] = ((hand[i])%10);  // 카드(D, H, S, C)
	}
	
	// 스트레이트 플러쉬
	if(value[1] + 1 == value[0] && suit[1] == suit[0] && 
		 value[2] + 2 == value[0] && suit[2] == suit[0] &&
		 value[3] + 3 == value[0] && suit[3] == suit[0] &&
		 value[4] + 4 == value[0] && suit[4] == suit[0])
		result = value[0] *10 +9;
	// 포카트
	else if(value[0] == value[3] || value[1] == value[4])
		result = value[1]*10 +8;
	//풀 하우스
	else if(value[0] == value[1] && value[2]== value[4])// 2장 3장
		result = value[2]*10+7;
	else if(value[0] == value[2] && value[3] ==value[4])//3장2장정렬이므로이넘이더큼
		result =value[0]*10 +7;
	//플러시
	else if(suit[0] == suit[1]&& suit[0] == suit[2]&&
				  suit[0] == suit[3] && suit[0] == suit[4])
		result = value[0]*10 +6;
	//스트레이트
	else if(value[0] == value[1]+1 && value[0] == value[2]+2 &&
				  value[0] == value[3]+3 && value[0] == value[4]+4)
		result = value[0] *10 +5;
	//쓰리카드
	else if(value[0] == value[2] || value[1] == value[3] || value[2] == value[4])
		result = value[2]*10 +4;
	//투 페어
	else if(value[0] == value[1] && value[2] == value[3])
		result = value[1]*10 +3;
	else if(value[0] == value[1] && value[3] == value[4])
		result = value[1]*10 +3;
	else if(value[1] == value[2] && value[3] == value[4])
		result = value[1]*10+3;
	//원페어
	else if(value[0] == value[1])
		result = value[0] *10 +2;
	else if(value[0] == value[2])
	 	result = value[0] *10 +2;
	else if(value[0] == value[3])
		result = value[0] *10 +2;
	else if(value[0] == value[4])
		result = value[0] *10 +2;
	else if(value[1] == value[2])
		result = value[1] *10 +2;
	else if(value[1] == value[3])
		result = value[1] *10+2;
	else if(value[1] == value[4])
		result =  value[1] *10 +2;
	else if(value[2] == value[3])
		result = value[2]*10 +2;
	else if(value[2] == value[4])
		result =value[2]*10+ 2;
	else if (value[3] == value[4])
		result = value[3]*10+2;
	else{
		result = value[0]*10 +1;
	}
	
	return result;
}
int main() {
	int i, j, count;
	char card[1000]; 
	int hand[10][5];
	char *ptr;
	long hand_value[2];
	long temp1, temp2;
	
	while(fgets(card, 100, stdin) != NULL){
		
		ptr = strtok(card, " ");
		for(i = 0; i < 2; i++){
			count =0;
			while(count != 5){
				hand[i][count] = encode_card(ptr);
				ptr= strtok(NULL, " ");
				count++;
			}
			hand_value[i] = get_hand_value(hand[i]);
		}
	
		
		
		if(hand_value[0]%10 > hand_value[1]%10)
			printf("Black wins.\n");
		else if(hand_value[0]%10 < hand_value[1]%10)
			printf("White wins.\n");
		else{
			
			if(hand_value[0]/10 > hand_value[1]/10)
				printf("Black wins.\n");
			else if(hand_value[0]/10 < hand_value[1]/10)
				printf("White wins.\n");
			else{
				printf("Tie.\n");
			}
				
			
		}
			
		
		
	}
	
}
