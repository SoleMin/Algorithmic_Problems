#include <stdio.h>
#include <string.h>
#define get_value(x) ((x)/10)
#define get_suit(x) ((x)%10)

int encode_card(char* card){
	int result;
	switch(card[0]){
		case 'T': result = 100; break;
		case 'J': result = 110; break;
		case 'Q': result = 120; break;
		case 'K': result = 130; break;
		case 'A': result = 140; break;
		default: result = (card[0]-'0')*10;
	}
	switch(card[1]){
		case 'H': result +=1; break;
		case 'D': result +=2; break;
		case 'S': result +=3; break;
		case 'C': result +=4; break;
	}
	return result;
}

long get_hand_value(int hand[5]){
	int i,j,max,temp;
	int value[5],suit[5];
	long result=0;
	
	for(i=0;i<4;i++){
		max=i;
		for(j=i+1;j<5;j++)
			if(hand[j]>hand[max])
				max=j;
		temp=hand[i];
		hand[i]=hand[max];
		hand[max]=temp;
	}
	for(i = 0;i<5;i++){
		value[i]=get_value(hand[i]);
		suit[i]=get_suit(hand[i]);
	}
	//straigt flush
	if(value[1]+1==value[0]&&suit[1]==suit[0]
		&&value[2]+2==value[0]&&suit[2]==suit[0]
		&&value[3]+3==value[0]&&suit[3]==suit[0]
		&&value[4]+4==value[0]&&suit[4]==suit[0])
		result = (9<<20)+(value[0]<<16);
	//four card
	else if(value[1]==value[0] && value[2]==value[0]&&value[3]==value[0])
		result = (8<<20)+(value[0]<<16);
	else if(value[2]==value[1]&&value[3]==value[1]&&value[4]==value[1])
		result=(8<<20)+(value[1]<<16);
	//full house
	else if(value[1]==value[0]&&value[2]==value[0]&&value[3]==value[4])
		result=(7<<20)+(value[0]<<16);
	else if(value[1]==value[0]&&value[2]==value[3]&&value[2]==value[4])
		result=(7<<20)+(value[2]<<16);
	//flush
	else if(suit[1]==suit[0]&&suit[2]==suit[0]&&suit[3]==suit[0]&&suit[4]==suit[0])
		result=(6<<20)+(value[0]<<16);
	//straight
	else if(value[1]+1 ==value[0] && value[2]+2==value[0]&& value[3]+3==value[0] &&value[4]+4==value[0])
		result=(5<<20)+(value[0]<<16);
	//three card
	else if(value[1]==value[0]&&value[2]==value[0])
		result=(4<<20)+(value[0]<<16);
	else if(value[3]==value[2]&&value[4]==value[2])
		result=(4<<20)+(value[2]<<16);
	//two pair
	else if(value[1]==value[0] &&  value[2]==value[3])
		result=(3<<20)+(value[0]<<16);
	else if(value[1]==value[0] && value[3]==value[4])
		result=(3<<20)+(value[0]<<16);
	else if(value[1]==value[2] &&value[4]==value[3])
		result=(3<<20)+(value[1]<<16);
	//one pair
	else if(value[1]==value[0])
		result=(2<<20)+(value[0]<<16);
	else if(value[1]==value[2])
		result=(2<<20)+(value[1]<<16);
	else if(value[2]==value[3])
		result=(2<<20)+(value[2]<<16);
	else if(value[3]==value[4])
		result=(2<<20)+(value[3]<<16);
	//high card
	else
		result=(1<<20)+(value[0]<<16)+(value[1]<<12)+(value[2]<<8)+(value[3]<<4)+value[4];
	return result;	
}


int main() {
	char line[31]={'\0',};
	while(fgets(line,31,stdin)!=NULL){
		line[strlen(line)-1]='\0';
		if(line[0]=='\0') break;
		char card[10][2]= {'\0',};
		int black_card[5],white_card[5];
		long black_score,white_score;
		for(int i=0;i<10;i++){
			card[i][0]= line[i*3];
			card[i][1]= line[i*3+1];
			if(i<5)
				black_card[i]=encode_card(card[i]);
			else
				white_card[i-5]=encode_card(card[i]);
		}
		black_score =get_hand_value(black_card);
		white_score = get_hand_value(white_card);
		if(black_score>white_score) printf("Black wins.\n");
		else if(black_score < white_score) printf("White wins.\n");
		else printf("Tie.\n");
	}
	return 0;
}
