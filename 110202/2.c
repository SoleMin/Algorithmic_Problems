#include <stdio.h>
#define get_value(x) ((x) / 10)
#define get_suit(x) (x % 10)

int encode_card(char *card){
	int result;
	switch(card[0]){
		case 'T' : result = 100; break;
		case 'J' : result = 110; break;
		case 'Q' : result = 120; break;
		case 'K' : result = 130; break;
		case 'A' : result = 140; break;
		default : result = (card[0] - '0') * 10;	
	}
	switch(card[1]){
		case 'H' : result += 1; break;
		case 'D' : result += 2; break;
		case 'S' : result += 3; break;
		case 'C' : result += 4; break;
	}
	return result;
}

long get_hand_value(int hand[5]){
	int i, j, max, temp;
	int same_one=9999, same_two=9999;
	int dif[3]={9999, 9999, 9999};
	int value[5], suit[5];
	long result;
	for(i=0;i<4;i++){
		max=i;
		for(j=i+1;j<5;j++)
			if(hand[j] > hand[max])
				max = j;
		temp = hand[i];
		hand[i] = hand[max];
		hand[max] = temp;
	}
	for(i = 0; i<5; i++){
		value[i] = get_value(hand[i]);
		suit[i] = get_suit(hand[i]);
	}
	
	/* 스트레이트 플러시 */
	if (value[1] + 1 == value[0] && suit[1] == suit[0]
		 && value[2] + 2 == value[0] && suit[2] == suit[0]
		 && value[3] + 3 == value[0] && suit[3] == suit[0]
		 && value[4] + 4 == value[0] && suit[4] == suit[0]){
		result = (9<<20) + (value[0] << 16);
		return result;
	}
	/*포카드*/
	if((value[0] == value[1] && value[0] == value[2] && value[0] ==value[3])
		||(value[4] == value[1] && value[4] == value[2] && value[4] ==value[3])){
		result = (8<<20) + (value[1]<<16);
		return result;
	}
	/*풀하우스*/
	if((value[0] == value[1]  && value[0] == value[2] && value[3] == value[4])
		|| (value[0] == value[1] && value[4] == value[2] && value[4] == value[3])
		|| (value[0] == value[4] && value[2] == value[1] && value[2] == value[3])){
		result = (7<<20) + (value[2]<<16);
		return result;
	}
	/*플러시*/
	if(suit[0] == suit[1] && suit[0] == suit[2]
		 && suit[0] == suit[3] && suit[0] == suit[4]){
		result = (6<<20) + (value[0]<<16) + (value[1]<<12) + (value[2]<<8) + (value[3]<<4) + value[4];
		return result;
	}
	/*스트레이트*/
	if(value[1]+1 == value[0] && value[2]+2 == value[0] 
		 && value[3]+3 == value[3] && value[4]+4 == value[4]){
		result = (5<<20) + (value[0]<<16);
		return result;
	}
	/*쓰리카드*/
	if((value[0] == value[1] && value[0] == value[2])
		|| (value[4] == value[2] && value[4] == value[3])
		|| (value[2] == value[1] && value[2] == value[3])){
		result = (4<<20) + (value[2]<<16);
		return result;
	}
	/*투페어*/
	if((value[0] == value[1] && value[2] == value[3])
		 || (value[0] == value[1] && value[3] == value[4])){
		if(value[2] == value[3])
			result = (3<<20) + (value[0]<< 16) + (value[2]<<12) + (value[4]<<8);
		else if(value[3] == value[4])
			result = (3<<20) + (value[0]<<16) + (value[3]<<12) + (value[2]<<8);
		return result;
	}
	if(value[1] == value[2] && value[3] == value[4]){
		result = (3<<20) + (value[1]<<16) + (value[3]<<12) + (value[0]<<8);
		return result;
	}
	/*원페어*/
	for(i=0;i<4;i++){
		for(j=(i+1);j<5;j++){
			if(value[i] == value[j]){
				same_one = i;
				same_two = j;
			}
		}
	}
	if(same_one != 9999){
		for(i=0;i<5;i++){
			for(j=0;j<3;j++){
				if(value[i] != value[same_one] || value[i] != value[same_two])
					dif[j] = i;
			}
		}
		result = (2<<20) + (value[same_one]<<16) + (value[dif[0]]<<12) + (value[dif[1]]<<8) + (value[dif[2]]<<4);
		return result;
	}
	/*하이카드*/
	result = (1<<20) + (value[0]<<16) + (value[1]<<12) + (value[2]<<8) + (value[3]<<4) + value[4];
	return result;
}

int main() {
	int black_hand[5], white_hand[5];
	int i, j, bl_co=0, wt_co=0;
	long bl_re, wt_re;
	char o_card[2];
	
	for(;scanf("%s", o_card) == 1;){
		if(bl_co<5){
			black_hand[bl_co] = encode_card(o_card);
			bl_co++;
		}
		else if(bl_co==5 && wt_co<5){
			white_hand[wt_co] = encode_card(o_card);
			wt_co++;
		}
		if(bl_co == 5 && wt_co == 5){
			bl_re = get_hand_value(black_hand);
			wt_re = get_hand_value(white_hand);
			
			if(bl_re > wt_re){
				printf("Black wins.\n");
			}
			else if(bl_re < wt_re){
				printf("White wins.\n");
			}
			else{
				printf("Tie.\n");
			}
			bl_co = 0;
			wt_co = 0;
		}		
	}
	
	return 0;
}
