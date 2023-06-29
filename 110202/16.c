#include <stdio.h>
#define get_value(x) ((x) / 10)
#define get_suit(x) ((x) % 10)
#define BUFSIZE 33

int encode_card(char* card){
	int result;
	switch(card[0]){
		case 'T': result = 100; break;
		case 'J': result = 110; break;
		case 'Q': result = 120; break;
		case 'K': result = 130; break;
		case 'A': result = 140; break;
		default: result = (card[0] - '0') * 10;
	}
	switch(card[1]){
		case 'H': result +=1; break;
		case 'D': result +=2; break;
		case 'S': result +=3; break;
		case 'C': result +=4; break;
 	}
	return result;
}

int get_hand_value(int hand[5]){
	int i, j, max, temp;
	int value[5], suit[5];
	long result;
	
	for(i=0; i<4; i++){
		max = i;
		for(j=i+1; j<5; j++)
			if(hand[j] > hand[max])
				max = j;
		temp = hand[i];
		hand[i] = hand[max];
		hand[max] = temp;
	}
	
	for(i=0; i<5; i++){
		value[i] = get_value(hand[i]);
		suit[i] = get_suit(hand[i]);
	}
	/* straigt flush */
	if(value[1]+1 == value[0] && suit[1] == suit[0]
		 && value[2]+2 == value[0] && suit[2] == suit[0]
		 && value[3]+3 == value[0] && suit[3] == suit[0]
		 && value[4]+4 == value[0] && suit[4] == suit[0])
		result = (9 << 20) + (value[0] << 16);
	/* four card */
	else if((value[0] == value[1] && value[0] == value[2]
		&& value[0] == value[3]) ||
		 (value[1] == value[2] && value[1] == value[3]
		 && value[1] == value[4]))
			result = (8 << 20) + (value[1] << 16);

	/* full house */
	else if((value[0] == value[1] && value[0] == value[2] && value[3]
			== value[4]) || (value[0] == value[1] && value[2] ==
			value[3] && value[2] == value[4]))
			result = (7 << 20) + (value[2] << 16);
	
	/* flush */
	else if(suit[0] == suit[1] && suit[0] == suit[2] && suit[0] ==
		suit[3] && suit[0] == suit[4])
		result = (6 << 20) + (value[0] << 16) + (value[1] << 12) + (value[2] << 8) + (value[3] << 4) + value[4];
	
	/* straight */
	else if(value[1]+1 == value[0] && value[2]+2 == value[0] &&
		 value[3]+3 == value[0] && value[4]+4 == value[0])
		result = (5 << 20) + (value[0] << 16);
	
	/* three card */
	else if((value[0] == value[1] && value[0] == value[2]) ||
		(value[1] == value[2] && value[1] == value[3]) ||
		 (value[2] == value[3] && value[2] == value[4]))
		result = (4 << 20) + (value[2] << 16);
	
	/* two pair */
	else if((value[0] == value[1] && value[2] == value[3]) ||
					(value[0] == value[1] && value[3] == value[4]) ||
					(value[1] == value[2] && value[3] == value[4])){
		if(value[0] == value[1] && value[2] == value[3])
			result = (3 << 20) + (value[0] << 16) + (value[2] << 12) + value[4];
		else if(value[0] == value[2] && value[3] == value[4])
			result = (3 << 20) + (value[0] << 16) + (value[3] << 12) + value[2];
		else
			result = (3 << 20) + (value[1] << 16) + (value[3] << 12) + value[0];
	}
		
	/* one pair */
	else if((value[0] == value[1]) || (value[1] == value[2]) ||
		(value[2] == value[3]) || (value[3] == value[4])){
		int index;
		for(i = 0; i<4;i++)
			if(value[i] == value[i+1]){
				index = i;
				break;
			}
		if(index == 0)
			result = (2 << 20) + (value[0] << 16) + (value[2] << 12)
			+ (value[3] << 8) + (value[4] << 4);
		else if(index == 1)
			result = (2 << 20) + (value[1] << 16) + (value[0] << 12)
			+ (value[3] << 8) + (value[4] << 4);
		else if(index == 2)
			result = (2 << 20) + (value[2] << 16) + (value[0] << 12)
			+ (value[1] << 8) + (value[4] << 4);
		else
			result = (2 << 20) + (value[3] <<16) + (value[0] << 12)
			+ (value[1] << 8) + (value[2] << 4);
	}
	/* high card */
	else
		result = (1 << 20) + (value[0] << 16) + (value[1] << 12) +
		(value[2] << 8) + (value[3] << 4) + value[4];
	return result;	
}

void main(){
	int hand[2][5];
	long value[2];
	char line[BUFSIZE];
	
	while(fgets(line, BUFSIZE, stdin) != NULL){
		int pointer = 0;
		for(int i=0; i<2; i++){
			for(int j=0; j<5; j++){
				if(line[pointer] == ' ')
					pointer++;
				if(line[pointer] == '\n')
					break;
				hand[i][j] = encode_card(line + pointer);
				pointer += 2;
			}
			value[i] = get_hand_value(hand[i]);
		}
		if(value[0]>value[1])
			printf("Black wins.\n");
		else if(value[0] < value[1])
			printf("White wins.\n");
		else
			printf("Tie.\n");
	}
}



























