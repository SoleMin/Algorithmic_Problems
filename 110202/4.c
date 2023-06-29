#include <stdio.h>
#define get_value(x) ((x) / 10)
#define get_suit(x) ((x) % 10)
int encode_card(char *card){
	int result;
	
	switch(card[0]){
		case 'T' : result = 100;break;
		case 'J' : result = 110;break;
		case 'Q' : result = 120;break;
		case 'K' : result = 130;break;
		case 'A' : result = 140;break;
		default : result = (card[0] - '0')*10;
	}
	switch(card[1]){
		case 'H' : result += 1;break;
		case 'D' : result += 2;break;
		case 'S' : result += 3;break;
		case 'C' : result += 4;break;
	}
	return result;
	
}

long get_hand_value (int *hand){
	int i, j, max, temp;
	int value[5], suit[5];
	long result;
	for( i =0; i<4; i++){
		max=i;
		for(j= i+1;j<5;j++)
			if(hand[j] > hand[max])
				max=j;
		temp = hand[i];
		hand[i] = hand[max];
		hand[max] = temp;
	}
	for( i=0;i<5;i++){
		value[i] = get_value(hand[i]);
		suit[i] = get_suit(hand[i]);
	}
	/*straight flush*/
	if(value[1] + 1 == value[0] && suit[1] == suit[0]
		&& value[2] + 2 == value[0] && suit[2] == suit[0] 
		&& value[3] + 3 == value[0] && suit[3] == suit[0]
		&& value[4] + 4 == value[0] && suit[4] == suit[0])
		result = (9 << 20) + (value[0] << 16); 
	
	/*four card*/
	else if(value[0] == value[1] && value[1] == value[2]
		&&value[2] == value[3])
		 result =(8 << 20) + (value[0] << 16);
	else if(value[1]==value[2] && value[2] == value[3]
		&& value[3] == value[4])
		result = (8 << 20) + (value[1] << 16);
		
	/*full house*/
	else if(value[0]==value[1] && value[1]==value[2]
		&& value[3]==value[4])
		result = (7 << 20) + (value[0] << 16);
	else if(value[0]==value[1] && value[2]==value[3]
				 && value[3] == value[4])
		result = (7 << 20) + (value[2] << 16);
	
	/*fulsh*/
	else if(suit[0] == suit[1] && suit[0] == suit[2]
		&& suit[0] == suit[3] && suit[0] == suit[4]
		&& !(value[1]+1 == value[0] && value[2]+2 == value[0]
				&& value[3]+3 == value[0] && value[4]+4 == value[0]))
		result = (6 << 20) + (value[0] << 16);
	
	/*straight*/
	else if(value[1]+1 == value[0] && value[2]+2 == value[0]
		&&value[3]+3 == value[0] && value[4]+4 == value[0]
		&& !(suit[0] == suit[1] && suit[1] == suit[2]
				&& suit[2] == suit[3] && suit[3] == suit[4]
				&& suit[4] == suit[5]))
		result = (5 << 20) + (value[0] << 16);
	
	/*three card*/
	else if(value[1] == value[2] && value[2] == value[3])
		result = (4 << 20) + (value[1] << 16);
	else if(value[0] == value[1] && value[1] == value[2] 
				 && value[2] != value[3] && value[3] != value[4])
		result = (4 << 20) + (value[0] << 16);
	else if(value[2] == value[3] && value[3] == value[4]
				 && value[0] != value[1] && value[1] != value[2])
		result = (4 << 20) + (value[2] << 16);
	
	/* two pair*/
	else if(value[0] == value[1] && value[1] != value[2]
		&& value[2] == value[3] && value[3] != value[4])
		result = (3 << 20) + (value[0] << 16) + (value[2] << 12) + (value[4] << 8);
	else if(value[0] == value[1] && value[1] != value[2]
				 && value[2] != value[3] && value[3] == value[4])
		result = (3 << 20) + (value[0] << 16) + (value[3] << 12) + (value[2] << 8);
	else if(value[0] != value[1] && value[1] == value[2]
				 && value[2] != value[3] && value[3] == value[4])
		result = (3 << 20) + (value[1] << 16) + (value[3] << 12) + (value[0] << 8);
	
	/* one pair */
	else if(value[0] == value[1] && value[1] != value[2]
		&& value[2] != value[3] && value[3] != value[4])
		result = (2 << 20) + (value[0] << 16) + (value[2] << 12) + (value[3] << 8) + (value[4] << 4);
	else if(value[0] != value[1] && value[1] == value[2] 
		&& value[2] != value[3] && value[3] != value[4])
		result = (2 << 20) + (value[1] << 16) + (value[0] << 12) + (value[3] << 8) + (value[4] << 4);
	else if(value[0] != value[1] && value[1] != value[2]
				 && value[2] == value[3] && value[3] != value[4])
		result = (2 << 20) + (value[2] << 16) + (value[0] << 12) + (value[1] << 8) + (value[4] << 4);
	else if(value[0] != value[1] && value[1] != value[2]
				 && value[2] != value[3] && value[3] == value[4])
		result = (2 << 20) + (value[3] << 16) + (value[0] << 12) + (value[1] << 8) + (value[2] << 4);
	
	/* high card*/
	else
		result = (1 << 20) + (value[0] << 16) + (value[1] << 12) + (value[2] << 8) + (value[3] << 4) + (value[4]);
}
int main(void) {

	
	char b1[3], b2[3], b3[3], b4[3], b5[3], w1[3], w2[3], w3[3], w4[3], w5[3];
	int black[5], white[5];
	long bc, wc;
	int i;
	while(scanf("%s %s %s %s %s %s %s %s %s %s", b1, b2, b3, b4, b5, w1, w2, w3, w4, w5) == 10){
		black[0]= encode_card(b1);
		black[1]= encode_card(b2);
		black[2]= encode_card(b3);
		black[3]= encode_card(b4);
		black[4]= encode_card(b5);
		white[0]= encode_card(w1);
		white[1]= encode_card(w2);
		white[2]= encode_card(w3);
		white[3]= encode_card(w4);
		white[4]= encode_card(w5);
		bc= get_hand_value(black);
		wc=	get_hand_value(white);
		if(bc > wc)
			printf("Black wins.\n");
		else if(wc > bc)
			printf("White wins.\n");
		else
			printf("Tie.\n");
	}
	
	return 0;
}
